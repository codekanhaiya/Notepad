package com.notepad;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	GUI gui;

	public KeyHandler(GUI gui) {
		this.gui = gui;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// Not needed
	}

	@Override
	public void keyPressed(KeyEvent e) {
		boolean ctrl = e.isControlDown();
		boolean shift = e.isShiftDown();
		int code = e.getKeyCode();

		// File shortcuts
		if (ctrl && code == KeyEvent.VK_N && !shift) gui.file.newFile();
		if (ctrl && shift && code == KeyEvent.VK_N) gui.file.newWindow();
		if (ctrl && code == KeyEvent.VK_O) gui.file.openFile();
		if (ctrl && code == KeyEvent.VK_S && !shift) gui.file.saveFile();
		if (ctrl && shift && code == KeyEvent.VK_S) gui.file.saveAsFile();
		if (ctrl && code == KeyEvent.VK_P) gui.file.print();
		if (ctrl && code == KeyEvent.VK_W) gui.file.exitFile();

		// Edit shortcuts
		if (ctrl && code == KeyEvent.VK_Z) gui.edit.undo();
		if (ctrl && code == KeyEvent.VK_Y) gui.edit.redo();
		if (ctrl && code == KeyEvent.VK_X) gui.edit.cut();
		if (ctrl && code == KeyEvent.VK_C) gui.edit.copy();
		if (ctrl && code == KeyEvent.VK_V) gui.edit.paste();
		if (ctrl && code == KeyEvent.VK_F) gui.edit.find();
		if (ctrl && code == KeyEvent.VK_A) gui.edit.select();
		if (code == KeyEvent.VK_F5) gui.edit.date(); // F5 = Date/Time

		// View shortcuts
		if (ctrl && code == KeyEvent.VK_EQUALS) gui.view.zoomIn();  // Ctrl + =
		if (ctrl && code == KeyEvent.VK_MINUS) gui.view.zoomOut();  // Ctrl + -
		if (ctrl && code == KeyEvent.VK_0) gui.view.restore();      // Ctrl + 0
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Not needed
	}
}
