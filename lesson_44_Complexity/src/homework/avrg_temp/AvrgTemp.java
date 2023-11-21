package homework.avrg_temp;

public class AvrgTemp {
    public static void main(String[] args) {
        // создаем 2 массива температур
        double[] lastWeekOctober = {15.5, 16.2, 14.8, 17.3, 18.0, 14.2, 15.8};
        double[] firstWeekNovember = {12.5, 13.2, 11.8, 14.3, 15.0, 11.2, 12.8};
        // вычисляем среднюю температуру
        double avrgTemp = avrgCalc(lastWeekOctober, firstWeekNovember);
        System.out.println(avrgTemp);

    }

    // метод подсчета среднего значения
    private static double avrgCalc(double[] oct, double[] nov) {
        double sum = 0;
        for (int i = 0; i < oct.length; i++) {
            sum += oct[i];
        }
        for (int i = 0; i < nov.length; i++) {
            sum += nov[i];
        }
        //возвращаем сумму температур за обе недели / на кол-во элементов в обоих массивах
        return sum / (oct.length + nov.length);
    }
}

