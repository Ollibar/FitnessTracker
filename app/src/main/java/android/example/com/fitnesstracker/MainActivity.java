package android.example.com.fitnesstracker;

import android.example.com.fitnesstracker.Datenbank.FitnessDbApi;
import android.example.com.fitnesstracker.DatenbankHung.User;
import android.example.com.fitnesstracker.DatenbankHung.UserDataSource;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MainActivity extends AppCompatActivity {

    private FitnessDbApi fitnessDbApi = new FitnessDbApi(this);

    private static final String LOG = MainActivity.class.getSimpleName();
    private UserDataSource userDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User testuser = new User("kenzo94",23,70);
        Log.d(LOG,"Inhalt vom Test user: "+ testuser.toString());

        userDataSource = new UserDataSource(this);

        Log.d(LOG, "Die Datenquelle wird geöffnet.");
        userDataSource.open();

        // db.execSQL(ENABLE_FOREIGN_KEYS);

        Log.d(LOG, "Die Datenquelle wird geschlossen.");
        userDataSource.close();


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
