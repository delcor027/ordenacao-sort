package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    // Método para ler os números de um arquivo
    public static int[] readFromFile(String fileName) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            numbers.add(Integer.parseInt(line));
        }
        reader.close();
        return numbers.stream().mapToInt(i -> i).toArray();
    }

    // Método para escrever os números em um arquivo
    public static void writeToFile(int[] array, String fileName) throws IOException {
        // Verifica se o arquivo existe
        File file = new File(fileName);
        
        // Se o arquivo não existir, ele será criado
        if (!file.exists()) {
            System.out.println("Arquivo " + fileName + " não encontrado. Criando um novo arquivo...");
            file.createNewFile();  // Cria o arquivo
        } else {
            System.out.println("Arquivo " + fileName + " já existe.");
        }

        // Escreve os números no arquivo
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (int num : array) {
            writer.write(num + "\n");
        }
        writer.close();
    }
}
