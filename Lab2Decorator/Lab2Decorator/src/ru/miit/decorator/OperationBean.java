package ru.miit.decorator;

import javax.inject.Inject;

public class OperationBean {

    @Inject
    private IMatrixOperation IMatrix;

    public void stringSearch(int[][] A, int[][] B) {
        IMatrix.searcher(A, B);
    }
}
