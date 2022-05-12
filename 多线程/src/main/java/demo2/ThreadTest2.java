package demo2;

/**
 * 练习：创建两个分线程，一个遍历偶数一个遍历奇数
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        //方式一：
        /*
        MyThread1 thread1 = new MyThread1();
        thread1.start();
        MyThread2 thread2 = new MyThread2();
        thread2.start();
         */
        //方式二：
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++){
                    if (i % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + "\t偶数：" + i);
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int j = 0; j <= 100; j++){
                    if (j % 2 != 0){
                        System.out.println(Thread.currentThread().getName() + "\t奇数：" + j);
                    }
                }
            }
        }.start();
    }
}
class MyThread1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i <= 100; i++){
                if (i % 2 == 0){
                    System.out.println(Thread.currentThread().getName() + "\t偶数：" + i);
                }
            }
        }
    }

    class MyThread2 extends Thread {
        @Override
        public void run() {
            for (int j = 0; j <= 100; j++){
                if (j % 2 != 0){
                    System.out.println(Thread.currentThread().getName() + "\t奇数：" + j);
                }
            }
        }
    }
