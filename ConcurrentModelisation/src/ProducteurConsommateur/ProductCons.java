/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProducteurConsommateur;

import java.util.Stack;

/**
 *
 * @author boya
 */
public class ProductCons {    
    static Magasin monMagasin;
    static Producteur prod;
    static Consommateur cons;     
    
    public static void main(String args[]) {      
       monMagasin=new Magasin();
       prod=new Producteur();
       cons=new Consommateur();
       
       cons.start();
       prod.start();    
    }

    static class Magasin extends Stack {

        final static int MAX = 100;         //taille maximale du magasin
        static boolean PLEIN=false, VIDE=true;
        static int N = 0;                    //compteur

        synchronized void empiler(Boisson boisson) {
            if (PLEIN) {                     //Si le magasin est plein
                try {
                    wait();                  //Bloquer le thread producteur
                } catch (InterruptedException ex) {
                }
            } else {
                this.push(boisson);           //ajouter boisson                         
                N++;
                if (N == 1) {                 //Dès que le magasin a 1 boisson, 
                    VIDE = false;
                    notify();                  //notifier le thread consommateur qui était bloqué
                }
                else if(N==MAX) PLEIN=true;  
            }
        }

        synchronized void depiler() {
            if (VIDE) {                         //Si le magasin est vide,
                try {
                    wait();                     //Bloquer le thread Consommateur
                } catch (InterruptedException ex) {
                }
            } else {
                this.pop();                       //Retirer 1 boisson
                N--;
                if (N == MAX - 1) {               //Dés que le magasin n'est plus plein, 
                    PLEIN = false;
                    notify();                     //Notifier le thread producteur qui était bloqué
                }else if(N==0) VIDE=true;               
            }            
        }
    }

    static class Boisson extends Object {
    }

    static class Producteur extends Thread {
        @Override
        public void run() {
            while (true) {                
                    monMagasin.empiler(new Boisson());                    
            }
        }
    }

    static class Consommateur extends Thread {
        @Override
        public void run() {
            while (true) {              
                    monMagasin.depiler();                    
            }
        }
    }
}
