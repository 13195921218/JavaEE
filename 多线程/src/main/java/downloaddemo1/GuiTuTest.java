package downloaddemo1;

public class GuiTuTest implements Runnable {
    private static String winner;

    public void run() {
        for (int i = 0; i <= 100; i++) {

            if (Thread.currentThread().getName().equals("兔子") && i % 10 == 0){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean flag = gameOver(i);
            if (flag){
                break;
            }
            System.out.println(Thread.currentThread().getName() + "-->跑了" + i +"步！");
        }
    }


    public static void main(String[] args) {
        GuiTuTest guiTuTest = new GuiTuTest();
        new Thread(guiTuTest,"兔子").start();
        new Thread(guiTuTest,"乌龟").start();

    }

    private boolean gameOver(int steps) {
        if (winner != null){
            return true;
        }{
            if (steps >= 100){
                winner = Thread.currentThread().getName();
                System.out.println("winner is " + winner);
                return true;
            }
        }
        return false;
    }
}
