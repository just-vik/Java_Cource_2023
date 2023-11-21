package practice;

// Запустить обратный отсчет старта ракеты от 10 до 0.
// Последнее сообщение: "Поехали!...".
public class Rocket {
    public static void main(String[] args) throws InterruptedException {
        //throws InterruptedException - добавляем для задержки цикла
        int countDown = 10;

        while (countDown >= 0) { // можно писать while (countDown == 0)
            Thread.sleep(300);          //задержка цикла
            System.out.println("До старта осталось " + countDown);
            countDown--; //Изменение параметра цикла
        }
        System.out.println("Поехали!...");
    }
}
