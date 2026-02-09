public class ArrayUtils {
    //nos ayudará a ver si el arreglo esta ordenado, compara los sorts.

    //copia del arreglo original
    public static <T> T[] copyArray(T[] original){
        return original.clone();
    }

    //verificar si el arreglo esta ordenado
    public static <T extends Comparable<T>> boolean isSorted(T[] array){
        for(int i = 1; i < array.length; i++){
            if(array[i-1].compareTo(array[i]) > 0){
                return false;
            }
        }
        return true;
    }
}
