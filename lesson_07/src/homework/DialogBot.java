package homework;

import java.util.Scanner;

// Написать бот который задает не менее 3ч вопросов (последовательно)
// принимает ответы от пользователя и реагирует на них
// как ваз зовут?
//меня зовет бот
//Какой у вас вес
//100
// .........и 3ий

public class DialogBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! Welcome to SunSPAResort Hotel!");
        String dialog = scanner.nextLine();


        if (dialog == "Hello") {
            System.out.println("What can I help you?");
        } else if (dialog == "Do you have room?") {
            System.out.println("Yes, of course. What kind of room would you like?");
        } else if (dialog == "Double room, please") {
            System.out.println("Double room is 85€ a night");
        } else if (dialog == "Ok, I will take it") {
            System.out.println("Very well, I'm need your I.D.");
        }
        return;
    }
}

