package dcom3b.test_db_android_env;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by u on 2/6/2017.
 */
public class OperationsDb {

    SQLiteDatabase db;

    public OperationsDb(SQLiteDatabase db){
        this.db=db;
    }

    public void Insert(String table, String note){
        ContentValues cv = new ContentValues();
        cv.put("Note",note);
        db.insert(table,null,cv);
    }

    public String GetAll(String table){
        Cursor result = db.rawQuery("Select * From " + table,null);
        return result.toString();
    }
}
