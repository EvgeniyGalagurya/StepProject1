package StepProject;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

  private static int k;

  public static void main() throws Exception {

    DAO<Flight> dao1 = new DaoFile<>(new File("flights.txt"));
    dao1.save(Flight.flight1);
    dao1.save(Flight.flight2);
    dao1.save(Flight.flight3);
    dao1.save(Flight.flight4);
    dao1.save(Flight.flight5);
    dao1.save(Flight.flight6);
  }

  public static void flightInfo(int id) throws Exception {

    DAO<Flight> dao1 = new DaoFile<>(new File("flights.txt"));
    dao1.save(Flight.flight1);
    dao1.save(Flight.flight2);
    dao1.save(Flight.flight3);
    dao1.save(Flight.flight4);
    dao1.save(Flight.flight5);
    dao1.save(Flight.flight6);
    System.out.println(dao1.load(id));
  }

  public static void board() throws Exception {

    DAO<Flight> mapFull = new DaoHashMap<>();
    mapFull.save(Flight.flight1);
    mapFull.save(Flight.flight2);
    mapFull.save(Flight.flight3);
    mapFull.save(Flight.flight4);
    mapFull.save(Flight.flight5);
    mapFull.save(Flight.flight6);
    for (int i = 1; i < 7; i++) {
      System.out.println(mapFull.load(i).id() + "." + "[" + mapFull.load(i).from() + "] - [" + mapFull.load(i).to() + "]" + " [" + mapFull.load(i).time() + "]");
    }
  }

  public static void findFlights() throws Exception {
    DAO<Flight> mapFull = new DaoHashMap<>();
    mapFull.save(Flight.flight1);
    mapFull.save(Flight.flight2);
    mapFull.save(Flight.flight3);
    mapFull.save(Flight.flight4);
    mapFull.save(Flight.flight5);
    mapFull.save(Flight.flight6);


    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите место назначения рейса: ");
    String place = scanner.nextLine();
    System.out.println("Введите количество билетов бронирования: ");
    Integer quantityPerson = scanner.nextInt();
    for (int i = 1; i < 7; i++)
      if (place.equals(mapFull.load(i).to()) && mapFull.load(i).places() > quantityPerson) {
        System.out.println(mapFull.load(i));
      }
    System.out.println("Введите id рейса для бронирования или нажмите 0 для возврата в основное меню");
    Integer id = scanner.nextInt();
    if (id != 0)
      toBook(id, quantityPerson);
  }

  public static DAO<Flight> myFlights = new DaoFile<>(new File("myflights.bin"));

    public static void toBook(Integer id, Integer quantityPerson) throws Exception {

    DAO<Flight> mapFull = new DaoHashMap<>();
    mapFull.save(Flight.flight1);
    mapFull.save(Flight.flight2);
    mapFull.save(Flight.flight3);
    mapFull.save(Flight.flight4);
    mapFull.save(Flight.flight5);
    mapFull.save(Flight.flight6);

    myFlights.save(mapFull.load(id));
//    k = k + 1;
//    System.out.println(myFlights.load(id));
  }

  public static void deleteFlights(Integer d) throws Exception {
    myFlights.delete(d);
  }

  public static void myBook() throws Exception {
    myFlights.loadAll();
//    System.out.println(myFlights.load(1));


  }
}











