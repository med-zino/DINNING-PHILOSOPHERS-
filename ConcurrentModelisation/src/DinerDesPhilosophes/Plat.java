/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DinerDesPhilosophes;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author boya
 */
public class Plat {
    Fourchette fg;
    Fourchette fd;
    public Plat(Fourchette fg, Fourchette fd){
        this.fg=fg;
        this.fd=fd;
    }
    
    protected boolean manger(){
        //while(true)
        synchronized(fg){
            if(!fd.libre) try {
                System.out.println(Thread.currentThread().getName()+" a faim");
                fg.wait();
                return false;
                
            } catch (InterruptedException ex) {
                
            }
            else synchronized(fd){
                fd.libre=false;
                fg.libre=false;
                System.out.println(Thread.currentThread().getName()+" mange");
                int TIMEOUT = (int)(10000.0 * Math.random()) + 1;
                System.out.println("MANGER: "+TIMEOUT);
                Temporiseur.temporiser(TIMEOUT);
                
             fd.libre=true;
             fg.libre=true;
             
             fd.notify();
             fg.notify();
            }
            
        }
        return true;
    }
    
}
