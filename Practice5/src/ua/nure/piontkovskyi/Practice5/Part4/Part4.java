package ua.nure.piontkovskyi.Practice5.Part4;

import java.util.Random;

public final class Part4 {

    private int[][] matrix = new int[4][100];

    private Part4() {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt();
            }
        }
    }

    private int getMaxWithoutParallelization() {
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread() + "is interrupted");
                }
                if (max < matrix[i][j]) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }

    private int getMaxWithParallelization() throws InterruptedException {
        Find[] maxValue = new Find[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            maxValue[i] = new Find();
            maxValue[i].findMax(matrix[i]);
        }
        int max = maxValue[0].getMax();
        for (int i = 1; i < maxValue.length; i++) {
            if (max < maxValue[i].getMax()) {
                max = maxValue[i].getMax();
            }
        }
        return max;
    }


    public static void main(String[] args) throws InterruptedException {
        Part4 first = new Part4();
        Part4 second = new Part4();

        System.out.println("====Without parallelization====");
        long start = System.currentTimeMillis();
        System.out.println("Max = " + first.getMaxWithoutParallelization());
        long end = System.currentTimeMillis();
        System.out.println("Time :" + (end - start));

        System.out.println("====With parallelization====");
        start = System.currentTimeMillis();
        System.out.println("Max = " + second.getMaxWithParallelization());
        end = System.currentTimeMillis();
        System.out.println("Time :" + (end - start));
    }
}
