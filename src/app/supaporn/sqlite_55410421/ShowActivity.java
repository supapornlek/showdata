package app.supaporn.sqlite_55410421;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
//import app.supaporn.insertandshow.R;
import android.widget.ListView;
import android.widget.SimpleAdapter;
//import app.supaporn.insertandshow.MyDBclass;
//import app.supaporn.insertandshow.R;
//import app.supaporn.insertandshow.ShowActivity;

public class ShowActivity  extends Activity{//40
	private ListView listView;//44
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show);//41 สร้า ง activity ใหม่ต้องเพิ่ม manitiface ไปที่หน้า mydbclass
		listView =(ListView)findViewById(R.id.listView1);//45
		MyDBClass myDBclass =new MyDBClass(this);//46
		ArrayList<HashMap<String, String>> arrayList = myDBclass.SelectAllData();

		SimpleAdapter adapter;
		adapter = new SimpleAdapter(ShowActivity.this, arrayList,
				
				R.layout.show_item, new String[] {"MemberID", "Name", "Tel"},
				new int[] { R.id.ColMemberID, R.id.ColName, R.id.ColTel });
		listView.setAdapter(adapter);
	}
		
		



}
