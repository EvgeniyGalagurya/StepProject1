package StepProject;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import static StepProject.FlightGenerator.mapFull;

public class App {

  public static void main(int quality) throws Exception {
    FlightGenerator.generateFlights(quality);
    }

  public static void flightInfo(int i) throws Exception {
    System.out.println(mapFull.load(i));
  }
  public static void board(int quality) throws Exception {
    String date = DateTimeFormatter.ofPattern("dd.MM.yyyy").format(LocalDateTime.now());
    DAO<FlightGenerator> file = new DaoFile<>(new File("flights" + "[" + date + "].bin"));
    for (int i = 1; i < quality+1; i++) {
      System.out.println(mapFull.load(i).id() + "." + "[" + mapFull.load(i).from() + "] - [" + mapFull.load(i).to() + "]" + " [" + mapFull.load(i).time() + "]");
      file.save(mapFull.load(i));
    }
  }
  public static void findFlights(int quality) throws Exception {

    Scanner scanner = new Scanner(System.in);
    Scanner scanner1 = new Scanner(System.in);
    System.out.println("Введите место назначения рейса: ");
    Destination place = Destination.valueOf(scanner.nextLine());
    System.out.println("Введите количество билетов бронирования: ");
    Integer quantityPerson = scanner.nextInt();

    for (int i = 1; i < quality; i++)
      if (mapFull.load(i).freePlaces() >= quantityPerson && mapFull.load(i).to() == place) {
        System.out.println(mapFull.load(i));
       } else if (mapFull.load(i).freePlaces() < quantityPerson && mapFull.load(i).to() == place){
          System.out.println("Нет рейса удовлетворяющего Вашим условиям.");
          break;
      }
    System.out.println("Введите id рейса для бронирования или нажмите 0 для возврата в основное меню");
    Integer id = scanner.nextInt();
    if (id > 0)
      for (int j = 1; j < quantityPerson + 1; j++) {
        System.out.println("Введите имя для бронирования:");
        String name = scanner1.nextLine();
        DAO<FlightGenerator> myFlights = new DaoFile<>(new File(name + ".bin"));
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
    DAO<FlightGenerator> file = new DaoFile<>(new File(name + ".bin"));
    file.delete(id);
  }

  public static void myBook(String name) throws Exception {
    DAO<FlightGenerator> file = new DaoFile<>(new File(name + ".bin"));
    file.loadAll(name);
  }
}













