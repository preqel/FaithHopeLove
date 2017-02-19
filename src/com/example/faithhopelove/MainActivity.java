package com.example.faithhopelove;

import java.util.ArrayList;

import com.example.faithhopelove.bean.Group;
import com.example.faithhopelove.bean.Person;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/*
       数据库查询项目，通过封装db层，从而提供了上层接口给后来开发者调用本地数据库。
       @author  wangkang

 */
public class MainActivity extends Activity {

	TextView textview ;
	Button btn , btn2 , btn3 ,btn4 ,btn5;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_main);
		init();
		super.onCreate(savedInstanceState);
	}

	private void init() {
		textview = (TextView) findViewById(R.id.textView1);
		btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new View.OnClickListener() {   //查询
			
			@Override
			public void onClick(View v) {
				DB db = new DB(v.getContext());
				ArrayList<Person> arrays = db.queryPersonList(0);
				textview.setText("");
				for(int i=0;i<arrays.size();i++){
					Log.d("tag",arrays.get(i).toString());
					textview.append(arrays.get(i).toString()+"\n");
				}
			}
		});
		btn2 =  (Button) findViewById(R.id.button2);    //往数据库插入数据
		btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Person p = generatePerson();
				new DB(v.getContext()).insertPerson(p);
				
			}
		});
		btn3 = (Button) findViewById(R.id.button3);     //往数据库删除数据
		btn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new DB(v.getContext()).deletePersonByName("mayintao");
			}
		});
		btn4 = (Button) findViewById(R.id.button4);    //查询小组信息
		btn4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				textview.setText("");
				ArrayList<Group> arrays =  	new DB(v.getContext()).queryGroupList();
				for(int i=0;i<arrays.size();i++){
					//Log.d("GROUP",arrays.get(i).toString());
					textview.append(arrays.get(i).toString()+"\n");
				}
			}
		});
		btn5 = (Button) findViewById(R.id.button5);   //查询信实组的所有成员
		btn5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ArrayList<Person> arrays =  new DB(v.getContext()).queryPersonList("信实组") ;
				textview.setText("");
				for(int i=0;i<arrays.size();i++){
					Log.d("GROUP",arrays.get(i).toString());
					textview.append(arrays.get(i).toString()+"\n");
				}
			}
		});
	}

	protected Person generatePerson() {
		Person person = new Person();
		person.setId("1");
		person.setIsmarried(1);
		person.setGroup(3);
		person.setGroupname("温柔组");
		person.setName("mayintao");
		person.setBirth("19891202");
		person.setPhone("12323");
		person.setJob("dfdf");
		person.setAddress("dfdfd");
		person.setSex("man");
		person.setBaptism(true);
		return person;
	}
}
