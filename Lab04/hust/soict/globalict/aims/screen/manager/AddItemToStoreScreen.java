package Lab04.hust.soict.globalict.aims.screen.manager;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Lab04.hust.soict.globalict.aims.store.*;

import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;;



public class AddItemToStoreScreen extends JPanel {
    JTextField set_id;
    JTextField set_title ; 
    JTextField set_category;
    JTextField set_cost;
    private JButton button;
    JLabel title;
    JLabel category;
    JLabel cost;
    JLabel id;
    Store store;

     AddItemToStoreScreen(Store store){
      title = new JLabel("Title",JLabel.CENTER);
      category = new JLabel("category",JLabel.CENTER);
      cost = new JLabel("Cost",JLabel.CENTER);
      id = new JLabel("Id",JLabel.CENTER);
       set_title = new JTextField();
       this.store = store;
       this.setLayout(null);
       button = new JButton("Ok");
       set_id = new JTextField();
       set_category = new JTextField();
       set_cost = new JTextField();
       set_id.setBounds(100, 100, 150, 30);
       set_title.setBounds(100, 140, 150, 30);
       set_category.setBounds(100, 180,150, 30);
       set_cost.setBounds(100, 220, 150, 30);
       button.setBounds(120,60,60,30);
       id.setBounds(270, 100, 100, 30);
       title.setBounds(270, 140, 100, 30);
       category.setBounds(270, 180, 100, 30);
       cost.setBounds(270, 220, 100, 30);
       id.setBackground(Color.CYAN);
       title.setBackground(Color.CYAN);
       category.setBackground(Color.CYAN);
       cost.setBackground(Color.CYAN);
       id.setOpaque(true);
       cost.setOpaque(true);
       category.setOpaque(true);
       title.setOpaque(true);
       this.add(set_id);
       this.add(set_title);
       this.add(set_category);
       this.add(set_cost);
       this.add(button);
       this.add(title);
       this.add(id);
       this.add(category);
       this.add(cost);
     }
     public JButton getButton(){
         return button;
     }
   
 }