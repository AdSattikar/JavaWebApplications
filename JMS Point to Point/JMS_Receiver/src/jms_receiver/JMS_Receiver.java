/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jms_receiver;

import javax.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class JMS_Receiver {

    static String SeviceName = "Queue1";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JMSException {
// Getting JMS connection from the server
        String url = "tcp://localhost:61616";
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.setClientID("Client2");
        connection.start();
        Session session
                = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue q1 = session.createQueue(SeviceName);
        MessageConsumer consumer = session.createConsumer(q1);
        MessageListener listner = new MessageListener() {
            public void onMessage(Message message) {
                try {
                    if (message instanceof TextMessage) {
                        TextMessage textMessage = (TextMessage) message;
                        System.out.println("Received message '" + textMessage.getText() + "'");
                        
                        //Entering the secret Key
                        Scanner sc = new Scanner(System.in);
                        System.out.print("Enter Secret Key  : ");
                        int shiftKey = sc.nextInt();
                        
                        String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
                        
                        // convert inputStr into lower case   
                        String Str = ""+textMessage.getText();
                        String inputStr = Str.toLowerCase();
                        System.out.println(inputStr);
                        // decryptStr to store decrypted data   
                        String decryptStr = "";

                        // use for loop for traversing each character of the input string   
                        for (int i = 0; i < inputStr.length(); i++) {

                            // get position of each character of inputStr in ALPHABET   
                            int pos = ALPHABET.indexOf(inputStr.charAt(i));

                            // get decrypted char for each char of inputStr   
                            int decryptPos = (pos - shiftKey) % 26;

                            // if decryptPos is negative   
                            if (decryptPos < 0) {
                                decryptPos = ALPHABET.length() + decryptPos;
                            }
                            char decryptChar = ALPHABET.charAt(decryptPos);

                            // add decrypted char to decrypted string   
                            decryptStr += decryptChar;
                        }
                        System.out.println("Decrypting...");
                        System.out.println(decryptStr);
                    }
                } catch (JMSException e) {
                    System.out.println("Caught:" + e);
                    e.printStackTrace();
                }
            }
        };
        consumer.setMessageListener(listner);
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.close();
    }
}
