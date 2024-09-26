import sorting.*;
import utils.Timer;
import utils.FileHandler;
import data.DataGenerator;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Usando try-with-resources para garantir que o Scanner será fechado automaticamente
        try (Scanner scanner = new Scanner(System.in)) {
            Timer timer = new Timer();

            // 1. Menu de seleção de algoritmo de ordenação
            System.out.println("Escolha o algoritmo de ordenação:");
            System.out.println("1 - Bubble Sort\n2 - Insertion Sort\n3 - Selection Sort\n4 - Merge Sort\n5 - Quick Sort\n6 - Heap Sort");
            int choice = scanner.nextInt();

            // 2. Menu de seleção do tipo de dado a ser gerado
            System.out.println("Escolha o tipo de dado a ser gerado:");
            System.out.println("1 - Crescente\n2 - Decrescente\n3 - Aleatório\n4 - Aleatório com Repetição");
            int dataTypeChoice = scanner.nextInt();

            // 3. Solicita o tamanho do conjunto de dados
            System.out.println("Informe o tamanho do conjunto de dados:");
            int dataSize = scanner.nextInt();

            // 4. Gera o conjunto de dados de acordo com a escolha do usuário
            int[] data = null;
            switch (dataTypeChoice) {
                case 1:
                    data = DataGenerator.generateIncreasingData(dataSize);
                    break;
                case 2:
                    data = DataGenerator.generateDecreasingData(dataSize);
                    break;
                case 3:
                    data = DataGenerator.generateRandomData(dataSize);
                    break;
                case 4:
                    data = DataGenerator.generateRandomDataWithRepetition(dataSize);
                    break;
                default:
                    System.out.println("Escolha de tipo de dado inválida.");
                    return;
            }

            // Diretório base de saída
            String outputBaseDir = "data/output/";

            // 5. Escolhe o algoritmo de ordenação e executa
            String algorithmDir = null;
            switch (choice) {
                case 1:
                    algorithmDir = "BubbleSort";
                    timer.start();
                    BubbleSort.sort(data);
                    timer.stop();
                    break;
                case 2:
                    algorithmDir = "InsertionSort";
                    timer.start();
                    InsertionSort.sort(data);
                    timer.stop();
                    break;
                case 3:
                    algorithmDir = "SelectionSort";
                    timer.start();
                    SelectionSort.sort(data);
                    timer.stop();
                    break;
                case 4:
                    algorithmDir = "MergeSort";
                    timer.start();
                    MergeSort.sort(data, 0, data.length - 1);
                    timer.stop();
                    break;
                case 5:
                    algorithmDir = "QuickSort";
                    timer.start();
                    QuickSort.sort(data, 0, data.length - 1);
                    timer.stop();
                    break;
                case 6:
                    algorithmDir = "HeapSort";
                    timer.start();
                    HeapSort.sort(data);
                    timer.stop();
                    break;
                default:
                    System.out.println("Escolha de algoritmo inválida.");
                    return;
            }

            // Exibe o tempo de execução
            System.out.println("Tempo de execução: " + timer.getElapsedTimeInMillis() + " ms");

            // 6. Gera o nome do arquivo de saída e salva os dados
            String outputFile = generateOutputFileName(outputBaseDir + algorithmDir + "/");
            FileHandler.writeToFile(data, outputFile);
            System.out.println("Dados ordenados foram salvos em: " + outputFile);
        } // O Scanner é fechado automaticamente aqui
    }

    // Método para gerar o próximo nome de arquivo de saída automaticamente
    private static String generateOutputFileName(String outputDir) throws IOException {
        File dir = new File(outputDir);

        // Cria o diretório se ele não existir
        if (!dir.exists()) {
            dir.mkdirs();
        }

        int fileIndex = 1;
        String outputFileName;
        File file;

        // Gera nomes como outputData1.txt, outputData2.txt, e assim por diante
        do {
            outputFileName = outputDir + "outputData" + fileIndex + ".txt";
            file = new File(outputFileName);
            fileIndex++;
        } while (file.exists());  // Se o arquivo já existir, incrementa o índice

        return outputFileName;  // Retorna o nome do arquivo disponível
    }
}
