package ru.miit.decorator;

import javax.enterprise.inject.Default;

@Default
public class MatrixAddition implements IMatrixOperation {
    @Override
    public int[][] searcher(int[][] A, int[][] B) {
        int i,j,k;
        k=0;
        int[][] C = new int[A.length][A[0].length];

        for (i = 0; i < A.length; i++) {
            for (j = 0; j < A[0].length; j++) {
                C[i][j] = A[i][j]+B[i][j];
                if (C[i][j]<0){
                    k=1;
                }
            }
        }
        if (k==0) {
            System.out.println("Сумма двух матриц:");
            for (i = 0; i < A.length; i++) {
                for (j = 0; j < A[0].length; j++) {
                    System.out.print(C[i][j] + " ");
                }
                System.out.println();
            }
        }
        return C;
    }
}
