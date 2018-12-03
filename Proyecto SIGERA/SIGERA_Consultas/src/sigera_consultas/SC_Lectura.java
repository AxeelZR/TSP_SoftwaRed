/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigera_consultas;

import BD.BD;
import BD.BD_Usuario;
import com.rabbitmq.client.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author juanj
 */
public class SC_Lectura {


    public void RecibirMensaje(String NomCola, int id) throws IOException, TimeoutException {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setUri("amqp://gmlwmzpm:v3Xz7-Mv7chUuduRsg0mqG-XO4yeCyE7@chimpanzee.rmq.cloudamqp.com/gmlwmzpm");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(NomCola, false, false, false, null);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(" [x] Received '" + message + "'");
                    String[] Fecha = message.split(" ");
                    String fecha = "";
                    for (int i = 0; i < Fecha.length; i++) {
                        fecha = Fecha[i];
                    }
                    BD_Usuario mBD = new BD_Usuario();
                    try {
                        mBD.Conectar();
                        if (!mBD.InsertarMsj(id, message, fecha)) {
                            JOptionPane.showMessageDialog(null, "Error");
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(SC_Lectura.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            channel.basicConsume(NomCola, true, consumer);
        } catch (URISyntaxException ex) {
            Logger.getLogger(SC_Lectura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SC_Lectura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyManagementException ex) {
            Logger.getLogger(SC_Lectura.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
