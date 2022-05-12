package demo1;

/**
 * 多线程的创建，方式一:继承于Thread类
 * 1．创建一个继承于Thread类的子类
 * 2．重写Thread类的run()
 * 3．创建Thread类的子类的对象
 * 4．通过此对象调用start()
 *
 *
 * 例子:遍历100以内的所有的偶数
 */


//1．创建一个继承于Thread类的子类
class MyThread extends Thread{
    @Override
    //2．重写Thread类的run()
    public void run() {
        for (int i = 0; i <= 100 ; i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+ ":" + i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        //3．创建Thread类的子类的对象
        MyThread myThread1 = new MyThread();
        //4．通过此对象调用start() ①启动当线程 ②调用当前线程得到run()
        myThread1.start();
        //demo1.MyThread.run();   问题一：不能通过直接调用run()方法启动线程
        //demo1.MyThread.start(); 问题二：再启动一个线程，不可以让已近运行的start()的线程去执行，会报IllegalThreadStateException()异常
        //我们需要重新再创建一个线程对象
        MyThread myThread2 = new MyThread();
        myThread2.start();
        for (int i = 0; i <= 100 ; i++){
            if (i % 2 == 0){
                System.out.println(i +"***********main***********");
            }
        }
    }
}
