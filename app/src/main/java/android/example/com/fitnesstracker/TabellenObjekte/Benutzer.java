package android.example.com.fitnesstracker.TabellenObjekte;

public class User {


    private String benutzername;
    private int alter;
    private double gewicht;



    public User(String benutzername,int alter, double gewicht){
        this.alter=alter;
        this.gewicht=gewicht;
        this.benutzername=benutzername;
    }


    public String getName() {
        return benutzername;
    }

    public void setName(String name) {
        this.benutzername=name;
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


    @Override
    public String toString() {
        String s = "-> Benutzername: "+ benutzername+" Gewicht: "+gewicht+" Alter: "+
                alter;
        return s;
    }
}
