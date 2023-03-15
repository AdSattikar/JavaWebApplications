/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jms_sender;

import javax.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class JMS_Sender {

    static String SeviceName = "Queue1";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JMSException {
        String url = "failover://tcp://localhost:61616";
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue q = session.createQueue(SeviceName);
        MessageProducer producer = session.createProducer(q);
        TextMessage message = session.createTextMessage();
        System.out.println("Enter the message: ");
        Scanner s = new Scanner(System.in);
        String sendmessage = s.nextLine();
        
        String ALPHABET = "abcdefghijklmnopqrstuvwxyz";   
        // convert inputStr into lower case   
        String inputStr = sendmessage.toLowerCase();
        
        System.out.println("Enter Secret Key: ");
        
        int shiftKey = s.nextInt();
        // encryptStr to store encrypted data   
        String encryptStr = "";

        // use for loop for traversing each character of the input string   
        for (int i = 0; i < inputStr.length(); i++) {
            // get position of each character of inputStr in ALPHABET   
            int pos = ALPHABET.indexOf(inputStr.charAt(i));

            // get encrypted char for each char of inputStr   
            int encryptPos = (shiftKey + pos) % 26;
            char encryptChar = ALPHABET.charAt(encryptPos);

            // add encrypted char to encrypted string   
            encryptStr += encryptChar;
        }
        message.setText(encryptStr);
        producer.send(message);
        System.out.println("Sent message '" + message.getText() + "'");
    }

}
