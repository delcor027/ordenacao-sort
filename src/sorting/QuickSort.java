package sorting;

public class QuickSort {

    public static void sort(int[] array, int low, int high) {
        // Certifique-se de que estamos operando em um subarray válido
        if (low < high) {
            // Realiza a partição do array
            int pi = partition(array, low, high);

            // Evitar recursão infinita
            if (pi > low) {
                sort(array, low, pi - 1);  // Ordenar lado esquerdo
            }
            if (pi < high) {
                sort(array, pi + 1, high);  // Ordenar lado direito
            }
        }
    }

    private static int partition(int[] array, int low, int high) {
        // Escolhe o pivô como o mediano de três: primeiro, meio e último
        int mid = low + (high - low) / 2;
        int pivot = medianOfThree(array, low, mid, high);

        // Mover o pivô para a última posição temporariamente
        int pivotIndex = high;
        for (int i = 0; i <= high; i++) {
            if (array[i] == pivot) {
                pivotIndex = i;
                break;
            }
        }
        swap(array, pivotIndex, high);

        // Particiona o array com o pivô escolhido
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        // Mover o pivô de volta à posição correta
        swap(array, i + 1, high);

        return i + 1;  // Retorna o índice do pivô
    }

    private static int medianOfThree(int[] array, int low, int mid, int high) {
        int a = array[low];
        int b = array[mid];
        int c = array[high];

        if ((a > b) ^ (a > c)) {
            return a;
        } else if ((b > a) ^ (b > c)) {
            return b;
        } else {
            return c;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
