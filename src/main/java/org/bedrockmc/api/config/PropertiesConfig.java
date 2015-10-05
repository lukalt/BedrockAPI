package org.bedrockmc.api.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesConfig implements Config {

	public static PropertiesConfig loadFromFile(File file) throws FileNotFoundException, IOException {
		return new PropertiesConfig(new FileInputStream(file));
	}
	
	public static PropertiesConfig loadFromFile(String file) throws FileNotFoundException, IOException {
		return new PropertiesConfig(new FileInputStream(new File(file)));
	}

	public static PropertiesConfig loadFromStream(InputStream input) throws IOException {
		return new PropertiesConfig(input);
	}

	
	private Properties prop;

	private PropertiesConfig(InputStream input) throws IOException {
		this.prop = new Properties();
		this.prop.load(input);
	}

	@Override
	public String getString(String key) {
		return this.prop.getProperty(key);
	}

	@Override
	public String getString(String key, String def) {
		return this.prop.getProperty(key, def);
	}

	@Override
	public int getInt(String key) {
		return Integer.parseInt(this.prop.getProperty(key, "0"));
	}

	@Override
	public int getInt(String key, int def) {
		return Integer.parseInt(this.prop.getProperty(key,
				Integer.toString(def)));
	}

	@Override
	public double getDouble(String key) {
		return Double.parseDouble(this.prop.getProperty(key, "0"));
	}

	@Override
	public double getDouble(String key, double def) {
		return Double.parseDouble(this.prop.getProperty(key,
				Double.toString(def)));
	}

	@Override
	public float getFloat(String key) {
		return Float.parseFloat(this.prop.getProperty(key, "0"));
	}

	@Override
	public float getFloat(String key, float def) {
		return Float
				.parseFloat(this.prop.getProperty(key, Float.toString(def)));
	}

	@Override
	public long getLong(String key) {
		return Long.parseLong(this.prop.getProperty(key, "0"));
	}

	@Override
	public long getLong(String key, long def) {
		return Long.parseLong(this.prop.getProperty(key, Long.toString(def)));
	}

	@Override
	public short getShort(String key) {
		return Short.parseShort(this.prop.getProperty(key, "0"));
	}

	@Override
	public short getShort(String key, short def) {
		return Short
				.parseShort(this.prop.getProperty(key, Short.toString(def)));
	}

	@Override
	public char getChar(String key) {
		return this.prop.getProperty(key).charAt(0);
	}

	@Override
	public char getChar(String key, char def) {
		return this.prop.getProperty(key, Character.toString(def)).charAt(0);
	}

	@Override
	public boolean getBoolean(String key) {
		return Boolean.parseBoolean(this.prop.getProperty(key, "false"));
	}

	@Override
	public boolean getBoolean(String key, boolean def) {
		return Boolean.parseBoolean(this.prop.getProperty(key,
				Boolean.toString(def)));
	}

	@Override
	public void save(File file) throws IOException {
		this.save(new FileOutputStream(file));
	}

	@Override
	public void save(OutputStream outputStream) throws IOException {
		this.prop.store(outputStream, "");
	}

}
