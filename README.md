# Projeto de Ordenação de Algoritmos

Este projeto implementa diferentes algoritmos de ordenação em Java, com foco na comparação de desempenho em diversos cenários de geração de dados. O objetivo é fornecer um ambiente flexível para gerar dados, aplicar algoritmos de ordenação e medir o tempo de execução.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

src/
├── data/
│   └── DataGenerator.java       # Gera diferentes tipos de conjuntos de dados
├── sorting/
│   ├── BubbleSort.java          # Implementação do Bubble Sort
│   ├── HeapSort.java            # Implementação do Heap Sort
│   ├── InsertionSort.java       # Implementação do Insertion Sort
│   ├── MergeSort.java           # Implementação do Merge Sort
│   ├── QuickSort.java           # Implementação do Quick Sort
│   └── SelectionSort.java       # Implementação do Selection Sort
├── tests/
│   ├── FileSorter.java          # Ordena arquivos de números e salva em diretórios
│   └── TestSortingAlgorithms.java # Testa os algoritmos com diferentes tamanhos e tipos de dados
├── utils/
│   ├── CustomFormatter.java     # Formata logs para resultados de teste
│   ├── FileHandler.java         # Lê e escreve arquivos de dados
│   └── Timer.java               # Mede o tempo de execução de algoritmos
└── Main.java                    # Interface principal para gerar dados, aplicar ordenação e salvar resultados

## Funcionalidades

### 1. Geração de Dados (DataGenerator.java)
O módulo `DataGenerator` permite gerar seis tipos diferentes de conjuntos de dados:
- **Crescente sem repetição:** Gera dados em ordem crescente sem valores duplicados.
- **Decrescente sem repetição:** Gera dados em ordem decrescente sem valores duplicados.
- **Aleatório sem repetição:** Gera dados aleatórios sem repetição.
- **Crescente com repetição:** Gera dados com repetição e os ordena em ordem crescente.
- **Decrescente com repetição:** Gera dados com repetição e os ordena em ordem decrescente.
- **Aleatório com repetição:** Gera dados aleatórios com repetição.

### 2. Algoritmos de Ordenação
Os seguintes algoritmos de ordenação foram implementados:
- **BubbleSort:** Ordenação simples que percorre repetidamente a lista, comparando elementos adjacentes e os trocando, se necessário.
- **HeapSort:** Utiliza a estrutura de heap para ordenar os elementos.
- **InsertionSort:** Insere elementos da lista em sua posição correta um por um.
- **MergeSort:** Algoritmo baseado na divisão e conquista que divide o array e depois o mescla.
- **QuickSort:** Um algoritmo eficiente de ordenação baseado na escolha de um pivô.
- **SelectionSort:** Seleciona repetidamente o menor elemento e o coloca em sua posição correta.

### 3. Teste de Algoritmos (TestSortingAlgorithms.java)
Este módulo permite a execução de diferentes algoritmos de ordenação em vários tamanhos de dados. Os resultados de tempo são registrados em um arquivo de log para cada tipo de dado e algoritmo.

### 4. Ordenação de Arquivos (FileSorter.java)
Este módulo lê dados de arquivos, executa os algoritmos de ordenação e grava os resultados em novos arquivos dentro de diretórios organizados por algoritmo.

### 5. Medição de Tempo (Timer.java)
A classe `Timer` mede o tempo de execução dos algoritmos em três formatos:
- Nanosegundos
- Milissegundos
- Segundos

### 6. Interface Principal (Main.java)
A classe `Main` oferece uma interface de linha de comando para:
- Selecionar o algoritmo de ordenação.
- Selecionar o tipo de dado a ser gerado.
- Definir o tamanho do conjunto de dados.
- Aplicar o algoritmo escolhido e exibir o tempo de execução.
- Salvar os resultados ordenados em arquivos.

## Como Usar

### Compilação
Para compilar todos os arquivos, execute o seguinte comando:

```bash
javac src/**/*.java
```

### Execução

Para executar o programa principal:

```bash
java -cp src Main
```

O usuário será solicitado a escolher um algoritmo de ordenação, um tipo de dado e o tamanho do conjunto de dados. O resultado será exibido no console e os dados ordenados serão salvos em um arquivo de saída.

### Testes Automatizados
Para rodar os testes dos algoritmos de ordenação:

```bash
java -cp src tests.TestSortingAlgorithms
```

Os resultados dos tempos de execução serão registrados no arquivo `sorting_results.log`.

### Diretórios e Arquivos de Saída

Os arquivos ordenados serão salvos no diretório `data/output/`, separados por algoritmo. Exemplos de arquivos gerados:

```bash
data/output/BubbleSort/sorted_numbers_BubbleSort.txt
data/output/QuickSort/sorted_numbers_QuickSort.txt
```

### Requisitos
- Java 8 ou superior
- Compilador Java
- Sistema de arquivos local

### Contribuições
Contribuições são bem-vindas. Sinta-se à vontade para abrir um _pull request_ ou relatar problemas no repositório.

### Contato
Para dúvidas ou sugestões, entre em contato pelo e-mail: [matheusdelcorbm@gmail.com](mailto:matheusdelcorbm@gmail.com)
