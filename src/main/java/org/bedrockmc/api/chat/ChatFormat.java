package org.bedrockmc.api.chat;

public enum ChatFormat {

	RESET('r'),
	BOLD('l'),
	ITALIC('o'),
	UNDERLINE('n'),
	MAGIC('k'),
	STRIKETHROUGH('m');
	
	private char c;
	
	ChatFormat(char c) {
		this.c = c;
	}
	
	public char getFormatCode() {
		return c;
	}
}
