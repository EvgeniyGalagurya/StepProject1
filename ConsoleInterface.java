package StepProject;

import java.io.File;
import java.util.Scanner;

public class ConsoleInterface {
    String menu = """
            ============================================================
            <<Онлайн платформа для поиска и бронирование авиабилетов>>
            1.Онлайн-табло.
            2.Посмотреть информацию о рейсе.
            3.Поиск и бронирование рейса.
            4.Отменить бронирование.
            5.Мои рейсы.
            6.Выход.
            ============================================================
            """;
    boolean b = true;

    public void Controller(String menu) throws Exception {
//        System.out.print("Bведите количество рандомных рейсов: ");
//        Scanner sc = new Scanner(System.in);
//        int quality = sc.nextInt();
        App.main(20);
        while (b) {
            System.out.printf(menu);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Выберите пункт меню: ");
            int i = scanner.nextInt();
            switch (i) {
                case 1:
                    System.out.println("Расписание вылетов на сегодня");
                    App.board(20);
                    break;
                case 2:
                    System.out.println("Посмотреть информацию о рейсе.");
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.print("Введите id рейса: ");
                    int id = scanner.nextInt();
                    App.flightInfo(id);
                    break;
                case 3:
                    System.out.println("Поиск и бронирование рейса.");
                    App.findFlights(20);
                    break;
                case 4:
                    System.out.println("Отменить бронирование.");
                    App.deleteFlights();
                    break;
                case 5:
                    Scanner scannername = new Scanner(System.in);
                    System.out.print("Введите имя ");
                    String name = scannername.nextLine();
                    App.myBook(name);
                    break;
                case 6:
                    System.out.println("Завершение работы приложения");
                    b = false;
                    break;
                default:
                    System.out.println("invalide id");
                    break;
            }
        }

    }


}

