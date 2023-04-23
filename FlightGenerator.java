package StepProject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class FlightGenerator implements IdentifableSerializable {
    public enum Destination {KYIV, KHARKIV, LVIV, IVANO_FRANKIVSK, CHERNIGIV, DNIPR}
    private static final int maxFreePlaces = 50;
    private static final Random GenerateNumbers = new Random();
    private final int id;
    private final Destination from;
    private final Destination to;
    private final String date;
    private final String time;
    private final int freePlaces;

    public FlightGenerator (int id, Destination from, Destination to, String date, String time, int freePlaces){
        this.id = id;
        this.from = from;
        this.to = to;
        this.date = date;
        this.time = time;
        this.freePlaces = freePlaces;
    }
    public static FlightGenerator getRandomFlight(int id, String date){
        Destination from = Destination.KYIV;
        Destination to = getRandomDestination(from);
        String time = getRandomTime();
        int freePlaces = GenerateNumbers.nextInt(maxFreePlaces) + 1;
        return new FlightGenerator(id,from, to,date, time, freePlaces);
    }
private static String getRandomTime(){
        int hour = GenerateNumbers.nextInt(24);
        int minute = GenerateNumbers.nextInt(60);
        return String.format("%02d:%02d", hour,minute);
}
    private static Destination getRandomDestination(Destination from) {
        Destination destination = from;
        while (destination == from) {
            int randomIndex = GenerateNumbers.nextInt(Destination.values().length);
            destination = Destination.values()[randomIndex];
        }
        return destination;
    }
    @Override
    public String toString() {
        return id + ". [" + from + "] - [" + to + "] [" + date + "] [" + time + "] freeplaces: [" + freePlaces + "]";
    }
 public static List<FlightGenerator> generateFlights (int numberOfFlights){
     List<FlightGenerator> flightsList = new ArrayList<>();
        for(int i = 1; i <=numberOfFlights; i++){
            Destination from = Destination.KYIV;
            Destination to = getRandomDestination(from);
            String date = "18.04.2023";
            String time = getRandomTime();
            int freePlaces = GenerateNumbers.nextInt(maxFreePlaces) + 1;
            FlightGenerator flight = new FlightGenerator(i + 1, from, to, date, time, freePlaces);
            flightsList.add(flight);
        }
return flightsList;
 }

}
