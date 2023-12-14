package practice.parallel_tasks;

public class MultiThreadAppl {
    private static final int MAX = 10;//указываем константу
    private static final int SIZE = 3;

    //Чтобы новый тред стартовал, надо создать объект типа Thread передав в конструктор
    //объект типа Runnable, и после этого вызвать у объекта типа Thread метод start.

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread started");//это начал работать 1 thread
//        MyTaskImplements task = new MyTaskImplements("Parallel task", MAX);
//        task.run();//это запуск 2 thread

        MyTaskImplements task1 = new MyTaskImplements("Parallel ONE ", MAX); //создали задачу
        MyTaskExtends task2 = new MyTaskExtends("Parallel TWO ", MAX);
        Thread thread1 = new Thread(task1);//создали новый поток и передали ему эту задачу
        Thread thread2 = new Thread(task2);//создали еще один поток паралельный поток и передали ему задачу
        thread1.start();//поток запустили
        thread2.start();


        //создаем массив паралельных задач на классе, который implements Runnable
        MyTaskImplements[] tasks = new MyTaskImplements[SIZE];//создаем массив паралельных задач, которые вложим в потоки
        for (int i = 0; i < tasks.length; i++) { //заполняем массив
            tasks[i] = new MyTaskImplements("Name # " + i, MAX);
        }

        //создаем массив потоков
        Thread[] threads = new Thread[SIZE];//создали массив на SIZE = 3 потока
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(tasks[i]);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();//стартуют все потоки
            //threads[i].join();//ожидая друг друга-так делать не надо

        }


        for (int i = 0; i < MAX; i++) {
            System.out.println("Main count = " + i);//докладывает main
            try {
                Thread.sleep(5); // положили поток спать
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        thread1.join();//присоединение к идущим процессам
        thread2.join();
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();//все присоединяем к идущему массиву main
        }


        System.out.println("Main thread finished.");
    }
}
