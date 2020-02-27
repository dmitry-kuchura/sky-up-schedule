package dmytro.kuchura.skyupschedule.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dmytro.kuchura.skyupschedule.R;
import dmytro.kuchura.skyupschedule.models.Flight;

public class FlightAdapter extends RecyclerView.Adapter<FlightAdapter.FlightsViewHolder> {

    private Context context;
    private ArrayList<Flight> flights;

    public FlightAdapter(Context context, ArrayList<Flight> flights) {
        this.context = context;
        this.flights = flights;
    }

    @NonNull
    @Override
    public FlightsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.flight_item, viewGroup, false);

        return new FlightsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlightsViewHolder holder, int position) {
        Flight currentFlight = flights.get(position);

        String departedTime = currentFlight.getDepartureTime();
        String departedAirport = currentFlight.getDepartureTrafficHub().getName();
        String departedTrafficHub = currentFlight.getDepartureTrafficHub().getCode();

        String flightNumber = currentFlight.getNumber();
        String boardStatus = currentFlight.getBoardStatus();
        String isCharterBoard = currentFlight.isCharter() ? "Charter" : "";

        String arrivalTime = currentFlight.getArrivalTime();
        String arrivalAirport = currentFlight.getArrivalTrafficHub().getName();
        String arrivalTrafficHub = currentFlight.getArrivalTrafficHub().getCode();

        holder.departedTime.setText(departedTime);
        holder.departedAirport.setText(departedAirport);
        holder.departedTrafficHub.setText(departedTrafficHub);

        holder.flightNumber.setText(flightNumber);
        holder.boardStatus.setText(boardStatus);
        holder.isCharterBoard.setText(isCharterBoard);

        holder.arrivalTime.setText(arrivalTime);
        holder.arrivalAirport.setText(arrivalAirport);
        holder.arrivalTrafficHub.setText(arrivalTrafficHub);
    }

    @Override
    public int getItemCount() {
        return flights.size();
    }

    public static class FlightsViewHolder extends RecyclerView.ViewHolder {

        TextView departedTime;
        TextView departedAirport;
        TextView departedTrafficHub;

        TextView flightNumber;
        TextView boardStatus;
        TextView isCharterBoard;

        TextView arrivalTime;
        TextView arrivalAirport;
        TextView arrivalTrafficHub;

        public FlightsViewHolder(@NonNull View itemView) {
            super(itemView);

            departedTime = itemView.findViewById(R.id.departed_time);
            departedAirport = itemView.findViewById(R.id.departed_airport);
            departedTrafficHub = itemView.findViewById(R.id.departed_traffic_hub);

            flightNumber = itemView.findViewById(R.id.flight_number);
            boardStatus = itemView.findViewById(R.id.board_status);
            isCharterBoard = itemView.findViewById(R.id.is_charter_board);

            arrivalTime = itemView.findViewById(R.id.arrival_time);
            arrivalAirport = itemView.findViewById(R.id.arrival_airport);
            arrivalTrafficHub = itemView.findViewById(R.id.arrival_traffic_hub);
        }
    }
}
