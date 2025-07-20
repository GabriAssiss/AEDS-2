package org.example;

public class InsertSort extends MostrarVetor {

    public static void sort(int[] vetor) {
        for(int i = 1; i < vetor.length; i++) {
            int j = i;
            int temp = vetor[j];

            while(j > 0) {
                if(vetor[j] < vetor[j-1]){
                    vetor[j] = vetor[j-1];
                    vetor[j-1] = temp;
                }
                j--;
            }
        }
        mostrarVetor(vetor);
    }
}
