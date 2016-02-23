/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmaticTimer;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class TimerBean implements Serializable{
    String name;

    @EJB
    private  EjbTimerInterface ejbTimerInterface;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String actionMethod()
    {
        ejbTimerInterface.callEjbTimerService(5*1000, name);
        return "";
    }
    
    public void processTheValue(String comingName)
    {
        System.out.println("Timer'dan Gelen Değer:"+comingName);
    }
}
