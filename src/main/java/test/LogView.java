//package test;
//import java.io.File;     
//import java.io.IOException;     
//import java.io.RandomAccessFile;     
//import java.util.concurrent.Executors;     
//import java.util.concurrent.ScheduledExecutorService;     
//import java.util.concurrent.TimeUnit;  
//public class LogView {
//	  private long lastTimeFileSize = 0;  //上次文件大小    
//	    /**   
//	     * 实时输出日志信息   
//	     * @param logFile 日志文件   
//	     * @throws IOException   
//	     */    
//	    public void realtimeShowLog(File logFile) throws IOException{ //定义方法realtimeShowLog    
//	        
//	        final RandomAccessFile randomFile = new RandomAccessFile(logFile,"rw"); 
//	        //启动一个线程每10秒钟读取新增的日志信息
//	       
//	        ScheduledExecutorService exec =Executors.newScheduledThreadPool(1); 
//	        
//	        exec.scheduleWithFixedDelay(new Runnable(){        
//	            public void run() { //定义了一个run方法，无返回值类型    
//	                try {     
//	                	lastTimeFileSize = randomFile.length(); //返回此文件的长度   
//	                    //获得变化部分的     
//	                	
//	                    randomFile.seek(lastTimeFileSize);    
//	                    //定义了一个String类型的tem为空
//	                    String tmp = ""; 
//	                    //randomFile.readLine从此文件读取文本的下一行
//	                    while( (tmp = randomFile.readLine())!= null){     
//	                        System.out.println(new String(tmp.getBytes("UTF-8"))); //打印tmp到控制台    
//	                    }     
//	                } catch (IOException e) {     
//	                    throw new RuntimeException(e);     
//	                }     
//	            }     
//	        }, 0, 1, TimeUnit.SECONDS);  //("0"初始延迟，“1”延迟，TimeUnit.SECONDS 延迟参数的时间单位 )
//	    }     
//	         
//	    public static void main(String[] args) throws Exception {     
//	        LogView view = new LogView();  //创建一个view对象
//	        final File tmpLogFile = new File("d:\\test.log"); //读取变化的部分    
//	        view.realtimeShowLog(tmpLogFile);     
//	    }     
//	    
//}
