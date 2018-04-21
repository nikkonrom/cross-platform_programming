package cpp.lab4.mainclient;

public class Controller {
    public void OnStartBotButtonClick(){
        Main.createBot();
        System.out.println("Bot started");
    }

    public void OnCreateClientButtonClick(){
        Main.createClient();
        System.out.println("Client created");
    }
}
