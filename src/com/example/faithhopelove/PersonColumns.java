package com.example.faithhopelove;

public class PersonColumns {

	public static  String TABLE_NAME(){
		return "persons";
	}
	public static final String ID = "id";  //ID

	public static final String USERNAME = "name";  //姓名

	public static final String PHONE = "phone";  // 电话

	public static final String  SEX = "sex";  //性别

	public static final String BIRTH = "birth";  //生日

	public static final String JOB = "job";   //工作

	public static final String ISMARRY = "ismarried";   //结婚

	public static final String ADDRESS = "address";   //地址

	public static final String BAPTISM = "baptism";   //是否受洗

	public static final String GROUPID = "groupid";   //组id

	public static final String GROUPNAME = "groupname";  //组名

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

