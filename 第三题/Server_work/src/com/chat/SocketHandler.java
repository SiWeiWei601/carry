package com.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketHandler implements Runnable{
	private Socket socket;
	public SocketHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		try {
			InputStreamReader reader = new InputStreamReader(socket.getInputStream());
			BufferedReader buffer = new BufferedReader(reader);
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			String client = "<"+socket.getInetAddress().toString()+":"+socket.getPort()+">";
			String request = buffer.readLine();
			String str = "ok";
			if(request.startsWith("register".substring(0,8))) {
			
					str = "register ok";

			}
			if(request.startsWith("login".substring(0,5))) {
				
					str = "login ok";
				
			}
			if(request.startsWith("message".substring(0,7))) {
				
					str = "message ok,xu zhang this is a test";
				
			}
			if(request.startsWith("logout".substring(0,6))) {
				
					str = "logout ok";
				
			}
			System.out.print(client+"say:"+request);
			System.out.println();

			String line = client+str;
			writer.print(line);
			writer.flush();
			writer.close();
			buffer.close();
			socket.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
