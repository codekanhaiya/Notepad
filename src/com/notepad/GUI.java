package com.notepad;

import javax.swing.*;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.undo.UndoManager;
import java.awt.event.*;

public class GUI implements ActionListener {

	JFrame window;
	JTextArea textArea;
	JScrollPane scrollPane;
	JMenuBar menuBar;
	JMenu menuFile, menuEdit, menuView, menuHelp, menuSetting;
	JCheckBoxMenuItem status, word;
	JLabel statusBar;



	boolean wordWrapOn = true;

	// Components
	fileFunction file;
	editFunction edit;
	viewFunction view;
	helpFunction help;
	setFunction set;
	KeyHandler keyHandler;
	UndoManager um = new UndoManager();

	public static void main(String[] args) {
		SwingUtilities.invokeLater(GUI::new);
	}

	public GUI() {
		initializeDependencies();
		createNotepad();
		createTextArea();
		createStatusBar();
		createMenuBar();
		createFileMenu();
		createEditMenu();
		createViewMenu();
		createHelpMenu();
		createSetMenu();

		set.family("Calibri");
		set.size(20);
		set.applyUIFontScaling();


		window.setVisible(true);
	}

	private void initializeDependencies() {
		// Initialize dependencies
		file = new fileFunction(this);
		edit = new editFunction(this);
		view = new viewFunction(this);
		help = new helpFunction(this);
		set = new setFunction(this);
		keyHandler = new KeyHandler(this);
	}

	public void createNotepad() {
		window = new JFrame("Untitled - Notepad");
		window.setBounds(400, 200, 1000, 600);
		window.setMinimumSize(new Dimension(1200, 800)); // Minimum window size
		window.setMaximumSize(new Dimension(1600, 1000)); // Maximum window size (acts as soft limit)
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Optional: Disable resizing is not good
		// window.setResizable(false);

		// Set Icon
		ImageIcon icon = new ImageIcon(getClass().getResource("notepadIcon.png"));
		window.setIconImage(icon.getImage());

		// Use system look and feel (for scrollbar appearance)
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(window);
		} catch (Exception e) {
			System.err.println("Could not set system look and feel: " + e.getMessage());
		}
	}


	public void createTextArea() {
		textArea = new JTextArea();
		textArea.setMargin(new Insets(10, 10, 10, 10)); // Add margin around text
		textArea.addKeyListener(keyHandler);
		textArea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));


		textArea.getDocument().addUndoableEditListener(e -> um.addEdit(e.getEdit())); // Lambda version

		scrollPane = new JScrollPane(textArea,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// Optional: Customize scroll bar UI
		scrollPane.getVerticalScrollBar().setUI(new javax.swing.plaf.basic.BasicScrollBarUI());
		scrollPane.getHorizontalScrollBar().setUI(new javax.swing.plaf.basic.BasicScrollBarUI());

		scrollPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Margin around text
		window.add(scrollPane, BorderLayout.CENTER);

	}


	public void createStatusBar() {
		statusBar = new JLabel("Ready");
		statusBar.setBorder(BorderFactory.createEmptyBorder(4, 10, 4, 10));
		statusBar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		window.add(statusBar, BorderLayout.SOUTH);

		// Update status dynamically (e.g., character count)
		textArea.addCaretListener(e -> {
			int length = textArea.getText().length();
			int lines = textArea.getLineCount();
			statusBar.setText("Length: " + length + "   |   Lines: " + lines);
		});
	}



	public void createMenuBar(){
		menuBar = new JMenuBar();
		window.setJMenuBar(menuBar);

		menuFile = new JMenu("File");
		menuFile.setMnemonic(KeyEvent.VK_F);
		menuBar.add(menuFile);

	    menuEdit = new JMenu("Edit");
	    menuEdit.setMnemonic(KeyEvent.VK_E);
	    menuBar.add(menuEdit);

	    menuView = new JMenu("View");
	    menuView.setMnemonic(KeyEvent.VK_V);
	    menuBar.add(menuView);

	    menuHelp = new JMenu("Help");
	    menuHelp.setMnemonic(KeyEvent.VK_H);
	    menuBar.add(menuHelp);

	    menuSetting = new JMenu("Setting");
	    menuSetting.setMnemonic(KeyEvent.VK_T);
	    menuBar.add(menuSetting);

		menuBar.setBackground(new Color(245, 245, 245)); // light gray
		menuBar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

		Font menuFont = new Font("Segoe UI", Font.BOLD, 16); // modern and bold

		for (JMenu menu : new JMenu[]{menuFile, menuEdit, menuView, menuHelp, menuSetting}) {
			menu.setFont(menuFont);
			menu.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 8));
			menu.setForeground(Color.DARK_GRAY); // modern gray tone
			menu.getPopupMenu().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
		}

	}

	public void createFileMenu() {
		menuFile.add(createItem("New (Ctrl+N)", "New"));
		menuFile.add(createItem("New Window (Ctrl+Shift+N)", "New Window"));
		menuFile.add(createItem("Open (Ctrl+O)", "Open"));
		menuFile.add(createItem("Save (Ctrl+S)", "Save"));
		menuFile.add(createItem("Save As (Ctrl+Shift+S)", "Save As"));
		menuFile.add(createItem("Print (Ctrl+P)", "Print"));
		menuFile.add(createItem("Exit (Ctrl+W)", "Exit"));
	}

	public void createEditMenu() {
		menuEdit.add(createItem("Undo (Ctrl+Z)", "Undo"));
		menuEdit.add(createItem("Redo (Ctrl+Y)", "Redo"));
		menuEdit.add(createItem("Cut (Ctrl+X)", "Cut"));
		menuEdit.add(createItem("Copy (Ctrl+C)", "Copy"));
		menuEdit.add(createItem("Paste (Ctrl+V)", "Paste"));
		menuEdit.add(createItem("Find (Ctrl+F)", "Find"));
		menuEdit.add(createItem("Select All (Ctrl+A)", "Select All"));
		menuEdit.add(createItem("Date/Time (F5)", "Date/Time"));
	}

	public void createViewMenu() {
		menuView.add(createItem("Zoom In (Ctrl +)", "Zoom In"));
		menuView.add(createItem("Zoom Out (Ctrl -)", "Zoom Out"));
		menuView.add(createItem("Restore Default Zoom (Ctrl+0)", "Restore Default Zoom"));

		status = new JCheckBoxMenuItem("Status Bar", true);
		status.setActionCommand("Status Bar");
		status.addActionListener(this);
		menuView.add(status);

		word = new JCheckBoxMenuItem("Word Wrap: ON", true);
		word.setActionCommand("Word Wrap");
		word.addActionListener(this);
		menuView.add(word);

		// Apply wrap initially
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);

		Font menuItemFont = new Font("Segoe UI", Font.PLAIN, 16);
		Color menuItemColor = Color.DARK_GRAY;

		for (JMenuItem item : new JMenuItem[]{status, word}) {
			item.setFont(menuItemFont);
			item.setForeground(menuItemColor);
			item.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // optional padding
		}
	}

	public void createHelpMenu() {
		menuHelp.add(createItem("About The Developer", "About The Developer"));
		menuHelp.add(createItem("About The Text-Editor", "About The Text-Editor"));
	}

	public void createSetMenu() {
		JMenu theme = new JMenu("App Theme");
		theme.add(createItem("Light", "Light"));
		theme.add(createItem("Dark", "Dark"));
		theme.add(createItem("Default", "Default"));
		menuSetting.add(theme);

		JMenu font = new JMenu("Font");
		menuSetting.add(font);

		JMenu family = new JMenu("Family");
		family.add(createItem("Arial", "Arial"));
		family.add(createItem("Bauhaus93", "Bauhaus93"));
		family.add(createItem("Calibri", "Calibri"));
		family.add(createItem("Comic Sans MS", "Comic Sans MS"));
		family.add(createItem("Courier New", "Courier New"));
		family.add(createItem("Georgia", "Georgia"));
		family.add(createItem("Times New Roman", "Times New Roman"));
		family.add(createItem("Verdana", "Verdana"));
		font.add(family);

		JMenu size = new JMenu("Size");
		size.add(createItem("8", "8"));
		size.add(createItem("9", "9"));
		size.add(createItem("10", "10"));
		size.add(createItem("12", "12"));
		size.add(createItem("14", "14"));
		size.add(createItem("16", "16"));
		size.add(createItem("18", "18"));
		size.add(createItem("20", "20"));
		size.add(createItem("24", "24"));
		size.add(createItem("28", "28"));
		size.add(createItem("48", "48"));
		size.add(createItem("72", "72"));
		font.add(size);

		JMenu style = new JMenu("Style");
		style.add(createItem("Regular", "Regular"));
		style.add(createItem("Bold", "Bold"));
		style.add(createItem("Italic", "Italic"));
		font.add(style);
	}

	private JMenuItem createItem(String name, String action) {
		JMenuItem item = new JMenuItem();
		item.setActionCommand(action);
		item.addActionListener(this);
		item.setFont(new Font("Segoe UI", Font.PLAIN, 16));

		// Optional: eliminate extra left spacing
		item.setIconTextGap(0);
		item.setMargin(new Insets(2, 4, 2, 4));
		item.setHorizontalTextPosition(SwingConstants.LEFT);
		item.setIcon(null);
		item.setFocusable(false);

		// Split label & shortcut
		String label = name;
		String shortcut = "";

		if (name.contains("(")) {
			int idx = name.indexOf('(');
			label = name.substring(0, idx).trim();
			shortcut = name.substring(idx).trim(); // e.g., (Ctrl+S)
		}

		item.setText("<html><table width='250'><tr>"
				+ "<td align='left'>" + label + "</td>"
				+ "<td align='right'><span style='color:gray;'>" + shortcut + "</span></td>"
				+ "</tr></table></html>");

		return item;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		switch (command) {
			case "New": file.newFile(); break;
			case "New Window": file.newWindow(); break;
			case "Open": file.openFile(); break;
			case "Save": file.saveFile(); break;
			case "Save As": file.saveAsFile(); break;
			case "Print": file.print(); break;
			case "Exit": file.exitFile(); break;

			case "Undo": edit.undo(); break;
			case "Redo": edit.redo(); break;
			case "Cut": edit.cut(); break;
			case "Copy": edit.copy(); break;
			case "Paste": edit.paste(); break;
			case "Find": edit.find(); break;
			case "Select All": edit.select(); break;
			case "Date/Time": edit.date(); break;

			case "Zoom In": view.zoomIn(); break;
			case "Zoom Out": view.zoomOut(); break;
			case "Restore Default Zoom": view.restore(); break;
			case "Status Bar": view.status(); break;
			case "Word Wrap": view.wrap(); break;

			case "About The Developer": help.about1(); break;
			case "About The Text-Editor": help.about2(); break;

			case "Light":
			case "Dark":
			case "Default": set.changeColor(command); break;

			case "Arial":
			case "Bauhaus93":
			case "Calibri":
			case "Comic Sans MS":
			case "Courier New":
			case "Georgia":
			case "Times New Roman":
			case "Verdana": set.family(command); break;


			case "8": set.size(8); break;
			case "9": set.size(9); break;
			case "10": set.size(10); break;
			case "12": set.size(12); break;
			case "14": set.size(14); break;
			case "16": set.size(16); break;
			case "18": set.size(18); break;
			case "20": set.size(20); break;
			case "24": set.size(24); break;
			case "28": set.size(28); break;
			case "48": set.size(48); break;
			case "72": set.size(72); break;

			case "Regular":
			case "Bold":
			case "Italic": set.font(command); break;

		}
	}
}






