package dcom3b.test_db_android_env;
import android.database.sqlite.SQLiteDatabase;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

/**
 * Created by Joshua Nuttall on 2/6/2017.
 * Creates the DataBase system
 */
public class SetupDb {

    SQLiteDatabase db;

    public SetupDb(){
       // try{
        db = Create();
        Tables();
        //}catch(Exception e){
        //    System.out.println(e);
        //}

    }

    public SQLiteDatabase GetDB(){
        return db;
    }

    private SQLiteDatabase Create(){
        SQLiteDatabase db = openOrCreateDatabase("TestDB",null);
        return db;
    }

    private void Tables(){
        db.execSQL("CREATE TABLE IF NOT EXISTS Notes(Note VARCHAR);");
    }
}
