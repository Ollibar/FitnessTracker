package android.example.com.fitnesstracker.Datenbank;

import java.util.Date;

public class ModelTraining {
	int train_id;
	Date train_date;


	public ModelTraining(int train_id,Date train_date) {
		this.train_id = train_id;
		this.train_date = train_date;
	}
	public void setTrain_id(int train_id) {
		this.train_id = train_id;
	}
	public int getTrain_id() {
		return this.train_id;
	}
	public void setTrain_date(Date train_date) {
		this.train_date = train_date;
	}
	public Date getTrain_date() {
		return this.train_date;
	}
}
