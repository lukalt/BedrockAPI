package org.bedrockmc.api.config;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public interface Config {

	public String getString(String key);

	public String getString(String key, String def);

	public int getInt(String key);

	public int getInt(String key, int def);

	public double getDouble(String key);

	public double getDouble(String key, double def);

	public float getFloat(String key);

	public float getFloat(String key, float def);

	public long getLong(String key);

	public long getLong(String key, long def);

	public short getShort(String key);

	public short getShort(String key, short def);

	public char getChar(String key);

	public char getChar(String key, char def);

	public boolean getBoolean(String key);

	public boolean getBoolean(String key, boolean def);

	public void save(File file) throws IOException;

	public void save(OutputStream outputStream) throws IOException;
}
