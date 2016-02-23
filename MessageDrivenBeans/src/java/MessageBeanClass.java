
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

@ManagedBean
@SessionScoped
public class MessageBeanClass 
{
    @Resource(lookup = "java:/ConnectionFactory")
    private ConnectionFactory connectionFactory;
    
    @Resource(lookup = "java:/jms/queue/ExpiryQueue")
    private Queue queue;
    
    public String sendMessage()
    {
        Connection connection=null;
        try {
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(queue);
            ObjectMessage jsmMessage = session.createObjectMessage();
            jsmMessage.setObject(message);
            producer.send(jsmMessage);
        } 
        catch (JMSException e) 
        {
            System.err.println("Hata Meydana Geldi:"+e);
        }
        
        finally
        {
            try {
                connection.close();
            } catch (Exception e) {
                System.err.println("Hata Meydana Geldi:"+e);
            }
            
        }
        return "";
    }
    
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
