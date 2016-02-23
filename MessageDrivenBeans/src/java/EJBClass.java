
import javax.ejb.Stateless;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ilkaygunel
 */
@Stateless
public class EJBClass implements EJBInterface{

    @Override
    public void writeMessageToConsole(String message) {
        System.out.println("Gelen Mesaj:"+message+"\n");
    }
    
}
