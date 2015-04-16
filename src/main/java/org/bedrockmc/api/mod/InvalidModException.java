package org.bedrockmc.api.mod;

public class InvalidModException extends IllegalStateException{
	
	public InvalidModException(String string) {
		super(string);
	}

	private static final long serialVersionUID = 145386425215517113L;

}
