package org.bedrockmc.api;

public class BedrockMC {

	private static Client client;

	public static Client getClient() {
		return client;
	}

	public static void setClient(Client client) {
		BedrockMC.client = client;
	}
	
	public static Client getInstance() {
		return BedrockMC.client;
	}
	
}
