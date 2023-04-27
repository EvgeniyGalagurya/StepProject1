package StepProject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public record FlightGenerator (int id, Destination from, Destination to, String date, String time, int freePlaces) implements IdentifableSerializable{
    static int maxFreePlaces = 50;
    static Random GenerateNumbers = new Random();


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
        return    id + ". [" + from + "] - [" + to + "] [" + date + "] [" + time + "] freeplaces: [" + freePlaces + "]" ;
    }
    static DAO<FlightGenerator> mapFull = new DaoHashMap<>();
    public static void generateFlights(int numberOfFlights) throws Exception {

        for (int i = 1; i <= numberOfFlights; i++) {
            Destination from = Destination.KYIV;
            Destination to = getRandomDestination(from);
//            String date = "18.04.2023";
            String date = DateTimeFormatter.ofPattern("dd.MM.yyyy").format(LocalDateTime.now());
            String time = getRandomTime();
            int freePlaces = GenerateNumbers.nextInt(maxFreePlaces) + 1;
            FlightGenerator flight = new FlightGenerator(i, from, to, date, time, freePlaces);
            mapFull.save(flight);
        }
    }
}
