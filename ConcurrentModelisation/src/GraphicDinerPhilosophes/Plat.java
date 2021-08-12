/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicDinerPhilosophes;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;



/**
 *
 * @author boya
 */
public class Plat extends JPanel {
    Fourchette fg;
    Fourchette fd;
    public Plat(Fourchette fg, Fourchette fd, int X, int Y, int longueur, int largeur, Color couleur){
        super();
        this.fg=fg;
        this.fd=fd;
        
    
    this.setLayout(null) ;
    this.setBounds(X,Y,longueur,largeur);
    this.setBackground(couleur);
    }
    
    protected boolean manger(){
        //while(true)
        synchronized(fg){
            if(!fd.libre) try {
                System.out.println(Thread.currentThread().getName()+" a faim");
                this.setBackground(Color.red);
                if(Table.combo_attenteNotification.getSelectedItem().toString().compareTo("Non")==0)
                fg.wait(Table.param_TIME_WAIT);
                else if(Table.combo_attenteNotification.getSelectedItem().toString().compareTo("Oui")==0)
                fg.wait();
                return false;
                
            } catch (InterruptedException ex) {
                
            }
            else synchronized(fd){
                fd.libre=false;
                fg.libre=false;
                System.out.println(Thread.currentThread().getName()+" mange");
                int TIMEOUT=1;
                if(Table.combo_fair.getSelectedItem().toString().compareTo("Oui")==0) TIMEOUT=Table.param_TIME_MANGE;
                else if(Table.combo_fair.getSelectedItem().toString().compareTo("Non")==0) TIMEOUT = (int)(Table.param_TIME_MANGE * Math.random()) + 1;
                //int TIMEOUT = (int)(Table.param_TIME_MANGE * Math.random()) + 1;
                //int TIMEOUT = Table.param_TIME_MANGE ;
                System.out.println("MANGER: "+TIMEOUT);
                this.setBackground(Color.CYAN);
                fg.setBackground(Color.BLUE);
                fd.setBackground(Color.BLUE);
                try {
                    //Temporiseur.temporiser(TIMEOUT);
                    Thread.sleep(TIMEOUT);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Plat.class.getName()).log(Level.SEVERE, null, ex);
                }
                
             fd.libre=true;
             fg.libre=true;            
             
             fd.notify();
             fg.notify();
             fg.setBackground(Color.YELLOW);
             fd.setBackground(Color.YELLOW);
            }
            
        }
        this.setBackground(Color.GREEN);
       // Thread.currentThread().suspend();
        //Thread.currentThread().resume();
        return true;
    }
    
}
