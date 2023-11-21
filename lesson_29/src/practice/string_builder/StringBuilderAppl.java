package practice.string_builder;

public class StringBuilderAppl {
    public static void main(String[] args) {
//        StringBuilder - это класс, в нем есть полезные методы для работы со строками
//        append - добавление, пристегивание
        String str = "Java";
        //str = str + "_" + 11
        str = str.concat("_"); // concat - это склеивание
        str = str.concat("" + 11); // "" - пустая строка, 11 - примитив(который является Integer)
        System.out.println(str);

//        StringBuilder - mutable!
        StringBuilder stringBuilder = new StringBuilder("Java");
        stringBuilder.append("_").append(11);
        System.out.println(stringBuilder); // объект stringBuilder - мутирует
        stringBuilder.reverse(); //строка задом наперед
        System.out.println(stringBuilder);
        // можно ли вернуть stringBuilder обратно в String?
        str =stringBuilder.toString(); //да, можно
        System.out.println(str);
    }
}
