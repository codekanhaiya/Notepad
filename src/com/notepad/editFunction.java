package com.notepad;

import javax.swing.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class editFunction {

	GUI gui;
	String h, m, s, date, month, year, hms;

	public editFunction(GUI gui) {
		this.gui = gui;
	}

	public void undo() {
		if (gui.um.canUndo()) {
			gui.um.undo();
		}
	}

	public void redo() {
		if (gui.um.canRedo()) {
			gui.um.redo();
		}
	}

	public void cut() {
		gui.textArea.cut();
	}

	public void copy() {
		gui.textArea.copy();
	}

	public void paste() {
		gui.textArea.paste();
	}

	public void find() {
		String searchTerm = JOptionPane.showInputDialog(gui.window, "Enter text to find:");
		if (searchTerm == null || searchTerm.isEmpty()) {
			return;
		}

		String text = gui.textArea.getText();
		int index = text.indexOf(searchTerm);

		if (index >= 0) {
			gui.textArea.requestFocus();
			gui.textArea.select(index, index + searchTerm.length());
			JOptionPane.showMessageDialog(gui.window, "Found at position: " + index);
		} else {
			JOptionPane.showMessageDialog(gui.window, "Text not found!", "Find", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void select() {
		gui.textArea.selectAll();
	}

	public void date() {
		GregorianCalendar calendar = new GregorianCalendar();
		h = String.format("%02d", calendar.get(Calendar.HOUR_OF_DAY));
		m = String.format("%02d", calendar.get(Calendar.MINUTE));
		s = String.format("%02d", calendar.get(Calendar.SECOND));
		date = String.format("%02d", calendar.get(Calendar.DATE));
		month = String.format("%02d", calendar.get(Calendar.MONTH) + 1); // Month is 0-based
		year = String.valueOf(calendar.get(Calendar.YEAR));
		hms = h + ":" + m + ":" + s + "  " + date + "/" + month + "/" + year + "  ";
		gui.textArea.append(hms);
	}
}
