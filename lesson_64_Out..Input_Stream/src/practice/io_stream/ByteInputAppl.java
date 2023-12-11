package practice.io_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ByteInputAppl {
    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream fileIN = new FileInputStream("./dest/data.txt");
        try {
//            System.out.println("Available: " + fileIN.available()); // Выясняем сколько байт доступно для чтения
//            int a = fileIN.read(); // считали
//            System.out.println(a); // напечатали
//            System.out.println("Available: " + fileIN.available());
//            // Каждое чтение байта из файла переещает "внутренний курсор" на 1 позицию
//            a= fileIN.read();
//            System.out.println(a);
//            System.out.println("Available: " + fileIN.available());
            //'процесс побайтного чтения'

            //как считать все из файла
            //Option 1
//            int a = fileIN.read();
//            while (a != -1) {
//                System.out.println(a);
//                a = fileIN.read(); // если есть значение больше 256(кол-во байт) 257 - 256 = 1
//            }
            //Option 2
//            int length = fileIN.available(); //сколько байт доступно для чтения
//            for (int i = 0; i < length; i++) {
//                int a = fileIN.read();
//                System.out.println(a);
//            }
            //Option 2 с помощью массива
            int length = fileIN.available(); //сколько байт доступно для чтения
            byte[] arr = new byte[length];
            fileIN.read(arr);
            for (byte b:arr){
                System.out.println(b);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
