package org.example;

public class BubbleSort extends MostrarVetor{
    public static void sort(int[] vetor) {
        for(int i = vetor.length - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(vetor[j] > vetor[j+1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = temp;
                }
            }
        }

        mostrarVetor(vetor);
    }
}
