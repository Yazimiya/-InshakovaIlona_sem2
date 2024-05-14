import java.util.Random;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Main {

    public static void main(String[] args) {

        FibonacciHeap heap = new FibonacciHeap();
        int[] array = generateRandom(10000);

        // ВСТАВКА(добавление)
        long totalOperationsInsert = 0;
        long totalTimeInsert = 0;

        for (int i = 0; i < array.length; i++) {
            long startTimeInsert = System.nanoTime();
            heap.resetInsertOperations();
            heap.insert(array[i], i);

            long InsertEndTime = System.nanoTime();
            long InsertTime = InsertEndTime - startTimeInsert;

            // Количество операций после вставки
            long operationsAfterInsert = heap.getInsertOperations();
            // Обновляем общее количество операций
            totalOperationsInsert += operationsAfterInsert;

            // Обновляем общее время выполнения
            totalTimeInsert += InsertTime;

            // ЗАПУСТИТЬ ДЛЯ ДОБАВЛЕНИЯ
//            System.out.println(operationsAfterInsert);
//            System.out.println(InsertTime);
        }

        System.out.println("ДОБАВЛЕНИЕ (общее время): " + totalTimeInsert + " ns");
        System.out.println("ДОБАВЛЕНИЕ (общее количество операций): " + totalOperationsInsert);

        double averageTimeInsert = totalTimeInsert / (double) array.length;
        double averageOperationsInsert = totalOperationsInsert / (double) array.length;
        System.out.println("ДОБАВЛЕНИЕ (среднее время): " + averageTimeInsert + " ns");
        System.out.println("ДОБАВЛЕНИЕ (среднее количество операций): " + averageOperationsInsert);

        // ПОИСК
        Random random = new Random();
        long totalOperationsSearch = 0;
        long totalTimeSearch = 0;

        for (int i = 0; i < 100; i++) { // Выполение поиска для 100 случайных элементов
            int elementToFind = array[random.nextInt(array.length)];
            long startTimeSearch = System.nanoTime();

            // Поиск элемента в куче
            boolean found = heap.contains(elementToFind);

            long SearchEndTime = System.nanoTime();
            long searchTime = SearchEndTime - startTimeSearch;
            // Количество операций после поиска
            long operationsAfterSearch = heap.getSearchOperations();
            // Обновляем общее количество операций
            totalOperationsSearch += operationsAfterSearch;

            // ЗАПУСТИТТЬ ДЛЯ ПОИСКА
//            System.out.println(searchTime);
//            System.out.println(operationsAfterSearch);

            // Обновляем общее время выполнения
            totalTimeSearch += searchTime;
        }

        System.out.println("ПОИСК (общее время): " + totalTimeSearch + " ns");
        System.out.println("ПОИСК (общее количество операций): " + totalOperationsSearch);

        double averageTimeSearch = totalTimeSearch / 100.0;
        double averageOperationsSearch = totalOperationsSearch / 100.0;
        System.out.println("ПОИСК (среднее время): " + averageTimeSearch + " ns");
        System.out.println("ПОИСК (среднее количество операций): " + averageOperationsSearch);

        // УДАЛЕНИЕ
        long totalOperationsDelete = 0;
        long totalTimeDelete = 0;

        for (int i = 0; i < 1000; i++) { // Выполнение удаления для 1000 случайных элементов
            int elementToRemove = array[random.nextInt(array.length)];

            long startTimeDelete = System.nanoTime();
            heap.resetDeletOperations();

            // Удаляем элемент из кучи
            boolean removed = heap.delete(elementToRemove);

            long DeleteEndTime = System.nanoTime();
            long deleteTime = DeleteEndTime - startTimeDelete;

            // Количество операций после удаления
            long operationsAfterDelete = heap.getDeleteOperations();
            // Обновляем общее количество операций
            totalOperationsDelete += operationsAfterDelete;

            // ЗАПУСТИТЬ ДЛЯ УДАЛЕНИЯ
//            System.out.println(deleteTime);
//            System.out.println(operationsAfterDelete);

            // Обновляем общее время выполнения
            totalTimeDelete += deleteTime;

        }
        System.out.println("УДАЛЕНИЕ (общее время): " + totalTimeDelete + " ns");
        System.out.println("УДАЛЕНИЕ (общее количество операций): " + totalOperationsDelete);

        double averageTimeDelete = totalTimeDelete / 1000.0;
        double averageOperationsDelete = totalOperationsDelete / 1000.0;
        System.out.println("УДАЛЕНИЕ (среднее время): " + averageTimeDelete + " ns");
        System.out.println("УДАЛЕНИЕ (реднее количество операций): " + averageOperationsDelete);
    }


    // Генерируем случайный массив
    private static int[] generateRandom ( int length){
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(10000);
        }
        return array;
    }
}