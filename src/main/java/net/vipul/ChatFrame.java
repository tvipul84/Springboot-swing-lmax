package net.vipul;

import net.vipul.jgroup.ChatOperations;

import java.awt.event.ActionEvent;

public class ChatFrame extends javax.swing.JFrame {
    private ChatOperations chatOperations;

    public ChatFrame() {
        try {
            initComponents();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void initComponents() throws Exception {

        msgLabel = new javax.swing.JLabel();

        sendButton = new javax.swing.JButton();

        msgTextField = new javax.swing.JTextField();

        closeButton = new javax.swing.JButton();
        chatScrollPane = new javax.swing.JScrollPane();
        msgTextArea = new javax.swing.JTextArea();

        msgLabel.setText("Message");
        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sendButtonActionPerformed(e);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Spring Boot - Chat Application");

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        msgTextArea.setEditable(false);
        msgTextArea.setColumns(20);
        msgTextArea.setLineWrap(true);
        msgTextArea.setRows(5);
        msgTextArea.setText("");
        msgTextArea.setWrapStyleWord(true);
        chatScrollPane.setViewportView(msgTextArea);
        chatOperations = new ChatOperations();
        msgTextArea.setText(msgTextArea.getText() + "Connected\n");
        chatOperations.receiveMessage(msgTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(msgLabel)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(msgTextField)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(sendButton)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(chatScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(closeButton)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(msgLabel)
                                .addComponent(msgTextField)
                                .addGap(16, 16, 16)
                                .addComponent(sendButton)
                                .addGap(16, 16, 16)
                                .addComponent(chatScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(closeButton)
                                .addGap(20, 20, 20))
        );

        pack();
    }

    private void sendButtonActionPerformed(ActionEvent e) throws Exception {
        chatOperations.sendMessage(msgTextField.getText());
    }

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JScrollPane chatScrollPane;
    private javax.swing.JTextArea msgTextArea;

    private javax.swing.JLabel msgLabel;
    private javax.swing.JTextField msgTextField;
    private javax.swing.JButton sendButton;

}
