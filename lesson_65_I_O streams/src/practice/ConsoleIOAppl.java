package practice;

import java.io.*;

public class ConsoleIOAppl {
    public static void main(String[] args) throws IOException {
// Сценарий:
// - Спросим у пользователя имя файла
// - Сохраняем то, что он вводит, в этом файле

// Создаем объект BufferedReader для чтения ввода пользователя с консоли
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// Выводим сообщение для пользователя, запрашивая имя файла
        System.out.println("Enter file name: ");
// Читаем строку, которую пользователь ввел в консоли (имя файла)
        String str = br.readLine();
// Создаем PrintWriter для записи в файл, используя введенное пользователем имя файла.
// true указывает на то, что мы хотим добавлять текст в конец файла, а не перезаписывать
        PrintWriter pw = new PrintWriter(new FileWriter(str, true));
// Запрашиваем у пользователя ввод текста
        System.out.println("Type the text here: ");
// Читаем строку, которую пользователь вводит в консоли
        str = br.readLine();
        while (!"stop".equalsIgnoreCase(str)) {
            // Пока пользователь не ввел "stop" (независимо от регистра), выполняем следующее:
            pw.println(str); // Записываем введенную строку в файл
            System.out.println("Type the text here: "); // Снова запрашиваем текст
            str = br.readLine(); // Читаем следующую строку пользователя
        }
// Отправляем данные из буфера PrintWriter в поток файла
        pw.flush();
// Закрываем PrintWriter и файл
        pw.close();
    }
}
