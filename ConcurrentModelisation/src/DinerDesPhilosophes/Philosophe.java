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
public class Philosophe extends Thread{
    private int id;
    private String nom;
    Plat plat;
    
    public Philosophe(int id, String nom,Plat plat){
        this.id=id;
        this.nom=nom;
        this.plat=plat;
        this.setName(nom);
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
            int TIMEOUT = (int)(10000.0 * Math.random()) + 1;
            System.out.println("PENSER: "+TIMEOUT);
            Temporiseur.temporiser(TIMEOUT);
        //} catch (InterruptedException ex) {
            
        //}
    }
}
