/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicDinerPhilosophes;

import DinerDesPhilosophes.*;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author boya
 */
public class Fourchette extends JPanel{
    private int id;
    boolean libre=true;
    public Fourchette(int id){
        super();
        this.id=id;
    }
    
     public Fourchette(int id, int X, int Y, int longueur, int largeur, Color couleur){
        super();       
    
    this.setLayout(null) ;
    this.setBounds(X,Y,longueur,largeur);
    this.setBackground(couleur);
    }
     
     
    
}
