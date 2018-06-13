package android.example.com.fitnesstracker.DatenbankBen;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class DBAdapter {

   public String table1 = "user";

    private DBHelper helper;
    private SQLiteDatabase db;
    public DBAdapter(Context c){
        helper = new DBHelper(c);
    }

    /*--------------------------------Insert data into table ---------------------------------------------------------*/

    //insert Data into table User

    public boolean insertUser(String name, Integer gewicht, Integer alter){

        try{
            db = helper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();

            contentValues.put(DBHelper.COL_user_2,name);
            contentValues.put(DBHelper.COL_user_3,gewicht);
            contentValues.put(DBHelper.COL_user_4,alter);


            long result = db.insert(table1,null, contentValues);
            if (result > 0) {
                return true;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            helper.close();
        }
        return false;
    }


}
