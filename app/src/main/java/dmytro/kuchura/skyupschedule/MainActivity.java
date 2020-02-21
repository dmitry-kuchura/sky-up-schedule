package dmytro.kuchura.skyupschedule;

import android.content.Intent;
import android.os.Handler;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

public class MainActivity extends FragmentActivity {

    int SPLASH_TIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mySuperIntent = new Intent(MainActivity.this, AirportSelectActivity.class);
                startActivity(mySuperIntent);

                finish();

            }
        }, SPLASH_TIME);
    }
}