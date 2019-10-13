package com.MultiThreadMatrix;

class MyThread implements Runnable
{
    int task;
    @Override
    public void run()
    {
        MultiThreadMatrix.threadCount++;
        while( (task = MultiThreadMatrix.getTask()) != -1 )
        {
            System.out.println("进程: "+Thread.currentThread().getName()+"\t开始计算第 "+(task+1)+"行");
            for(int i=0; i<MultiThreadMatrix.n; i++)
            {
                for(int j=0; j<MultiThreadMatrix.k; j++)
                {
                    MultiThreadMatrix.matrix3[task][i] += MultiThreadMatrix.matrix1[task][j] * MultiThreadMatrix.matrix2[j][i];
                }
            }
        }
        MultiThreadMatrix.threadCount--;
    }
}
