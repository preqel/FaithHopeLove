package com.example.faithhopelove;

import java.util.ArrayList;

import com.example.faithhopelove.bean.Group;
import com.example.faithhopelove.bean.Person;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 *
 *  所谓跟业务层有关的接口都在这个类当中定义
 */
public class DB {
	
	private DBHelper dbhelper;
	
	public DB(Context context){
		dbhelper = DBHelper.getInstance(context);
	}

	protected SQLiteDatabase openW() {
		return dbhelper.getWritableDB();
	}
	
	protected SQLiteDatabase openR() {
		return dbhelper.getReadableDB();
	}
	

	protected void beginTransaction() {
		openW().beginTransaction();
	}
	


	protected void setTransactionSuccessful() {
		openW().setTransactionSuccessful();
	}
	

	protected void endTransaction() {
		openW().endTransaction();
	}
	
	
	protected void close(Cursor c) {
		if (c != null) {
			c.close();
		}
	}
	
 
	public int getCount(Cursor cursor) {
		return cursor != null ? cursor.getCount() : 0;
	}
 
	public void initGroup(String tableName){
		dbhelper.initGroup(openW(),tableName);
	}
	
	/**
	 * 根据groupid查询人员列表
	 */
	public ArrayList<Person> queryPersonList( int groupid) {
		String selection = "";
		if (groupid != 0)
			selection = PersonColumns.GROUPID + "=" + groupid;
		Cursor cursor = null;
		try {
			String orderBy = PersonColumns.ID + " desc ";
			cursor = dbhelper.getReadableDB().query(PersonColumns.TABLE_NAME(),
					PersonColumns.COLUMN_ARRAY, selection, null, null, null, orderBy,
					null);
			int count = cursor.getCount();
			if (count == 0) {
				return new ArrayList<Person>(0);
			}
			ArrayList<Person> result = new ArrayList<Person>();
			while (cursor.moveToNext()) {
				Person person = getValue(cursor);
				result.add(person);
			}
			return result;
		} finally {
			dbhelper.closeDB();
			//dbhelper.close(cursor);
		}
	}
	
	
	
	
	/**
	 * 添加人员
	 * @return 
	 */
	public boolean insertPerson(Person p ){
		ContentValues cv = getValue(p);
		return dbhelper.getWritableDB().insert(PersonColumns.TABLE_NAME(), PersonColumns.ID, cv)>= 0 ?true:false;
	}
	
	
	
	/**
	 * 删除人员
	 */
	public  int  deletePersonByName(String name){
		if(name == null || name.length() <= 0)
			name = ""; 
		String whereClause = PersonColumns.USERNAME +" = ? "  ;
		return dbhelper.getWritableDB().delete(PersonColumns.TABLE_NAME(), whereClause, new String[]{name});
	}
	
	
	/**
	 * 查询团队列表
	 */
	public  ArrayList<Group>  queryGroupList( ){
		Cursor cursor = null;
		cursor = dbhelper.getWritableDB().query(PersonColumns.TABLE_NAME(), null, null, null, PersonColumns.GROUPNAME, null, null);
		try{
		ArrayList<Group> results = new ArrayList<Group>();
		while(cursor.moveToNext()){
			Group  group = new Group();
			String name = cursor.getString(cursor.getColumnIndex(PersonColumns.GROUPNAME));
		    group.setName(name);
		    results.add(group);
		}
		return results;
		}finally{
			dbhelper.closeDB();
		}
 
	}
	
	 
	
	/**
	 * 根据团队名称查询人员列表
	 */
	public ArrayList<Person> queryPersonList( String groupname) {
		String selection = PersonColumns.GROUPNAME + "=? " ;
		Cursor cursor = null;
		try {
 			String orderBy = PersonColumns.ID + " desc "; 
			cursor = dbhelper.getReadableDB().query(PersonColumns.TABLE_NAME(),
					PersonColumns.COLUMN_ARRAY, selection , new String[]{groupname }, null, null, orderBy,
					null);
			int count = cursor.getCount();
			if (count == 0) {
				return new ArrayList<Person>(0);
			}
			ArrayList<Person> result = new ArrayList<Person>();
			while (cursor.moveToNext()) {
				Person  person = getValue(cursor);
				result.add(person);
			}
			return result;
		} finally {
			dbhelper.closeDB();
		}
	}
	
	
	
	
	/**
	 * ���ContentValues
	 * 
	 * @param chat
	 * @return
	 */
	private ContentValues getValue(Person person) {
		ContentValues values = new ContentValues();
		values.put(PersonColumns.ID,  person.getId());
		values.put(PersonColumns.USERNAME, person.getName ());
		values.put(PersonColumns.SEX, person.getSex());
		values.put(PersonColumns.ISMARRY, person.isIsmarried());
		values.put(PersonColumns.BAPTISM, person.getBaptism ());
		values.put(PersonColumns.PHONE, person.getPhone());
		values.put(PersonColumns.JOB, person.getJob());
		values.put(PersonColumns.ADDRESS, person.getAddress());
		values.put(PersonColumns.BIRTH, person.getBirth());
		return values;
	}

	/**
	 * 获取bean
	 * 
	 * @param cursor
	 * @return
	 */
	private Person getValue(Cursor cursor) {
		Person person = new Person();
		String id = cursor.getString(cursor.getColumnIndex( PersonColumns.ID));
		String birth  = cursor.getString(cursor.getColumnIndex(PersonColumns.BIRTH)) ;
		String address = cursor.getString(cursor.getColumnIndex(PersonColumns.ADDRESS));
		String job  = cursor.getString(cursor.getColumnIndex(PersonColumns.JOB));
		String phone = cursor.getString(cursor.getColumnIndex(PersonColumns.PHONE));
		String sex = cursor.getString(cursor.getColumnIndex(PersonColumns.SEX));
		String username = cursor.getString(cursor.getColumnIndex(PersonColumns.USERNAME));
		int baptism = cursor.getInt(cursor.getColumnIndex(PersonColumns.BAPTISM));
		Integer ismarry = cursor.getInt(cursor.getColumnIndex(PersonColumns.ISMARRY));
		String groupname = cursor.getString(cursor.getColumnIndex(PersonColumns.GROUPNAME));
		person.setBirth(birth);
		person.setId(id);
		person.setAddress(address);
		person.setJob(job);
		person.setSex(sex);
		person.setName(username);
		person.setIsmarried(ismarry); 
		person.setGroupname(groupname);
		person.setPhone(phone);
		person.setBaptism(baptism==1?true:false);
		return person;
	}
	
}
