
import java.io.Serializable;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ilkaygunel
 */
@MessageDriven(activationConfig = {
@ActivationConfigProperty(propertyName = "destinationLookup",propertyValue = "java:/jms/queue/ExpiryQueue"),
@ActivationConfigProperty(propertyName = "destinationType",propertyValue = "javax.jms.Queue")
} )
public class MessageDrivenBean implements MessageListener,Serializable{

    @EJB
    private EJBInterface ejbInterface;
    @Override
    public void onMessage(Message message) {
        try {
            ObjectMessage objectMessage = (ObjectMessage) message;
            String receivedMessage = (String) objectMessage.getObject();
            ejbInterface.writeMessageToConsole(receivedMessage);
        } catch (JMSException e) {
            System.out.println("Hata oldu!:"+e);
        }
    }
    
}
