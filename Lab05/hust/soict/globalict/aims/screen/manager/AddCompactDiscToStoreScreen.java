package Lab05.hust.soict.globalict.aims.screen.manager;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Lab05.hust.soict.globalict.aims.media.*;
import Lab05.hust.soict.globalict.aims.screen.manager.AddItemToStoreScreen;
import Lab05.hust.soict.globalict.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen implements ActionListener {
    JButton button;
    JLabel add_a_cd;
    JTextField set_artist;
    JTextField set_length;
    JTextField set_director;
    JLabel director;
    JLabel artist;
    JLabel length;
    String[] list = {"Add Track","Remove Track"};
    JComboBox track_adding = new JComboBox<>(list);
    JTextField text ;
    JTextField text_length;
    JButton track_button;
    JButton remove_button;
    JLabel reminding;
    CompactDisc cd ;
    AddCompactDiscToStoreScreen(Store store) {
        super(store);
        button = getButton();
        button.addActionListener(this);
        track_adding.setBounds(280, 400, 120, 30);
        track_adding.addActionListener(this);
        add_a_cd = new JLabel("Adding a CD",JLabel.CENTER);
        add_a_cd.setBounds(433, 20, 130, 40);
        add_a_cd.setBackground(Color.PINK);
        add_a_cd.setOpaque(true);
        set_artist = new JTextField();
        set_length = new JTextField();
        set_director = new JTextField();
        artist = new JLabel("Artist",JLabel.CENTER);
        length = new JLabel("Length",JLabel.CENTER);
        director = new JLabel ("Director",JLabel.CENTER);
        artist.setBackground(Color.CYAN);
        director.setBackground(Color.CYAN);
        length.setBackground(Color.CYAN);
        artist.setOpaque(true);        
        director.setOpaque(true);
        length.setOpaque(true);
        set_artist.setBounds(100, 260, 150, 30);
        set_length.setBounds(100,300,150,30);
        set_director.setBounds(100, 340, 150, 30);
        artist.setBounds(270, 260, 100, 30);
        length.setBounds(270, 300, 100, 30);
        director.setBounds(270, 340, 100, 30);
        this.add(add_a_cd);
        this.add(set_artist);
        this.add(set_director);
        this.add(set_length);
        this.add(artist);
        this.add(length);
        this.add(director);
        this.add(track_adding);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == button){
            if(set_cost.getText().equals("") || set_category.getText().equals("") ||
         set_id.getText().equals("") || set_title.getText().equals("")){
              JOptionPane.showMessageDialog(this,"Please enter all the information" , "WARNING", JOptionPane.WARNING_MESSAGE);
              return;
        }
        String title = set_title.getText();
        String category = set_category.getText();
        String cost_string = set_cost.getText();
        String id_string = set_id.getText();
        int id = Integer.parseInt(id_string);
        float cost = Float.parseFloat(cost_string);
        String the_artist = set_artist.getText();
        String the_director = set_director.getText();
        String length_string = set_length.getText();
           
        if(set_director.getText().equals("") && set_length.getText().equals("")) {
            cd =  new CompactDisc(id, title, category, cost, the_artist);
        }
        else if(!(set_director.getText().isEmpty()) && !(set_length.getText().equals(""))) {
            int the_length = Integer.parseInt(length_string);
            cd = new CompactDisc(id, the_length, title, category, cost, the_artist, the_director);
        }else{
            JOptionPane.showMessageDialog(this,"Please fill both the information about the director and the length","WARNING",JOptionPane.WARNING_MESSAGE);
            return;
        }
        store.addMedia(cd);
        set_title.setText("");
        set_id.setText("");
        set_category.setText("");
        set_cost.setText("");
        set_artist.setText("");
        set_director.setText("");
        set_length.setText("");
      }
      if(e.getSource() == track_adding){
        int choice = track_adding.getSelectedIndex();
        switch(choice){
           case 0:
           if(remove_button != null) this.remove(remove_button);
           reminding = new JLabel("Enter the track's title and length, respectively",JLabel.CENTER);
           reminding.setBounds(270, 440, 250, 30);
           reminding.setBackground(Color.GREEN);
           reminding.setOpaque(true);
           text = new JTextField();
           text.setBounds(270,480,150,30);
           text_length = new JTextField();
           text_length.setBounds(270,520,150,30);
           track_button = new JButton("Add");
           track_button.setBounds(570,440, 150, 30);
           track_button.addActionListener(this);
           this.add(reminding);
           this.add(text);
           this.add(text_length);
           this.add(track_button);
           SwingUtilities.updateComponentTreeUI(this);
           break;
           case 1:
           if(track_button != null) this.remove(track_button);
           reminding = new JLabel("Enter the track's title and length, respectively",JLabel.CENTER);
           reminding.setBounds(270, 440, 250, 30);
           reminding.setBackground(Color.GREEN);
           reminding.setOpaque(true);
           text = new JTextField();
           text.setBounds(270,480,150,30);
           text_length = new JTextField();
           text_length.setBounds(270,520,150,30);
           remove_button = new JButton("Remove");
           remove_button.setBounds(570,440 , 150, 30);
           remove_button.addActionListener(this);
           this.add(reminding);
           this.add(text);
           this.remove(text_length);
           this.add(remove_button);
           SwingUtilities.updateComponentTreeUI(this);
           break;
        }
      }if(e.getSource() == track_button){
        if(cd == null || text.getText().equals("") || text_length.getText().equals("")){
         JOptionPane.showMessageDialog(this,"Please enter all information or create a CD first" , "WARNING", JOptionPane.WARNING_MESSAGE);
        }
        String name = text.getText();
        String length_string = text_length.getText();
        int length_track = Integer.parseInt(length_string);
        Track track = new Track(name, length_track);
        cd.addTrack(track);
        this.remove(text);
        this.remove(text_length);
        this.remove(reminding);
        this.remove(track_button);
        SwingUtilities.updateComponentTreeUI(this);
    }
    if(e.getSource() == remove_button){
     if(cd == null){
         JOptionPane.showMessageDialog(this,"Please enter all information or create a CD first" ,  "WARNING", JOptionPane.WARNING_MESSAGE);
        }
        String name = text.getText();
        String length_string = text_length.getText();
        int length_track = Integer.parseInt(length_string);
        Track track = new Track(name, length_track);
        cd.removeTrack(track);
        this.remove(text);
        this.remove(reminding);
        this.remove(remove_button);
        SwingUtilities.updateComponentTreeUI(this);
    }
 }
    }
    

