package ru.miit.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class MatrixSubtraction implements IMatrixOperation {
    @Inject
    @Delegate
    private IMatrixOperation IMatrix;

    @Override
    public int[][] searcher(int[][] A, int[][] B) {
        int i,j;
        int[][] C;
        C = IMatrix.searcher(A, B);
        for (i = 0; i < A.length; i++) {
            for (j = 0; j < A[0].length; j++) {
                B[i][j]=-B[i][j];
            }
        }
        C = IMatrix.searcher(A, B);
        System.out.println("Вычитани матрицы B из A:");
        for (i = 0; i < A.length; i++) {
            for (j = 0; j < A[0].length; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
        return C;
    }
}
