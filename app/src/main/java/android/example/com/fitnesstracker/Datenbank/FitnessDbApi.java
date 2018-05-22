package android.example.com.fitnesstracker.Datenbank;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class FitnessDbApi {
    private FitnessDbHelper helper;
    private SQLiteDatabase db;
    public FitnessDbApi (Context c) { helper = new FitnessDbHelper(c); }



}
