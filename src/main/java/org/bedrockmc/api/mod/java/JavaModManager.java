package org.bedrockmc.api.mod.java;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.imageio.ImageIO;

import org.bedrockmc.api.BedrockMC;
import org.bedrockmc.api.Client;
import org.bedrockmc.api.ModManager;
import org.bedrockmc.api.mod.InvalidModException;
import org.bedrockmc.api.mod.MaximumVersion;
import org.bedrockmc.api.mod.MinimumVersion;
import org.bedrockmc.api.mod.Mod;
import org.bedrockmc.api.mod.ModDescriptionFile;
import org.bedrockmc.api.mod.ModIcon;

public class JavaModManager implements ModManager {

	private static final String DESCRIPTION_FILE_NAME = "mod.properties";

	private Map<String, Mod> loadedMods = new HashMap<String, Mod>();

	@Override
	public boolean isLoaded(String name) {
		return loadedMods.containsKey(name.toLowerCase());
	}

	@Override
	public Mod getMod(String name) {
		return loadedMods.get(name.toLowerCase());
	}

	@SuppressWarnings({ "resource", "unchecked" })
	@Override
	public void loadMod(File file) {
		if (!file.exists()) {
			throw new InvalidModException("File does not exist.");
		}

		try {
			JarFile jarFile = new JarFile(file);
			JarEntry entry = jarFile.getJarEntry(DESCRIPTION_FILE_NAME);
			if (entry == null) {
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append("Jar doesn't contain a ");
				stringBuilder.append(DESCRIPTION_FILE_NAME);
				throw new InvalidModException(stringBuilder.toString());
			}
			InputStream stream = jarFile.getInputStream(entry);
			ModDescriptionFile mdf = null;
			try {
				mdf = ModDescriptionFile.parseFromInputStream(stream);
			} catch (InvalidModException ex) {
				ex.printStackTrace();
			} 
			JarEntry icon = jarFile.getJarEntry("icon.png");
			ModIcon modIcon = null;
			if(icon == null) {
				modIcon = BedrockMC.getClient().createModIcon(null);
			}else {
				BufferedImage img = ImageIO.read(jarFile.getInputStream(icon));
				modIcon = BedrockMC.getClient().createModIcon(img);
			}
			URL url = file.toURL();
			URLClassLoader loader = new URLClassLoader (new URL[] {url});
			Enumeration<JarEntry> en = jarFile.entries();
			boolean found = false;
			while (en.hasMoreElements()) {
				JarEntry je = en.nextElement();
				if (je.isDirectory()) {
					continue;
				}
				if (je.getName().endsWith(".class")) {
					String className = je.getName().substring(0,
							je.getName().length() - 6);
					className = className.replace('/', '.');
					Class<?> clazz = loader.loadClass(className);
					if(clazz.getName().equals(mdf.getMainClass())) {
						found = true;
						if(clazz.isAnnotationPresent(MinimumVersion.class)) {
							MinimumVersion min = clazz.getAnnotation(MinimumVersion.class);
							if(min.minVersion().getVersionCode() > BedrockMC.getClient().getCurrentVersion().getVersionCode()) {
								throw new InvalidModException("This mod requires Minecraft " + min.minVersion().getVersionString());
							}
						}
						if(clazz.isAnnotationPresent(MaximumVersion.class)) {
							MaximumVersion max = clazz.getAnnotation(MaximumVersion.class);
							if(max.maxVersion().getVersionCode() < BedrockMC.getClient().getCurrentVersion().getVersionCode()) {
								throw new InvalidModException("This mod requires Minecraft " + max.maxVersion().getVersionString());
							}
						}
						Constructor<JavaMod> constr = (Constructor<JavaMod>) clazz.getConstructor(Client.class, ModDescriptionFile.class);
						constr.setAccessible(true);
						JavaMod mod = constr.newInstance(BedrockMC.getClient(), mdf);
						mod.setModIcon(modIcon);
						this.loadedMods.put(mod.getName().toLowerCase(), mod);
						mod.onLoad();
					}
				}
			}
			if(!found) {
				throw new InvalidModException("Main class " + mdf.getMainClass() + " was not found.");
			}
			jarFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void enableMod(Mod mod) {
		mod.onEnable();
		if (mod instanceof JavaMod) {
			((JavaMod) mod).setEnabled(true);
		}
	}

	@Override
	public void disableMod(Mod mod) {
		mod.onDisable();
		if (mod instanceof JavaMod) {
			JavaMod javaMod = (JavaMod) mod;
			javaMod.setEnabled(false);
			javaMod.getOverlays().clear();
		}
	}

	@Override
	public Collection<Mod> getLoadedMods() {
		return loadedMods.values();
	}

	@Override
	public boolean isEnabled(Mod mod) {
		if (isLoaded(mod.getName().toLowerCase())) {
			Mod mo = loadedMods.get(mod.getName().toLowerCase());
			return mo.isEnabled();
		}
		return false;
	}

	@Override
	public void reloadMod(Mod mod) {
		if(isLoaded(mod.getName())) {
			if(isEnabled(mod)) {
				disableMod(mod);
			}
			loadedMods.remove(mod.getName());			
		}
	}

}
