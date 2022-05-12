package downloaddemo1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ThreadDownloadFileTest extends Thread{
    private String url;
    private String name;

    public ThreadDownloadFileTest(String name, String url) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader downloader = new WebDownloader();
        downloader.downloader(url,name);
        System.out.println("下载的文件名称为：" + name);
    }


    public static void main(String[] args) {
        ThreadDownloadFileTest t1 = new ThreadDownloadFileTest("1.jpg", "https://pic.netbian.com/uploads/allimg/211122/000739-16375108599425.jpg");
        ThreadDownloadFileTest t2 = new ThreadDownloadFileTest("2.jpg","https://pic.netbian.com/uploads/allimg/220323/230503-164804790381c4.jpg");
        ThreadDownloadFileTest t3 = new ThreadDownloadFileTest("3.jpg","https://pic.netbian.com/uploads/allimg/220409/000014-1649433614abb5.jpg");
        t1.start();
        t2.start();
        t3.start();
    }
}


class WebDownloader{
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloaderIO异常！！！");
        }
    }
}
