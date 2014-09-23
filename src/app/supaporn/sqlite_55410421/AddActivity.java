package app.supaporn.sqlite_55410421;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
//import app.supaporn.insertandshow.R;
//import app.supaporn.insertandshow.R;
import android.widget.EditText;
//import app.supaporn.insertandshow.MyDBclass;
//import app.supaporn.insertandshow.R;

public class AddActivity extends Activity {// 18
	private Button btn_add;// 26
	private EditText edt_name, edt_tel;//31

	protected void onCreate(Bundle savedInstanceState) {//19
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add);//19 add miniface
		btn_add = (Button) findViewById(R.id.btn_add);//27
		btn_add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				saveData();//29
			
			
			}//28

			
		
	});
		
}
	private void saveData() {//30
		// TODO Auto-generated method stub
		edt_name = (EditText) findViewById(R.id.txt_name);//32
		edt_tel = (EditText) findViewById(R.id.txt_tel);
		MyDBClass myDBClass = new MyDBClass(this);
		long  saveStatus = myDBClass.InsertData(edt_name.getText().toString(),edt_tel.getText().toString());  
		if(saveStatus <=0)	{
		Log.d("Error save","Error!");
			
	}
		Toast.makeText(getApplicationContext(),"Add Data Successfully", Toast.LENGTH_SHORT).show();//33
		//34ให้เพิ่มปุ่ม show ที่activitymain เเล้วเพิ่ม show.xml  ใส่ listview
}
}
