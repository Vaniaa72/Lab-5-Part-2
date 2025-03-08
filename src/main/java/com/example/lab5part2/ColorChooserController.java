package com.example.lab5part2;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorChooserController {

    @FXML private Slider redSlider;
    @FXML private TextField redTextField;
    @FXML private Slider greenSlider;
    @FXML private TextField greenTextField;
    @FXML private Slider blueSlider;
    @FXML private TextField blueTextField;
    @FXML private Slider alphaSlider;
    @FXML private TextField alphaTextField;
    @FXML private Rectangle colorRectangle;

    // Define properties for bidirectional binding
    private final DoubleProperty redValue = new SimpleDoubleProperty();
    private final DoubleProperty greenValue = new SimpleDoubleProperty();
    private final DoubleProperty blueValue = new SimpleDoubleProperty();
    private final DoubleProperty alphaValue = new SimpleDoubleProperty();

    @FXML
    public void initialize() {
        // Bind sliders to properties
        redSlider.valueProperty().bindBidirectional(redValue);
        greenSlider.valueProperty().bindBidirectional(greenValue);
        blueSlider.valueProperty().bindBidirectional(blueValue);
        alphaSlider.valueProperty().bindBidirectional(alphaValue);

        // Bind text fields to properties
        ((Property<String>) redValue.asString()).bindBidirectional(redTextField.textProperty());
        greenTextField.textProperty().bindBidirectional((Property<String>) greenValue.asString());
        blueTextField.textProperty().bindBidirectional((Property<String>) blueValue.asString());
        alphaTextField.textProperty().bindBidirectional((Property<String>) alphaValue.asString());

        // Add listener to update color
        redValue.addListener((observable, oldValue, newValue) -> updateColor());
        greenValue.addListener((observable, oldValue, newValue) -> updateColor());
        blueValue.addListener((observable, oldValue, newValue) -> updateColor());
        alphaValue.addListener((observable, oldValue, newValue) -> updateColor());
    }

    private void updateColor() {
        Color color = new Color(redValue.get() / 255.0, greenValue.get() / 255.0,
                blueValue.get() / 255.0, alphaValue.get());
        colorRectangle.setFill(color);
    }
}