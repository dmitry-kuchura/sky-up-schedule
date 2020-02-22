package dmytro.kuchura.skyupschedule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AirportSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airport_select);
    }

    public void setLvivAirport(View view) {
        Intent mySuperIntent = new Intent(AirportSelectActivity.this, AirportActivity.class);
        startActivity(mySuperIntent);

        finish();
    }
}
