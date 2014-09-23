package app.supaporn.sqlite_55410421;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
////import app.supaporn.insertandshow.MainActivity;
//port app.supaporn.insertandshow.AddActivity;
//port app.supaporn.insertandshow.MainActivity;
//import app.supaporn.insertandshow.R;
//import app.supaporn.insertandshow.ShowActivity;


public class MainActivity extends Activity {
	private Button btn_insert, btn_show;//14

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn_show= (Button) findViewById(R.id.btn_show);//35
		//MyDBClass  myDBclass = new MyDBClass(this); //8     ///ปิดรอบ 2
	  // myDBclass.getWritableDatabase();//9 รันเเล้วจะเเสดงหน้าเปล่ามา เเล้วโยนไฟล์ sql ออกมา
	   //10 สร้างไป xml file ที่layout ชื่อ add
	   //11 ดึง btn หน้า activity_main id btn_insert
	   //12 เปลี่ยนหน้า add ให้เปน rela
	   //13 เอา paimtext ไปวาง ที่add 2 อัน
	   //////////////////////////////////////////////////////////////////////////////////
		btn_insert = (Button) findViewById(R.id.btn_insert); //14
		btn_insert.setOnClickListener(new OnClickListener() { //15
		

			@Override
			public void onClick(View v) { //16
				// TODO Auto-generated method stub
				if (v == btn_insert) {//17
					Intent add = new Intent(MainActivity.this,
							AddActivity.class);
					startActivity(add);

			}

			}
	});


	btn_show.setOnClickListener(new OnClickListener() {//36

		@Override
		public void onClick(View v) {//37
			// TODO Auto-generated method stub
			if (v == btn_show) {//38
				Intent show = new Intent(MainActivity.this,//39
						ShowActivity.class);
				startActivity(show);//ไปทำหน้า show activity

			

		}

		}
});
}
}



