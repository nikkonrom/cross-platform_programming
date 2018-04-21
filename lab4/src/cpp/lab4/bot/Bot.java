package cpp.lab4.bot;
import java.util.HashMap;
import java.util.Map;

public class Bot implements Runnable
{
    private Map<String, String> messages = new HashMap<>();


    public Bot(){
        messages.put("Hello", "Hello");
        messages.put("Bye", "Good bye!");
        messages.put("How are you?", "I'm fine, thank you");
    }

    @Override
    public void run() {

    }
}
