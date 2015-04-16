package org.bedrockmc.api.mod.java;

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

import org.bedrockmc.api.BedrockMC;
import org.bedrockmc.api.Client;
import org.bedrockmc.api.ModManager;
import org.bedrockmc.api.mod.InvalidModException;
import org.bedrockmc.api.mod.Mod;
import org.bedrockmc.api.mod.ModDescriptionFile;

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
				System.out.println(mdf.getName());
			} catch (InvalidModException ex) {
				ex.printStackTrace();
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
						System.out.println("Loading main class " + clazz.getName());
						Constructor<JavaMod> constr = (Constructor<JavaMod>) clazz.getConstructor(Client.class, ModDescriptionFile.class);
						constr.setAccessible(true);
						Mod mod = constr.newInstance(BedrockMC.getClient(), mdf);
						this.loadedMods.put(mod.getName().toLowerCase(), mod);
						mod.onLoad();
					}else {
						System.out.println("Loading class " + clazz.getName());
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

}
