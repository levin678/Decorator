package ru.miit.decorator;

import java.util.Random;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;


@Decorator
public class MatrixMultiplication implements IMatrixOperation {
    @Inject
    @Delegate
    private IMatrixOperation IMatrix;

    @Override
    public int[][] searcher(int[][] A, int[][] B) {
        Random random = new Random();
        int h = random.nextInt(9)+1;
        int i,j;
        int[][] C;
        C=IMatrix.searcher(A, B);
        System.out.println("Число на котрое умножется матрица = "+h);
        for (i = 0; i < A.length; i++) {
            for (j = 0; j < A[0].length; j++) {
                C[i][j]=h*C[i][j];
            }
        }
        System.out.println("Умножение результат матрицы на число "+h+":");
        for (i = 0; i < A.length; i++) {
            for (j = 0; j < A[0].length; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
        return C;
    }
}
