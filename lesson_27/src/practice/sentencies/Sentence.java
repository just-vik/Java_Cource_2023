package practice.sentencies;

public class Sentence {

    //    Count words in Sentence
//    public int countWords(String str) {
//        String[] words = str.split(" ");
//        int n = 0;
//        for (int i = 0; i < words.length; i++) {
//            if (words[i].equals("–") || words[i].equals("-") ||
//                    words[i].equals(",") || words[i].isEmpty()) {
//                n++;
//            }
//        }
////        System.out.println(words.length);
////        System.out.println(n);
//        return words.length - n;
//    }

    public int countWords(String str) {
        str.trim();
        //String[] words = str.split("\\s+"); //  "\\s+" -[регикс] любой символ пробела 1 или более
        String[] words = str.replaceAll("[^a-zA-Zа-яёА-ЯЁ ]","").split(" ");
        return words.length;
        // split - разделяем строку на подстроки
    }

    public int countSymbols(String str) {
        str.trim();
        String countSymbols = str.replaceAll(" ", "");
        return countSymbols.length();
    } // replaceAll - возвращает новую строку, в которой все совпадения шаблона заменены на replacement




    //    Count symbols in Sentence
//    public int countSymbols(String str) {
//        String[] symbols = str.split("");
//        int n = 0;
//        for (int i = 0; i < symbols.length; i++) {
//            if (symbols[i].equals(" ")) {
//                n++;
//            }
//            //TODO исключить пробелы из результата метода
//        }
//        return symbols.length - n;
//
//    }
}