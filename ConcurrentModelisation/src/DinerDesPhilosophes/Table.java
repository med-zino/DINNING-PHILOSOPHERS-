/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DinerDesPhilosophes;



/**
 *
 * @author boya
 */
public class Table {
    static protected Plat plat0;
    static protected Plat plat1;
    static protected Plat plat2;
    static protected Plat plat3;
    static protected Plat plat4;
  
    static protected Fourchette f0;
    static protected Fourchette f1;
    static protected Fourchette f2;
    static protected Fourchette f3;
    static protected Fourchette f4;
    
    static protected Philosophe ph0;
    static protected Philosophe ph1;
    static protected Philosophe ph2;
    static protected Philosophe ph3;
    static protected Philosophe ph4;
    
    
    
   /*
    public Table(Philosophe[] poolPhilosophes, Fourchette[] poolFourchettes){
        this.poolPhilosophes=poolPhilosophes;
        this.poolFourchettes=poolFourchettes;
    }
    public void initialiser(){
        poolPhilosophes[0]=new Philosophe(0, "philosophe0");
        poolFourchettes[0]=new Fourchette(0);
        PhilosopheEtFourchette PF0= new PhilosopheEtFourchette(poolPhilosophes[0], poolFourchettes[0],poolFourchettes[4] );
    }*/
    
    public static void main(String args[]){
    f0=new Fourchette(0);
    f1=new Fourchette(1);
    f2=new Fourchette(2);
    f3=new Fourchette(3);
    f4=new Fourchette(4);
    
    plat0=new Plat(f0,f1);
    plat1=new Plat(f1,f2);
    plat2=new Plat(f2,f3);
    plat3=new Plat(f3,f4);
    plat4=new Plat(f4,f0);
    
    ph0= new Philosophe(0,"Platon",plat0);
    ph1= new Philosophe(1,"Socrate",plat1);
    ph2= new Philosophe(2,"Descartes",plat2);
    ph3= new Philosophe(3,"Marx",plat3);
    ph4= new Philosophe(4,"Sartre",plat4);
    
    
    ph0.start();
    ph1.start();
    ph2.start();
    ph3.start();
    ph4.start(); 
    /*
    try{
        ph0.join();
        ph1.join();
    ph2.join();
    ph3.join();
    ph4.join();
    
    }catch(Exception e){
    }*/
        
    }
    
}
