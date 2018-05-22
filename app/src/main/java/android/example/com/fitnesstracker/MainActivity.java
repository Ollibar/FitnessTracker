package android.example.com.fitnesstracker;

import android.example.com.fitnesstracker.Datenbank.FitnessDbApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private FitnessDbApi fitnessDbApi = new FitnessDbApi(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
