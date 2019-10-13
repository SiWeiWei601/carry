package com.MultiThreadMatrix;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 

public class Driver {
	public final static int M=1100;//定义常量：矩阵A的行数
	public final static int K=1100;//定义常量：矩阵A的列数，矩阵B的行数
	public final static int N=1100;//定义常量：矩阵B的列数
	final static int NUM_THREADS=2;//定义常量：线程数量
	private static int [][]A;//矩阵A
	private static int [][]B;//矩阵B
	private static int [][]C;//矩阵C
	//---------------------
	//驱动类构造方法
	public Driver(){
		A=new int[M][K];
		B=new int[K][N];
		C=new int[M][N];//A、B、C初始化
		fillRandom(A);//用0-99的随机数初始化矩阵A
		fillRandom(B);//用0-99的随机数初始化矩阵B
		for(int i=0;i<M;i++)
			for(int j=0;j<N;j++)
				C[i][j]=0;//将C矩阵全置零		
	}
	
	//-------------------
	//初始化方法：产生0-99的随机数初始化矩阵A、B
	private void fillRandom(int[][] A) {
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[i].length;j++)
				A[i][j]=(int)(Math.random()*100);
		}
	}
	
	//--------------------
	//串行矩阵乘法运算
	public static void singleThread(){
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				for(int k=0;k<K;k++)
					C[i][j]+=A[i][k]*B[k][j];
			}
		}
	}
	
	//----------------------
	//main函数
	public static void main(String[] args){
		new Driver();//新建一个驱动类对象
		
		//随机产生三组C矩阵位置信息，便于后面验证三种方法计算结果是否都正确
		int []rol=new int[3];
		int []col=new int[3];
		for(int i=0;i<rol.length;i++){
			rol[i]=(int)(Math.random()*M);
			col[i]=(int)(Math.random()*N);
		}
		
		
		
		
		for(int i=0;i<M;i++)
			for(int j=0;j<N;j++)
				C[i][j]=0;//将C矩阵全置零	
		//建立四个工作线程
		Thread []poolThreads=new Thread[NUM_THREADS];
		for(int i=0;i<NUM_THREADS;i++)
			poolThreads[i]=new Thread(new WorkThread(i,A,B,C));
		//建立线程池
		ExecutorService pool = Executors.newCachedThreadPool();
		long time5=System.currentTimeMillis();//记录开始时间
		for(int i=0;i<NUM_THREADS;i++)
			pool.execute(poolThreads[i]);//将四个工作线程放入线程池中执行
		pool.shutdown();//在线程池终止前允许执行以前提交的任务
		while (true) {  
            if (pool.isTerminated()) {   
                break;  
            }
        }//用一个死循环判断线程池是否执行完成
		long time6=System.currentTimeMillis();//记录结束时间
		//打印方法二使用的时间和矩阵C三个随机位置的值
		System.out.println("计算["+M+","+K+"]与["+K+","+N+"]阶矩阵乘法,线程池计算用时:"+(time6-time5)+"毫秒");
		System.out.println(C[rol[0]][col[0]]+" "+C[rol[1]][col[1]]+" "+C[rol[2]][col[2]]);
	}
}

