package com.sequence;

public class SerializeTest {

	public static void main(String[] args) throws Exception  {
		// TODO 自动生成的方法存根
		Teacher t =new Teacher();
		SerializeTool.serialize(t,"teacher");
		
		SerializeTool.printFileInfo("teacher");
		
		
		

	}
	

}
