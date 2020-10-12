package Chatting;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;

public class Chatting_ChatBox extends JFrame implements ActionListener {

   private JPanel contentPane;
   private JScrollPane Scroll;
   private JTextField textField;
   private JButton btnSend, btnExport, btnExit;
   private JTextArea textArea;
   /**
    * Launch the application.
    */
   public static void ChatBoxScreen() {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Chatting_ChatBox frame = new Chatting_ChatBox();
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
   
   public Chatting_ChatBox() {
      setResizable(false);
      setFont(new Font("Arial Black", Font.BOLD, 12));
      setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Mtest\\Chatting Project\\RainBow.jpg"));
      setTitle("InsideOut");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 415, 595);
      
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      textArea = new JTextArea();
      Scroll = new JScrollPane(textArea);
      Scroll.setBounds(0, 0, 409, 512);
      textArea.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
      textArea.setBackground(new Color(255, 235, 205));
      textArea.setBounds(0, 0, 409, 509);
      contentPane.add(Scroll);
      
      textField = new JTextField();
      textField.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
      textField.setBounds(0, 510, 252, 59);
      contentPane.add(textField);
      textField.setColumns(10);
      
      btnSend = new JButton("Send");
      btnSend.setBackground(new Color(245, 255, 250));
      btnSend.setFont(new Font("Arial Black", Font.PLAIN, 12));
      btnSend.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {   
         }
      });
      btnSend.setBounds(252, 510, 80, 57);
      contentPane.add(btnSend);
      
      btnExport = new JButton("Export");
      btnExport.setFont(new Font("Arial Black", Font.PLAIN, 12));
      btnExport.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btnExport.setForeground(new Color(0, 0, 0));
      btnExport.setBackground(new Color(245, 255, 250));
      btnExport.setBounds(329, 510, 80, 29);
      contentPane.add(btnExport);
      
      btnExit = new JButton("Exit");
      btnExit.setBackground(new Color(245, 255, 250));
      btnExit.setFont(new Font("Arial Black", Font.PLAIN, 12));
      btnExit.setBounds(329, 539, 80, 28);
      contentPane.add(btnExit);
      
      this.textField.addActionListener(this);
      this.btnSend.addActionListener(this);
      this.btnExport.addActionListener(this);
      this.btnExit.addActionListener(this);
   }
   
   public void sendMessage() {
      String data = textField.getText();
      this.textArea.append(data + "\n");
      this.textField.setText("");
      this.textField.requestFocus();
   }//end
   
   public void export() {
      String chat = textArea.getText();
      String path = "C:/Mtest/Chatting.txt";
      try {
         File file = new File(path);
         FileWriter fw = new FileWriter(file, true);
         BufferedWriter bw = new BufferedWriter(fw);
         bw.write(chat);
         textArea.append("        #대화내용이 저장되었어요#\n");
         System.out.println(path + "파일저장 성공");
         bw.close(); // 필수 
      } catch (Exception ex) {
         System.out.println("저장실패" + ex);
        }
   }//end
   
   public void sendExit() {
      System.exit(1);
   }//end
   
   @Override
   public void actionPerformed(ActionEvent e) {
      Object ob = e.getSource();
      if(ob==this.textField) {
         this.sendMessage();
      }else if(ob==this.btnSend) {
         this.sendMessage();
      }else if(ob==this.btnExport) {
         this.export();         
      }else if(ob==this.btnExit) {
         this.sendExit();
      }else {}
   }//end
      
}






