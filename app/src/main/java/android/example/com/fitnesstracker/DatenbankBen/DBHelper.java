package android.example.com.fitnesstracker.DatenbankBen;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.SQLException;

/**
 * Created as a part of the bachelor thesis
 * by Chantal Bothe on 10.11.2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    //Constructor
    DBHelper(Context context) {
        super(context, database_name, null, databaseVersion);
    }

    private static final String database_name = "FitnessDB";
    private static final int databaseVersion = 1;


    //columns of the table User
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

    //columns of the table training
    static final String table_user_name = "user";
    static final String COL_user_1 = "user_ID";
    static final String COL_user_2= "user_name";
    static final String COL_user_3 = "user_gewicht";
    static final String COL_user_4 = "user_alter";


    @Override
    public void onCreate(SQLiteDatabase db) {
        try
        {
            //execute the defined statements!
            db.execSQL(sqlCreateTableUser);

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        try{
            //Drop all tables in database
            db.execSQL("DROP TABLE IF EXISTS "+ table_name);

            //recreate the tables
            onCreate(db);

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
