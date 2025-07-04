package com.notepad;

import javax.swing.*;
import java.awt.*;

public class helpFunction {

	GUI gui;

	public helpFunction(GUI gui) {
		this.gui = gui;
	}

	public void about1() {
		// Developer Info Window
		JFrame aboutDev = new JFrame("About The Developer");

		// 🔒 Lock resizing, minimize/maximize
		aboutDev.setResizable(false);
		aboutDev.setUndecorated(false);
		aboutDev.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		aboutDev.setSize(550, 420);
		aboutDev.setLayout(new BorderLayout(10, 10));
		aboutDev.setLocationRelativeTo(gui.window);

		// Set icon (top-left)
		ImageIcon icon = new ImageIcon(getClass().getResource("developer.png"));
		aboutDev.setIconImage(icon.getImage());

		// Icon label
		JLabel iconLabel = new JLabel(icon);
		iconLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		// HTML styled content
		JLabel textLabel = new JLabel("<html>"
				+ "<div style='padding:10px;'>"
				+ "<h1 style='color:#2E86C1;'>Kanhaiya Gupta</h1>"
				+ "<p style='font-size:14pt;'>"
				+ "A passionate Java & MERN Stack developer who enjoys turning ideas into real-world projects.<br>"
				+ "Creator of this Notepad app, aiming to blend simplicity with feature-rich capabilities."
				+ "</p><br><br>"
				+ "<p style='font-size:12pt; color:gray;'>"
				+ "📧 kanhaiyaguptaksg@gmail.com<br>"
				+ "🌐 GitHub: @codekanhaiya"
				+ "</p>"
				+ "<hr/>" +
				"<p style='text-align:right;'>© 2025 All Rights Reserved</p>"
				+ "</div></html>"
		);
		textLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));

		// Add to window
		aboutDev.add(iconLabel, BorderLayout.WEST);
		aboutDev.add(textLabel, BorderLayout.CENTER);
		aboutDev.setVisible(true);
	}

	public void about2() {
		// Text Editor Info Window
		JFrame aboutText = new JFrame("About The Text Editor");

		// 🔒 Lock resizing, minimize/maximize
		aboutText.setResizable(false);
		aboutText.setUndecorated(false);
		aboutText.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		aboutText.setSize(550, 420);
		aboutText.setLayout(new BorderLayout(10, 10));
		aboutText.setLocationRelativeTo(gui.window);

		// Set icon (top-left)
		ImageIcon icon = new ImageIcon(getClass().getResource("notepadIcon.png"));
		aboutText.setIconImage(icon.getImage());

		// Icon label
		JLabel iconLabel = new JLabel(icon);
		iconLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		// HTML styled content
		JLabel textLabel = new JLabel("<html>"
				+ "<div style='padding:10px;'>"
				+ "<h1 style='color:#239B56;'>Welcome to Notepad</h1>"
				+ "<p style='font-size:14pt;'>"
				+ "This is a lightweight, customizable text editor built in Java using Swing and Gradle. "
				+ "It supports font styles, themes, printing, multiple windows, and more.<br>"
				+ "Ideal for note-taking, writing quick code snippets, or general editing tasks."
				+ "</p><br><br>"
				+ "<p style='font-size:12pt; color:gray;'>"
				+ "🔧 Version: 1.0.0<br>"
				+ "📅 Release Date: July 2025"
				+ "</p>"
				+ "<hr><p style='text-align:right;'>© 2025 Notepad App. All Rights Reserved</p>"
				+ "</div></html>"
		);
		textLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));

		// Add to window
		aboutText.add(iconLabel, BorderLayout.WEST);
		aboutText.add(textLabel, BorderLayout.CENTER);
		aboutText.setVisible(true);
	}
}
