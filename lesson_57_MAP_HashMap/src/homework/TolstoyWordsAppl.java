package homework;

import java.util.HashMap;
import java.util.Map;

public class TolstoyWordsAppl {
    public static void main(String[] args) {
        String text = "В 1800-х годах, в те времена, когда не было еще ни железных, ни шоссейных дорог, ни газового, ни стеаринового света, ни пружинных низких диванов, ни мебели без лаку, ни разочарованных юношей со стеклышками, ни либеральных философов-женщин, ни милых дам-камелий, которых так много развелось в наше время, – в те наивные времена, когда из Москвы, выезжая в Петербург в повозке или карете, брали с собой целую кухню домашнего приготовления, ехали восемь суток по мягкой, пыльной или грязной дороге и верили в пожарские котлеты, в валдайские колокольчики и бублики, – когда в длинные осенние вечера нагорали сальные свечи, освещая семейные кружки из двадцати и тридцати человек, на балах в канделябры вставлялись восковые и спермацетовые свечи, когда мебель ставили симметрично, когда наши отцы были еще молоды не одним отсутствием морщин и седых волос, а стрелялись за женщин и из другого угла комнаты бросались поднимать нечаянно и не нечаянно уроненные платочки, наши матери носили коротенькие талии и огромные рукава и решали семейные дела выниманием билетиков, когда прелестные дамы-камелии прятались от дневного света, – в наивные времена масонских лож, мартинистов, тугендбунда, во времена Милорадовичей, Давыдовых, Пушкиных, – в губернском городе К. был съезд помещиков, и кончались дворянские выборы.";
        int totalWords = wordsFrequency(text);
        int totalLetters = lettersFrequency(text);
        System.out.println("Общее количество слов: " + totalWords);
        System.out.println("Общее количество букв: " + totalLetters);
    }

    private static int  wordsFrequency(String text) {
        Map<String, Integer> wordFreq = new HashMap<>(); // cоздаем wordFreq для хранения слов
        String[] words = text.replaceAll("[^а-яА-Яa-zA-Z\\s]", "").toLowerCase().split("\\s+"); //удаляем все символы, переводим в нижний регистр
        //считаем кол-во слов
        for (String word : words) {
                wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1); //увеличиваем счетчик
//getOrDefault - возвращает значение, которому соответствует указанный ключ
        }
        System.out.println("========= Слова и их кол-во =========");
        wordFreq.forEach((word, freq) -> System.out.println(word + " => " + freq));
        // сортировка
//        wordFreq.entrySet().stream()
//                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) // сортировка
//                .forEachOrdered(entry -> System.out.println(entry.getKey() + " => " + entry.getValue()));

        return wordFreq.size();
    }

    private static int  lettersFrequency(String text) {
        Map<Character, Integer> letterFreq = new HashMap<>(); //cоздаем letterFreq для хранения букв
        text = text.replaceAll("[^а-яА-Яa-zA-Z]", "").toLowerCase(); //удаляем все символы, переводим в нижний регистр

        //считаем кол-во букв
        for (char letter : text.toCharArray()) {
            letterFreq.put(letter, letterFreq.getOrDefault(letter, 0) + 1); //увеличиваем счетчик
        }
        System.out.println("========= Буквы и их кол-во =========");
        letterFreq.forEach((letter, freq) -> System.out.println(letter + " => " + freq));

        return text.length();
    }
}
