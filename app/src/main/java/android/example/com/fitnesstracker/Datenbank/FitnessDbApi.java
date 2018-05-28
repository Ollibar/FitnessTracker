package android.example.com.fitnesstracker.Datenbank;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class FitnessDbApi {
    private SQLiteDatabase db;
    public FitnessDbApi (Context c) {
        FitnessDbHelper helper = new FitnessDbHelper(c);
    }



}
