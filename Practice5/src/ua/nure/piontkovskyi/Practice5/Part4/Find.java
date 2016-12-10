package ua.nure.piontkovskyi.Practice5.Part4;


class Find {

    private int max;

    int getMax() {
        return max;
    }

    public int findMax(int[] columt) {
        max = columt[0];
        final int[] arr = columt;
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < arr.length; i++) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread() + "is interrupted");
                    }
                    if (arr[i] > max) {
                        max = arr[i];
                    }
                }
            }
        }).start();
        return max;
    }
}
