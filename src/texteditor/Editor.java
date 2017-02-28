package texteditor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class Editor {
    private JPanel mainPanel;
    private JTextArea textArea;
    private JMenuBar menuBar;
    private File file;

    private final JFileChooser fc = new JFileChooser();

    private void createUIComponents() {
        menuBar = new MenuBar();
        menuBar.getMenu(0).getItem(0).addActionListener((ActionEvent e) -> {
            textArea.setText("");
            file = null;
        });
        menuBar.getMenu(0).getItem(1).addActionListener((ActionEvent e) -> open());
        menuBar.getMenu(0).getItem(2).addActionListener((ActionEvent e) -> save(false));
        menuBar.getMenu(0).getItem(3).addActionListener((ActionEvent e) -> save(true));

    }

    private void open() {
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                textArea.read(reader, file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void save(boolean saveAs) {
        if (file == null || saveAs)
            if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
                file = fc.getSelectedFile();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file + ".txt"))) {
            writer.write(textArea.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ben's Text Editor");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(new Editor().mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
