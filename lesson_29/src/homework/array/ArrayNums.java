package homework.array;

public class ArrayNums {
    public static double evenNum(int[] arr) {
        double res = 0;
        int sum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                sum += arr[i];
                count++;
            }
        }
        if (count == 0 || sum == 0) {
            return -1;
        }
        res = (double) sum / count;
        return res;
    }

}
