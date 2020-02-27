package dmytro.kuchura.skyupschedule.models;

public class Flight {
    private String number;
    private Plane info;
    private TrafficHub departureTrafficHub;
    private TrafficHub arrivalTrafficHub;
    private String departureTime;
    private String arrivalTime;
    private String boardStatus;
    private boolean isCharter;

    public Flight() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Plane getInfo() {
        return info;
    }

    public void setInfo(Plane info) {
        this.info = info;
    }

    public TrafficHub getDepartureTrafficHub() {
        return departureTrafficHub;
    }

    public void setDepartureTrafficHub(TrafficHub departureTrafficHub) {
        this.departureTrafficHub = departureTrafficHub;
    }

    public TrafficHub getArrivalTrafficHub() {
        return arrivalTrafficHub;
    }

    public void setArrivalTrafficHub(TrafficHub arrivalTrafficHub) {
        this.arrivalTrafficHub = arrivalTrafficHub;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getBoardStatus() {
        return boardStatus;
    }

    public void setBoardStatus(String boardStatus) {
        this.boardStatus = boardStatus;
    }

    public boolean isCharter() {
        return isCharter;
    }

    public void setCharter(boolean charter) {
        isCharter = charter;
    }
}
