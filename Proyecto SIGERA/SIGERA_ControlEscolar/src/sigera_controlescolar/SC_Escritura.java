/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigera_controlescolar;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanj
 */
public class SC_Escritura {
    Channel Channel;
    Connection Connection;
    ConnectionFactory Factory;
    public SC_Escritura() throws URISyntaxException, NoSuchAlgorithmException, KeyManagementException, IOException, TimeoutException{
         Factory = new ConnectionFactory();
         Factory.setUri("amqp://gmlwmzpm:v3Xz7-Mv7chUuduRsg0mqG-XO4yeCyE7@chimpanzee.rmq.cloudamqp.com/gmlwmzpm");
         Connection = Factory.newConnection();
         Channel = Connection.createChannel();
    }
    
    public void CrearCola(String NomCola) throws URISyntaxException, NoSuchAlgorithmException, KeyManagementException, TimeoutException{
        try {
            Channel.queueDeclare(NomCola, false, false, false, null);
            Channel.close();
            Connection.close();
        } catch (IOException ex) {
            Logger.getLogger(SC_Escritura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Boolean enviarmsj(String NomCola, String Msj) throws IOException, TimeoutException, URISyntaxException{
        Boolean Envio = false;
        try {
            
            Factory = new ConnectionFactory();
            Factory.setUri("amqp://gmlwmzpm:v3Xz7-Mv7chUuduRsg0mqG-XO4yeCyE7@chimpanzee.rmq.cloudamqp.com/gmlwmzpm");
            Connection = Factory.newConnection();
            Channel = Connection.createChannel();
            Channel.basicPublish("", NomCola, null, Msj.getBytes("UTF-8"));
            Channel.close();
            Connection.close();
            Envio= true;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SC_Escritura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyManagementException ex) {
            Logger.getLogger(SC_Escritura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Envio;
    }
    public void EliminarCola(String NomCola) throws URISyntaxException, NoSuchAlgorithmException, KeyManagementException, TimeoutException{
        try {
            Channel.queueDelete(NomCola);
            Channel.close();
            Connection.close();
        } catch (IOException ex) {
            Logger.getLogger(SC_Escritura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
