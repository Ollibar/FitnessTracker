package android.example.com.fitnesstracker.Datenbank;

import java.util.Date;

public class ModelStation {
	Date stat_Soll_Dauer;
	double stat_Soll_Gewicht;
	String stat_Pos1;
	String stat_Pos2;
	String stat_Pos3;
	int stat_id;
	String stat_typ;
	String stat_Beschreibung;
	double stat_Soll_Geschw;


	public ModelStation(Date stat_Soll_Dauer,double stat_Soll_Gewicht,String stat_Pos1,String stat_Pos2,String stat_Pos3,int stat_id,String stat_typ,String stat_Beschreibung,double stat_Soll_Geschw) {
		this.stat_Soll_Dauer = stat_Soll_Dauer;
		this.stat_Soll_Gewicht = stat_Soll_Gewicht;
		this.stat_Pos1 = stat_Pos1;
		this.stat_Pos2 = stat_Pos2;
		this.stat_Pos3 = stat_Pos3;
		this.stat_id = stat_id;
		this.stat_typ = stat_typ;
		this.stat_Beschreibung = stat_Beschreibung;
		this.stat_Soll_Geschw = stat_Soll_Geschw;
	}
	public void setStat_soll_dauer(Date stat_Soll_Dauer) {
		this.stat_Soll_Dauer = stat_Soll_Dauer;
	}
	public Date getStat_soll_dauer() {
		return this.stat_Soll_Dauer;
	}
	public void setStat_soll_gewicht(double stat_Soll_Gewicht) {
		this.stat_Soll_Gewicht = stat_Soll_Gewicht;
	}
	public double getStat_soll_gewicht() {
		return this.stat_Soll_Gewicht;
	}
	public void setStat_pos1(String stat_Pos1) {
		this.stat_Pos1 = stat_Pos1;
	}
	public String getStat_pos1() {
		return this.stat_Pos1;
	}
	public void setStat_pos2(String stat_Pos2) {
		this.stat_Pos2 = stat_Pos2;
	}
	public String getStat_pos2() {
		return this.stat_Pos2;
	}
	public void setStat_pos3(String stat_Pos3) {
		this.stat_Pos3 = stat_Pos3;
	}
	public String getStat_pos3() {
		return this.stat_Pos3;
	}
	public void setStat_id(int stat_id) {
		this.stat_id = stat_id;
	}
	public int getStat_id() {
		return this.stat_id;
	}
	public void setStat_typ(String stat_typ) {
		this.stat_typ = stat_typ;
	}
	public String getStat_typ() {
		return this.stat_typ;
	}
	public void setStat_beschreibung(String stat_Beschreibung) {
		this.stat_Beschreibung = stat_Beschreibung;
	}
	public String getStat_beschreibung() {
		return this.stat_Beschreibung;
	}
	public void setStat_soll_geschw(double stat_Soll_Geschw) {
		this.stat_Soll_Geschw = stat_Soll_Geschw;
	}
	public double getStat_soll_geschw() {
		return this.stat_Soll_Geschw;
	}
}
