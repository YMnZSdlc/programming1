package pl.kszafran.sda.algo.exercises.sorting;

public class SelectionSort implements IntSortingAlgorithm {

    @Override
    public void sort(int[] array) {
        for (int k = 0; k < array.length-1; k++) {
            int min = k;
            for (int i = k; i < array.length; i++) {
                if (array[min]>array[i]){
                    min=i;
                }
            }
            swap(array,min,k);
        }
//        throw new UnsupportedOperationException("Not implemented yet");
    }

    private void swap (int[] arrayToSwap, int a , int b){
        int tmp = arrayToSwap [a];
        arrayToSwap [a] = arrayToSwap [b];
        arrayToSwap [b] = tmp;
    }
}
