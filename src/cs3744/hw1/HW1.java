package cs3744.hw1;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * Color Mixer Desktop Tool Single view main class.
 * 
 * @author Kevin Cheng
 * @version 1
 */
public class HW1 extends Application {
    private static double MIN_COLOR_PERCENT = 0;
    private static double MAX_COLOR_PERCENT = 100;
    private static double INIT_COLOR_PERCENT = 0;

    /**
     * Initializes the GUI and shows the application window
     * 
     * @param stage Top level container
     */
    @Override
    public void start(Stage stage) throws Exception {
        
        HW1Model model = new HW1Model();
        HW1View view = new HW1View(MIN_COLOR_PERCENT, MAX_COLOR_PERCENT, MAX_COLOR_PERCENT);
        Scene scene = new Scene(view, 400, 500);
        try {
            scene.getStylesheets().add(getClass().getResource("hw1.css").toExternalForm());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        stage.setTitle("HW1: kevinc95");
        stage.setScene(scene);
        @SuppressWarnings("unused")
        HW1Controller controller = new HW1Controller(model, view, INIT_COLOR_PERCENT);
        stage.show();
    }

    /**
     * Invokes the program from the command line.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
