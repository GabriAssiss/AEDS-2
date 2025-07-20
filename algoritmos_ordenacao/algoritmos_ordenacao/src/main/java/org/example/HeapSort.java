package org.example;

import java.util.Arrays;

public class HeapSort {

    public static void heapSort(int[] array) {
        int[] heap = new int[array.length+1];
        for(int i = 1; i < heap.length; i++) {
            heap[i] = array[i-1];
        }
        int tamHeap = heap.length;
        for(int i = tamHeap/2; i > 0; i--) {
            restaurar(heap, i, tamHeap);
        }

       int referencia = tamHeap-1;
       int indexMaior = 1;
       
       sort(heap, referencia, indexMaior, tamHeap);

        Arrays.stream(heap).forEach(System.out::println);
    }

    private static void restaurar(int[] heap, int index, int tamHeap) {
        int maior = heap[index];
        int esquerda = index*2;
        int direita = index*2+1;
        if(esquerda < tamHeap && maior < heap[esquerda]) {
            maior = heap[esquerda];
            troca(maior, heap, index, esquerda);
            restaurar(heap, esquerda, tamHeap);
        }
        if(direita < tamHeap && maior < heap[direita]) {
            maior = heap[direita];
            troca(maior, heap, index, direita);
            restaurar(heap, direita, tamHeap);
        }

    }

    private static void troca(int maior, int[] heap, int index, int j) {
        int temp;
        temp = heap[index];
        heap[index] = maior;
        heap[j] = temp;
    }

    private static void sort(int[] heap, int referencia, int index, int tamHeap) {
        int direita = index*2+1;
        int esquerda = index*2;
        int maior = heap[index];
        

    }
}
