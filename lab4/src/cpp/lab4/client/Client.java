package cpp.lab4.client;
import cpp.lab4.Message;
import cpp.lab4.bot.Bot;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Observer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Client {
    @FXML
    private TextField sendField;

    @FXML
    private ListView messageView;

    private Bot chatBot;
    private BlockingQueue<String> stringQueue;

    @FXML
    public void OnSendButtonClick() throws InterruptedException {
        chatBot.messageQueue.put(new Message(sendField.getText(), stringQueue));
    }

    private void Poll(){
        while (true){
            String message;
            while ((message = stringQueue.poll()) != null){
                messageView.getItems().add(message);
            }
        }
    }


    public void run(Bot bot) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("client.fxml"));
        stage.setTitle("Client");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
        System.out.println(Thread.currentThread());
        this.chatBot = bot;
        this.stringQueue = new LinkedBlockingQueue<>();
        Thread thread = new Thread(this::Poll);
        thread.start();
    }
}
