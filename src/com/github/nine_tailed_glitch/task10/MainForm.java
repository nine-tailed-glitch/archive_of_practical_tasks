package com.github.nine_tailed_glitch.task10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;

public class MainForm {
    private JPanel mainPanel;
    private JTextArea textArea;
    private JButton countButton;
    private JButton clearButton;

    public MainForm() {
        clearButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });

        countButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                int length = text.length();
                JOptionPane.showConfirmDialog(
                        mainPanel,
                        length + " симв.",
                        "Длина текста",
                        JOptionPane.PLAIN_MESSAGE
                );
            }
        });

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
