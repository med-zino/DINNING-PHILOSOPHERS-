
package SynchronizedSyntax;


public class Increment implements Runnable{
    public static final int N=1000, numThreads=32;
    public  int x; //ressource à protéger
    
    public Increment(int x){
        this.x=x;
    }
    
    public synchronized void  add(){
        for(int i=0;i<N;i++)
            x=x+1; 
    }
    
    public void afficher(){
        System.out.println("le résulat de l'addition est: "+x);
        System.out.println("Le résultat attendu est de  : "+N*numThreads);
    }

    @Override
    public void run() {
        add();
    }
    
    public static void main(String args[]){       
        
        Thread[] threads= new Thread [numThreads];
        
        Increment increment=new Increment(0);
        for(int i=0;i<numThreads;i++){ 
            threads[i]=new Thread(increment);
            threads[i].start();
        }       
       
        try {
           for(int i=0;i<numThreads;i++){             
            threads[i].join();
           }     
        } catch (InterruptedException ex) {           
        }
        
        increment.afficher();        
    }
    
}
