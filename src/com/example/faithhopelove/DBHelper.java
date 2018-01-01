package com.example.faithhopelove;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.faithhopelove.db.Group;

/**
 * 数据库访问辅助类
 */
public class DBHelper {

	private static DBHelper dbhelper = null;
	
	private DatabaseHelper databasehelper = null;
	
	private DBHelper(Context context){
		this.databasehelper = new DatabaseHelper(context );
	}
	 
	
	public synchronized static DBHelper getInstance(Context context){   //单例模型
	      if(dbhelper == null){
	    	  dbhelper = new DBHelper(context);
	      }	 return dbhelper;
	}
	
	public SQLiteDatabase getWritableDB(){
		return databasehelper.getWritableDatabase();
	}
	
	
	public SQLiteDatabase getReadableDB(){
		return databasehelper.getReadableDatabase();
	}
	
	public void closeDB(){
		databasehelper.close();
	}
	
	private class DatabaseHelper extends SQLiteOpenHelper{
		
		private static final String DATABASE_NAME = "hzbg.db";  //数据库名称
		private static final int DB_VERSION = 10;     //默认版本号
		
		public DatabaseHelper(Context context, String name,
				CursorFactory factory, int version) {
			super(context, name, factory, version);
		}
		
		public DatabaseHelper(Context context){
			this(context, DATABASE_NAME, null, DB_VERSION);
		}
		
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(PersonColumns.CREAT_TABLE(PersonColumns.TABLE_NAME()));
		    db.execSQL(GroupColumns.CREAT_TABLE(GroupColumns.TABLE_NAME()));
		    initGroup(db, GroupColumns.TABLE_NAME());
		    initPerosn(db,PersonColumns.TABLE_NAME());
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL(PersonColumns.CREAT_TABLE(PersonColumns.TABLE_NAME()));
		    db.execSQL(GroupColumns.CREAT_TABLE(GroupColumns.TABLE_NAME()));
		}
		
	}

 
	public void initGroup(SQLiteDatabase db,String tableName) {
		String[] names = { Group.GROUP1, Group.GROUP2, Group.GROUP3 };
		int len = names.length;
		db.beginTransaction();
		try {
			for (int i = 0; i < len; i++) {
				ContentValues values = new ContentValues();
				values.put( GroupColumns.ID, i);
				values.put(GroupColumns.GROUPNAME, names[i]);
 				db.insert(tableName, null, values);
			}
			db.setTransactionSuccessful();
		} catch (Exception e) {
		} finally {
			db.endTransaction();
		}
	}


	public void initPerosn(SQLiteDatabase db, String table_NAME) {
		db.beginTransaction();
		try {
				ContentValues values = new ContentValues();
				values.put(PersonColumns.ID, "3");
				values.put(PersonColumns.USERNAME, "zhangkang");
				values.put(PersonColumns.BIRTH, "25");
				values.put(PersonColumns.ISMARRY, true);
				values.put(PersonColumns.SEX, "man");
				values.put(PersonColumns.BAPTISM, true);
				values.put(PersonColumns.ADDRESS, "china");
				values.put(PersonColumns.JOB, "programer");
				values.put(PersonColumns.PHONE, "110");
				values.put(PersonColumns.GROUPID, 1);
				values.put(PersonColumns.GROUPNAME, "信实组");
 				db.insert(table_NAME, null, values);
 				db.setTransactionSuccessful();
		} catch (Exception e) {
		} finally {
			db.endTransaction();
		}
	}
}
