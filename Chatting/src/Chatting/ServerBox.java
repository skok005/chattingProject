package Chatting;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class ServerBox extends JFrame {

   private JPanel contentPane;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               ServerBox frame = new ServerBox();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public ServerBox() {
      setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Mtest\\Chatting Project\\RainBow.jpg"));
      setTitle("InsideOut Headquarter");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 453, 680);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      
      JTextArea textArea = new JTextArea();
      textArea.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
      textArea.setBackground(new Color(248, 248, 255));
      textArea.setForeground(new Color(0, 0, 0));
      
      JButton btnNewButton = new JButton("Server Shutdown");
      btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
      GroupLayout gl_contentPane = new GroupLayout(contentPane);
      gl_contentPane.setHorizontalGroup(
         gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
            .addComponent(textArea, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
      );
      gl_contentPane.setVerticalGroup(
         gl_contentPane.createParallelGroup(Alignment.TRAILING)
            .addGroup(gl_contentPane.createSequentialGroup()
               .addComponent(textArea, GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
               .addPreferredGap(ComponentPlacement.RELATED)
               .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
      );
      contentPane.setLayout(gl_contentPane);
   }
}