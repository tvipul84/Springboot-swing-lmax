package net.vipul.jgroup;

import org.jgroups.JChannel;
import org.jgroups.Message;

import javax.swing.*;

public class ChatOperations {
    private JChannel channel;

    public ChatOperations(String ipAddress) throws Exception {
        System.setProperty("jgroups.bind_addr", ipAddress);
        channel = new JChannel();
        channel.connect("Chat");
    }

    public void sendMessage(String msg) throws Exception {
        channel.send(new Message(null, msg.getBytes()));
        System.out.println("Sending Successful");
    }

    public void receiveMessage(JTextArea receiver) {
        channel.receiver(r -> {
            receiver.setText(receiver.getText() + "Received: " + new String(r.rawBuffer()) + "\n");
            System.out.println("Receiving successful");
        });
    }

}
