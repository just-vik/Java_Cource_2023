package practice;
// Задача о яблоках (начальное значение 30)
// Запустить цикл, в котором яблоки берутся из корзины до тех пор, пока они там есть
// Последнее сообщение: "Яблоки кончились!".

public class Apples {
    public static void main(String[] args) {

        int apples = 30;           //стартовые значения
        int counter = 0;             //счетчик с 0
        int applesInCycle = apples;  //параметр цикла

        while (applesInCycle > 0) {
            //тело цикла
            System.out.println("Take one apple from basket ");
            applesInCycle = applesInCycle - 1;//изменяем параметр цикла
            // applesInCycle--;
            counter++; //кол-во выполненных операций
            System.out.println("The rest of apples " + applesInCycle);
        }
        System.out.println("The job is done, total apples " + counter + " added in pie from " + apples + " in basket");

    }
}
