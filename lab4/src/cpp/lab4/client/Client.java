package cpp.lab4.client;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Client {
    public void run() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("client.fxml"));
        stage.setTitle("Client");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
        System.out.println(Thread.currentThread());
    }
}
