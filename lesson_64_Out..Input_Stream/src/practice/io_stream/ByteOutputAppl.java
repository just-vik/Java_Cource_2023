package practice.io_stream;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteOutputAppl {
    public static void main(String[] args) {

        try (FileOutputStream fileOut = new FileOutputStream("./dest/data.txt")) {
            fileOut.write(74); // Этот вызов записывает байт со значением 74. В ASCII это соответствует символу 'J'.
            fileOut.write(65); // Записывается байт со значением 65, что соответствует ASCII коду для буквы 'A'.
            fileOut.write(86); // Этот вызов записывает байт со значением 86. В ASCII это символ 'V'.
            fileOut.write(65); // Этот вызов также записывает байт со значением 65, что соответствует ASCII коду для буквы 'A'.
            fileOut.write(32); // Записывается байт со значением 32. В ASCII это код пробела.
            fileOut.write(27); // Записываем байт со значением 27
            fileOut.write(257); // Пытаемся записать байт со значением 257 (выходит за пределы диапазона байта)
            fileOut.write(1); // Записываем байт со значением 1
            // fileOut.close(); - не нужен так как используем try catch
            //FileNotFoundException - исключение возникает, когда программа пытается открыть файл для чтения или записи, который не существует в указанном пути.
            //Оно указывает на то, что файл, который вы пытаетесь использовать, не найден.
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // Выводим информацию об ошибке, если файл не найден
            //IOException - это более общее исключение, которое может возникнуть при попытке выполнения операции ввода-вывода с файлом или потоком данных.
            //Оно может быть вызвано различными условиями, такими как потеря соединения во время чтения/записи, некорректный доступ к файлу и другими проблемами ввода-вывода.
        } catch (IOException e) { // Это объявление переменной e, которая представляет исключение типа IOException. В этой переменной содержится информация об ошибке, которая произошла в блоке кода внутри блока try.
           throw  new RuntimeException(e); // Эта строка создает новый объект типа RuntimeException с исключением e в качестве параметра. RuntimeException является типом необрабатываемого исключения, то есть не требует явного обработчика или объявления.
        }
    }
}
