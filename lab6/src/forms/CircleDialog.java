package forms;

import shapes.Circle;

import javax.swing.*;
import java.awt.event.*;

public class CircleDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField radiusText;
    private JLabel errorLabel;

    public CircleDialog(OnCreateListener onCreateListener) {
        setContentPane(contentPane);
        setModal(true);
        setTitle("Create circle");
        getRootPane().setDefaultButton(buttonOK);
        errorLabel.setVisible(false);
        buttonOK.addActionListener(e -> {
            try {
                double radius = Double.parseDouble(radiusText.getText());
                Circle circle = new Circle(radius);
                onCreateListener.create(circle);
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
        setBounds(0, 0, 300, 125);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
