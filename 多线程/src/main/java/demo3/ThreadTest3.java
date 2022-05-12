package demo3;

/**
 * 测试Thread中的常用方法:
 * 1. start):启动当前线程;调用当前线程的run()
 * 2. run()︰通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3. currentThread():静态方法，返回执行当前代码的线程
 * 4. getName():获取当前线程的名字
 * 5. setName():设置当前线程的名字
 * 6. yield():释放当前CPU的执行权
 * 7. join():在线程a中调用线程b的join(),此时线程a进入阻塞状态，知道线程b完全执行完成后，线程a才结束阻塞状态
 * 8. stop():已过时，强制结束当前线程
 * 9. sleep():让当前线程睡眠指定的millis毫秒
 * 10.isAlive():判断当前线程是否存活
 *
 * 线程的优先级
 * MIN_PRIORITY = 1
 * NORM_PRIORITY = 5 →默认
 * MAX_PRIORITY = 10
 *
 * getPriority()：获取优先级
 * setPriority()：设置优先级
 */

class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + ":优先级" + getPriority() + ":" + i);
            }
            if (i % 20 == 0){
                yield();
            }
        }
    }
}


public class ThreadTest3 {
    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1();
        thread1.setName("线程一");
        thread1.start();

        Thread.currentThread().setName("主线程");
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            if (i == 20){
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(thread1.isAlive());

    }
}
