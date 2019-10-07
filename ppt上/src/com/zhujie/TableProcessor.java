package com.zhujie;

import java.io.File;
import java.util.List;
import java.util.Scanner;


public class TableProcessor implements IProcessor{

	@Override
	public String process(String url) throws Exception {
		// TODO Auto-generated method stub
		List<File> classFiles = Scanner.getClassFile(url);
		StringBuilder sql = new StringBuilder();
		for (File file: classFiles) {
			Class<?>clazz = ClassFileLoader.loadClass(file);
			TableInfo table = TableInfo.parse(clazz);
			if(table!=null) 
				sql.append(table.toString());
			
		}
		return sql.toString();
	}
	
}
