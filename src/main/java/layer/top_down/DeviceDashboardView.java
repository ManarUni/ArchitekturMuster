package layer.top_down;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;


public class DeviceDashboardView extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    // Simpler DB-Connect
    Connection conn = DatabaseConnector.connect();
    DeviceRepository repo = new DeviceRepository(conn);
    DeviceService service = new DeviceService(repo);
    DeviceController controller = new DeviceController(service);

    // Dummy Device
    Device lamp = new Device(1, "Living Room Lamp", false);

    Button turnOnButton = new Button("Turn On");
    turnOnButton.setOnAction(e -> controller.onTurnOnButtonClicked(lamp));

    Button turnOffButton = new Button("Turn Off");
    turnOffButton.setOnAction(e -> controller.onTurnOffButtonClicked(lamp));

    VBox layout = new VBox(10, turnOnButton, turnOffButton);

    Scene scene = new Scene(layout, 300, 200);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Smart Home Dashboard");
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
