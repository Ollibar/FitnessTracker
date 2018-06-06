package android.example.com.fitnesstracker.Datenbank;

public class ModelSatz {


	private int satz_Wiederholung;
	private int satz_id;
	private int satz_Nummer;
	private double satz_Gewicht;

	public ModelSatz(int satz_Wiederholung,int satz_id,int satz_Nummer,double satz_Gewicht) {
		this.satz_Wiederholung = satz_Wiederholung;
		this.satz_id = satz_id;
		this.satz_Nummer = satz_Nummer;
		this.satz_Gewicht = satz_Gewicht;
	}
	public void setSatz_wiederholung(int satz_Wiederholung) {
		this.satz_Wiederholung = satz_Wiederholung;
	}
	public int getSatz_wiederholung() {
		return this.satz_Wiederholung;
	}
	public void setSatz_id(int satz_id) {
		this.satz_id = satz_id;
	}
	public int getSatz_id() {
		return this.satz_id;
	}
	public void setSatz_nummer(int satz_Nummer) {
		this.satz_Nummer = satz_Nummer;
	}
	public int getSatz_nummer() {
		return this.satz_Nummer;
	}
	public void setSatz_gewicht(double satz_Gewicht) {
		this.satz_Gewicht = satz_Gewicht;
	}
	public double getSatz_gewicht() {
		return this.satz_Gewicht;
	}
}
