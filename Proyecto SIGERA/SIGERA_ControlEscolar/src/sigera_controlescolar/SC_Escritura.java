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
    Channel channel;
    Connection connection;
    ConnectionFactory factory;
    public SC_Escritura() throws URISyntaxException, NoSuchAlgorithmException, KeyManagementException, IOException, TimeoutException{
         factory = new ConnectionFactory();
         factory.setUri("amqp://gmlwmzpm:v3Xz7-Mv7chUuduRsg0mqG-XO4yeCyE7@chimpanzee.rmq.cloudamqp.com/gmlwmzpm");
         connection = factory.newConnection();
         channel = connection.createChannel();
    }
    
    public String CrearCola(String NomCola) throws URISyntaxException, NoSuchAlgorithmException, KeyManagementException, TimeoutException{
        String msj="";
        try {
    channel.queueDeclare(NomCola, false, false, false, null);
            msj = "cola " + NomCola + " creada";
            channel.close();
            connection.close();
        } catch (IOException ex) {
            Logger.getLogger(SC_Escritura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return msj;
    }
    
    public Boolean enviarmsj(String NomCola, Alumno mAlumno) throws IOException, TimeoutException{
        Boolean envio = false;
        String Msj= "El Alumno " + mAlumno.getNombre() + "ha sido inscrito";
        channel.basicPublish("", NomCola, null, Msj.getBytes("UTF-8"));
        channel.close();
        connection.close();
        return envio;
    }
    
}
