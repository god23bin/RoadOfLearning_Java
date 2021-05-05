package com.bin23.chat.ui.csub;

import javax.swing.*;
import java.awt.*;

public class LabelAndTextField extends JPanel {
    private JLabel label;
    private JTextField textField;

    public LabelAndTextField() {
    }

    public LabelAndTextField(int size_x, int size_y, String _L) {
        this.setSize(size_x, size_y);
        label = new JLabel(_L);
        BoxLayout layout = new BoxLayout(this, BoxLayout.X_AXIS);
        this.setLayout(layout);
        textField = new JTextField();
        textField.setSize(size_x - 100, size_y);
        textField.setPreferredSize(new Dimension(size_x - 100, size_y));
        textField.setMaximumSize(new Dimension(size_x - 100, size_y));
        this.add(label);
        this.add(textField);
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }
}
