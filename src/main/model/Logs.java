package model;

// Represents the logs throughout the days of the week from Monday to Sunday
public class Logs {
    private Meals monday;
    private Meals tuesday;
    private Meals wednesday;
    private Meals thursday;
    private Meals friday;
    private Meals saturday;
    private Meals sunday;

    // EFFECTS: constructs a log with new meals for every day of the week
    public void Logs() {
        monday = new Meals();
        tuesday = new Meals();
        wednesday = new Meals();
        thursday = new Meals();
        friday = new Meals();
        saturday = new Meals();
        sunday = new Meals();

    }

    //REQUIRES: string must be either "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" or "Sunday"
    //EFFECTS: returns the meals corresponding to the given day
    public Meals getMealsByDay(String day) {
        return null;
    }

    public Meals getMonday() {
        return monday;
    }

    public Meals getTuesday() {
        return tuesday;
    }

    public Meals getWednesday() {
        return wednesday;
    }

    public Meals getThursday() {
        return thursday;
    }

    public Meals getFriday() {
        return friday;
    }

    public Meals getSaturday() {
        return saturday;
    }

    public Meals getSunday() {
        return sunday;
    }

}
