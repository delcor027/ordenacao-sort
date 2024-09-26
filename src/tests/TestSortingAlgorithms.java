package tests;

import data.DataGenerator;
import sorting.*;
import java.util.Arrays;
import utils.Timer;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TestSortingAlgorithms {

    private static final Logger logger = Logger.getLogger(TestSortingAlgorithms.class.getName());

    public static void main(String[] args) throws IOException {
        // Configurar o logger para gravar em arquivo
        FileHandler fileHandler = new FileHandler("sorting_results.log", true); // O "true" é para não sobrescrever o arquivo
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        logger.addHandler(fileHandler);

        // Array de tamanhos a serem testados
        int[] sizes = {100000, 160000, 220000, 280000, 340000, 400000, 460000, 520000, 580000, 640000, 700000};
        Timer timer = new Timer();

        // Para cada tamanho no array sizes
        for (int size : sizes) {
            logger.info("Testando para " + size + " elementos:");

            // Inicializar acumuladores para somar os tempos de execução
            long sumCrescenteNoRepeticao = 0;
            long sumDecrescenteNoRepeticao = 0;
            long sumAleatorioNoRepeticao = 0;
            long sumCrescenteComRepeticao = 0;
            long sumDecrescenteComRepeticao = 0;
            long sumAleatorioComRepeticao = 0;

            // Executar cada teste 3 vezes para calcular a média
            for (int i = 0; i < 3; i++) {
                // Gerar dados para os 6 tipos
                int[] increasingDataNoRepetition = DataGenerator.generateIncreasingData(size);
                int[] decreasingDataNoRepetition = DataGenerator.generateDecreasingData(size);
                int[] randomDataNoRepetition = DataGenerator.generateRandomData(size);
                int[] increasingDataWithRepetition = DataGenerator.generateIncreasingDataWithRepetition(size);
                int[] decreasingDataWithRepetition = DataGenerator.generateDecreasingDataWithRepetition(size);
                int[] randomDataWithRepetition = DataGenerator.generateRandomDataWithRepetition(size);

                // Testar com Bubble Sort para Crescente sem repetição
                int[] dataCopy = Arrays.copyOf(increasingDataNoRepetition, increasingDataNoRepetition.length);
                timer.start();
                SelectionSort.sort(dataCopy);
                // QuickSort.sort(dataCopy, 0, dataCopy.length - 1);
                // MergeSort.sort(dataCopy, 0, dataCopy.length - 1);
                // Passando índice inicial e final caso seja QuickSort e MergeSort, se não o código não irá funcionar
                timer.stop();
                sumCrescenteNoRepeticao += timer.getElapsedTimeInMillis();

                // Testar com Bubble Sort para Decrescente sem repetição
                dataCopy = Arrays.copyOf(decreasingDataNoRepetition, decreasingDataNoRepetition.length);
                timer.start();
                SelectionSort.sort(dataCopy);
                timer.stop();
                sumDecrescenteNoRepeticao += timer.getElapsedTimeInMillis();

                // Testar com Bubble Sort para Aleatório sem repetição
                dataCopy = Arrays.copyOf(randomDataNoRepetition, randomDataNoRepetition.length);
                timer.start();
                SelectionSort.sort(dataCopy);
                timer.stop();
                sumAleatorioNoRepeticao += timer.getElapsedTimeInMillis();

                // Testar com Bubble Sort para Crescente com repetição
                dataCopy = Arrays.copyOf(increasingDataWithRepetition, increasingDataWithRepetition.length);
                timer.start();
                SelectionSort.sort(dataCopy);
                timer.stop();
                sumCrescenteComRepeticao += timer.getElapsedTimeInMillis();

                // Testar com Bubble Sort para Decrescente com repetição
                dataCopy = Arrays.copyOf(decreasingDataWithRepetition, decreasingDataWithRepetition.length);
                timer.start();
                SelectionSort.sort(dataCopy);
                timer.stop();
                sumDecrescenteComRepeticao += timer.getElapsedTimeInMillis();

                // Testar com Bubble Sort para Aleatório com repetição
                dataCopy = Arrays.copyOf(randomDataWithRepetition, randomDataWithRepetition.length);
                timer.start();
                SelectionSort.sort(dataCopy);
                timer.stop();
                sumAleatorioComRepeticao += timer.getElapsedTimeInMillis();
            }

            // Calcular as médias (somando os tempos de cada teste e dividindo por 3)
            long avgCrescenteNoRepeticao = sumCrescenteNoRepeticao / 3;
            long avgDecrescenteNoRepeticao = sumDecrescenteNoRepeticao / 3;
            long avgAleatorioNoRepeticao = sumAleatorioNoRepeticao / 3;
            long avgCrescenteComRepeticao = sumCrescenteComRepeticao / 3;
            long avgDecrescenteComRepeticao = sumDecrescenteComRepeticao / 3;
            long avgAleatorioComRepeticao = sumAleatorioComRepeticao / 3;

            // Gravar as médias no arquivo de log
            logger.info("Médias de tempo para " + size + " elementos:");
            logger.info("Selection Sort (Crescente sem Repetição): " + avgCrescenteNoRepeticao + " ms");
            logger.info("Selection Sort (Decrescente sem Repetição): " + avgDecrescenteNoRepeticao + " ms");
            logger.info("Selection Sort (Aleatório sem Repetição): " + avgAleatorioNoRepeticao + " ms");
            logger.info("Selection Sort (Crescente com Repetição): " + avgCrescenteComRepeticao + " ms");
            logger.info("Selection Sort (Decrescente com Repetição): " + avgDecrescenteComRepeticao + " ms");
            logger.info("Selection Sort (Aleatório com Repetição): " + avgAleatorioComRepeticao + " ms");
            logger.info("");
        }

        // Fechar o arquivo de log ao terminar
        fileHandler.close();
    }
}
