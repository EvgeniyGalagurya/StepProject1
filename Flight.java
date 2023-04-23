package StepProject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public record Flight(int id, String from, String to, String date, String time, Integer places) implements IdentifableSerializable {
    static Flight flight1 = new Flight(1, "Kyiv", "Kharkiv", "18.04.23", "12:45", 58);
    static Flight flight2 = new Flight(2, "Kyiv", "Kharkiv", "18.04.23", "02:45", 32);
    static Flight flight3 = new Flight(3, "Kyiv", "Lviv", "18.04.23", "14:45", 41);
    static Flight flight4 = new Flight(4, "Kyiv", "Ivano-Frankivsk", "18.04.23", "15:35", 31);
    static Flight flight5 = new Flight(5, "Kyiv", "Chernigiv", "18.04.23", "17:25", 7);
    static Flight flight6 = new Flight(6, "Kyiv", "Dnipr", "18.04.23", "18:15", 34);


    @Override
    public String toString() {
        return id + ". [" + from + "] - [" + to + "] [" + date + "] [" + time + "] freeplaces: [" + places + "]";
    }
}

