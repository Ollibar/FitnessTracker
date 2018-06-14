package android.example.com.fitnesstracker;



import android.example.com.fitnesstracker.DatenbankHung.BenutzerData;
import android.example.com.fitnesstracker.TabellenObjekte.Benutzer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {


    private static final String LOG = MainActivity.class.getSimpleName();
    private BenutzerData benutzerData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        benutzerData = new BenutzerData(this);

        Log.d(LOG, "Die Datenquelle wird geöffnet.");
        benutzerData.open();

        //hier müssen wir die datenübergeben bzw. eine neue activity erschaffen für den
        //benutzer
        Benutzer benutzer= benutzerData.createBenutzer("king",60
                ,20);
        Log.d(LOG,"folgender Eintrag in der Datenbank");
        Log.d(LOG,"Inhalt: "+benutzer.toString());


        Log.d(LOG, "Die Datenquelle wird geschlossen.");
        benutzerData.close();


    }

    public boolean onCreateOptionsMenu(Menu menu){
        //add items to action bar
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem menu){
        int id = menu.getItemId();

        if(id==R.id.menu_item){
            return true;
        }
        return super.onOptionsItemSelected(menu);
    }
}
