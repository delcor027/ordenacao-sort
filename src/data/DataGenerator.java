package data;

import java.util.Random;
import java.util.Arrays;
import java.util.HashSet;

public class DataGenerator {

    // Crescente sem repetição
    public static int[] generateIncreasingData(int size) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = i;
        }
        return data;
    }

    // Decrescente sem repetição
    public static int[] generateDecreasingData(int size) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = size - i;
        }
        return data;
    }

    // Aleatório sem repetição
    public static int[] generateRandomData(int size) {
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        Random random = new Random();
        int[] data = new int[size];
        int i = 0;

        while (i < size) {
            int num = random.nextInt(size * 10);  // Gera um número aleatório grande o suficiente
            if (!uniqueNumbers.contains(num)) {
                uniqueNumbers.add(num);
                data[i] = num;
                i++;
            }
        }
        return data;
    }

    // Crescente com repetição
    public static int[] generateIncreasingDataWithRepetition(int size) {
        int[] data = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(size / 10);  // Usa random para adicionar repetição aleatória
        }
        Arrays.sort(data);  // Mantém os dados em ordem crescente
        return data;
    }

    // Decrescente com repetição
    public static int[] generateDecreasingDataWithRepetition(int size) {
        int[] data = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(size / 10);  // Usa random para adicionar repetição aleatória
        }
        Arrays.sort(data);
        // Reverter a ordem para ser decrescente
        for (int i = 0; i < size / 2; i++) {
            int temp = data[i];
            data[i] = data[size - i - 1];
            data[size - i - 1] = temp;
        }
        return data;
    }

    // Aleatório com repetição
    public static int[] generateRandomDataWithRepetition(int size) {
        Random random = new Random();
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(100);  // Limita os valores a um intervalo pequeno para ter repetição
        }
        return data;
    }
}
