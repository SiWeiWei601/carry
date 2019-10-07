package com.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client3 {

	public static void main(String[] args) throws Exception{
		// TODO 自动生成的方法存根
		Socket socket = new Socket("127.0.0.1", 888);
		InputStreamReader reader = new InputStreamReader(socket.getInputStream());
		BufferedReader buffer = new BufferedReader(reader);
		PrintWriter writer = new PrintWriter(socket.getOutputStream());
		String readline = "message from=xu";
		writer.println(readline);
		writer.flush();
		String response = buffer.readLine();
		if(response.endsWith("this is a test".substring("this is a test".length()-7))) {
			readline = "message ok";
			writer.println(readline);
			writer.flush();
		}
		System.out.println("Server say:"+response);
		writer.close();
		buffer.close();
		socket.close();
		
	}

}
