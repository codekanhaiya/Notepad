package com.notepad;

import java.awt.FileDialog;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.awt.Color;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.*;

public class fileFunction {

	GUI gui;
	private String fileAddress;
	private String fileName;

	public fileFunction(GUI gui) {
		this.gui = gui;
	}

	public void newFile() {
		gui.textArea.setText("");
		gui.window.setTitle("Untitled - Notepad");
		fileName = null;
		fileAddress = null;
	}

	public void newWindow() {
		new GUI(); // Opens a new instance
	}

	public void openFile() {
		FileDialog fileDialog = new FileDialog(gui.window, "Open", FileDialog.LOAD);
		fileDialog.setVisible(true);

		if (fileDialog.getFile() != null) {
			fileName = fileDialog.getFile();
			fileAddress = fileDialog.getDirectory();
			gui.window.setTitle(fileName + " - Notepad");

			try (BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName))) {
				gui.textArea.setText("");
				String line;
				while ((line = br.readLine()) != null) {
					gui.textArea.append(line + "\n");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(gui.window, "Error opening file!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void saveFile() {
		if (fileName == null) {
			saveAsFile();
		} else {
			writeToFile(fileAddress + fileName);
		}
	}

	public void saveAsFile() {
		FileDialog fileDialog = new FileDialog(gui.window, "Save As", FileDialog.SAVE);
		fileDialog.setVisible(true);

		if (fileDialog.getFile() != null) {
			fileName = fileDialog.getFile();
			fileAddress = fileDialog.getDirectory();

			// Ensure .txt extension
			if (!fileName.endsWith(".txt")) {
				fileName += ".txt";
			}

			gui.window.setTitle(fileName + " - Notepad");
			writeToFile(fileAddress + fileName);
		}
	}

	private void writeToFile(String fullPath) {
		try (FileWriter fw = new FileWriter(fullPath)) {
			fw.write(gui.textArea.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(gui.window, "Error saving file!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void print() {
		try {
			Color bg = gui.textArea.getBackground();
			Color fg = gui.textArea.getForeground();

			gui.textArea.setBackground(Color.WHITE);
			gui.textArea.setForeground(Color.BLACK);

			gui.textArea.print();

			gui.textArea.setBackground(bg);
			gui.textArea.setForeground(fg);
		} catch (PrinterException e) {
			JOptionPane.showMessageDialog(gui.window, "Error printing file!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}


	public void exitFile() {
		System.exit(0);
	}
}
