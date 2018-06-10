package android.example.com.fitnesstracker.DatenbankHung;

import android.content.ContentValues;
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

        String [] SQL_CREATE_QUERIES = DatabaseContract.SQL_CREATE_TABLE_ARRAY;
        try{
            for(int i = 0;i<SQL_CREATE_QUERIES.length;i++) {
                Log.d(LOG, "Die Tabellen mit den Anweisungen " + SQL_CREATE_QUERIES[i]
                        + " werden erzeugt.");
                db.execSQL(SQL_CREATE_QUERIES[i]);
            }
        }catch(Exception e){
            for (int i =0;i<SQL_CREATE_QUERIES.length;i++) {
                Log.d(LOG, "Fehler beim Anlegen der Tabellen: "+SQL_CREATE_QUERIES[i]
                        + e.getStackTrace() +
                        "  " + e.getMessage());
            }
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

       db.execSQL(String.valueOf(DatabaseContract.SQL_DELETE_TABLE_ARRAY));
       onCreate(db);

    }
    public boolean insertUser(String benutzername, int gewicht, int alter){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("User_Benutzername",benutzername);
        contentValues.put("User_Gewicht",gewicht);
        contentValues.put("User_Alter",alter);
        long result = db.insert("User_Tabelle",null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
}
