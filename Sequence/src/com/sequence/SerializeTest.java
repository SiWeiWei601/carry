package com.sequence;

public class SerializeTest {

	public static void main(String[] args) throws Exception  {
		// TODO �Զ����ɵķ������
		Teacher t =new Teacher();
		SerializeTool.serialize(t,"teacher");
		
		SerializeTool.printFileInfo("teacher");
		
		
		

	}
	

}
