package StepProject;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
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
    Scanner scanner1 = new Scanner(System.in);
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
//    mapFull.load(id).places() = places
    if (id > 0)
      for (int j = 1; j < quantityPerson + 1; j++) {
        System.out.println("Введите имя для бронирования:");
        String name = scanner1.nextLine();
        DAO<Flight> myFlights = new DaoFile<>(new File(name + ".bin"));

        myFlights.save(mapFull.load(id));
      }

  }

  public static void deleteFlights() throws Exception {
    Scanner scannername1 = new Scanner(System.in);
    System.out.print("Введите имя ");
    String name = scannername1.nextLine();
    System.out.println("На Ваше имя забронированы следующие рейсы:");
    App.myBook(name);
    Scanner scanner2 = new Scanner(System.in);
    System.out.print("Введите id рейса, который Вы хотите отменить: ");
    int id = scanner2.nextInt();
    FileInputStream fis = new FileInputStream(name + ".bin");
    ObjectInputStream ois = new ObjectInputStream(fis);
    ArrayList<Flight> as = (ArrayList<Flight>) ois.readObject();
    ois.close();
    as.removeIf(a -> a.id() == id);
    FileOutputStream fos = new FileOutputStream(name + ".bin");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(as);
    oos.close();;
  }

  //
  public static void myBook(String name) throws Exception {
    FileInputStream fis = new FileInputStream(name + ".bin");
    ObjectInputStream ois = new ObjectInputStream(fis);
    ArrayList<Flight> as = (ArrayList<Flight>) ois.readObject();
    ois.close();
    for (Flight a : as) {
      System.out.println(a);



  }}}













