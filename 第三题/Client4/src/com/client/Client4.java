package com.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client4 {

	public static void main(String[] args) throws Exception{
		// TODO 自动生成的方法存根
		Socket socket = new Socket("127.0.0.1", 888);
		InputStreamReader reader = new InputStreamReader(socket.getInputStream());
		BufferedReader buffer = new BufferedReader(reader);
		PrintWriter writer = new PrintWriter(socket.getOutputStream());
		String readline = "logout name=xu";
		writer.println(readline);
		writer.flush();
		String response = buffer.readLine();
		System.out.println("Server say:"+response);
		writer.close();
		buffer.close();
		socket.close();
		
	}

}
