/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmaticTimer;

import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.inject.Inject;

/**
 *
 * @author ilkaygunel
 */
@Stateless
public class TimerSessionBean implements EjbTimerInterface{

    @Resource
    private SessionContext sessionContext;
    
    @Inject
    private TimerBean timerBean;
    
    
    @Override
    public void callEjbTimerService(long duration, String name) {
        System.out.println("Timer Service Nesnesi Oluşturuldu:"+new Date());
        sessionContext.getTimerService().createTimer(duration, name);
    }
    
    @Timeout
    public void timeOutEvent(Timer timer)
    {
        System.out.println("TimeOut gerçekleşti!"+new Date());
        timerBean.processTheValue(timer.getInfo().toString());
        timer.cancel();
    }
}
