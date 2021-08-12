/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DinerDesPhilosophes1;

/**
 *
 * @author boya
 */
public class Table {
    //Plats
    static protected Plat plat0;
    static protected Plat plat1;
    static protected Plat plat2;
    static protected Plat plat3;
    static protected Plat plat4;
    
    //Fourchettes
    static protected Fourchette f0;
    static protected Fourchette f1;
    static protected Fourchette f2;
    static protected Fourchette f3;
    static protected Fourchette f4;
    
    //Philosophes
    static protected Philosophe ph0;
    static protected Philosophe ph1;
    static protected Philosophe ph2;
    static protected Philosophe ph3;
    static protected Philosophe ph4;

    public static void main(String args[]) {
        f0 = new Fourchette(0);
        f1 = new Fourchette(1);
        f2 = new Fourchette(2);
        f3 = new Fourchette(3);
        f4 = new Fourchette(4);

        plat0 = new Plat(f0, f1);
        plat1 = new Plat(f1, f2);
        plat2 = new Plat(f2, f3);
        plat3 = new Plat(f3, f4);
        plat4 = new Plat(f4, f0);

        ph0 = new Philosophe(0, "Platon", plat0);
        ph1 = new Philosophe(1, "Socrate", plat1);
        ph2 = new Philosophe(2, "Descartes", plat2);
        ph3 = new Philosophe(3, "Marx", plat3);
        ph4 = new Philosophe(4, "Sartre", plat4);

        ph0.start();
        ph1.start();
        ph2.start();
        ph3.start();
        ph4.start();

    }

    static class Fourchette {
        private int id;
        boolean libre = true;

        public Fourchette(int id) {
            this.id = id;
        }

    }

    static class Plat {
        Fourchette fg;                          //fourchette gauche
        Fourchette fd;                          //fourchette droite

        public Plat(Fourchette fg, Fourchette fd) {
            this.fg = fg;
            this.fd = fd;
        }

        protected boolean manger() {            
            synchronized (fg) {                 //acquerir la fourchette gauche et poser un verrou sur cette fourchette
                if (!fd.libre) {                //si la fourchette droite n'est pas libre, 
                    try {
                        System.out.println(Thread.currentThread().getName() + " a faim");
                        fg.wait();              //le philosophe est bloqué (attend que la fourchette droite soit libre)
                        return false;           //le philosophe n'a pu manger et retourne attendre
                    } catch (InterruptedException ex) {
                    }
                } else {                        //si la fourchette droite est libre,              
                    synchronized (fd) {         // acquérir la fourchette droite droite
                        fd.libre = false;       //aussitot, déclarer que la fourchette droite est occupée (n'est plus libre)
                        fg.libre = false;       //aussitot, déclarer que la fourchette gauche est occupée (n'est plus libre)
                        
                        System.out.println(Thread.currentThread().getName() + " mange");
                        int TIMEOUT = (int) (10000.0 * Math.random()) + 1;
                        System.out.println("MANGER: " + TIMEOUT);
                        Temporiseur.temporiser(TIMEOUT);   //le temps que le philosophe mange

                        fd.libre = true;         //Aussitot après avoir fini de manger, déclarer que la fourchette droite est devenue libre
                        fg.libre = true;        //Aussitot après avoir fini de manger, déclarer que la fourchette gauche est devenue libre
                        fd.notify();            //Avertir le philosophe qui était boqué sur cette fourchette droite, que celle-ci est devenue libre
                        fg.notify();            //Avertir le philosophe qui était boqué sur cette fourchette gauche, que celle-ci est devenue libre
                    }
                }
            }
            return true;
        }
    }

    static class Philosophe extends Thread {
        private int id;
        private String nom;
        Plat plat;

        public Philosophe(int id, String nom, Plat plat) {
            this.id = id;
            this.nom = nom;
            this.plat = plat;
            this.setName(nom);
        }

        public void run() {
            while (true) {            
                boolean RASSASIE = plat.manger();   //si cette fonction retourne true, cela veut dure que le philosophe a pu mangé et est rassassié, sinon le philosophe a toujours faim
                if (RASSASIE) {                     //si le philosophe est rassassié, il pense
                    penser();
                }
            }
        }

        public void penser() {
           
            System.out.println(Thread.currentThread().getName() + " pense");           
            int TIMEOUT = (int) (10000.0 * Math.random()) + 1;
            System.out.println("PENSER: " + TIMEOUT);
            Temporiseur.temporiser(TIMEOUT);        
        }
    }

}
