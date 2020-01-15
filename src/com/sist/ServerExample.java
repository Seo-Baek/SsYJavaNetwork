package com.sist;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {

	public static void main(String[] args) {
		
		ServerSocket server = null;
		
		try {
			server = new ServerSocket();
			// 연결해주는 소켓을 만드는 메소드
			server.bind(new InetSocketAddress("211.238.142.87", 5779));	
			
			while(true) {
				System.out.println("[연결 기다림]....");
				//클라이언트의 연결 수락
				Socket socket = server.accept();	
				//클라이언트의 IP주소 받음
				InetSocketAddress address = 
						(InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("[연결 수락함] >>> " + address.getHostName());
				
				byte[] bytes = null;
				String message = null;
				
				// 2. 클라이언트에서 넘어온 메세지를 받자.
				InputStream is = socket.getInputStream();
				bytes = new byte[300];
				int readByte = is.read(bytes);
				message = new String(bytes, 0, readByte, "UTF-8");
				System.out.println("[데이터 받기 성공] >>> " + message);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(!server.isClosed()) {	// 소켓이 닫혀있지 않은 경우
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
