package com.zhujie;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class TableInfo {
	private String tableName;
	private Class<?>clazz;
	private boolean needpersist = false;
	private Map<String, ColumInfo>columns =new HashMap<String, ColumInfo>();
	
	public  TableInfo parse(Class<?>clazz) {
		this.clazz = clazz;
		this.tableName = this.clazz.getSimpleName();
		Annotation[] annotations = this.clazz.getAnnotations();
		for(Annotation annotation:annotations) {
			if(annotation.annotationType().equals(Entity.class)) {
				this.needpersist = true;
				Entity entity = (Entity)annotation;
				if(!entity.value().equals("")) {
					this.tableName=entity.value();
				}
				break;
			}
		}
		if(this.needpersist) {
			Field fields = this.clazz.getDeclaredField();
			for(Field field:fields) {
				ColumInfo column = new  ColumInfo();
				column = column.parse(field);
				if(column!=null) {
					this.columns.put(field.getName(), column);
				}
			}
			return this;
		}else {
			return null;
		}
		
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(Symbol.LINE);
		sql.append("CREATE TABLE");
		sql.append(this.tableName+Symbol.BLANK);
		sql.append("(");
		for(ColumInfo column:this.columns.values()) {
			sql.append(Symbol.LINE);
			sql.append(Symbol.TAB);
			sql.append(column.toString());
		}
		sql.append(Symbol.LINE);
		sql.append(");");
		return sql.toString();
	}
}
