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
public class PhilosopheEtFourchette {
    private Philosophe philosophe;
    private Fourchette fourchette_gauche;
    private Fourchette fourchette_droite;
    public PhilosopheEtFourchette(Philosophe philosophe,Fourchette fourchette_gauche,Fourchette fourchette_droite){
        this.philosophe=philosophe;
        this.fourchette_gauche=fourchette_gauche;
        this.fourchette_droite=fourchette_droite;
    }    
    
}
