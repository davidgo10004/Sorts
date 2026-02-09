package sort;

/**
 * Implementación de Quick Sort.
 * Complejidad temporal:
 * - Peor caso: O(n²) cuando el pivot es siempre el peor
 * - Caso promedio: O(n log n)
 * - Mejor caso: O(n log n)
 * Complejidad espacial: O(log n) por la recursión
 */
public class QuickSort {
    
    /**
     * Ordena un arreglo usando Quick Sort (algoritmo divide y conquista).
     *
     * @param array arreglo a ordenar que implementa Comparable
     */
    public static <T extends Comparable<T>> void sort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        
        quickSort(array, 0, array.length - 1);
    }
    
    /**
     * Método recursivo que ordena el arreglo usando particiones.
     */
    private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
        if (low < high) {
            // Encuentra la posición del pivot después de particionar
            int pivotIndex = partition(array, low, high);
            
            // Ordena recursivamente los elementos antes y después del pivot
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }
    
    /**
     * Particiona el arreglo y retorna el índice del pivot.
     * Coloca elementos menores a la izquierda y mayores a la derecha del pivot.
     */
    private static <T extends Comparable<T>> int partition(T[] array, int low, int high) {
        // Selecciona el último elemento como pivot
        T pivot = array[high];
        
        // Índice del elemento más pequeño, indica la posición correcta del pivot
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor o igual al pivot
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                
                // Intercambia array[i] y array[j]
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        
        // Intercambia array[i+1] y array[high] (el pivot)
        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        
        return i + 1;
    }
}
