package sort;

/**
 * Implementación de Gnome Sort (Garden Gnome Sort).
 * Complejidad temporal:
 * - Peor caso: O(n²)
 * - Caso promedio: O(n²)
 * - Mejor caso: O(n) cuando ya está ordenado
 */
public class GnomeSort {
    
    /**
     * Ordena un arreglo usando Gnome Sort.
     * El algoritmo trabaja similar a como un gnomo de jardín ordena macetas.
     *
     * @param array arreglo a ordenar que implementa Comparable
     */
    public static <T extends Comparable<T>> void sort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        
        int index = 0;
        
        while (index < array.length) {
            if (index == 0) {
                index++;
            } else if (array[index].compareTo(array[index - 1]) >= 0) {
                // Si el elemento actual es mayor o igual al anterior, avanza
                index++;
            } else {
                // Si el elemento actual es menor, intercambia y retrocede
                T temp = array[index];
                array[index] = array[index - 1];
                array[index - 1] = temp;
                index--;
            }
        }
    }
}
