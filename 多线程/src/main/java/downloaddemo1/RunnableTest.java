package downloaddemo1;

public class RunnableTest  implements Runnable{

    private int ticketNum = 10;
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ticketNum > 0){
                System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNum-- + "票");
            }
        }
    }

    public static void main(String[] args) {
        RunnableTest runnableTest = new RunnableTest();
        new Thread(runnableTest,"小明").start();
        new Thread(runnableTest,"小红").start(); ;
        new Thread(runnableTest,"黄牛").start();
    }
}
