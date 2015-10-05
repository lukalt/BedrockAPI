package org.bedrockmc.api;

public enum MinecraftVersion {

	MINECRAFT_1_8_8(58, 47, "1.8.8"),
	MINECRAFT_1_8_7(57, 47, "1.8.7"),
	MINECRAFT_1_8_6(56, 47, "1.8.6"),
	MINECRAFT_1_8_5(55, 47, "1.8.5"),
	MINECRAFT_1_8_4(54, 47, "1.8.4"),
	MINECRAFT_1_8_3(53, 47, "1.8.3"),
	MINECRAFT_1_8_2(52, 47, "1.8.2"),
	MINECRAFT_1_8_1(51, 47, "1.8.1"),
	MINECRAFT_1_8_0(50, 47, "1.8.0");
	
	private int versionCode;
	private int networkVersion;
	private String versionString;
	
	private MinecraftVersion(int versionCode, int networkVersion, String versionString) {
		this.versionCode = versionCode;
		this.versionString = versionString;
		this.networkVersion = networkVersion;
	}
	
	public int getVersionCode() {
		return versionCode;
	}
	
	public String getVersionString() {
		return versionString;
	}

	public int getNetworkVersion() {
		return networkVersion;
	}
	
	
	
	
}
