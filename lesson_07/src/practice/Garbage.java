package practice;

import java.util.Scanner;

// Запрограммировать бот, который помогает выбрасывать мусор в баки разных цветов:
// упаковки в желтый бак
// пищевые отходы в коричневый бак
// бумага в зеленый бак
// прочие отходы в черный бак
public class Garbage {
    public static void main(String[] args) {

        // ввод названия мусора - строкой, может быть много значений
        // желтый бак должен принять упаковки,пластик,пакеты
        // черный бак - отходы, мусор
        // синий бак - бумага

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input type of garbage: ");
        System.out.printf("package,plastic,bag,rest,waste,paper,cardboard");
        String garbage = scanner.next(); //принимаем ответы пользователя

        if (garbage.equals("package") | garbage.equals("plastic") | garbage.equals("bag")) { //equels(равно)     == плохо для String(не применяется)
            System.out.printf("Put it into yellow box");
        } else if (garbage.equals("rest") | garbage.equals("waste")) {
            System.out.printf("Put in into black box");
        } else {
            System.out.printf("Put it into blue box");
        }
    }
}
