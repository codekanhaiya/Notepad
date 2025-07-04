package com.notepad;

import javax.swing.*;
import java.awt.*;

public class viewFunction {

	GUI gui;
	private int zoomLevel = 16; // default zoom level

	public viewFunction(GUI gui) {
		this.gui = gui;
	}

	public void status() {
		if (gui.statusBar.isVisible()) {
			gui.statusBar.setVisible(false);
		} else {
			gui.statusBar.setVisible(true);
		}
	}


	public void wrap() {
		if (gui.word.isSelected()) {
			gui.wordWrapOn = true;
			gui.textArea.setLineWrap(true);
			gui.textArea.setWrapStyleWord(true);
			gui.word.setText("Word Wrap: ON");
		} else {
			gui.wordWrapOn = false;
			gui.textArea.setLineWrap(false);
			gui.textArea.setWrapStyleWord(false);
			gui.word.setText("Word Wrap: OFF");
		}
	}


	public void zoomIn() {
		if (zoomLevel < 72) {
			zoomLevel += 2;
			gui.textArea.setFont(new Font(gui.set.getSelectedFont(), Font.PLAIN, zoomLevel));
		} else {
			JOptionPane.showMessageDialog(gui.window, "Maximum zoom level reached");
		}
	}

	public void zoomOut() {
		if (zoomLevel > 8) {
			zoomLevel -= 2;
			gui.textArea.setFont(new Font(gui.set.getSelectedFont(), Font.PLAIN, zoomLevel));
		} else {
			JOptionPane.showMessageDialog(gui.window, "Minimum zoom level reached");
		}
	}

	public void restore() {
		zoomLevel = 16;
		gui.textArea.setFont(new Font(gui.set.getSelectedFont(), Font.PLAIN, zoomLevel));
	}

}
