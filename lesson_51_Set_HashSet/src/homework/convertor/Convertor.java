package homework.convertor;

import java.util.*;

//TODO не понятно почему выводит номера меню в хаотичном порядке
// помогло - поменял HashSet на LinkedHashSet(сохраняет порядок добавления элементов)
public class Convertor {
    public static void main(String[] args) {
        //создаем множество (Set) для хранения валют, копируем значения во множество используем Arrays.asList
        Set<Currency> currencies = new LinkedHashSet<>(Arrays.asList(Currency.values())); //чтобы скопировать значения во множество используем Arrays.asList

        //выводим меню в терминал
        System.out.println("Available currencies: ");
        for (Currency с : currencies) {
            System.out.println(с);
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter currency number: ");
        int choicedNumber = scanner.nextInt();

        System.out.print("Enter amount of the choiced currency: ");
        double amount = scanner.nextDouble();

        Currency choicedCurrency = getCurrencyByNumber(currencies, choicedNumber);
        if (choicedCurrency != null) {
            double amountEuro = amount * choicedCurrency.getCourse();
            System.out.println("Total: " + amountEuro + " \u20ac");
        } else {
            //если валюта не найдена
            System.out.println("Incorrect choice.");
        }
    }

    //метод для поиска валюты по номеру
    private static Currency getCurrencyByNumber(Set<Currency> currencies, int number) {
        for (Currency c : currencies) {
            if (c.getNumber() == number) {
                return c;
            }
        }
        //если валюта не найдена
        return null;
    }
}
