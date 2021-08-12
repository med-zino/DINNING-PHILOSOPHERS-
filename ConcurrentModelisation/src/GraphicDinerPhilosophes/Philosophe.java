/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicDinerPhilosophes;

import DinerDesPhilosophes.*;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author boya
 */
public class Philosophe extends Thread{
    private int id;
    private String nom;
    Plat plat;
    JLabel jlabel;
    
    public Philosophe(int id, String nom,Plat plat,JLabel jlabel) {
        this.id=id;
        this.nom=nom;
        this.plat=plat;
        this.setName(nom);
        this.jlabel=jlabel;
        //this.jlabel.setText("Philisophe");
        //this.jlabel.setHorizontalAlignment(10);
       // this.jlabel.setVerticalAlignment(20);
        
    }  
    
    public void run(){
        while(true){
            //if(!FAIM)
        //penser();
        boolean RASSASIE= plat.manger();
        if(RASSASIE) penser();
        
        }
    }
    
    public void penser(){
       // try {
            System.out.println(Thread.currentThread().getName()+" pense");
            //Thread.sleep(30000);
            //int TIMEOUT = (int)(Table.param_TIME_PENSE * Math.random()) + 1;
            int TIMEOUT = Table.param_TIME_PENSE ;
            System.out.println("PENSER: "+TIMEOUT);
        try {
            //Temporiseur.temporiser(TIMEOUT);
            Thread.sleep(TIMEOUT);
            //} catch (InterruptedException ex) {
            
            //}
        } catch (InterruptedException ex) {
            Logger.getLogger(Philosophe.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.plat.setBackground(Color.red);
    }
}
