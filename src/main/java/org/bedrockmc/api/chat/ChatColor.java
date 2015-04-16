package org.bedrockmc.api.chat;

public enum ChatColor {
	
	BLACK('0'),
	DARK_BLUE('1'),
	DARK_GREEN('2'),
	DARK_AQUA('3'),
	DARK_RED('4'),
	DARK_PURPLE('5'),
	GOLD('6'),
	GRAY('7'),
	DARK_GRAY('8'),
	LIGHT_BLUE('9'),
	GREEN('a'),
	AQUA('b'),
	RED('c'),
	LIGHT_PURPLE('d'),
	YELLOW('e'),
	WHITE('f');

	private char colorCode;
	
	ChatColor(char colorCode) {
		this.colorCode = colorCode;
	}
	
	@Override
	public String toString() {
		return Character.toString(this.colorCode);
	}
}
