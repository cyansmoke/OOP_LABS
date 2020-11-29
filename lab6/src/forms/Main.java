package forms;

import shapes.BaseShape;
import source.ShapeStore;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main extends JDialog {
    private JButton removeButton;
    private JButton createTriangleButton;
    private JButton createRectangleButton;
    private JButton createSquareButton;
    private JButton createCircleButton;
    private JButton moveDownButton;
    private JButton moveUpButton;
    public JPanel mainContent;
    private JList shapesList;


    public Main() {
        setContentPane(mainContent);
        ShapeStore shapesStore = new ShapeStore("shapes.json");
        List<BaseShape> shapes = new ArrayList<>(shapesStore.read());
        shapesList.setListData(shapes.toArray());
        System.out.print(shapes.toString());
        setContentPane(mainContent);
        setTitle("Shapes App");
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        moveDownButton.addActionListener(e -> {
            int index = shapesList.getSelectedIndex();
            if (index >= 0 && index < shapes.size()) {
                Collections.swap(shapes, index, index + 1);
                shapesList.setListData(shapes.toArray());
            }
        });
        moveUpButton.addActionListener(e -> {
            int index = shapesList.getSelectedIndex();
            if (index >= 0 && index < shapes.size()) {
                Collections.swap(shapes, index - 1, index);
                shapesList.setListData(shapes.toArray());
            }
        });
        removeButton.addActionListener(e -> {
            shapes.remove(shapesList.getSelectedIndex());
            shapesList.setListData(shapes.toArray());
        });

        createSquareButton.addActionListener(e -> {
            SquareDialog squareDialog = new SquareDialog(shape -> {
                shapes.add(shape);
                shapesList.setListData(shapes.toArray());
            });
            squareDialog.setVisible(true);
            squareDialog.pack();
        });
        createRectangleButton.addActionListener(e -> {
            RectangleDialog rectangleDialog = new RectangleDialog(shape -> {
               shapes.add(shape);
               shapesList.setListData(shapes.toArray());
            });
            rectangleDialog.setVisible(true);
            rectangleDialog.pack();
        });
        createCircleButton.addActionListener(e -> {
            CircleDialog circleDialog = new CircleDialog(shape -> {
                shapes.add(shape);
                shapesList.setListData(shapes.toArray());
            });
            circleDialog.setVisible(true);
            circleDialog.pack();
        });
        createTriangleButton.addActionListener(e -> {
            TriangleDialog triangleDialog = new TriangleDialog(shape -> {
                shapes.add(shape);
                shapesList.setListData(shapes.toArray());
            });
            triangleDialog.setVisible(true);
            triangleDialog.pack();
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("here");
                shapesStore.write(shapes);
                e.getWindow().dispose();
            }
        });

        setVisible(true);
        pack();
    }
}
