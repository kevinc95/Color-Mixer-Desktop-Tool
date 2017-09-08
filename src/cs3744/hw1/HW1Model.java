package cs3744.hw1;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.paint.Color;

/**
 * Color Mixer Desktop Tool single (view) model class.
 * Stores the values for RGB.
 * 
 * @author Kevin Cheng
 * @version 1
 */
public class HW1Model {
    
    private DoubleProperty redValue = null;
    private DoubleProperty greenValue = null;
    private DoubleProperty blueValue = null;
    private ObjectProperty<Color> color = null;
    
    /**
     * Creates instance of HW1Model class.
     */
    public HW1Model() {
        redValue = new SimpleDoubleProperty();
        greenValue = new SimpleDoubleProperty();
        blueValue = new SimpleDoubleProperty();
        color = new SimpleObjectProperty<Color>();
        
        // if redValue, greenValue, or blueValue ever changes, color updates accordingly
        redValue.addListener((ObservableValue<? extends Number> o, Number oldVal, Number newVal) ->
            color.set(calculateColor(newVal.doubleValue(), greenValue.doubleValue(), blueValue.doubleValue())));
        greenValue.addListener((ObservableValue<? extends Number> o, Number oldVal, Number newVal) ->
            color.set(calculateColor(redValue.doubleValue(), newVal.doubleValue(), blueValue.doubleValue())));
        blueValue.addListener((ObservableValue<? extends Number> o, Number oldVal, Number newVal) ->
            color.set(calculateColor(redValue.doubleValue(), greenValue.doubleValue(), newVal.doubleValue())));
    }
    
    /**
     * Gets the red percentage value
     * @return redValue's double
     */
    public final double getRedValue() { return redValue.get(); }
    
    /**
     * Sets the red percentage value
     * @param val New red percentage
     */
    public final void setRedValue(double val) { redValue.set(val); }
    
    /**
     * Get DoubleProperty of red percentage value
     * @return redValue
     */
    public DoubleProperty redValueProperty() { return redValue; }
    
    /**
     * Gets the green percentage value
     * @return greenValue's double
     */
    public final double getGreenValue() { return greenValue.get(); }
    
    /**
     * Sets the green percentage value
     * @param val New green percentage
     */
    public final void setGreenValue(double val) { greenValue.set(val); }
    
    /**
     * Get DoubleProperty of green percentage value
     * @return greenValue
     */
    public DoubleProperty greenValueProperty() { return greenValue; }
    
    /**
     * Gets the blue percentage value
     * @return blueValue's double
     */
    public final double getBlueValue() { return blueValue.get(); }
    
    /**
     * Sets the blue percentage value
     * @param val New blue percentage
     */
    public final void setBlueValue(double val) { blueValue.set(val); }
    
    /**
     * Get DoubleProperty of blue percentage value
     * @return blueValue
     */
    public DoubleProperty blueValueProperty() { return blueValue; }
    
    /**
     * Gets the color object
     * @return color's object
     */
    public final Color getColor() { return color.get(); }
    
    /**
     * Sets the color value
     * @param col New color object
     */
    public final void setColor(Color col) { color.set(col); }
    
    /**
     * Gets ObjectProperty of color object
     * @return color
     */
    public ObjectProperty<Color> colorProperty() { return color; }
    
    /**
     * Calculates the color based on the percentage of red, green, and blue
     * @param redPercent Percentage of red
     * @param greenPercent Percentage of green
     * @param bluePercent Percentage of blue
     * @return resulting color 
     */
    private Color calculateColor(double redPercent, double greenPercent, double bluePercent) {
        
        double redNumerator = (redPercent / 100) * 255;
        double greenNumerator = (greenPercent / 100) * 255;
        double blueNumerator = (bluePercent / 100) * 255;
        return new Color(redNumerator / 255, greenNumerator / 255, blueNumerator / 255, 1);
    }
}
