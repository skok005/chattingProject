package Chatting;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Chatting_Client implements Runnable{
	
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 9090;
	
	public static void main(String[] args) throws IOException{
		Socket socket = new Socket(SERVER_IP, SERVER_PORT);
		
		InputStream is=socket.getInputStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(is));
		
		OutputStream os=socket.getOutputStream();
		PrintWriter out =new PrintWriter(new OutputStreamWriter(os));
		
		String serverResponse = br.readLine();
		
		JOptionPane.showMessageDialog(null, "서버 연결 성공!");
		Chatting_Client cc = new Chatting_Client();
		cc.run();
		
		socket.close();
		System.out.println(0);
	
		
	}

	@Override
	public void run() {
	  Chatting_Login ca = new Chatting_Login();
    ca.LoginScreen();
 }
}

