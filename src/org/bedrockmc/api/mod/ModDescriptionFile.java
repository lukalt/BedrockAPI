package org.bedrockmc.api.mod;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ModDescriptionFile {

	private String author;
	private String version;
	private String name;
	private String mainClass;
	private String website = "";

	public ModDescriptionFile(String author, String version, String name,
			String mainClass) {
		super();
		this.author = author;
		this.version = version;
		this.name = name;
		this.mainClass = mainClass;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getAuthor() {
		return author;
	}

	public String getMainClass() {
		return mainClass;
	}

	public void setMainClass(String mainClass) {
		this.mainClass = mainClass;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static ModDescriptionFile parseFromInputStream(InputStream stream)
			throws IOException, InvalidModException {
		Properties prop = new Properties();
		prop.load(stream);
		String version = prop.getProperty("version");
		if (version == null) {
			throw new InvalidModException("Mod version cannot be null.");
		}
		String author = prop.getProperty("author", "unknown");
		String name = prop.getProperty("name");
		if (name == null) {
			throw new InvalidModException("Mod name cannot be null.");
		}
		String main = prop.getProperty("main");
		if (main == null) {
			throw new InvalidModException("Main class cannot be null.");
		}
		ModDescriptionFile mdf = new ModDescriptionFile(author, version, name, main);
		String website = prop.getProperty("website");
		if(website != null) {
			mdf.setWebsite(website);
		}
		return mdf;
	}
}
