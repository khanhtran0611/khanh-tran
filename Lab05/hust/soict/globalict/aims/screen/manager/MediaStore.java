package Lab05.hust.soict.globalict.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Lab05.hust.soict.globalict.aims.exception.PlayerException;
import Lab05.hust.soict.globalict.aims.media.*;
import Lab05.hust.soict.globalict.aims.screen.manager.StoreManagerScreen;

public class MediaStore extends JPanel implements ActionListener {
     private Media media;
     JButton playbutton;
     public MediaStore(Media media){
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN,15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(""+media.getCost()+" $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if(media instanceof Playable){
             playbutton = new JButton("Play");
             playbutton.addActionListener(this);
             container.add(playbutton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
     }
     @Override
     public void actionPerformed(ActionEvent e) {
          if(media instanceof CompactDisc){
               try {
                    ((CompactDisc)media).play();
               } catch (PlayerException e1) {
                    e1.printStackTrace();
               }
               JFrame frame = new JFrame();
               JDialog dialog = new JDialog(frame,"Playing track",true);
               dialog.setSize(new Dimension(1024,768));
               dialog.setLayout(null);
               JLabel playtrack = new JLabel("Playing CD: "+((CompactDisc)media).getTitle(),JLabel.CENTER);
               playtrack.setBackground(Color.BLACK);
               playtrack.setBounds(412,20,200,40);
               playtrack.setForeground(Color.WHITE);
               playtrack.setOpaque(true);
               JLabel playtrack2 = new JLabel("CD length: " + ((CompactDisc)media).getLength(),JLabel.CENTER);
               playtrack2.setBackground(Color.BLACK);
               playtrack2.setBounds(412,80,200,40);
               playtrack2.setForeground(Color.WHITE);
               playtrack2.setOpaque(true);
               dialog.add(playtrack,BorderLayout.CENTER);
               dialog.add(playtrack2,BorderLayout.CENTER);
               dialog.setVisible(true);
               SwingUtilities.updateComponentTreeUI(this);
          }
          if(media instanceof DigitalVideoDisc){
               try {
                    ((DigitalVideoDisc)media).play();
               } catch (PlayerException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
               }
               JFrame frame = new JFrame();
               JDialog dialog = new JDialog(frame,"Playing track",true);
               dialog.setSize(new Dimension(1024,768));
               dialog.setLayout(null);
               JLabel playtrack = new JLabel("Playing DVD: "+((DigitalVideoDisc)media).getTitle(),JLabel.CENTER);
               playtrack.setBackground(Color.BLACK);
               playtrack.setBounds(412,20,200,40);
               playtrack.setForeground(Color.WHITE);
               playtrack.setOpaque(true);
               JLabel playtrack2 = new JLabel("DVD length: " + ((DigitalVideoDisc)media).getLength(),JLabel.CENTER);
               playtrack2.setBackground(Color.BLACK);
               playtrack2.setBounds(412,80,200,40);
               playtrack2.setForeground(Color.WHITE);
               playtrack2.setOpaque(true);
               dialog.add(playtrack);
               dialog.add(playtrack2);
               dialog.setVisible(true);
               SwingUtilities.updateComponentTreeUI(this);
          }
     }
}
