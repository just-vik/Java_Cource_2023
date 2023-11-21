package homework.array;

public class ArrayMethods {
    public int sum(int[] array) {
        int res = 0;
        for (int num : array) {
            res += num;
        }
        return res;
    }

    public boolean elementSearch(int[] array, int el) {
        for (int num : array) {
            if (num == el) {
                return true;
            }
        }
        return false;
    }
}
