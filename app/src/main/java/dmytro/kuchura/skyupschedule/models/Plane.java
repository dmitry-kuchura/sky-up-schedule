package dmytro.kuchura.skyupschedule.models;

public class Plane {
    private String model;
    private String firstFly;
    private String age;
    private String places;

    public Plane() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFirstFly() {
        return firstFly;
    }

    public void setFirstFly(String firstFly) {
        this.firstFly = firstFly;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }
}
