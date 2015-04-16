package org.bedrockmc.api.chat;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ChatMessage {

	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	public static Gson getGson() {
		return gson;
	}

	private String color;
	private String text;
	private boolean bold = false;
	private boolean italic = false;
	private boolean underlined = false;
	private boolean strikethrough = false;
	private boolean obfuscated = false;
	private List<ChatMessage> extra = new ArrayList<ChatMessage>();

	public ChatMessage(String text) {
		this.text = text;
		this.setColor(ChatColor.WHITE);
	}
	
	public ChatColor getColor() {
		return ChatColor.valueOf(color.toUpperCase());
	}

	public void setColor(ChatColor color) {
		this.color = color.name().toLowerCase();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isBold() {
		return bold;
	}

	public void setBold(boolean bold) {
		this.bold = bold;
	}

	public boolean isItalic() {
		return italic;
	}

	public void setItalic(boolean italic) {
		this.italic = italic;
	}

	public boolean isUnderlined() {
		return underlined;
	}

	public void setUnderlined(boolean underlined) {
		this.underlined = underlined;
	}

	public boolean isStrikethrough() {
		return strikethrough;
	}

	public void setStrikethrough(boolean strikethrough) {
		this.strikethrough = strikethrough;
	}

	public boolean isObfuscated() {
		return obfuscated;
	}

	public void setObfuscated(boolean obfuscated) {
		this.obfuscated = obfuscated;
	}
	
	public String toJson() {
		return gson.toJson(this);
	}
	
	public List<ChatMessage> getExtras() {
		return this.extra;
	}
	
	public void addExtra(ChatMessage msg) {
		this.extra.add(msg);
	}

}
