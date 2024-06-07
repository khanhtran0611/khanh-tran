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
import Lab05.hust.soict.globalict.aims.screen.customer.controller.ViewStoreController;
import Lab05.hust.soict.globalict.aims.screen.manager.AddItemToStoreScreen;
import Lab05.hust.soict.globalict.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen implements ActionListener{
    JButton button;
    JLabel add_a_book;
    Book book;
    String[] list = {"Add author","Remove author"};
    JComboBox authors = new JComboBox<>(list);
    JTextField text ;
    JButton author_button;
    JButton remove_button;
    JLabel reminding;
    AddBookToStoreScreen(Store store){
        super(store);
        authors.setBounds(280, 260, 120, 30);
        authors.addActionListener(this);
        button = getButton();
        button.addActionListener(this);
        add_a_book = new JLabel("Adding a book",JLabel.CENTER);
        add_a_book.setBounds(433, 20, 130, 40);
        add_a_book.setBackground(Color.PINK);
        add_a_book.setOpaque(true);
        this.add(add_a_book);
        this.add(authors);
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
        book = new Book(id, title, category, cost);
        store.addMedia(book);
        set_title.setText("");
        set_id.setText("");
        set_category.setText("");
        set_cost.setText("");
        System.out.println(book.toString());
       }
       if(e.getSource() == authors){
           int choice = authors.getSelectedIndex();
           switch(choice){
              case 0:
              if(remove_button != null) this.remove(remove_button);
              reminding = new JLabel("Enter the author 's name",JLabel.CENTER);
              reminding.setBounds(270, 300, 150, 30);
              reminding.setBackground(Color.GREEN);
              reminding.setOpaque(true);
              text = new JTextField();
              text.setBounds(270,340,150,30);
              author_button = new JButton("Add");
              author_button.setBounds(270,380 , 150, 30);
              author_button.addActionListener(this);
              this.add(reminding);
              this.add(text);
              this.add(author_button);
              SwingUtilities.updateComponentTreeUI(this);
              break;
              case 1:
              if(author_button != null) this.remove(author_button);
              reminding = new JLabel("Enter the author 's name",JLabel.CENTER);
              reminding.setBounds(270, 300, 150, 30);
              reminding.setBackground(Color.GREEN);
              reminding.setOpaque(true);
              text = new JTextField();
              text.setBounds(270,340,150,30);
              remove_button = new JButton("Remove");
              remove_button.setBounds(270,380 , 150, 30);
              remove_button.addActionListener(this);
              this.add(reminding);
              this.add(text);
              this.add(remove_button);
              SwingUtilities.updateComponentTreeUI(this);
              break;
           }
       }
       if(e.getSource() == author_button){
           if(book == null){
            JOptionPane.showMessageDialog(this,"Please create a book first" , "WARNING", JOptionPane.WARNING_MESSAGE);
           }
           String name = text.getText();
           book.addAuthor(name);
           this.remove(text);
           this.remove(reminding);
           this.remove(author_button);
           SwingUtilities.updateComponentTreeUI(this);
       }
       if(e.getSource() == remove_button){
        if(book == null){
            JOptionPane.showMessageDialog(this,"Please create a book first" , "WARNING", JOptionPane.WARNING_MESSAGE);
           }
           String name = text.getText();
           book.removeAuthor(name);
           this.remove(text);
           this.remove(reminding);
           this.remove(remove_button);
           SwingUtilities.updateComponentTreeUI(this);
       }
    }

}
