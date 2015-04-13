package org.bedrockmc.api.gui;

import java.util.Collection;
import java.util.List;

public interface ModGuiScreen {

	public List<Button> getButtons();
	
	public void addButton(Button button);
	
	public void removeButton(Button button);
	
	public GuiListener getGuiListener();
	
	public void setGuiListener(GuiListener listener);
	
	public void closeGui();
	
	public Button createButton(String label, int x, int y);
	
	public Button createButton(String label, int x, int y, int width, int height, boolean enabled);
	
	public void addLabel(String string, int x, int y);
	
	public Collection<Label> getLabels();
	
	public void removeLabel(Label label);
	
	public GuiScreenType getType();
	
	public void openGui();
	
}
