package android.example.com.fitnesstracker.DatenbankHung;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

public class FitnessDbHelper extends SQLiteOpenHelper {


    //von : https://developer.android.com/training/data-storage/sqlite#java

    public static final String LOG = FitnessDbHelper.class.getSimpleName();
    public static final int DB_VERSION = 1;
    public static final String DB_NAME= "FitnessDB.db";



    public FitnessDbHelper(Context context) {
        super(context, DB_NAME , null, DB_VERSION);
        Log.d(LOG,"FitnessDBHelper hat die Datenbank: "+ getDatabaseName()+" erzeugt.");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try{
            db.execSQL(String.valueOf(DatabaseContract.SQL_CREATE_TABLE_ARRAY));
        }catch(Exception e){
            Log.d(LOG,"Fehler beim Anlegen der Tabllen: "+e.getStackTrace()+
                    "/n"+e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

       db.execSQL(String.valueOf(DatabaseContract.SQL_DELETE_TABLE_ARRAY));
       onCreate(db);

    }
}
