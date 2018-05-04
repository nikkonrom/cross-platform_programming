package cpp.lab4;

import java.util.concurrent.BlockingQueue;

public class Message {
    public String messageData;
    public BlockingQueue<String> sender;

    public Message(String messageData, BlockingQueue<String> sender){
        this.messageData = messageData;
        this.sender = sender;
    }
}
