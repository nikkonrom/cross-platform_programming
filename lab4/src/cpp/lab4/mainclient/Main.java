package cpp.lab4.mainclient;

import cpp.lab4.bot.Bot;
import cpp.lab4.client.Client;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Main extends Application {

    private static Bot bot;
    private static List<Client> clients;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainclient.fxml"));
        primaryStage.setTitle("Main client");
        primaryStage.setScene(new Scene(root, 600, 275));
        primaryStage.show();
        System.out.println(Thread.currentThread());
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void createBot(){
        bot = new Bot();
        new Thread(bot,"Bot").start();
    }

    public static void createClient(){
        Client client = new Client();
        try {
            client.run(bot);
        } catch (IOException e) {
            e.printStackTrace();
    }
}}
