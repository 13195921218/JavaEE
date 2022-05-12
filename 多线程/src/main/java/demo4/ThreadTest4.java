package demo4;

/**
 * 创建多线程的方式二:实现Runnable接口
 * 1.创建一个实现了Runnable接口的类
 * 2．实现类去实现Runnable中的抽象方法: run()
 * 3.创建实现类的对象
 * 4．将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5．通过Thread类的对象调用start()
 */

//1.创建一个实现了Runnable接口的类
class MThread implements Runnable{
    //2．实现类去实现Runnable中的抽象方法: run()
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}


public class ThreadTest4 {
    public static void main(String[] args) {
        //3.创建实现类的对象
        MThread thread = new MThread();
        //4．将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread thread1 = new Thread(thread);
        //5．通过Thread类的对象调用start()
        thread1.setName("线程一");
        thread1.start();
        Thread thread2 = new Thread(thread);
        thread2.setName("线程二");
        thread2.start();

        //
    }
}
