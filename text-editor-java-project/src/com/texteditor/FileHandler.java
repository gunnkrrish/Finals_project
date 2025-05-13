package com.texteditor;

import javax.swing.*;
import java.io.*;
import java.util.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class FileHandler {
    
    private JTextArea textArea;

    public FileHandler(JTextArea textArea) {
        this.textArea = textArea;
    }

    public void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text files", "txt"));

        int response = fileChooser.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            try (Scanner fileIn = new Scanner(file)) {
                textArea.setText(""); // Clear the existing content
                while (fileIn.hasNextLine()) {
                    textArea.append(fileIn.nextLine() + "\n");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));

        int response = fileChooser.showSaveDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            try (PrintWriter fileOut = new PrintWriter(file)) {
                fileOut.println(textArea.getText());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
