package com.sist;

import java.net.UnknownHostException;

public class InetAddress {

	public static void main(String[] args) {
		
		try {
			// 내컴퓨터 IP주소 찾기
			java.net.InetAddress local = 
					java.net.InetAddress.getLocalHost();
			System.out.println("내 컴퓨터 IP Address >>> " + local.getHostAddress());
			System.out.println();
			
			java.net.InetAddress inet = java.net.InetAddress.getByName("www.naver.com");
			System.out.println("네이버 IP Address >>> " + inet.getHostAddress());
			System.out.println();
			
			java.net.InetAddress[] inetarr =
					java.net.InetAddress.getAllByName("www.daum.net");
			for(java.net.InetAddress remote : inetarr) {
				System.out.println("다음 IP Address >>> " + remote.getHostAddress());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
}
