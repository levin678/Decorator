package ru.miit.decorator;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import java.util.Random;


public class Lab2Start {
    protected static Weld weld;
    protected static WeldContainer container;

    public static void main(String args[]) throws Exception {
        weld = new Weld();
        container = weld.initialize();

        try {
            Random random = new Random();
            int size1 = random.nextInt(5)+2;//колличество столбцов матрицы
            int size2 = random.nextInt(5)+2;//колличество строк матрицы

            int i,j;
            System.out.println("Матрица A:");
            int[][] A = new int[size1][size2];
            for (i = 0; i < size1; i++) {
                for (j = 0; j < size2; j++) {
                    A[i][j]=random.nextInt(30)+1;//заполнение массива А
                    System.out.print(A[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("Матрица B:");
            int[][] B = new int[size1][size2];
            for (i = 0; i < size1; i++) {
                for (j = 0; j < size2; j++) {
                    B[i][j]=random.nextInt(30)+1;//заполнение массива В
                    System.out.print(B[i][j] + " ");
                }
                System.out.println();
            }

            OperationBean searcherBean = container.instance().select(OperationBean.class).get();
            searcherBean.stringSearch(A, B);

        } finally {
            weld.shutdown();
        }
    }
}
