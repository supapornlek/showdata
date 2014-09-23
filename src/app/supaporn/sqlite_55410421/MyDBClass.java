package app.supaporn.sqlite_55410421;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBClass extends SQLiteOpenHelper {//1
	private static final int DATABASE_VERSION = 1; //3
	private static final String DATABASE_NAME = "supaporn";
	private static final String TABLE_MEMBER = "member";

	public MyDBClass(Context context) {//2
		super(context, DATABASE_NAME, null, DATABASE_VERSION);//4
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub      //5
		db.execSQL("CREATE TABLE " + TABLE_MEMBER
				+ "(MemberID INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "Name TEXT (100)," + "Tel TEXT (100));");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE  IF EXIT" + TABLE_MEMBER); //6
		onCreate(db);//7
		//ลำดับต่อไปไปที่หน้า mainactivity
	///////////////////////////////////////////////////////////////////////////////////////////////////////////	
	}
	///////////insert////////////////
	public long InsertData(String strname, String strTel) {//18
		try {//19
			SQLiteDatabase db;   //22
			db = this.getWritableDatabase();
			
			ContentValues values = new ContentValues();
			
			values.put("Name", strname);//23
			values.put("Tel", strTel);
			
			long rows = db.insert(TABLE_MEMBER, null, values);//24
			db.close();
			return rows;
			
			
		} catch (Exception e) {//20
			return -1;	//25
		}
		//return 0;//21
		}
////////////////////////////////select all data//////////////////////////////
	public ArrayList<HashMap<String, String>> SelectAllData() {//43 เเล้วไปที่หน้า showactivity //เเล้วสร้าง show_item
		try {
			ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> map;
			SQLiteDatabase db;
			db = this.getReadableDatabase();

			String strSQL = "SELECT * FROM " + TABLE_MEMBER ;
			Cursor cursor = db.rawQuery(strSQL, null);
			if (cursor != null) {
				if (cursor.moveToFirst()) {
					do {
						map = new HashMap<String, String>();
						map.put("MemberID", cursor.getString(0));
						map.put("Name", cursor.getString(1));
						map.put("Tel", cursor.getString(2));
						arrayList.add(map);
					} while (cursor.moveToNext());
				}

			}
			cursor.close();
			db.close();
			return arrayList;
			
		} catch (Exception e) {
			return null;
		}
	}
	
}
