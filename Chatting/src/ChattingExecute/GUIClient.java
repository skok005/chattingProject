package ChattingExecute;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

import Chatting.Chatting_ChatBox;
import Chatting.Chatting_TableData;

public class GUIClient extends JFrame implements ActionListener,Runnable{ 
	JPanel mainPan, firstPan, twoPan;  

	JLabel  info;
	JButton btn_connect, btn_send, btn_exit, btn_export, btn_signUp;
	JTextField txt_server_ip, txt_name, txt_input;
	TextArea txt_list;
	CardLayout cardlayout; 
	JPasswordField passwordField;
	
	String ip_txt;                            
	Socket sock;
	final int PORT=7500;
	PrintWriter pw=null;                
	BufferedReader br=null;            
	OutputStream os=null;
	
	public GUIClient() 	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Mtest\\Chatting Project\\RainBow.jpg"));
    this.setTitle("InsideOut");
		serverConnect();
		ChatPane();
		
		//card-----------------------------
		mainPan = new JPanel();
		cardlayout = new CardLayout();
		mainPan.setLayout(cardlayout);
		
		mainPan.add(firstPan,"접속창");
		mainPan.add(twoPan,"채팅창");
		cardlayout.show(mainPan, "접속창"); //기본선택 
		//----------------------------------
		getContentPane().add(mainPan);
		setBounds(200,200,800,500);
		setVisible(true);
		
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//이벤트처리-----------------------
		btn_connect.addActionListener(this);
		btn_export.addActionListener(this);
		btn_exit.addActionListener(this);
		btn_send.addActionListener(this);
		btn_signUp.addActionListener(this);
		txt_input.addActionListener(this);
		//----------------------------------
	} //end
	
	public void serverConnect() {
	  firstPan = new JPanel();
    //JPanel pn = new JPanel();
    ImagePanel pn = new ImagePanel(new ImageIcon("C:/Mtest/Chatting Project/insideOut1.jpg").getImage());
    pn.setLayout(null);
    
    firstPan.setLayout(new BorderLayout());
    firstPan.add(pn,BorderLayout.NORTH);
    
    JLabel lb1 = new JLabel("IP :");
    lb1.setHorizontalAlignment(SwingConstants.RIGHT);
    lb1.setFont(new Font("Lucida Handwriting", Font.PLAIN, 20));
    lb1.setBounds(295, 129, 60, 20);
    pn.add(lb1);
    txt_server_ip = new JTextField("192.168.0.29", 15);
    txt_server_ip.setForeground(new Color(105, 105, 105));
    txt_server_ip.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
    txt_server_ip.setBounds(365, 129, 110, 20);
    pn.add(txt_server_ip);
    txt_name = new JTextField("Enter ID",15);
    txt_name.setForeground(new Color(105, 105, 105));
    txt_name.setFont(new Font("Calibri", Font.BOLD, 15));
    txt_name.setBounds(365, 69, 110, 20);
    pn.add(txt_name);
    JLabel lb2 = new JLabel("ID :");
    lb2.setHorizontalAlignment(SwingConstants.RIGHT);
    lb2.setFont(new Font("Lucida Handwriting", Font.PLAIN, 20));
    lb2.setBounds(295, 69, 60, 20);
    pn.add(lb2);
    
    JLabel pw = new JLabel("PW :");
    pw.setFont(new Font("Lucida Handwriting", Font.PLAIN, 20));
    pw.setHorizontalAlignment(SwingConstants.RIGHT);
    pw.setBounds(295, 99, 60, 20);
    pn.add(pw);
    
    passwordField = new JPasswordField();
    passwordField.setFont(new Font("Calibri", Font.BOLD, 15));
    passwordField.setBounds(365, 99, 110, 21);
    pn.add(passwordField);
    
    btn_connect = new JButton("LOG IN");
    btn_connect.setForeground(new Color(0, 0, 102));
    btn_connect.setBackground(new Color(255, 255, 204));
    btn_connect.setFont(new Font("Arial Unicode MS", Font.PLAIN, 10));
    btn_connect.setBounds(315, 155, 75, 20);
    pn.add(btn_connect);
    
    btn_signUp = new JButton("SIGN UP");
    btn_signUp.setForeground(new Color(0, 0, 102));
    btn_signUp.setBackground(new Color(255, 255, 204));
    btn_signUp.setFont(new Font("Arial Unicode MS", Font.PLAIN, 10));
    btn_signUp.setBounds(395, 155, 80, 20);
    pn.add(btn_signUp);

	} //end
	
	public void ChatPane(){
		twoPan = new JPanel();
		JPanel  pn = new JPanel();
		pn.setBackground(new Color(230, 230, 250));
		txt_list = new TextArea();
		txt_list.setBackground(new Color(255, 255, 240));
		txt_input = new JTextField("",40);
		btn_send = new JButton("Send");
		btn_send.setForeground(new Color(255, 255, 255));
		btn_send.setBackground(new Color(138, 43, 226));
		btn_export = new JButton("Export");
		btn_export.setForeground(new Color(255, 255, 255));
		btn_export.setBackground(new Color(138, 43, 226));
		btn_exit = new JButton("Exit");
		btn_exit.setForeground(new Color(255, 255, 255));
		btn_exit.setBackground(new Color(138, 43, 226));

		pn.add(txt_input); pn.add(btn_send); pn.add(btn_export); pn.add(btn_exit);
		
		twoPan.setLayout(new BorderLayout());
		twoPan.add(txt_list, "Center");
		twoPan.add(pn, "South");
	} //end

	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		Chatting_TableData data_check = new Chatting_TableData();
		 // 아이디 저장 변수
	  String idcheak = txt_name.getText();
	   // 비밀번호 저장 변수
	  String passcheak = passwordField.getText();
	 		if(ob == btn_connect){ 
	    	 // 검사 후 맞으면 1 틀리면 0 반환
	     	 int num = data_check.idCheck(idcheak, passcheak);
	     	 System.out.println(num);
	     	 if( num == 1 ) {
	 			   cardlayout.show(mainPan, "채팅창");
					 this.setTitle("접속자이름:" + txt_name.getText());
					 ip_txt=txt_server_ip.getText();	
	    	 } else {
    	 	 JOptionPane.showMessageDialog(null,"입력하신 정보가 틀렸습니다.");
    	   }				
				Thread th=new Thread(this);  
				th.start();
			}
			
			if(ob == btn_signUp) { 
				Chatting_signUp su = new Chatting_signUp(); 
				su.SignupScreen();}
			if(ob == btn_send) { send( ); }
			if(ob == txt_input) { send( ); }
			if(ob == btn_export) {export();}
			if(ob == btn_exit){
				pw.println( txt_name.getText() +"님 퇴장");
				pw.flush();
				System.exit(1);
			}
	}	//actionPerformed end
		
		 public void export() {
		   String chat = txt_list.getText();
		   String path = "C:/Mtest/Chatting.txt";
		   try {
		      File file = new File(path);
		      FileWriter fw = new FileWriter(file, true);
		      BufferedWriter bw = new BufferedWriter(fw);
		      bw.write(chat);
		      txt_list.append("        #대화내용이 저장되었어요#\n");
		      System.out.println(path + "파일저장 성공");
		      bw.close(); // 필수 
		   } catch (Exception ex) {
		      System.out.println("저장실패" + ex);
		     }
    }//end
  
		public void send( ){
			String text=txt_input.getText();
			if(text.equals("exit")){
			  text="채팅방을 퇴장합니다";
			  pw.println( txt_name.getText() +"님 퇴장");
			  pw.flush();
			  System.out.println("채팅유저 프로그램이 종료됩니다");
			  System.exit(1);
			}
		
			txt_input.setText("");
			txt_input.requestFocus(); 
			pw.println(text);
			pw.flush();
		} //end
	
		
	public void run() {
		try{
			sock = new Socket(ip_txt, PORT);
			String nickname=txt_name.getText();
			Chatting_Transaction t = new Chatting_Transaction();
			Chatting_TransactionBuilder tb = new Chatting_TransactionBuilder(t);			
			os=sock.getOutputStream();
			pw=new PrintWriter(new OutputStreamWriter(os));
			pw.println(nickname);           
			pw.flush();
			InputStream is=sock.getInputStream();
			br=new BufferedReader(new InputStreamReader(is));
			
			String str;
			while(true)	{
				str=br.readLine();
				txt_list.append(str + "\n");
			} //while end			
		}catch(IOException e){  }		
	
	} //run end
	
	 public static void main(String[] args) {
	 	new GUIClient();
	 } //end
}//GUIChatClient class END

class ImagePanel extends JPanel {
  
  private Image img;
  
  public ImagePanel( Image img ) {
     this.img = img;
     setSize( new Dimension(img.getWidth(null), img.getHeight(null)));
     setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
     setLayout(null);
  }
  // 이미지의 가로 넓이를 구한다.
  public int getWidth() {
     return img.getWidth(null);
  }
  // 이미지의 높이 길이를 구한다.
  public int getHeight() {
     return img.getHeight(null);
  }
  
  public void paintComponent( Graphics g ) {
     g.drawImage( img, 0, 0, null);
  }
}