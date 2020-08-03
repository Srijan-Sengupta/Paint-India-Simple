package com.srijan.javafx.paintIndia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class PaintIndiaController {
    @FXML
    public Button undo;

    @FXML
    public Button clear;
    //Drawing pane:
    @FXML
    private Pane pane;
    //toggleGroup:
    @FXML
    private ToggleGroup toggleGroup;
    //Colour picker
    @FXML
    private ColorPicker colorPicker;
    // Radio Buttons:
    @FXML
    private RadioButton smallest;
    @FXML
    private RadioButton small;
    @FXML
    private RadioButton medium;
    @FXML
    private RadioButton large;
    @FXML
    private RadioButton largest;

    //Drawing method:
    @FXML
    public void draw(MouseEvent event) {
        Circle circle = new Circle(
                event.getX(),
                event.getY(),
                ((penSize) toggleGroup.getSelectedToggle().getUserData()).getRadius(),
                colorPicker.getValue()
        );

        pane.getChildren().add(circle);
        // Logger.getLogger("Paint-India").log(Level.INFO, circle.toString());
    }

    @FXML
    public void clear(ActionEvent event) {
        pane.getChildren().clear();
    }

    @FXML
    public void undo(ActionEvent event) {
        if (pane.getChildren().size() != 0)
            pane.getChildren().remove(pane.getChildren().size() - 1);
    }

    @FXML
    public void initialize() {
        medium.setSelected(true);

        smallest.setUserData(penSize.SMALLEST);
        small.setUserData(penSize.SMALL);
        medium.setUserData(penSize.MEDIUM);
        large.setUserData(penSize.LARGE);
        largest.setUserData(penSize.LARGEST);
    }

    private enum penSize {
        SMALLEST(10),
        SMALL(15),
        MEDIUM(20),
        LARGE(25),
        LARGEST(30);

        private final int radius;

        penSize(int radius) {
            this.radius = radius;
        }

        public int getRadius() {
            return radius;
        }
    }

}
