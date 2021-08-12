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
public class Temporiseur {
    public static void temporiser(long TIMEOUT){
        long startTime=System.currentTimeMillis();
        long stopTime=System.currentTimeMillis();
        while (stopTime - startTime<TIMEOUT){
            stopTime = System.currentTimeMillis();
        }
        //long stopTime = System.currentTimeMillis();
        //long elapsedTime = stopTime - startTime;
    }
    
}
