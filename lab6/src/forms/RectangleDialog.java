package forms;

import shapes.Rectangle;

import javax.swing.*;
import java.awt.event.*;

public class RectangleDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField widthText;
    private JTextField heightText;
    private JLabel errorLabel;

    public RectangleDialog(OnCreateListener onCreateListener) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Create Rectangle");

        buttonOK.addActionListener(e -> {
            double width = 0;
            double height = 0;
            try {
                width = Double.parseDouble(widthText.getText());
                height = Double.parseDouble(heightText.getText());
                Rectangle rectangle = new Rectangle(width, height);
                onCreateListener.create(rectangle);
                dispose();
            } catch (Exception err) {
                errorLabel.setVisible(true);
            }
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

        setBounds(0, 0, 350, 250);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
