package dmytro.kuchura.skyupschedule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import dmytro.kuchura.skyupschedule.adapters.FlightAdapter;
import dmytro.kuchura.skyupschedule.models.Flight;
import dmytro.kuchura.skyupschedule.models.Plane;
import dmytro.kuchura.skyupschedule.models.TrafficHub;

public class ScheduleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FlightAdapter flightAdapter;
    private ArrayList<Flight> flights;
    private RequestQueue requestQueue;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        recyclerView = findViewById(R.id.schedule);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        flights = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);

        getFlights();
    }

    private void getFlights() {

        String url = "http://192.168.56.1:8080/api/flights?airport=KBP";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("data");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String number = jsonObject.getString("Number");
                        String departureTime = jsonObject.getString("DepartureTime");
                        String arrivalTime = jsonObject.getString("ArrivalTime");
                        String boardStatus = jsonObject.getString("BoardStatus");
                        boolean isCharter = jsonObject.getBoolean("IsCharter");

                        Plane plane = new Plane();
                        plane.setModel("");
                        plane.setFirstFly("");
                        plane.setAge("");
                        plane.setPlaces("");

                        TrafficHub departureTrafficHub = new TrafficHub();
                        departureTrafficHub.setName("");
                        departureTrafficHub.setCode("");

                        TrafficHub arrivalTrafficHub = new TrafficHub();
                        arrivalTrafficHub.setName("");
                        arrivalTrafficHub.setCode("");

                        Flight flight = new Flight();
                        flight.setNumber(number);
                        flight.setInfo(plane);
                        flight.setDepartureTrafficHub(departureTrafficHub);
                        flight.setArrivalTrafficHub(arrivalTrafficHub);
                        flight.setDepartureTime(departureTime);
                        flight.setArrivalTime(arrivalTime);
                        flight.setBoardStatus(boardStatus);
                        flight.setCharter(isCharter);

                        flights.add(flight);
                    }

                    flightAdapter = new FlightAdapter(ScheduleActivity.this, flights);
                    recyclerView.setAdapter(flightAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(request);
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
        } else {
            backToast = Toast.makeText(getBaseContext(), R.string.press_again_to_exit, Toast.LENGTH_SHORT);
            backToast.show();
        }

        backPressedTime = System.currentTimeMillis();
    }
}
