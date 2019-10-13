package com.MultiThreadMatrix;
import java.util.Date;

public class SingleThreadMatrix
{
    static int[][] matrix1;
    static int[][] matrix2;
    static int[][] matrix3;
    static int m,n,k;
    static long startTime;
    
    public static void main(String[] args)
    {
        m = 1100;
        n = 1100;
        k = 1100;
        matrix1 = new int[m][k];
        matrix2 = new int[k][n];
        matrix3 = new int[m][n];
        
        fillRandom(matrix1);
        fillRandom(matrix2);
        startTime = new Date().getTime();
        
        //输出a,b
//        printMatrix(matrix1);
//        printMatrix(matrix2);
        

        
        for(int task=0; task<m; task++)
        {
            System.out.println("进程: "+Thread.currentThread().getName()+"\t开始计算第 "+(task+1)+"行");
            for(int i=0; i<n; i++)
            {
                for(int j=0; j<k; j++)
                {
                    matrix3[task][i] += matrix1[task][j] * matrix2[j][i];
                }
            }
        }
        
//        printMatrix(matrix3);
        long finishTime = new Date().getTime();
        System.out.println("计算完成,用时"+(finishTime-startTime)+"毫秒");
    }

    static void fillRandom(int[][] x)
    {
        for (int i=0; i<x.length; i++)
        {
            for(int j=0; j<x[i].length; j++)
            {
                //每个元素设置为0到99的随机自然数
                x[i][j] = (int) (Math.random() * 100);
            }
        }
    }
}