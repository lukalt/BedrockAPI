package org.bedrockmc.api.gui;

import java.util.Collection;
import java.util.List;

public interface ModGuiScreen {

	/**
	 * Get all buttons on the gui screen
	 * @return all buttons
	 */
	public List<Button> getButtons();
	
	/**
	 * Add a button to the gui screem
	 * @param button
	 */
	public void addButton(Button button);
	
	/**
	 * Remove a button from the gui screen
	 * @param button
	 */
	public void removeButton(Button button);
	
	/**
	 * Get the current gui listener
	 * @return listener
	 */
	public GuiListener getGuiListener();
	
	/**
	 * Set the current gui listener
	 * @param listener
	 */
	public void setGuiListener(GuiListener listener);
	
	/**
	 * Close the curren gui. <b>If it is not open, the screen currently open will be closed</b>
	 */
	public void closeGui();
	
	/**
	 * Create a new button
	 * @param label
	 * @param x
	 * @param y
	 * @return button
	 */
	public Button createButton(String label, int x, int y);
	
	/**
	 * Create a new button
	 * @param label
	 * @param x-Position
	 * @param y-Position
	 * @param width
	 * @param height
	 * @param enabled
	 * @return
	 */
	public Button createButton(String label, int x, int y, int width, int height, boolean enabled);
	
	/**
	 * Add a new label to the screen
	 * @param string
	 * @param x
	 * @param y
	 */
	public void addLabel(String string, int x, int y);
	
	/**
	 * Add an new element to the gui screen
	 * @param element
	 */
	public void addElement(Element element);
	
	/**
	 * Get all elements on the screen
	 * @return elements
	 */
	public Collection<Element> getElements();
	
	/**
	 * Remove an element from the screen
	 * @param element
	 */
	public void removeElement(Element element);
	
	/**
	 * Get the current type of the screen
	 * @return gui screen
	 */
	public GuiScreenType getType();
	
	/**
	 * Open the current screen
	 */
	public void openGui();
	
}
