package com.sist;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientExample {

	public static void main(String[] args) {
		
		Socket socket = null;
		socket = new Socket();	// 소켓객체생성
		System.out.println("[연결 요청]...");
		try {
			socket.connect(new InetSocketAddress("211.238.142.86", 5779));
			System.out.println("[연결 성공]");
			
			String message = null;
			byte[] bytes = null;
			
			// 1. 우선적으로 클라이언트에서 서버로 메세지를 전송해 보자.
				OutputStream os = socket.getOutputStream();
				message = "안녕 서버~!";
				bytes = message.getBytes("UTF-8");  // UTF-8은 3 byte씩 보낸다.
				os.write(bytes);
				os.flush();
				System.out.println("[데이터 보내기 성공]");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		if(!socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
