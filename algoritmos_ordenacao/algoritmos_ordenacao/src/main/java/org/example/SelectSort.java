package org.example;

public class SelectSort extends  MostrarVetor{

    public static void sort(int[] vetor) {
        for(int i = 0; i < vetor.length-1; i++) {
          int posMenor = i;
          for(int j = i + 1; j < vetor.length; j++) {
              if (vetor[j] < vetor[posMenor]) {
                  posMenor = j;
              }
          }
            int temp = vetor[i];
            vetor[i] = vetor[posMenor];
            vetor[posMenor] = temp;
        }
        mostrarVetor(vetor);
    }
}
