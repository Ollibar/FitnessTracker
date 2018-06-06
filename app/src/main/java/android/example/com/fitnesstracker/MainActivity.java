package android.example.com.fitnesstracker;

import android.example.com.fitnesstracker.Datenbank.FitnessDbApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private FitnessDbApi fitnessDbApi = new FitnessDbApi(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
