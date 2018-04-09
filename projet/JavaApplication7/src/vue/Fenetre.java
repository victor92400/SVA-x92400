/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import Modèle.Connexion;
/**
 *
 * @author solen
 */import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fenetre extends JFrame implements ActionListener{
  private JPanel pan;
  private JButton bouton1; 
    private JButton bouton2;
      private JButton bouton3;
       private JButton bouton4; 
    private JButton bouton5;
      private JButton bouton6;
      private int choix;
              private Connexion conloc;
              
  

  public Fenetre() throws SQLException, ClassNotFoundException {
       conloc=new Connexion("hopital","root","");
       this.setTitle("");
    this.setSize(600, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
        choix=0;
  }    
  
  public void menu()
  {
       pan= new JPanel();
      this.setTitle("Menu");

    bouton1=new JButton("Recherche dans la base de données");
    bouton1.addActionListener(this);
    bouton2= new JButton("Mise à jour de la base de données");
   bouton2.addActionListener(this);
   bouton3 = new JButton("Mise à jour de la base de données");
    bouton3.addActionListener(this);
      pan.add(bouton1);
    pan.add(bouton2);
    pan.add(bouton3);
    this.setContentPane(pan);
    this.setVisible(true);

  }
  public JButton getBouton1()
      {
        return bouton1;
      }   

 
public JButton getBouton2()
      {
        return bouton2;
      }   

public JButton getBouton3()
      {
        return bouton3;
      } 

public void menuReporting()
{
     pan= new JPanel();
    this.setTitle("MenuReporting");
   
    //Ajout du bouton à notre content pane
   
 bouton4=new JButton("Charte du nombre de lits par services");
    bouton4.addActionListener(this);
    bouton5= new JButton("Camembert de la spécialité des médecins");
   bouton5.addActionListener(this);
   bouton6 = new JButton("A definir sous peu ..."); 
   bouton6.addActionListener(this);
   
      pan.add(bouton4);
    pan.add(bouton5);
    pan.add(bouton6);
     this.setContentPane(pan);
    this.setVisible(true);
}

  @Override
 public void actionPerformed(ActionEvent e) {
    Object  source=e.getSource();
        
        if  (source==bouton1)
        {
            System.out.println("1er !");
            choix=1;
           
      }
        else if (source==bouton2)
        {
            System.out.println("2eme !");
            choix=2;
        
        }
        else if (source==bouton3)
        {
            choix=3;
            menuReporting();
        }
        else if(source==bouton4)
        {
            System.out.println("choix 4");
            try {
            conloc.afficherCamembert2();
        } catch (SQLException ex) {
            Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        }
        else if(source==bouton5)
        {
            System.out.println("choix 5");
            try {
            conloc.afficherCamembert1();
        } catch (SQLException ex) {
            Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
}