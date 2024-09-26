package tests;

import sorting.*;
import java.io.*;
import java.util.*;

public class FileSorter {

    public static void main(String[] args) {
        String inputFile = "data/input/10k.txt";  // Arquivo de entrada com os números
        String outputDirectory = "data/output/sorted/";  // Diretório de saída

        try {
            // Ler os números do arquivo de entrada
            List<Integer> numbers = readNumbersFromFile(inputFile);

            // Converte para array de int
            int[] numbersArray = numbers.stream().mapToInt(i -> i).toArray();

            // Executar as 6 ordenações e gravar os resultados em arquivos separados
            sortAndWriteToFile(numbersArray, "BubbleSort", outputDirectory);
            sortAndWriteToFile(numbersArray, "InsertionSort", outputDirectory);
            sortAndWriteToFile(numbersArray, "SelectionSort", outputDirectory);
            sortAndWriteToFile(numbersArray, "MergeSort", outputDirectory);
            sortAndWriteToFile(numbersArray, "QuickSort", outputDirectory);
            sortAndWriteToFile(numbersArray, "HeapSort", outputDirectory);

            System.out.println("Os números foram ordenados e gravados nos arquivos correspondentes.");
        } catch (IOException e) {
            System.err.println("Erro ao ler ou gravar o arquivo: " + e.getMessage());
        }
    }

    // Método para realizar a ordenação e gravar o resultado em arquivos diferentes
    public static void sortAndWriteToFile(int[] numbers, String sortAlgorithm, String outputDirectory) throws IOException {
        // Faz uma cópia do array para não alterar o original
        int[] dataCopy = Arrays.copyOf(numbers, numbers.length);

        // Executa a ordenação de acordo com o algoritmo escolhido
        switch (sortAlgorithm) {
            case "BubbleSort":
                BubbleSort.sort(dataCopy);
                break;
            case "InsertionSort":
                InsertionSort.sort(dataCopy);
                break;
            case "SelectionSort":
                SelectionSort.sort(dataCopy);
                break;
            case "MergeSort":
                MergeSort.sort(dataCopy, 0, dataCopy.length - 1);
                break;
            case "QuickSort":
                QuickSort.sort(dataCopy, 0, dataCopy.length - 1);
                break;
            case "HeapSort":
                HeapSort.sort(dataCopy);
                break;
            default:
                throw new IllegalArgumentException("Algoritmo de ordenação desconhecido: " + sortAlgorithm);
        }

        // Gerar o nome do arquivo de saída
        String outputFile = outputDirectory + "sorted_numbers_" + sortAlgorithm + ".txt";

        // Escrever os números ordenados no arquivo de saída
        writeNumbersToFile(dataCopy, outputFile);
    }

    // Método para ler os números do arquivo
    public static List<Integer> readNumbersFromFile(String inputFile) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String line;

        // Ler cada linha e adicionar os números à lista
        while ((line = reader.readLine()) != null) {
            String[] numStrings = line.split("\\s+");  // Dividir por espaços
            for (String numStr : numStrings) {
                if (!numStr.isEmpty()) {
                    numbers.add(Integer.parseInt(numStr));  // Converter para inteiro e adicionar à lista
                }
            }
        }

        reader.close();
        return numbers;
    }

    // Método para escrever os números ordenados no arquivo
    public static void writeNumbersToFile(int[] numbers, String outputFile) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        // Escrever cada número em uma nova linha no arquivo de saída
        for (int num : numbers) {
            writer.write(num + "\n");
        }

        writer.close();
    }
}
