package forms;

import shapes.Square;

import javax.swing.*;
import java.awt.event.*;

public class SquareDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField sideText;
    private JLabel errorLabel;

    public SquareDialog(OnCreateListener onCreateListener) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Create Square");
        errorLabel.setVisible(false);

        buttonOK.addActionListener(e -> {
            try {
                double side = Double.parseDouble(sideText.getText());
                Square square = new Square(side);
                onCreateListener.create(square);
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
