package org.example;

public class Main {
    public static void main(String[] args) {

        int[] vetorA = {55,34,25,67,3,8,3,9};
        int[] vetorB = {5,6,32,6,23,74,85,4};
        int[] vetorC = {2,1,7,6,5,4,3,8};


        //SelectSort.selectSort(vetorA);

        //InsertSort.insertSort(vetorA);

        //BubbleSort.bubbleSort(vetorB);

        //MergeSort.mergeSort(vetorA, 0, vetorA.length-1);

        HeapSort.heapSort(vetorC);
    }
}