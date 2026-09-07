class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
 
        // Paso 1: construir un max-heap con todo el arreglo.
        // Empezamos desde el último nodo con hijos (n/2 - 1) hacia atrás.
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }
 
        // Paso 2: extraer el máximo repetidamente y colocarlo al final.
        for (int i = n - 1; i > 0; i--) {
            swap(nums, 0, i);       // el máximo (raíz del heap) va a su posición final
            heapify(nums, i, 0);    // reparamos el heap con lo que queda (tamaño i)
        }
 
        return nums;
    }
 
    // Asegura que el subárbol con raíz en "i" cumpla la propiedad de max-heap,
    // asumiendo que sus subárboles izquierdo y derecho ya la cumplen.
    private void heapify(int[] arr, int tamano, int i) {
        int mayor = i;
        int izq = 2 * i + 1;
        int der = 2 * i + 2;
 
        if (izq < tamano && arr[izq] > arr[mayor]) mayor = izq;
        if (der < tamano && arr[der] > arr[mayor]) mayor = der;
 
        if (mayor != i) {
            swap(arr, i, mayor);
            heapify(arr, tamano, mayor); // el cambio pudo romper el heap más abajo
        }
    }
 
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 
}