package Lab04.hust.soict.globalict.aims.screen.manager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;

import Lab04.hust.soict.globalict.aims.media.DigitalVideoDisc;
import Lab04.hust.soict.globalict.aims.store.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen implements ActionListener {
    JButton button;
    JLabel add_a_dvd;
    JTextField set_length;
    JTextField set_director;
    JLabel director;
    JLabel length;
    AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        button = getButton();
        button.addActionListener(this);
        add_a_dvd = new JLabel("Adding a DVD",JLabel.CENTER);
        add_a_dvd.setBounds(433, 20, 130, 40);
        add_a_dvd.setBackground(Color.PINK);
        add_a_dvd.setOpaque(true);
        set_length = new JTextField();
        set_director = new JTextField();
        length = new JLabel("Length",JLabel.CENTER);
        director = new JLabel ("Director",JLabel.CENTER);
        director.setBackground(Color.CYAN);
        length.setBackground(Color.CYAN);       
        director.setOpaque(true);
        length.setOpaque(true);
        set_length.setBounds(100,260,150,30);
        set_director.setBounds(100, 300, 150, 30);
        length.setBounds(270, 260, 100, 30);
        director.setBounds(270, 300, 100, 30);
        this.add(add_a_dvd);
        this.add(set_director);
        this.add(set_length);
        this.add(length);
        this.add(director);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            if(set_cost.getText().equals("") || set_category.getText().equals("") ||
         set_id.getText().equals("") || set_title.getText().equals("") ||
          set_director.getText().equals("") || set_length.getText().equals("")){
              JOptionPane.showMessageDialog(this,"Please enter all the information" , "WARNING", JOptionPane.WARNING_MESSAGE);
              return;
        }
        String title = set_title.getText();
        String category = set_category.getText();
        String cost_string = set_cost.getText();
        String id_string = set_id.getText();
        int id = Integer.parseInt(id_string);
        float cost = Float.parseFloat(cost_string);
        String the_director = set_director.getText();
        String length_string = set_length.getText();
        int the_length = Integer.parseInt(length_string);
        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, the_director, the_length, cost, id);
        store.addMedia(dvd);
        set_title.setText("");
        set_id.setText("");
        set_category.setText("");
        set_cost.setText("");
        set_director.setText("");
        set_length.setText("");
    }
  } 
}
