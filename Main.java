import java.util.ArrayList;
import java. util. Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> transactions = new ArrayList<>();
        System.out.println("<<<Система Учета Расходов>>>");
        System.out.println("Введите сумму расходов(или напишите 'exit'  для завершения):");
        while (true) {
            System.out.println("Введите сумму");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            double amount = Double.parseDouble(input);
            transactions.add(amount);
            System.out.println("Транзакция на сумму " + amount + " успешно сохранена");


            System.out.println("\n <<<Сессия Завершена>>>");
            System.out.println("Всего совершенных операций:" + transactions.size());
            double totalSum = 0;
            for (double t : transactions) {
                totalSum += t;
            }
            System.out.println("Общая сумма расходов:" + totalSum + "руб.");
        }
    }
}