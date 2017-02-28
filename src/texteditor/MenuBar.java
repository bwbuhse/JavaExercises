package texteditor;

import javax.swing.*;

class MenuBar extends JMenuBar {

	MenuBar() {
		JMenu fileMenu;
		JMenuItem newFile;
		JMenuItem open;
		JMenuItem save;
		JMenuItem saveAs;

		fileMenu = new JMenu("File");
		newFile = new JMenuItem("New");
		open = new JMenuItem("Open");
		save = new JMenuItem("Save");
		saveAs = new JMenuItem("Save As");

		this.add(fileMenu);

		fileMenu.add(newFile);
		fileMenu.add(open);
		fileMenu.add(save);
		fileMenu.add(saveAs);
	}
}
