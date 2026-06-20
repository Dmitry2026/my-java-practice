import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Transaction> history = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("#,##0.00");

        System.out.println("<<<Т-Система: Логистики транзикций>>>");

        while (true) {
            System.out.println("Катерогория ( или 'exit'): ");
            String cat = scanner.nextLine();

            if (cat.equalsIgnoreCase("exit")) break;

            System.out.println("Сумма: ");
            String sumStr = scanner.nextLine().replace(',', '.').trim();

            try {
                BigDecimal money = new BigDecimal(sumStr).setScale(2, RoundingMode.HALF_UP);
                Transaction th = new Transaction(cat, money);
                history.add(th);
                System.out.println("Объек Transaction успешно добавлен в память.");
            } catch (NumberFormatException | ArithmeticException e) {
                System.out.println("Ошибка парсинга суммы. Попробуйте еще раз.");
                System.out.println();
            }


            System.out.println("\n<<<Выгрузка транзикций из сети>>>");
            BigDecimal total = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);

            for (Transaction t : history) {
                System.out.println("Транзикция >>> Категория: " + t.getCategory() + " | Сумма: " + df.format(t.getAmount()) + " руб.");
                total = total.add(t.getAmount());
            }

            System.out.println("Итого обработанона сумму: " + df.format(total) + " руб.");

        }
        scanner.close();
    }
}
