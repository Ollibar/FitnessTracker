package android.example.com.fitnesstracker.DatenbankBen;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.SQLException;

public class DBHelper extends SQLiteOpenHelper {

    //Constructor
    DBHelper(Context context) {
        super(context, database_name, null, databaseVersion);
    }

    private static final String database_name = "FitnessDB";
    private static final int databaseVersion = 1;


    //columns of the table Benutzer
    static final String table_user_name = "user";
    static final String COL_user_1 = "user_ID";
    static final String COL_user_2= "user_name";
    static final String COL_user_3 = "user_gewicht";
    static final String COL_user_4 = "user_alter";



    //SQL statement of the user table creation
    private static final String sqlCreateTableUser = "CREATE TABLE if not exists "+ table_user_name + " (" +
            COL_user_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_user_2 + " TEXT NOT NULL, " +
            COL_user_3 + " INTEGER , " +
            COL_user_4 + " INTEGER);";

    //columns of the table station
    static final String table_station_name = "station";
    static final String COL_station_1 = "station_ID";
    static final String COL_station_2= "station_name";
    static final String COL_station_3 = "station_typ";

    //SQL statement of the station table creation
    private static final String sqlCreateTableStation = "CREATE TABLE if not exists "+ table_station_name + " (" +
            COL_station_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_station_2 + " TEXT NOT NULL, "+
            COL_station_3 + " TEXT);";

    //columns of the table training
    static final String table_training_name = "training";
    static final String COL_training_1 = "training_ID";
    static final String COL_training_2=  "training_user_ID";
    static final String COL_training_3 = "training_station_ID";
    static final String COL_training_4 = "training_datum";
    static final String COL_training_5 = "training_beschreibung";
    static final String COL_training_6 = "training_dauer";
    static final String COL_training_7 = "training_geschwindigkeit";

    //SQL statement of the training table creation
    private static final String sqlCreateTableTraining = "CREATE TABLE if not exists "+ table_training_name + " (" +
            COL_training_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_training_2 + " INTEGER, "+
            COL_training_3 + " INTEGER, "+
            COL_training_4 + " DATE," +
            COL_training_5 + " TEXT," +
            COL_training_6 + " INTEGER," +
            COL_training_7 + " INTEGER," +
            "FOREIGN KEY ("+COL_training_2+")REFERENCES "+table_user_name+"("+COL_user_1+")," +
            "FOREIGN KEY ("+COL_training_3+")REFERENCES "+table_station_name+"("+COL_station_1+") );";

    //columns of the table satz
    static final String table_satz_name = "satz";
    static final String COL_satz_1 = "satz_ID";
    static final String COL_satz_2=  "satz_training_ID";
    static final String COL_satz_3 = "satz_nr";
    static final String COL_satz_4 = "satz_gewicht";
    static final String COL_satz_5 = "satz_wiederholung";


    //SQL statement of the satz table creation
    private static final String sqlCreateTableSatz = "CREATE TABLE if not exists "+ table_satz_name + " (" +
            COL_satz_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_satz_2 + " INTEGER, "+
            COL_satz_3 + " INTEGER, "+
            COL_satz_4 + " INTEGER," +
            COL_satz_5 + " INTEGER," +
            "FOREIGN KEY ("+COL_satz_2+")REFERENCES "+table_training_name+"("+COL_training_1+") );";

    //columns of the table ziel
    static final String table_ziel_name = "ziel";
    static final String COL_ziel_1 = "ziel_ID";
    static final String COL_ziel_2=  "ziel_user_ID";
    static final String COL_ziel_3 = "ziel_station_ID";
    static final String COL_ziel_4 = "ziel_gewicht";
    static final String COL_ziel_5 = "ziel_geschwindigkeit";
    static final String COL_ziel_6 = "ziel_dauer";
    static final String COL_ziel_7 = "ziel_pos1";
    static final String COL_ziel_8 = "ziel_pos2";
    static final String COL_ziel_9 = "ziel_pos3";

    //SQL statement of the ziel table creation
    private static final String sqlCreateTableZiel = "CREATE TABLE if not exists "+ table_ziel_name + " (" +
            COL_ziel_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_ziel_2 + " INTEGER, "+
            COL_ziel_3 + " INTEGER, "+
            COL_ziel_4 + " INTEGER," +
            COL_ziel_5 + " INTEGER," +
            COL_ziel_6 + " INTEGER," +
            COL_ziel_7 + " TEXT," +
            COL_ziel_8 + " TEXT," +
            COL_ziel_9 + " TEXT," +

            "FOREIGN KEY ("+COL_ziel_2+")REFERENCES "+table_user_name+"("+COL_user_1+")," +
            "FOREIGN KEY ("+COL_ziel_3+")REFERENCES "+table_station_name+"("+COL_station_1+") );";


    @Override
    public void onCreate(SQLiteDatabase db) {
        try
        {
            //execute the defined statements!
            db.execSQL(sqlCreateTableUser);
            db.execSQL(sqlCreateTableStation);
            db.execSQL(sqlCreateTableTraining);
            db.execSQL(sqlCreateTableSatz);
            db.execSQL(sqlCreateTableZiel);


        }catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        try{
            //Drop all tables in database
            db.execSQL("DROP TABLE IF EXISTS "+ table_user_name);
            db.execSQL("DROP TABLE IF EXISTS "+ table_training_name);
            db.execSQL("DROP TABLE IF EXISTS "+ table_station_name);
            db.execSQL("DROP TABLE IF EXISTS "+ table_satz_name);
            db.execSQL("DROP TABLE IF EXISTS "+ table_ziel_name);

            //recreate the tables
            onCreate(db);

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
