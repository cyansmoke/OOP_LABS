package forms;

import shapes.Triangle;

import javax.swing.*;
import java.awt.event.*;

public class TriangleDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField secondSideText;
    private JTextField firstSideText;
    private JTextField thirdSideText;

    public TriangleDialog(OnCreateListener onCreateListener) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Create Triangle");

        buttonOK.addActionListener(e -> {
            double first = Double.parseDouble(firstSideText.getText());
            double second = Double.parseDouble(secondSideText.getText());
            double third = Double.parseDouble(thirdSideText.getText());
            onCreateListener.create(new Triangle(first, second, third));
            dispose();
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        setBounds(0, 0, 350, 300);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
