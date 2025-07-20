package org.example;

public class MergeSort extends MostrarVetor{

    public static void sort(int[] vetor, int esq, int dir) {
        int meio = (dir + esq)/2;
        if(esq < dir) {
            sort(vetor, esq, meio);
            sort(vetor, meio + 1, dir);
            intercalar(vetor, esq, meio, dir);
        }
    }

    private static void intercalar(int[] vetor, int esq, int meio, int dir) {
        int tamArray1, tamArray2, i, j, k;

        tamArray1 = meio - esq + 1;
        tamArray2 = dir - meio;

        int[] array1 = new int[tamArray1];
        int[] array2 = new int[tamArray2];


        for (i = 0; i < tamArray1; i++) {
            array1[i] = vetor[esq + i];
        }


        for (j = 0; j < tamArray2; j++) {
            array2[j] = vetor[meio + j + 1];
        }

        for (i = j = 0, k = esq; (i < tamArray1 && j < tamArray2); k++) {
            if (array1[i] <= array2[j])
                vetor[k] = array1[i++];
            else
                vetor[k] = array2[j++];
        }

        if (i == tamArray1)
            for (; k <= dir; k++) {
                vetor[k] = array2[j++];
            }
        else
            for (; k <= dir; k++) {
                vetor[k] = array1[i++];
            }
        mostrarVetor(array1);
        mostrarVetor(array2);
    }
}
