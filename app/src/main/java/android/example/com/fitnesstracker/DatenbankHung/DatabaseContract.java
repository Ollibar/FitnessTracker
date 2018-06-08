package android.example.com.fitnesstracker.DatenbankHung;

import android.provider.BaseColumns;

public final class DatabaseContract {

    //nach --> https://developer.android.com/training/data-storage/sqlite#java <--
    //weil wir so viele Tabellen haben, denke ich es wäre cleaner die Tabellen so zu initialisieren



      private DatabaseContract(){}



    final String ENABLE_FOREIGN_KEYS ="PRAGMA foreign_keys=ON";//db.execSQL(ENABLE_FOREIGN_KEYS);

    //User_Tabelle
    public static abstract class Benutzer implements BaseColumns {
        public static final String TBL_NAME = "Benutzer_Tabelle";
        public static final String BENUTZERNAME = "Benutzername";
        public static final String GEWICHT = "Gewicht";
        public static final String ALTER = "_Alter";

        public static final String SQL_CREATE =
                "CREATE TABLE " + TBL_NAME + "(" +
                        BENUTZERNAME + " TEXT PRIMARY KEY, " +
                        GEWICHT + " INTEGER, " +
                        ALTER + " INTEGER);";


        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TBL_NAME;
    }

    //Training_Tabelle
    public static class Training implements BaseColumns {
        public static final String TBL_NAME = "Training_Tabelle";
        public static final String BENUTZERNAME = "Benutzername"; //FK
        public static final String GERAETE_ID = "Geräte_ID"; //FK
        public static final String BESCHREIBUNG = "Beschreibung";
        public static final String DATUM = "Datum";
        public static final String GESCHW = "Geschwindigkeit";
        public static final String DAUER = "Dauer";


        public static final String SQL_CREATE =
                " CREATE TABLE " + TBL_NAME + "(" +
                        Training._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        Training.BENUTZERNAME + " TEXT NOT NULL, "+
                        BESCHREIBUNG + " TEXT, " +
                        GERAETE_ID + " INTEGER NOT NULL, " +
                        GESCHW + " DOUBLE, " + //REAL
                        DAUER + " INTEGER, "+
                        DATUM + " TEXT DEFAULT (datetime('now')), "+
                        "FOREIGN KEY(" + Training.BENUTZERNAME + ") REFERENCES " +
                        Benutzer.TBL_NAME +"("+ Benutzer.BENUTZERNAME +") ON DELETE CASCADE ON UPDATE CASCADE, "
                        +"FOREIGN KEY(" + GERAETE_ID + ") REFERENCES " +
                        Geraet.TBL_NAME + "(" + Geraet._ID + ") ON DELETE NO ACTION ON UPDATE CASCADE);";


        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TBL_NAME;
    }

    //Trainingszieltabelle
    public static class Trainingsziel implements BaseColumns {
        public static final String TBL_NAME = "Trainingsziel_Tabelle";
        public static final String BENUTZERNAME= "Benutzer";//FK
        public static final String GERAET_ID = "Geräte_ID";//FK
        public static final String SOLL_GEWICHT = "Sollgewicht";
        public static final String SOLL_DAUER = "Solldauer_in_Min";
        public static final String SOLL_GESCHW = "Sollgeschwindigkeit_in_Km_H";
        public static final String POSITION_EINSTELLUNG= "Position_Einstellung";

        public static final String SQL_CREATE =
                "CREATE TABLE " + TBL_NAME + "("
                        + Trainingsziel._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + Trainingsziel.BENUTZERNAME + " TEXT NOT NULL, "
                        + Trainingsziel.GERAET_ID + " INTEGER NOT NULL, "
                        + SOLL_GEWICHT + " DOUBLE, " +
                        SOLL_DAUER + " INTEGER, " +
                        SOLL_GESCHW + " DOUBLE, "+
                        POSITION_EINSTELLUNG + " TEXT DEFAULT 'K.A.', "+
                        " FOREIGN KEY (" + Trainingsziel.BENUTZERNAME
                        + ")REFERENCES "+Benutzer.TBL_NAME +" ("+
                        Benutzer.BENUTZERNAME+ ") ON DELETE CASCADE ON UPDATE CASCADE,"+
                        " FOREIGN KEY("+Trainingsziel.GERAET_ID
                        + ") REFERENCES "+Geraet.TBL_NAME+ "("+ Geraet._ID+")"+
                        " ON DELETE CASCADE ON UPDATE CASCADE);";


        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TBL_NAME;
    }

    //Gerätetabelle
    public static class Geraet implements BaseColumns {
        public static final String TBL_NAME = "Gerät_Tabelle";
        public static final String NAME = "Gerät_Name";
        public static final String TYP = "Gerät_Typ";


        public static final String SQL_CREATE =
                "CREATE TABLE " + TBL_NAME + "(" +
                        Geraet._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        NAME + " TEXT NOT NULL, " +
                        TYP + " TEXT NOT NULL);";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TBL_NAME;


    }

    public static class Satz implements BaseColumns {

        public static final String TBL_NAME = "Satz";
        public static final String NR = "Satznummer";
        public static final String GEWICHT = "Satzgewicht";
        public static final String TRAINING_ID = "Gerät_ID";//FK

        public static final String SQL_CREATE =
                "CREATE TABLE " + TBL_NAME + " (" +
                        Satz._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        Satz.TRAINING_ID + " INTEGER,"+
                        NR + " INTEGER NOT NULL, " +
                        GEWICHT + " DOUBLE NOT NULL,"+
                        "FOREIGN KEY (" + Satz.TRAINING_ID +") REFERENCES " +
                        Training.TBL_NAME + " (" + Training._ID + ") ON DELETE CASCADE ON UPDATE CASCADE);";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TBL_NAME;

    }


    public static final String[] SQL_CREATE_TABLE_ARRAY = {
            Benutzer.SQL_CREATE,
            Training.SQL_CREATE,
            Geraet.SQL_CREATE,
            Trainingsziel.SQL_CREATE,
            Satz.SQL_CREATE
    };

    public  static final String[] SQL_DELETE_TABLE_ARRAY ={
            Benutzer.DELETE_TABLE,
            Training.DELETE_TABLE,
            Geraet.DELETE_TABLE,
            Trainingsziel.DELETE_TABLE,
            Satz.DELETE_TABLE
    };
}
