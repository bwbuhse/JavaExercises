package texteditor;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    private JMenu fileMenu;
    private JMenuItem newFile;
    private JMenuItem open;
    private JMenuItem save;
    private JMenuItem saveAs;

    public MenuBar() {
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
