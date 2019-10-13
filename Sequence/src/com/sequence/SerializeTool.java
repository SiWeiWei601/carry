package com.sequence;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SerializeTool {
public static void serialize (Object obj,String fileName)throws Exception{
	File file =new File(fileName);
	FileOutputStream output=new FileOutputStream(file);
	ObjectOutputStream oos=new ObjectOutputStream(output);
	oos.writeObject(obj);
	oos.flush();
	oos.close();
	
	output.close();
}


public static Object deSerialize (String fileName) throws Exception {
	File file =new File(fileName);
	
	FileInputStream input=new FileInputStream(file);
	ObjectInputStream ois=new ObjectInputStream(input);
	Object obj=ois.readObject();
	
	
	ois.close();
	
	input.close();
	return obj;
	
	
	
}

public static void printFileInfo(String fileName) {
	File file =new File(fileName);
	System.out.println(".....................");
	System.out.println("<FileName>:"+fileName);
	System.out.println("<FileSize>:"+file.length()+"bytes");
	System.out.println(".......................");
	
	
	
	
}



	

}
