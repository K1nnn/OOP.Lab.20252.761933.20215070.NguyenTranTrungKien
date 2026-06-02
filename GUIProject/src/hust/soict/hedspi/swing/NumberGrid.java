package hust.soict.hedspi.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10];
    private Button btnDelete, btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(
                ComponentOrientation.RIGHT_TO_LEFT);
        JPanel panelButtons = new JPanel(new GridLayout(4, 3));
        addButtons(panelButtons);
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(200, 200);
        setVisible(true);
    }

    void addButtons(JPanel panelButtons) {
        ButtonListener btnListener = new ButtonListener();
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton("" + i);
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener);
        }

        // Add DEL button
        btnDelete = new Button("DEL");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(btnListener);

        // Add C button
        btnReset = new Button("C");
        panelButtons.add(btnReset);
        btnReset.addActionListener(btnListener);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
                tfDisplay.setText(tfDisplay.getText() + button);
            } else if (button.equals("DEL")) {
                // handles the "DEL" case
                String text = tfDisplay.getText();
                if (text.length() > 0) {
                    text = text.substring(0, text.length() - 1);
                    tfDisplay.setText(text);
                }
            } else {
                // handles the "C" case"
                tfDisplay.setText("");
            }
        }
    }
    public static void main(String[] args) {
        new NumberGrid();
    }
}
