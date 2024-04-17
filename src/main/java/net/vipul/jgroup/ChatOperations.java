package net.vipul.jgroup;

import org.jgroups.JChannel;
import org.jgroups.Message;

import javax.swing.*;

public class ChatOperations {
    private JChannel channel = new JChannel();

    public ChatOperations() throws Exception {
/*
        System.setProperty("jgroups.bind_addr", ipAddress);
        Util.checkIfValidAddress(InetAddress.getByName(ipAddress), "UDP");
        UDP udp = new UDP();
        udp.setBindAddress(InetAddress.getByName(ipAddress));
        channel = new JChannel(udp);
*/
        channel.connect("Chat");
    }

    public void sendMessage(String msg) throws Exception {
        channel.send(new Message(null, msg.getBytes()));
    }

    public void receiveMessage(JTextArea receiver) {
        channel.receiver(r -> {
            receiver.setText(receiver.getText() + r.getSrc().toString() + ": " + new String(r.rawBuffer()) + "\n");
        });
    }

}
