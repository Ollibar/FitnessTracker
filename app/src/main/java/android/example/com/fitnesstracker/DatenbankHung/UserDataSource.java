package android.example.com.fitnesstracker.DatenbankHung;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class UserDataSource {

    private static final String LOG = UserDataSource.class.getSimpleName();

    private SQLiteDatabase database;
    private FitnessDbHelper dbHelper;


    public UserDataSource(Context context){
        Log.d(LOG,"Unsere DataSource erzeugt jetzt den dbHelper. ");
        dbHelper = new FitnessDbHelper(context);
    }
    public void open() {
        Log.d(LOG, "Eine Referenz auf die Datenbank wird jetzt angefragt.");
        database = dbHelper.getWritableDatabase();
        Log.d(LOG, "Datenbank-Referenz erhalten. Pfad zur Datenbank: " + database.getPath());
    }

    public void close() {
        dbHelper.close();
        Log.d(LOG, "Datenbank mit Hilfe des DbHelpers geschlossen.");
    }



}
