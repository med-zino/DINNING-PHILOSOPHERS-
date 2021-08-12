/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicDinerPhilosophes;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.text.StyleConstants.Bold;


/**
 *
 * @author boya
 */
public class Table extends JFrame  {
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
    
    static protected JPanel legende_pense;
    static protected JLabel legende_pense_txt;
    
    static protected JPanel legende_afaim;
    static protected JLabel legende_afaim_txt;
    
    static protected JPanel legende_mange;
    static protected JLabel legende_mange_txt;
    
    static protected JPanel legende_libre;
    static protected JLabel legende_libre_txt;
    
    static protected JPanel legende_occupe;
    static protected JLabel legende_occupe_txt;
    
    static protected JLabel label_fair;
    static protected JComboBox<String> combo_fair;
    
    static protected JLabel label_attenteNotification;
    static protected JComboBox<String> combo_attenteNotification;
    
    static protected JLabel label_tempsPenser;
    static protected JComboBox<String> combo_tempsPenser;
    
    static protected JLabel label_tempsManger;
    static protected JComboBox<String> combo_tempsManger;
    
    static protected JButton button_start;
    static protected JButton button_end;
    
    static protected JPanel panel_table;
    static protected JPanel panel_legende;
    static protected JPanel panel_parametres;
    
    public  static int param_TIME_PENSE=1000;
    public  static int param_TIME_MANGE=1000;
     public  static int param_TIME_WAIT=1;
    
    public Table(){
    
      this.setTitle("Diner des philosophes") ;
      this.setSize(1500,700) ;
      //this.setBackground(Color.GRAY);
    // Container pane = this.getContentPane( );
     // this.label = new JLabel("Legende");
      //pane.add(this.label,BorderLayout.NORTH);
      //this.label1 = new JLabel("Carre Bleu: Philosophe a faim");
      
     // this.label1.setLocation(0,50) ;
      //pane.add(this.label1,BorderLayout.BEFORE_FIRST_LINE );
      //this.initialise_parametre();
          this.addWindowListener(new WindowAdapter()
                             {public void windowClosing(WindowEvent e)
                                   { System.exit(1);
                                   }});
    }
    
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
    private static void initialise_parametre(){
       if(Table.combo_tempsPenser.getSelectedItem().toString().compareTo("Court")==0) param_TIME_PENSE=1000;
       else if(Table.combo_tempsPenser.getSelectedItem().toString().compareTo("Long")==0) param_TIME_PENSE=10000;
       
       if(Table.combo_tempsManger.getSelectedItem().toString().compareTo("Court")==0) param_TIME_MANGE=1000;
       else if(Table.combo_tempsManger.getSelectedItem().toString().compareTo("Long")==0) param_TIME_MANGE=10000;
    }
    
    private static void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("hello");
    }
    
    public static void main(String args[]){
        /*
    f0=new Fourchette(0);
    f1=new Fourchette(1);
    f2=new Fourchette(2);
    f3=new Fourchette(3);
    f4=new Fourchette(4);
    */
    f0=new Fourchette(0,376,167,10,40,Color.YELLOW);
    f1=new Fourchette(1,288,408,40,10,Color.YELLOW);
    f2=new Fourchette(2,495,532,10,40,Color.YELLOW);
    f3=new Fourchette(3,673,408,40,10,Color.YELLOW);
    f4=new Fourchette(4,614,167,10,40,Color.YELLOW);
    /*
    plat0=new Plat(f0,f1,475,75,50,50,Color.GREEN);
    plat1=new Plat(f1,f2,237,248,50,50,Color.GREEN);
    plat2=new Plat(f2,f3,328,527,50,50,Color.GREEN);
    plat3=new Plat(f3,f4,622,527,50,50,Color.GREEN);
    plat4=new Plat(f4,f0,713,248,50,50,Color.GREEN);
    */
   
    plat0=new Plat(f0,f1,237,248,50,50,Color.GREEN);
    plat1=new Plat(f1,f2,328,527,50,50,Color.GREEN);
    plat2=new Plat(f2,f3,622,527,50,50,Color.GREEN);
    plat3=new Plat(f3,f4,713,248,50,50,Color.GREEN);
    plat4=new Plat(f4,f0,475,75,50,50, Color.GREEN);
    
    JLabel labelPh0=new JLabel("Marx");
    labelPh0.setBounds(187, 273, 50,10);
    JLabel labelPh1=new JLabel("Kant");
    labelPh1.setBounds(328, 587, 50,10);
    JLabel labelPh2=new JLabel("Descartes");
    labelPh2.setBounds(622, 587, 60,10);
    JLabel labelPh3=new JLabel("Socrate");
    labelPh3.setBounds(768, 273, 60,10);
    JLabel labelPh4=new JLabel("Platon");
    labelPh4.setBounds(475,50,50,10);
   // labelPh0.setText("platon");
   // labelPh0.setFont(Bold);
    //labelPh0.setForeground(Color.red);
   //labelPh0.setBackground(Color.WHITE);
    //labelPh0.setOpaque(true);
    //labelPh0.setVisible(true);
    
   
    ph0= new Philosophe(0,"Marx",plat0,labelPh0);
    ph1= new Philosophe(1,"Kant",plat1,labelPh1);
    ph2= new Philosophe(2,"Descartes",plat2,labelPh2);
    ph3= new Philosophe(3,"Socrate",plat3,labelPh3);
    ph4= new Philosophe(4,"Platon",plat4,labelPh4);
     
     legende_pense=new JPanel();
     legende_pense_txt=new JLabel();     
     legende_afaim=new JPanel();
     legende_afaim_txt=new JLabel();
     legende_mange=new JPanel();
     legende_mange_txt=new JLabel();
     legende_libre=new JPanel();
     legende_libre_txt=new JLabel();
     legende_occupe=new JPanel();
     legende_occupe_txt=new JLabel();
     
     label_fair=new JLabel();             
     combo_fair=new JComboBox<>();
     
     label_attenteNotification=new JLabel();             
     combo_attenteNotification=new JComboBox<>();
     label_tempsPenser=new JLabel();             
     combo_tempsPenser=new JComboBox<>();
     label_tempsManger=new JLabel();             
     combo_tempsManger=new JComboBox<>();     
     button_start=new JButton();
     button_end=new JButton();
     /*
     legende_pense.setBounds(1013, 50, 20, 20);
     legende_pense.setBackground(Color.GREEN);
     legende_pense_txt.setBounds(1038, 50, 150, 20);
     legende_pense_txt.setText("Philosophe pense");
     */
     
     legende_pense.setBounds(50, 50, 20, 20);
     legende_pense.setBackground(Color.GREEN);
     legende_pense_txt.setBounds(75, 50, 150, 20);
     legende_pense_txt.setText("Philosophe pense");
     /*
     legende_afaim.setBounds(1013, 80, 20, 20);
     legende_afaim.setBackground(Color.RED);
     legende_afaim_txt.setBounds(1038, 80, 150, 20);
     legende_afaim_txt.setText("Philosophe a faim");
     
     
     legende_mange.setBounds(1013, 110, 20, 20);
     legende_mange.setBackground(Color.CYAN);
     legende_mange_txt.setBounds(1038, 110, 150, 20);
     legende_mange_txt.setText("Philosophe mange");
     
     legende_libre.setBounds(1013, 160, 20, 5);
     legende_libre.setBackground(Color.YELLOW);
     legende_libre_txt.setBounds(1038, 155, 150, 20);
     legende_libre_txt.setText("Fourchette libre");
     
     legende_occupe.setBounds(1013, 180, 20, 5);
     legende_occupe.setBackground(Color.BLUE);
     legende_occupe_txt.setBounds(1038, 175, 150, 20);
     legende_occupe_txt.setText("Fourchette occupee");
     */
     
     legende_afaim.setBounds(50, 80, 20, 20);
     legende_afaim.setBackground(Color.RED);
     legende_afaim_txt.setBounds(75, 80, 150, 20);
     legende_afaim_txt.setText("Philosophe a faim");
     
     
     legende_mange.setBounds(50, 110, 20, 20);
     legende_mange.setBackground(Color.CYAN);
     legende_mange_txt.setBounds(75, 110, 150, 20);
     legende_mange_txt.setText("Philosophe mange");
     
     legende_libre.setBounds(50, 160, 20, 5);
     legende_libre.setBackground(Color.YELLOW);
     legende_libre_txt.setBounds(75, 155, 150, 20);
     legende_libre_txt.setText("Fourchette libre");
     
     legende_occupe.setBounds(50, 180, 20, 5);
     legende_occupe.setBackground(Color.BLUE);
     legende_occupe_txt.setBounds(75, 175, 150, 20);
     legende_occupe_txt.setText("Fourchette occupee");
     
     /*
     label_fair.setBounds(1038, 400, 200, 20);
     label_fair.setText("Temps Equitable");
     label_attenteNotification.setBounds(1038, 450, 200, 20);
     label_attenteNotification.setText("Attente d une notification");
     label_tempsPenser.setBounds(1038, 500, 200, 20);
     label_tempsPenser.setText("Temps de Penser");
     label_tempsManger.setBounds(1038, 550, 200, 20);
     label_tempsManger.setText("Temps de Manger");
     combo_fair.setBounds(1238, 400, 100, 20);
     combo_fair.addItem("Oui");
     combo_fair.addItem("Non");     
     combo_attenteNotification.setBounds(1238, 450, 100, 20);
     combo_attenteNotification.addItem("Oui");
     combo_attenteNotification.addItem("Non");
     combo_tempsPenser.setBounds(1238, 500, 100, 20);
     combo_tempsPenser.addItem("Court");
     combo_tempsPenser.addItem("Moyen");
     combo_tempsPenser.addItem("Long");
     combo_tempsManger.setBounds(1238, 550, 100, 20);
     combo_tempsManger.addItem("Court");
     combo_tempsManger.addItem("Moyen");
     combo_tempsManger.addItem("Long");
     button_start.setBounds(1038, 600, 100, 20);
     button_start.setText("Demarrer");
     button_end.setBounds(1188, 600, 100, 20);
     button_end.setText("Arreter");
     */
     
     label_fair.setBounds(50, 25, 200, 20);
     label_fair.setText("Temps Equitable");
     label_attenteNotification.setBounds(50, 75, 200, 20);
     label_attenteNotification.setText("Attente d une notification");
     label_tempsPenser.setBounds(50, 125, 200, 20);
     label_tempsPenser.setText("Temps de Penser");
     label_tempsManger.setBounds(50, 175, 200, 20);
     label_tempsManger.setText("Temps de Manger");
     combo_fair.setBounds(250, 25, 100, 20);
     combo_fair.addItem("Oui");
     combo_fair.addItem("Non");     
     combo_attenteNotification.setBounds(250, 75, 100, 20);
     combo_attenteNotification.addItem("Oui");
     combo_attenteNotification.addItem("Non");
     combo_tempsPenser.setBounds(250, 125, 100, 20);
     combo_tempsPenser.addItem("Court");
     //combo_tempsPenser.addItem("Moyen");
     combo_tempsPenser.addItem("Long");
     combo_tempsManger.setBounds(250, 175, 100, 20);
     combo_tempsManger.addItem("Court");
     //combo_tempsManger.addItem("Moyen");
     combo_tempsManger.addItem("Long");
     button_start.setBounds(50, 250, 125, 20);  
     button_start.setText("Demarrer");
     /*
     button_end.setBounds(150, 200, 100, 20);
     button_end.setText("Arreter");
     */
     
     
     Table grtable=new Table ();
     panel_table=new JPanel();
     panel_table.setBounds(1, 1, 900, 650);
     //panel_table.setLayout(grtable.getLayout());
     panel_table.setBackground(Color.white);
     GroupLayout panel_tableLayout = new GroupLayout(panel_table);
        panel_table.setLayout(panel_tableLayout);
     
     panel_legende=new JPanel();
     panel_legende.setBounds(905, 1, 600, 300);
     //panel_legende.setLayout(grtable.getLayout());
    panel_legende.setBackground(new Color(252,242,233));
    GroupLayout panel_legendeLayout = new GroupLayout(panel_legende);
        panel_legende.setLayout(panel_legendeLayout);
       // panel_legende.setLayout(null);
        
        panel_parametres=new JPanel();
     panel_parametres.setBounds(905, 305, 600, 345);
     //panel_legende.setLayout(grtable.getLayout());
    panel_parametres.setBackground(new Color(204,204,255));
    GroupLayout panel_parametresLayout = new GroupLayout(panel_parametres);
        //panel_parametres.setLayout(panel_parametresLayout);
       panel_parametres.setLayout(null);
    
  //grtable.getContentPane().setLayout(null);
   //grtable.getContentPane().setBackground(Color.red);
    /*
     grtable.getContentPane().add(f0);
     grtable.getContentPane().add(f1);
     grtable.getContentPane().add(f2);
     grtable.getContentPane().add(f3);
     grtable.getContentPane().add(f4);
     grtable.getContentPane().add(plat0);
     grtable.getContentPane().add(plat1);
     grtable.getContentPane().add(plat2);
     grtable.getContentPane().add(plat3);
     grtable.getContentPane().add(plat4);
     grtable.getContentPane().add(ph0.jlabel);
     grtable.getContentPane().add(ph1.jlabel);
     grtable.getContentPane().add(ph2.jlabel);
     grtable.getContentPane().add(ph3.jlabel);
     grtable.getContentPane().add(ph4.jlabel);*/
    
    panel_table.add(f0);
     panel_table.add(f1);
     panel_table.add(f2);
     panel_table.add(f3);
     panel_table.add(f4);
     panel_table.add(plat0);
     panel_table.add(plat1);
     panel_table.add(plat2);
     panel_table.add(plat3);
     panel_table.add(plat4);
     panel_table.add(ph0.jlabel);
     panel_table.add(ph1.jlabel);
     panel_table.add(ph2.jlabel);
     panel_table.add(ph3.jlabel);
     panel_table.add(ph4.jlabel);
     panel_table.add(new Component() {});
     grtable.add(panel_table);
     
     /*
     grtable.getContentPane().add(legende_pense);
     grtable.getContentPane().add(legende_pense_txt);
     
     grtable.getContentPane().add(legende_afaim);
     grtable.getContentPane().add(legende_afaim_txt);
     
     grtable.getContentPane().add(legende_mange);
     grtable.getContentPane().add(legende_mange_txt);
     
     grtable.getContentPane().add(legende_libre);
     grtable.getContentPane().add(legende_libre_txt);
     
     grtable.getContentPane().add(legende_occupe);
     grtable.getContentPane().add(legende_occupe_txt);
     */
     
     
     
     panel_legende.add(legende_pense);
     panel_legende.add(legende_pense_txt);
     
     panel_legende.add(legende_afaim);
     panel_legende.add(legende_afaim_txt);
     
     panel_legende.add(legende_mange);
     panel_legende.add(legende_mange_txt);
     
     panel_legende.add(legende_libre);
     panel_legende.add(legende_libre_txt);
     
     panel_legende.add(legende_occupe);
     panel_legende.add(legende_occupe_txt);
     panel_legende.add(new Component() {});
     grtable.add(panel_legende);
     
     /*
     grtable.getContentPane().add(label_fair);
     grtable.getContentPane().add(combo_fair);
     grtable.getContentPane().add(label_attenteNotification);
     grtable.getContentPane().add(combo_attenteNotification);
     grtable.getContentPane().add(label_tempsPenser);
     grtable.getContentPane().add(combo_tempsPenser);
     grtable.getContentPane().add(label_tempsManger);
     grtable.getContentPane().add(combo_tempsManger);
     grtable.getContentPane().add(button_start);
     grtable.getContentPane().add(button_end);
     */
     panel_parametres.add(label_fair);
     panel_parametres.add(combo_fair);
     panel_parametres.add(label_attenteNotification);
     panel_parametres.add(combo_attenteNotification);
     panel_parametres.add(label_tempsPenser);
     panel_parametres.add(combo_tempsPenser);
     panel_parametres.add(label_tempsManger);
     panel_parametres.add(combo_tempsManger);
     panel_parametres.add(button_start);
     panel_parametres.add(button_end);
     //panel_parametres.add(new Component() {});
     grtable.add(panel_parametres);
     
 //grtable.getContentPane().add(ph4.jlabel,);
     grtable.getContentPane().add(new Component() {
});
     
      //grtable.setLayout(null);
     panel_table.setVisible(true);
     panel_legende.setVisible(true);
     panel_parametres.setVisible(true);
     grtable.setVisible(true);
  /*
    ph0.start();
    ph1.start();
    ph2.start();
    ph3.start();
    ph4.start(); 
    */
     
    button_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jButton1ActionPerformed(evt);
            
            initialise_parametre();
            ph0.start();    
            ph1.start();
            ph2.start();
            ph3.start();
            ph4.start(); 
            }
        });
    
    button_end.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jButton1ActionPerformed(evt);
                
            ph0.interrupt();    
            ph1.interrupt();
            ph2.interrupt();
            ph3.interrupt();
            ph4.interrupt();
            }
        });
    
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
