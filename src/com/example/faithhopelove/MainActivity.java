package com.example.faithhopelove;

import java.util.ArrayList;

import com.example.faithhopelove.bean.Group;
import com.example.faithhopelove.bean.Person;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/*
 *    入口类
 *    数据库查询项目，通过封装db层，从而提供了上层接口给后来开发者调用本地数据库。
 *
 */
public class MainActivity extends Activity {

	TextView mText;
	Button btn, btnAdd, btnDel, btnQuery, btnQueryList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_main);
		initView();
		super.onCreate(savedInstanceState);
	}

	private void initView() {
		mText = (TextView) findViewById(R.id.textView1);
		btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new View.OnClickListener() {   //查询
			
			@Override
			public void onClick(View v) {
				DB db = new DB(v.getContext());
				ArrayList<Person> arrays = db.queryPersonList(0);
				mText.setText("");
				for(int i=0;i<arrays.size();i++){
					Log.d("tag",arrays.get(i).toString());
					mText.append(arrays.get(i).toString()+"\n");
				}
			}
		});
		btnAdd = (Button) findViewById(R.id.btnAdd);    //往数据库插入数据
		btnAdd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Person p = generatePerson();
				new DB(v.getContext()).insertPerson(p);
				
			}
		});
		btnDel = (Button) findViewById(R.id.butDel);     //往数据库删除数据
		btnDel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new DB(v.getContext()).deletePersonByName("mayintao");
			}
		});
		btnQuery = (Button) findViewById(R.id.butQuery);    //查询小组信息
		btnQuery.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mText.setText("");
				ArrayList<Group> arrays =  	new DB(v.getContext()).queryGroupList();
				for(int i=0;i<arrays.size();i++){
					//Log.d("GROUP",arrays.get(i).toString());
					mText.append(arrays.get(i).toString()+"\n");
				}
			}
		});
		btnQueryList = (Button) findViewById(R.id.butQueryList);   //查询信实组的所有成员
		btnQueryList.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ArrayList<Person> arrays =  new DB(v.getContext()).queryPersonList("信实组") ;
				mText.setText("");
				for(int i=0;i<arrays.size();i++){
					Log.d("GROUP",arrays.get(i).toString());
					mText.append(arrays.get(i).toString()+"\n");
				}
			}
		});
	}

    //初始化测试数据
	protected Person generatePerson() {
		Person person = new Person();
		person.setId("1");
		person.setIsmarried(1);
		person.setGroup(3);
		person.setGroupname("温柔组");
		person.setName("Zhangsan");
		person.setBirth("19891202");
		person.setPhone("110");
		person.setJob("english");
		person.setAddress("Hangzhou");
		person.setSex("man");
		person.setBaptism(true);
		return person;
	}
}
