/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmaticTimer;

import javax.ejb.Local;

/**
 *
 * @author ilkaygunel
 */
@Local
public interface EjbTimerInterface {
    public void callEjbTimerService(long duration,String name);
}
