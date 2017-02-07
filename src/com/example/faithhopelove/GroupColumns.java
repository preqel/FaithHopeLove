package com.example.faithhopelove;

public class GroupColumns {
	
	public static  String TABLE_NAME(){
		return "groups";
	} 
	
	public static final String ID = "id";  //IDs
	
	public static final String GROUPNAME = "name";  //×éÃû
	
	public static final String[] COLUMN_ARRAY = {
		ID,
		GROUPNAME 
	};
	
	public static String CREAT_TABLE(String tableName){
		return new StringBuffer().
				append("CREATE TABLE IF NOT EXISTS ").append(tableName).
				append("(").
				append(ID).append(" TEXT PRIMARY KEY NOT NULL,").
				append(GROUPNAME).append(" TEXT ").
				append(");").toString();
	}
}
