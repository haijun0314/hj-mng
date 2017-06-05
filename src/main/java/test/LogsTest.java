package test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletResponse;
import org.jxjz.base.spring.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//@Controller
//@RequestMapping("/log")
//public class LogsTest extends BaseAction {
//	
//	private long lastTimeFileSize = 0;  //上次文件大小
//	
//	 public void realtimeShowLog(File logFile) throws IOException{     
//	        //指定文件可读可写     
//	        final RandomAccessFile randomFile = new RandomAccessFile(logFile,"rw");     
//	        //启动一个线程每10秒钟读取新增的日志信息     
//	        ScheduledExecutorService exec =Executors.newScheduledThreadPool(1);     
//	        exec.scheduleWithFixedDelay(new Runnable(){     
//	            public void run() {     
//	                try {     
//	                    //获得变化内容     
//	                    randomFile.seek(lastTimeFileSize);     
//	                    String tmp = "";     
//	                    while( (tmp = randomFile.readLine())!= null) {     
//	                        System.out.println(new String(tmp.getBytes("UTF-8")));     
//	                    }     
//	                    lastTimeFileSize = randomFile.length();     
//	                } catch (IOException e) {     
//	                    throw new RuntimeException(e);     
//	                }     
//	            }     
//	        }, 0, 1, TimeUnit.SECONDS);     
//	    }     
//	
//	@RequestMapping(params = "showLog")
//	public void showLog(HttpServletResponse response) throws Exception {
//		Random rand = new Random();
//		PrintWriter writer = response.getWriter(); 
//		final File tmpLogFile = new File("d:\\test.log"); //读取变化的部分
//		realtimeShowLog(tmpLogFile);
//		// 死循环 查询有无数据变化
//		while (true) {
//			try {
//				FileInputStream inputStream = new FileInputStream("d:\\test.log");
//				int i = rand.nextInt(100); // 产生一个0-100之间的随机数
//				if (i>20&&i<56) { // 如果随机数在20-56之间就视为有效数据，模拟数据发生变化
//					writer.print("result: "+(char)inputStream.read());
//					//writer.print("result: "+realtimeShowLog(tmpLogFile));
//					break; // 跳出循环，返回数据
//				} else { // 模拟没有数据变化，将休眠 hold住连接
//					Thread.sleep(1300);
//				}
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//}