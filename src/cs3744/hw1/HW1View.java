package cs3744.hw1;

import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

/**
 * Color Mixer Desktop Tool single (view) view class.
 * Provides GUI.
 * 
 * @author Kevin Cheng
 * @version 1
 */
public class HW1View extends GridPane {
    private Label labelColor = null;
    private Label labelRed = null;
    private Label labelGreen = null;
    private Label labelBlue = null;
    private Slider sliderRed = null;
    private Slider sliderGreen = null;
    private Slider sliderBlue = null;
    private Label labelRedValue = null;
    private Label labelGreenValue = null;
    private Label labelBlueValue = null;
    
    /**
     * Creates an instance of HW1View.
     * 
     * @param min Minimum value of sliders
     * @param max Maximum value of sliders
     * @param init Starting value of slider pointer
     */
    public HW1View(double min, double max, double init) {
        super();
        
        // create row and column constraints
        setPadding(new Insets(10, 10, 10, 10));
        setVgap(10);
        setHgap(10);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(20);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(55);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(25);
        getColumnConstraints().addAll(col1, col2, col3);
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(70);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(10);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(10);
        RowConstraints row4 = new RowConstraints();
        row4.setPercentHeight(10);
        getRowConstraints().addAll(row1, row2, row3, row4);
        
        // populate graph with color box
        labelColor = new Label();
        labelColor.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        add(labelColor, 0, 0, 3, 1);
        labelColor.setId("labelColor");
        
        // populate graph with "Red" label
        labelRed = new Label("Red");
        labelRed.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        add(labelRed, 0, 1);
        labelRed.setId("labelRed");
        
        // populate graph with "Green" label
        labelGreen = new Label("Green");
        labelGreen.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        add(labelGreen, 0, 2);
        labelGreen.setId("labelGreen");
        
        // populate graph with "Blue" label
        labelBlue = new Label("Blue");
        labelBlue.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        add(labelBlue, 0, 3);
        labelBlue.setId("labelBlue");
        
        // populate graph with slider, with a listener to update labelRedValue
        sliderRed = new Slider(min, max, init);
        sliderRed.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        add(sliderRed, 1, 1);
        sliderRed.setId("sliderRed");
        sliderRed.valueProperty().addListener((ObservableValue<? extends Number> o,Number oldVal, Number newVal) ->
                        labelRedValue.setText(String.format("%.2f", newVal.doubleValue())));
        
        // populate graph with slider, with a listener to update labelGreenValue
        sliderGreen = new Slider(min, max, init);
        sliderGreen.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        add(sliderGreen, 1, 2);
        sliderGreen.setId("sliderGreen");
        sliderGreen.valueProperty().addListener((ObservableValue<? extends Number> o,Number oldVal, Number newVal) ->
                        labelGreenValue.setText(String.format("%.2f", newVal.doubleValue())));
        
        // populate graph with slider, with a listener to update labelBlueValue
        sliderBlue = new Slider(min, max, init);
        sliderBlue.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        add(sliderBlue, 1, 3);
        sliderBlue.setId("sliderBlue");
        sliderBlue.valueProperty().addListener((ObservableValue<? extends Number> o,Number oldVal, Number newVal) ->
                        labelBlueValue.setText(String.format("%.2f", newVal.doubleValue())));
        
        // populate graph with red value label to indicate value of sliderRed
        labelRedValue = new Label(String.format("%.2f", init));
        labelRedValue.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        add(labelRedValue, 2, 1);
        labelRedValue.setId("labelRedValue");
        labelRedValue.setTextFill(Color.RED);
        
        // populate graph with green value label to indicate value of sliderGreen
        labelGreenValue = new Label(String.format("%.2f", init));
        labelGreenValue.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        add(labelGreenValue, 2, 2);
        labelGreenValue.setId("labelGreenValue");
        labelGreenValue.setTextFill(Color.GREEN);
        
        // populate graph with blue value label to indacate value of sliderBlue
        labelBlueValue = new Label(String.format("%.2f", init));
        labelBlueValue.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        add(labelBlueValue, 2, 3);
        labelBlueValue.setId("labelBlueValue");
        labelBlueValue.setTextFill(Color.BLUE);
    }
    
    /**
     * Sets the color of the color box in the GUI.
     * @param c Color to set the color box to
     */
    public void setColor(Color c) {
        labelColor.setStyle("-fx-background-color: rgb(" + c.getRed() * 100 + "%, " + c.getGreen() * 100 + "%, " + c.getBlue() * 100 + "%);");
    }
    
    /**
     * Get red percentage value based on sliderRed position
     * @return red percentage value
     */
    public final double getRedValue() { return redProperty().get(); }
    
    /**
     * Get green percentage value based on sliderGreen position
     * @return green percentage value
     */
    public final double getGreenValue() { return greenProperty().get(); }
    
    /**
     * Get blue percentage value based on sliderBlue position
     * @return blue percentage value
     */
    public final double getBlueValue() { return blueProperty().get(); }
    
    /**
     * Set the value position of sliderRed to parameter
     * @param value Value for the red slider to be set to
     */
    public final void setRedValue(double value) { redProperty().set(value); }
    
    /**
     * Set the value position of sliderGreen to parameter
     * @param value Value for the green slider to be set to
     */
    public final void setGreenValue(double value) { greenProperty().set(value); }
    
    /**
     * Set the value position of sliderBlue to parameter
     * @param value Value for the blue slider to be set to
     */
    public final void setBlueValue(double value) { blueProperty().set(value); }
    
    /**
     * Returns the DoubleProperty displayed by sliderRed
     * @return DoubleProperty of sliderRed
     */
    public DoubleProperty redProperty() { return sliderRed.valueProperty(); }
    
    /**
     * Returns the DoubleProperty displayed by sliderGreen
     * @return DoubleProperty of sliderGreen
     */
    public DoubleProperty greenProperty() { return sliderGreen.valueProperty(); }
    
    /**
     * Returns the DoubleProperty displayed by sliderBlue
     * @return DoubleProperty of sliderBlue
     */
    public DoubleProperty blueProperty() { return sliderBlue.valueProperty(); }
}
