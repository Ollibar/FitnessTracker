package android.example.com.fitnesstracker.Datenbank;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FitnessDbHelper extends SQLiteOpenHelper{

    public static final String DB_NAME="fitness.db";
    public static final int DB_Version = 1;

    // Strings für die Tabelle der Stationen

    public static final String STAT_TBL_NAME ="Station";
    public static final String STAT_ID ="stat_ID";
    public static final String STAT_Typ ="stat_Typ";
    public static final String STAT_SOLL_GESCHW ="stat_Soll_Geschw";
    public static final String STAT_SOLL_DAUER ="stat_Soll_Dauer";
    public static final String STAT_POS1 ="stat_Pos1";
    public static final String STAT_POS2 ="stat_Pos2";
    public static final String STAT_POS3 ="stat_Pos3";
    public static final String STAT_SOLL_GEWICHT ="stat_Soll_Gewicht";

    public static final String STAT_SQL_CREATE =
            "CREATE TABLE" + STAT_TBL_NAME + "(" +
                    STAT_ID + "integer primary key autoincrement, "+
                    STAT_Typ + "text not null, " +
                    STAT_SOLL_DAUER +"text, "+
                    STAT_SOLL_GESCHW +"text, "+
                    STAT_SOLL_GEWICHT +"text, "+
                    STAT_POS1 +"text, "+
                    STAT_POS2 +"text, "+
                    STAT_POS3 +"text); ";

    // Strings für die Tabelle der Trainings

    public static final String TRAIN_TBL_NAME = "Training";
    public static final String TRAIN_ID = "train_ID";
    public static final String TRAIN_DATUM = "train_Datum";
    public static final String TRAIN_KOMMENTAR = "train_Kommentar";


    public static final String TRAIN_SQL_CREATE =
            "CREATE TABLE" + TRAIN_TBL_NAME + "(" +
                    TRAIN_ID + "integer primary key autoincrement, "+
                    TRAIN_DATUM + "text not null, " +
                    TRAIN_KOMMENTAR +"text); ";

    // Strings für die Tabelle der Übungen

    public static final String UEBUNG_TBL_NAME = "Uebung";
    public static final String UEBUNG_ID = "ueb_ID";
    public static final String UEBUNG_STATION = "ueb_Station"; // Fremdschlüssel
    public static final String UEBUNG_DAUER = "ueb_Dauer";
    public static final String UEBUNG_GESCHW = "ueb_Geschw";
    public static final String UEBUNG_Kcal = "ueb_Kcal";

    public static final String UEBUNG_SQL_CREATE =
            "CREATE TABLE" + UEBUNG_TBL_NAME + "(" +
                    UEBUNG_ID + "integer primary key autoincrement, "+
                    UEBUNG_STATION + "integer ,FOREIGN KEY(" + UEBUNG_STATION + ") REFERENCES " + STAT_TBL_NAME + "(" + STAT_ID + ")," +
                    UEBUNG_DAUER +"text, " +
                    UEBUNG_GESCHW +"text," +
                    UEBUNG_Kcal +"text);";

    // Strings für die Tabelle Satz

    public static final String SATZ_TBL_NAME = "Satz";
    public static final String SATZ_ID="satz_ID";
    public static final String SATZ_UEBUNG="satz_UEBUNG"; //Fremdschlüssel
    public static final String SATZ_Nummer="satz_Nummer"; // Umbennen?!
    public static final String SATZ_GEWICHT="satz_Gewicht";
    public static final String SATZ_WIEDERHOLUNG="satz_Wiederholung";

    public static final String SATZ_SQL_CREATE =
            "create table"+ SATZ_TBL_NAME + " ( " +
                    SATZ_ID + "integer primary key autoincrement," +
                    SATZ_UEBUNG + "integer ,FOREIGN KEY(" + SATZ_UEBUNG + ") REFERENCES " + UEBUNG_TBL_NAME + "(" + UEBUNG_ID + ")," +
                    SATZ_Nummer + "text," +
                    SATZ_GEWICHT + "text," +
                    SATZ_WIEDERHOLUNG +"integer;";





    public FitnessDbHelper(Context context) {
        super(context, DB_NAME, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(STAT_SQL_CREATE);
            db.execSQL(TRAIN_SQL_CREATE);
            db.execSQL(UEBUNG_SQL_CREATE);
            db.execSQL(SATZ_SQL_CREATE);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            //Drop all tables in database
            db.execSQL("DROP TABLE IF EXISTS "+ STAT_TBL_NAME);
            db.execSQL("DROP TABLE IF EXISTS "+ TRAIN_TBL_NAME);
            db.execSQL("DROP TABLE IF EXISTS "+ UEBUNG_TBL_NAME);
            db.execSQL("DROP TABLE IF EXISTS "+ SATZ_TBL_NAME);

            //recreate the tables
            onCreate(db);

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
