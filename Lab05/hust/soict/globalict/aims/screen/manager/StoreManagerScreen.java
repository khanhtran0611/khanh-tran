package Lab05.hust.soict.globalict.aims.screen.manager;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Lab05.hust.soict.globalict.aims.Aims.AIMS;
import Lab05.hust.soict.globalict.aims.media.Media;
import Lab05.hust.soict.globalict.aims.screen.manager.AddBookToStoreScreen;
import Lab05.hust.soict.globalict.aims.screen.manager.AddItemToStoreScreen;
import Lab05.hust.soict.globalict.aims.store.Store;

import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





public class StoreManagerScreen extends JFrame implements ActionListener {
     static Container cp;
     private Store store = new Store();
     static JFrame frame;
     JPanel list_of_items;
     JMenuItem add_book = new JMenuItem("Add Book") ;
     JMenuItem add_cd = new JMenuItem("Add CD");
     JMenuItem add_dvd = new JMenuItem("Add DVD");
     JMenuItem update_store = new JMenuItem("View Store");
     AddBookToStoreScreen AddBook;
     AddCompactDiscToStoreScreen AddCD;
     AddDigitalVideoDiscToStoreScreen AddDVD;
     JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
     }
     JMenuBar createMenuBar(){
        JMenu menu = new JMenu("Option");
        menu.add(update_store);
        JMenu smUpdateStore = new JMenu("Update Store");
        add_book.addActionListener(this);
        add_cd.addActionListener(this);
        add_dvd.addActionListener(this);
        update_store.addActionListener(this);
        smUpdateStore.add(add_book);
        smUpdateStore.add(add_cd);
        smUpdateStore.add(add_dvd);
        menu.add(smUpdateStore);
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
     }

     JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        
        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10,10)));
        return header;
     } 

     JPanel createCenter(){
         JPanel center = new JPanel();
         center.setLayout(new GridLayout(3,3,2,2));
   
         ArrayList <Media> mediaInStore = store.getItemsInStore();
         if(mediaInStore == null) {
            System.out.println(1);
            return null;
         }
         for(int i = 0;i < min(9,mediaInStore.size()) ;i++){
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
         }
         return center;
     }
     private int min(int a, int b) {
         if(a < b) return a;
         else return b;
   }
   public StoreManagerScreen(){
           AIMS.setup(store);
           update_store.addActionListener(this);
           list_of_items = createCenter();
           cp = getContentPane();
           cp.setLayout(new BorderLayout());
           cp.add(createNorth(),BorderLayout.NORTH);
           cp.add(list_of_items,BorderLayout.CENTER);
           setTitle("Store");
           setSize(1024,768);
           setLocationRelativeTo(null);
           setVisible(true);
     }
     public static void main(String[] args) {
        new StoreManagerScreen();
        
     }
   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == add_book){
          if(list_of_items != null) {cp.remove(list_of_items);  list_of_items = null;}
          if(AddCD != null) {cp.remove(AddCD); AddCD = null;}
          if(AddDVD != null) {cp.remove(AddDVD); AddDVD = null;}
          if(AddBook != null) return;
          AddBook = new AddBookToStoreScreen(store);
          cp.add(AddBook);
          SwingUtilities.updateComponentTreeUI(cp);
      }
      if(e.getSource() == add_cd){
         if(list_of_items != null) {cp.remove(list_of_items); list_of_items = null;}
         if(AddBook != null) {cp.remove(AddBook);AddBook = null;}
         if(AddDVD != null) {cp.remove(AddDVD); AddDVD = null;}
         if(AddCD != null) return;
         AddCD = new AddCompactDiscToStoreScreen(store);
         cp.add(AddCD);
         SwingUtilities.updateComponentTreeUI(cp);
      }
      if(e.getSource() == add_dvd){
         if(list_of_items != null) {cp.remove(list_of_items); list_of_items = null;}
         if(AddBook != null) {cp.remove(AddBook);AddBook = null;}
         if(AddCD != null) {cp.remove(AddCD); AddCD = null;}
         if(AddDVD != null) return;
         AddDVD = new AddDigitalVideoDiscToStoreScreen(store);
         cp.add(AddDVD);
         SwingUtilities.updateComponentTreeUI(cp);
      }
      if(e.getSource() == update_store){
         if(AddBook != null) {cp.remove(AddBook);AddBook = null;}
         if(list_of_items != null) {cp.remove(list_of_items);list_of_items = null;}
         if(AddCD != null) {cp.remove(AddCD); AddCD = null;}
         if(AddDVD != null) {cp.remove(AddDVD); AddDVD = null;}
         list_of_items = createCenter();
         cp.add(list_of_items);
         SwingUtilities.updateComponentTreeUI(cp);
      }
   }
}
