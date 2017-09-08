package cs3744.hw1;

import javafx.beans.value.ObservableValue;
import javafx.scene.paint.Color;

/**
 * Color Mixer Desktop Tool Single (view) controller class.
 * Coordinates model and view.
 * 
 * @author Kevin Cheng
 * @version 1
 */
public class HW1Controller {
    
    /**
     * Creates an instance of the HW1Controller class
     * @param m The model object
     * @param v The view object
     * @param init Starting value for the sliders
     */
    public HW1Controller(HW1Model m, HW1View v, double init) {
        // if the colorProperty ever changes in model, change the color of color box in view
        m.colorProperty().addListener((ObservableValue<? extends Color> o, Color oldVal, Color newVal) 
                -> v.setColor(newVal) );
        
        // if redProperty, greenProperty, or blueProperty ever change in view, update according values in model
        v.redProperty().addListener((ObservableValue<? extends Number> o, Number oldVal, Number newVal) 
                -> m.setRedValue(Math.round(newVal.doubleValue() * 100.0) / 100.0));
        v.greenProperty().addListener((ObservableValue<? extends Number> o, Number oldVal, Number newVal)
                -> m.setGreenValue(Math.round(newVal.doubleValue() * 100.0) / 100.0));
        v.blueProperty().addListener((ObservableValue<? extends Number> o, Number oldVal, Number newVal)
                -> m.setBlueValue(Math.round(newVal.doubleValue() * 100.0) / 100.0));
        
        // set starting value of sliders in view to init
        v.setRedValue(init);
        v.setGreenValue(init);
        v.setBlueValue(init);
        
        // set starting color of color box in view to color of init
        v.setColor(new Color(init, init, init, 1));
    }
}
