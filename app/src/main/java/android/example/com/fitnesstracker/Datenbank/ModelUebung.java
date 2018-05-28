package android.example.com.fitnesstracker.Datenbank;

public class ModelUebung {
	double ueb_Geschw;
	double ueb_Gewicht;
	int ueb_id;
	int ueb_Training;
	int ueb_Station;
	double ueb_Dauer;


	public ModelUebung(double ueb_Geschw,double ueb_Gewicht,int ueb_id,int ueb_Training,int ueb_Station,double ueb_Dauer) {
		this.ueb_Geschw = ueb_Geschw;
		this.ueb_Gewicht = ueb_Gewicht;
		this.ueb_id = ueb_id;
		this.ueb_Training = ueb_Training;
		this.ueb_Station = ueb_Station;
		this.ueb_Dauer = ueb_Dauer;
	}
	public void setUeb_geschw(double ueb_Geschw) {
		this.ueb_Geschw = ueb_Geschw;
	}
	public double getUeb_geschw() {
		return this.ueb_Geschw;
	}
	public void setUeb_gewicht(double ueb_Gewicht) {
		this.ueb_Gewicht = ueb_Gewicht;
	}
	public double getUeb_gewicht() {
		return this.ueb_Gewicht;
	}
	public void setUeb_id(int ueb_id) {
		this.ueb_id = ueb_id;
	}
	public int getUeb_id() {
		return this.ueb_id;
	}
	public void setUeb_training(int ueb_Training) {
		this.ueb_Training = ueb_Training;
	}
	public int getUeb_training() {
		return this.ueb_Training;
	}
	public void setUeb_station(int ueb_Station) {
		this.ueb_Station = ueb_Station;
	}
	public int getUeb_station() {
		return this.ueb_Station;
	}
	public void setUeb_dauer(double ueb_Dauer) {
		this.ueb_Dauer = ueb_Dauer;
	}
	public double getUeb_dauer() {
		return this.ueb_Dauer;
	}
}
