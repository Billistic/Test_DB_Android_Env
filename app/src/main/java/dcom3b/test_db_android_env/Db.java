package dcom3b.test_db_android_env;
import java.util.ArrayList;
import java.util.List;
import android.content.*;
import android.database.Cursor;
import android.database.sqlite.*;

public class Db extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	 
    public Db(Context context) {
        super(context, "todo", null, DATABASE_VERSION);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
				"CREATE TABLE list"
						+ "("
						+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
						+ "note TEXT"
						+ ");"
		);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS list;");
        db.execSQL("DROP TABLE IF EXISTS items;");
	    onCreate(db);
	}

	public long add(String note) throws Exception {
		long id;
	    SQLiteDatabase db = this.getWritableDatabase();
	    ContentValues values = new ContentValues();
    	values.put("note", note);
	    id = db.insert("list", null, values);
		return id;
	}

	public List<String> getList() {
		List<String> list = new ArrayList<String>();
		SQLiteDatabase db = this.getReadableDatabase();
		String query = "SELECT id, note FROM list";
		Cursor c = db.rawQuery(query, null);
		if (c.moveToFirst()) {
			do {
				list.add(c.getString(0));
			} while (c.moveToNext());
		}
		c.close();
		return list;
	}

}