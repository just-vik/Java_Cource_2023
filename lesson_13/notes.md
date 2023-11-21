**Печать массива;**
public static void printArray(**int**[] arr) { //(int[] arr)
for (int i = 0; i < arr.length; i++) {
System.out.println(arr[i] + " "); //печатает поочереди элементы массива
}
}
public static void printArray(**String**[] arr) { //(String[] arr)
for (int i = 0; i < arr.length; i++) {
System.out.println(arr[i] + " "); //печатает поочереди элементы массива
}
}

**Поиск элемента массива (перебором всех элементов массива);**


**Поиск максимального/минимального значения;**
public static int minElOfArray(int[] arr) {
//пробегаем по массиву, каждый элемент сравним с min
//если элемент будет <min то делаем min = элементу
int min = arr[0];
for (int i = 0; i < arr.length; i++) {
if (arr[i] < min) { //если элемент массива с индексом i < min
min = arr[i];
}
}
return min; //закрываем метод
}


