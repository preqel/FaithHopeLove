package com.example.faithhopelove;

public class PersonColumns {

	public static  String TABLE_NAME(){
		return "persons";
	} 
	public static final String ID = "id";  //ID
	
	public static final String USERNAME = "name";  //����
	
	public static final String PHONE = "phone";  // �绰
	
	public static final String  SEX = "sex";  //�Ա�
	
	public static final String BIRTH = "birth";  //����
	
	public static final String JOB = "job";   //����
	
	public static final String ISMARRY = "ismarried";   //���
	
	public static final String ADDRESS = "address";   //��ַ
	
	public static final String BAPTISM = "baptism";   //�Ƿ���ϴ
	
	public static final String GROUPID = "groupid";   //��id
	
	public static final String GROUPNAME = "groupname";  //����
	
	public static final String[] COLUMN_ARRAY = {
		ID,
		USERNAME,
		PHONE,
		SEX,
		BIRTH,
		JOB,
		ISMARRY,
		ADDRESS,
		BAPTISM,
		GROUPID,
		GROUPNAME
	};
	
	
	public static String CREAT_TABLE(String tableName){
		return new StringBuffer().
				append("CREATE TABLE IF NOT EXISTS ").append(tableName).
				append("(").
				append(ID).append(" TEXT PRIMARY KEY NOT NULL,").
				append(USERNAME).append(" TEXT,").
				append(PHONE).append(" TEXT,").
				append(SEX).append(" TEXT,").
				append(BIRTH).append(" TEXT,").
				append(JOB).append(" TEXT,").
				append(ISMARRY).append(" INTEGER DEFAULT 1,").
				append(ADDRESS).append(" INTEGER DEFAULT 0,").
				append(BAPTISM).append(" TEXT ,").
				append(GROUPID).append(" INTEGER DEFAULT 0, ").
				append(GROUPNAME).append(" TEXT  ").
				append(");").toString();
	}
	
	private static String DROP_TABLE(){
		return "DROP TABLE IF EXISTS " +  TABLE_NAME();
	}
	
}
