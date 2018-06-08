package android.example.com.fitnesstracker.DatenbankHung;

public class User {


    private String Benutzername;
    private int alter;
    private double gewicht;



    public User(String benutzername,int alter, double gewicht){
        this.alter=alter;
        this.gewicht=gewicht;
        this.Benutzername=benutzername;
    }


    public String getName() {
        return Benutzername;
    }

    public void setName(String name) {
        this.Benutzername=name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public double getGewicht() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }




}
