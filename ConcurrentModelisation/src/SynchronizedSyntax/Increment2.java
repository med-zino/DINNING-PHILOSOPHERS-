package SynchronizedSyntax;

public class Increment2 implements Runnable{
    public static final int N=1000, numThreads=32;
    public final Object obj=new Object();
    public int x; //ressource à protéger
    
    public Increment2(int x){
        this.x=x;
    }
    
    public  void  add(){
        synchronized(obj){
            for(int i=0;i<N;i++)
                x=x+1;
        }
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
        
        Increment2 increment=new Increment2(0);
        Thread[] threads= new Thread [numThreads];
        
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
