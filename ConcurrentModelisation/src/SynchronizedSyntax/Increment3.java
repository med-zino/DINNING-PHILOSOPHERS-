
package SynchronizedSyntax;

public class Increment3 implements Runnable{
    public static final int N=1000, numThreads=32;    
    public static int x; //ressource à protéger
   
    public static void Initialiser(){
        x=0;
    }
    public  void  add(){
        synchronized(Increment3.class){      
            for(int i=0;i<N;i++)
                x=x+1;
        }
    }
    
    public static void afficher(){
        System.out.println("le résulat de l'addition est: "+x);
        System.out.println("Le résultat attendu est de  : "+N*numThreads);
    }

    @Override
    public void run() {
        add();
    }
    
    
    
    public static void main(String args[]){
        
        Thread[] threads= new Thread [numThreads];
        
        Initialiser();
        
        for(int i=0;i<numThreads;i++){ 
            threads[i]=new Thread(new Increment3());
            threads[i].start();
        }       
       
        try {
           for(int i=0;i<numThreads;i++){             
            threads[i].join();
           }     
        } catch (InterruptedException ex) {           
        }
        
        afficher();
        
    }
    
}
