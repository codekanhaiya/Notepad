package com.notepad;

import java.awt.*;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;
import javax.swing.JMenu;
import javax.swing.JMenuItem;



public class setFunction {

	private final GUI gui;

	private String selectedFont = "Calibri";
	private String selectedStyle = "Regular";
	private int selectedSize = 16;

	public setFunction(GUI gui) {
		this.gui = gui;
	}

	// Theme Switcher
	public void changeColor(String theme) {
		Color bg, fg, menuBg, menuFg;

		switch (theme.toLowerCase()) {
			case "light":
				bg = Color.WHITE;
				fg = Color.BLACK;
				menuBg = new Color(245, 245, 245);
				menuFg = Color.BLACK;
				break;
			case "dark":
				bg = new Color(30, 30, 30);
				fg = Color.WHITE;
				menuBg = new Color(45, 45, 45);
				menuFg = Color.WHITE;
				break;
			default:
				bg = Color.LIGHT_GRAY;
				fg = Color.BLACK;
				menuBg = UIManager.getColor("Menu.background");
				menuFg = UIManager.getColor("Menu.foreground");
				break;
		}

		// Main components
		gui.textArea.setBackground(bg);
		gui.textArea.setForeground(fg);
		gui.textArea.setCaretColor(fg);
		gui.window.getContentPane().setBackground(bg);
		gui.statusBar.setBackground(bg);
		gui.statusBar.setForeground(fg);

		// Menu bar background fix
		gui.menuBar.setOpaque(true);
		gui.menuBar.setBackground(menuBg);
		gui.menuBar.setForeground(menuFg);

		// Apply to each menu
		JMenu[] menus = {gui.menuFile, gui.menuEdit, gui.menuView, gui.menuHelp, gui.menuSetting};
		for (JMenu menu : menus) {
			if (menu == null) continue;

			menu.setOpaque(true);
			menu.setBackground(menuBg);
			menu.setForeground(menuFg);

			for (int i = 0; i < menu.getItemCount(); i++) {
				JMenuItem item = menu.getItem(i);
				if (item != null) {
					item.setOpaque(true); // 🔑 Required for custom background to apply
					item.setBackground(menuBg);
					item.setForeground(menuFg);
				}
			}
		}

		// Refresh UI
		SwingUtilities.updateComponentTreeUI(gui.window);
	}


	public void family(String fontFamily) {
		if (fontFamily != null && !fontFamily.trim().isEmpty()) {
			selectedFont = fontFamily;
			applyFont();
		}
	}

	public void applyUIFontScaling() {
		Font uiFont = new Font(selectedFont, Font.PLAIN, 20);

		UIManager.put("Menu.font", uiFont);
		UIManager.put("MenuItem.font", uiFont);
		UIManager.put("Label.font", uiFont);
		UIManager.put("CheckBoxMenuItem.font", uiFont);
		UIManager.put("TextArea.font", new Font(selectedFont, Font.PLAIN, selectedSize));
		UIManager.put("OptionPane.messageFont", uiFont);
		UIManager.put("OptionPane.buttonFont", uiFont);
		UIManager.put("Button.font", uiFont);
		UIManager.put("ScrollPane.font", uiFont);
		UIManager.put("ToolTip.font", uiFont);

		SwingUtilities.updateComponentTreeUI(gui.window); // refresh UI
	}


	public String getSelectedFont() {
		return selectedFont;
	}


	public void font(String fontStyle) {
		if (fontStyle != null && !fontStyle.trim().isEmpty()) {
			selectedStyle = fontStyle;
			applyFont();
		}
	}

	public void size(int fontSize) {
		if (fontSize > 0) {
			selectedSize = fontSize;
			applyFont();
		}
	}

	private void applyFont() {
		int fontStyle;

		switch (selectedStyle.toLowerCase()) {
			case "bold":
				fontStyle = Font.BOLD;
				break;
			case "italic":
				fontStyle = Font.ITALIC;
				break;
			case "regular":
			default:
				fontStyle = Font.PLAIN;
				break;
		}

		Font font = new Font(selectedFont, fontStyle, selectedSize);
		gui.textArea.setFont(font);
	}
}
