package android.example.com.fitnesstracker.Datenbank;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String LOG_TAG = DatabaseHelper.class.getName();
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "FitnessDB";




	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	private static final String CREATE_TABLE_TRAINING = "CREATE TABLE training (" + 
	"train_id INTEGER PRIMARY KEY," + 
	"train_date DATE	" + 
	")";

	private static final String CREATE_TABLE_STATION = "CREATE TABLE station (" + 
	"stat_Soll_Dauer DATETIME," + 
	"stat_Soll_Gewicht DECIMAL," + 
	"stat_Pos1 VARCHAR," + 
	"stat_Pos2 VARCHAR," + 
	"stat_Pos3 VARCHAR," + 
	"stat_id INTEGER PRIMARY KEY," + 
	"stat_typ VARCHAR(50)," + 
	"stat_Beschreibung VARCHAR(50)," + 
	"stat_Soll_Geschw DECIMAL	" + 
	")";

	private static final String CREATE_TABLE_UEBUNG = "CREATE TABLE uebung (" + 
	"ueb_Geschw DECIMAL," + 
	"ueb_Gewicht DECIMAL," + 
	"ueb_id INTEGER PRIMARY KEY," + 
	"ueb_Training INTEGER," + 
	"ueb_Station INTEGER," + 
	"ueb_Dauer DECIMAL	" + 
	")";

	private static final String CREATE_TABLE_SATZ = "CREATE TABLE satz (" + 
	"satz_Wiederholung INTEGER," + 
	"satz_id INTEGER PRIMARY KEY," + 
	"satz_Nummer INTEGER," + 
	"satz_Gewicht DECIMAL	" + 
	")";


	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_TRAINING);
		db.execSQL(CREATE_TABLE_STATION);
		db.execSQL(CREATE_TABLE_UEBUNG);
		db.execSQL(CREATE_TABLE_SATZ);
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS training");
		db.execSQL("DROP TABLE IF EXISTS station");
		db.execSQL("DROP TABLE IF EXISTS uebung");
		db.execSQL("DROP TABLE IF EXISTS satz");
		onCreate(db);
	}


	public void clear(SQLiteDatabase db) {
		db.execSQL("DELETE FROM training");
		db.execSQL("DELETE FROM station");
		db.execSQL("DELETE FROM uebung");
		db.execSQL("DELETE FROM satz");
	}


	public void closeDB() {
		SQLiteDatabase db = this.getReadableDatabase();
		if (db != null && db.isOpen()) db.close();
	}

	private String getDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		Date date = new Date();
		return dateFormat.format(date);
	}

	public long createTraining(ModelTraining training) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(train_id, training.getTrain_id());
		values.put(train_date, training.getTrain_date());
		return db.insertOrThrow(training, null, values);
	}

	public int updateTraining(ModelTraining training) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(train_id, training.getTrain_id());
		values.put(train_date, training.getTrain_date());
		return db.update(training, values, "train_id = ?", new String[] {String.valueOf(training.getTrain_id())});
	}

	public int deleteTraining(ModelTraining training) {
		SQLiteDatabase db = this.getWritableDatabase();
		return db.delete(training, "train_id = ?", new String[] {String.valueOf(training.getTrain_id())});
	}

	protected ModelTraining getModelTrainingFromCursor(Cursor c){
		ModelTraining training = new ModelTraining();
		training.setTrain_id(c.getInt(c.getColumnIndex("train_id")));
		training.setTrain_date(c.getDate(c.getColumnIndex("train_date")));
		return training;
	}

	public ModelTraining getTraining(long id) {
		SQLiteDatabase db = this.getReadableDatabase();
		String selectQuery = "SELECT * FROM training Where train_id =  ?";
		Cursor c = db.rawQuery(selectQuery, new String[] { String.valueOf(id) });
		if (c != null) c.moveToFirst();
		return getModelTrainingFromCursor(c);
	}

	public ArrayList<ModelTraining> getAllTraining() {
		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<ModelTraining> trainingList = new ArrayList<ModelTraining>();
		String selectQuery = "SELECT * FROM training";
		Cursor c = db.rawQuery(selectQuery, null);
		if (c.moveToFirst()) {
			do {
				ModelTraining training = getModelTrainingFromCursor(c);
				trainingList.add(training);
			} while (c.moveToNext());
		}
		return trainingList;
	}

	public int getTrainingCount() {
		String countQuery = "SELECT * FROM training";
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		int count = cursor.getCount();
		cursor.close();
		return count;
	}

	public long createStation(ModelStation station) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(stat_Soll_Dauer, station.getStat_soll_dauer());
		values.put(stat_Soll_Gewicht, station.getStat_soll_gewicht());
		values.put(stat_Pos1, station.getStat_pos1());
		values.put(stat_Pos2, station.getStat_pos2());
		values.put(stat_Pos3, station.getStat_pos3());
		values.put(stat_id, station.getStat_id());
		values.put(stat_typ, station.getStat_typ());
		values.put(stat_Beschreibung, station.getStat_beschreibung());
		values.put(stat_Soll_Geschw, station.getStat_soll_geschw());
		return db.insertOrThrow(station, null, values);
	}

	public int updateStation(ModelStation station) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(stat_Soll_Dauer, station.getStat_soll_dauer());
		values.put(stat_Soll_Gewicht, station.getStat_soll_gewicht());
		values.put(stat_Pos1, station.getStat_pos1());
		values.put(stat_Pos2, station.getStat_pos2());
		values.put(stat_Pos3, station.getStat_pos3());
		values.put(stat_id, station.getStat_id());
		values.put(stat_typ, station.getStat_typ());
		values.put(stat_Beschreibung, station.getStat_beschreibung());
		values.put(stat_Soll_Geschw, station.getStat_soll_geschw());
		return db.update(station, values, "stat_id = ?", new String[] {String.valueOf(station.getStat_id())});
	}

	public int deleteStation(ModelStation station) {
		SQLiteDatabase db = this.getWritableDatabase();
		return db.delete(station, "stat_id = ?", new String[] {String.valueOf(station.getStat_id())});
	}

	protected ModelStation getModelStationFromCursor(Cursor c){
		ModelStation station = new ModelStation();
		station.setStat_soll_dauer(c.getDate(c.getColumnIndex("stat_Soll_Dauer")));
		station.setStat_soll_gewicht(c.getDouble(c.getColumnIndex("stat_Soll_Gewicht")));
		station.setStat_pos1(c.getString(c.getColumnIndex("stat_Pos1")));
		station.setStat_pos2(c.getString(c.getColumnIndex("stat_Pos2")));
		station.setStat_pos3(c.getString(c.getColumnIndex("stat_Pos3")));
		station.setStat_id(c.getInt(c.getColumnIndex("stat_id")));
		station.setStat_typ(c.getString(c.getColumnIndex("stat_typ")));
		station.setStat_beschreibung(c.getString(c.getColumnIndex("stat_Beschreibung")));
		station.setStat_soll_geschw(c.getDouble(c.getColumnIndex("stat_Soll_Geschw")));
		return station;
	}

	public ModelStation getStation(long id) {
		SQLiteDatabase db = this.getReadableDatabase();
		String selectQuery = "SELECT * FROM station Where stat_id =  ?";
		Cursor c = db.rawQuery(selectQuery, new String[] { String.valueOf(id) });
		if (c != null) c.moveToFirst();
		return getModelStationFromCursor(c);
	}

	public ArrayList<ModelStation> getAllStation() {
		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<ModelStation> stationList = new ArrayList<ModelStation>();
		String selectQuery = "SELECT * FROM station";
		Cursor c = db.rawQuery(selectQuery, null);
		if (c.moveToFirst()) {
			do {
				ModelStation station = getModelStationFromCursor(c);
				stationList.add(station);
			} while (c.moveToNext());
		}
		return stationList;
	}

	public int getStationCount() {
		String countQuery = "SELECT * FROM station";
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		int count = cursor.getCount();
		cursor.close();
		return count;
	}

	public long createUebung(ModelUebung uebung) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(ueb_Geschw, uebung.getUeb_geschw());
		values.put(ueb_Gewicht, uebung.getUeb_gewicht());
		values.put(ueb_id, uebung.getUeb_id());
		values.put(ueb_Training, uebung.getUeb_training());
		values.put(ueb_Station, uebung.getUeb_station());
		values.put(ueb_Dauer, uebung.getUeb_dauer());
		return db.insertOrThrow(String.valueOf(uebung), null, values);
	}

	public int updateUebung(ModelUebung uebung) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(ueb_Geschw, uebung.getUeb_geschw());
		values.put(ueb_Gewicht, uebung.getUeb_gewicht());
		values.put(ueb_id, uebung.getUeb_id());
		values.put(ueb_Training, uebung.getUeb_training());
		values.put(ueb_Station, uebung.getUeb_station());
		values.put(ueb_Dauer, uebung.getUeb_dauer());
		return db.update(uebung, values, "ueb_id = ?", new String[] {String.valueOf(uebung.getUeb_id())});
	}

	public int deleteUebung(ModelUebung uebung) {
		SQLiteDatabase db = this.getWritableDatabase();
		return db.delete(uebung, "ueb_id = ?", new String[] {String.valueOf(uebung.getUeb_id())});
	}

	protected ModelUebung getModelUebungFromCursor(Cursor c){
		ModelUebung uebung = new ModelUebung();
		uebung.setUeb_geschw(c.getDouble(c.getColumnIndex("ueb_Geschw")));
		uebung.setUeb_gewicht(c.getDouble(c.getColumnIndex("ueb_Gewicht")));
		uebung.setUeb_id(c.getInt(c.getColumnIndex("ueb_id")));
		uebung.setUeb_training(c.getInt(c.getColumnIndex("ueb_Training")));
		uebung.setUeb_station(c.getInt(c.getColumnIndex("ueb_Station")));
		uebung.setUeb_dauer(c.getDouble(c.getColumnIndex("ueb_Dauer")));
		return uebung;
	}

	public ModelUebung getUebung(long id) {
		SQLiteDatabase db = this.getReadableDatabase();
		String selectQuery = "SELECT * FROM uebung Where ueb_id =  ?";
		Cursor c = db.rawQuery(selectQuery, new String[] { String.valueOf(id) });
		if (c != null) c.moveToFirst();
		return getModelUebungFromCursor(c);
	}

	public ArrayList<ModelUebung> getAllUebung() {
		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<ModelUebung> uebungList = new ArrayList<ModelUebung>();
		String selectQuery = "SELECT * FROM uebung";
		Cursor c = db.rawQuery(selectQuery, null);
		if (c.moveToFirst()) {
			do {
				ModelUebung uebung = getModelUebungFromCursor(c);
				uebungList.add(uebung);
			} while (c.moveToNext());
		}
		return uebungList;
	}

	public int getUebungCount() {
		String countQuery = "SELECT * FROM uebung";
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		int count = cursor.getCount();
		cursor.close();
		return count;
	}

	public long createSatz(ModelSatz satz) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(satz_Wiederholung, satz.getSatz_wiederholung());
		values.put(satz_id, satz.getSatz_id());
		values.put(satz_Nummer, satz.getSatz_nummer());
		values.put(satz_Gewicht, satz.getSatz_gewicht());
		return db.insertOrThrow(satz, null, values);
	}

	public int updateSatz(ModelSatz satz) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(satz_Wiederholung, satz.getSatz_wiederholung());
		values.put(satz_id, satz.getSatz_id());
		values.put(satz_Nummer, satz.getSatz_nummer());
		values.put(satz_Gewicht, satz.getSatz_gewicht());
		return db.update(satz, values, "satz_id = ?", new String[] {String.valueOf(satz.getSatz_id())});
	}

	public int deleteSatz(ModelSatz satz) {
		SQLiteDatabase db = this.getWritableDatabase();
		return db.delete(satz, "satz_id = ?", new String[] {String.valueOf(satz.getSatz_id())});
	}

	protected ModelSatz getModelSatzFromCursor(Cursor c){
		ModelSatz satz = new ModelSatz();
		satz.setSatz_wiederholung(c.getInt(c.getColumnIndex("satz_Wiederholung")));
		satz.setSatz_id(c.getInt(c.getColumnIndex("satz_id")));
		satz.setSatz_nummer(c.getInt(c.getColumnIndex("satz_Nummer")));
		satz.setSatz_gewicht(c.getDouble(c.getColumnIndex("satz_Gewicht")));
		return satz;
	}

	public ModelSatz getSatz(long id) {
		SQLiteDatabase db = this.getReadableDatabase();
		String selectQuery = "SELECT * FROM satz Where satz_id =  ?";
		Cursor c = db.rawQuery(selectQuery, new String[] { String.valueOf(id) });
		if (c != null) c.moveToFirst();
		return getModelSatzFromCursor(c);
	}

	public ArrayList<ModelSatz> getAllSatz() {
		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<ModelSatz> satzList = new ArrayList<ModelSatz>();
		String selectQuery = "SELECT * FROM satz";
		Cursor c = db.rawQuery(selectQuery, null);
		if (c.moveToFirst()) {
			do {
				ModelSatz satz = getModelSatzFromCursor(c);
				satzList.add(satz);
			} while (c.moveToNext());
		}
		return satzList;
	}

	public int getSatzCount() {
		String countQuery = "SELECT * FROM satz";
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		int count = cursor.getCount();
		cursor.close();
		return count;
	}

}