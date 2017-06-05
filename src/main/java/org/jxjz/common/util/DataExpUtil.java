package org.jxjz.common.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.jxjz.base.spring.BaseAction;
import org.jxjz.common.util.beans.BeanUtil;
import org.jxjz.framework.util.ConfigUtil;

/**
 *  
 * 
 * @author lihaijun 2011-05-18
 */
public class DataExpUtil extends BaseAction {
	/**
	 * 数据导出工具fs方法
	 * @param Title 列标题
	 * @param fields 导出字段
	 * @param list 数据类别 现在暂时支持map数据
	 * @param sheetName sheet名称
	 * @param fileName导出的文件名称
	 * @return
	 */
	public static void dataExpForMap(HttpServletResponse response,
			String[] Title, String[] fields,short[] widths, List list, String sheetName,
			String fileName) {
		SimpleDateFormat sdfmat=new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeStr=sdfmat.format(new Date());
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName);
		/*****标题栏样式******/
		HSSFCellStyle titleStyle = wb.createCellStyle();
		HSSFFont titleFont = wb.createFont();
		titleFont.setFontName("宋体");
		titleFont.setColor((short) 8);
		titleFont.setFontHeightInPoints((short) 10);
		titleFont.setBoldweight((short) 700);
		titleStyle.setAlignment((short) 2);
		titleStyle.setVerticalAlignment((short) 1);
		titleStyle.setBorderLeft((short) 1);
		titleStyle.setBorderRight((short) 1);
		titleStyle.setBorderTop((short) 1);
		titleStyle.setBorderBottom((short) 1);
		titleStyle.setFont(titleFont);
		/*****标题样式******/
		HSSFCellStyle sheetTitleStyle = wb.createCellStyle();
		HSSFFont sheetTitleFont = wb.createFont();
		sheetTitleFont.setFontName("宋体");
		sheetTitleFont.setColor((short) 8);
		sheetTitleFont.setFontHeightInPoints((short) 15);
		sheetTitleFont.setBoldweight((short) 1000);
		sheetTitleStyle.setAlignment((short) 2);
		sheetTitleStyle.setVerticalAlignment((short) 1);
		sheetTitleStyle.setBorderLeft((short) 1);
		sheetTitleStyle.setBorderRight((short) 1);
		sheetTitleStyle.setBorderTop((short) 1);
		sheetTitleStyle.setBorderBottom((short) 1);
		sheetTitleStyle.setFont(sheetTitleFont);
		
		sheet.setDefaultColumnWidth((short) 17);
		//设置sheet标题和创建时间
		HSSFRow sheetTitle = sheet.createRow(0);
		sheetTitle.setHeight((short) 500);
		HSSFCell sheetTitleCell=sheetTitle.createCell((short)0);
		sheetTitleCell.setCellValue("   创建时间："+sdf.format(new Date()));
		sheetTitleCell.setCellStyle(sheetTitleStyle);
		sheet.addMergedRegion(new Region(0, (short) 0, 0, (short) (fields.length - 1)));// 指定合并区域,前二个参数为开始处X,Y坐标.后二个为结束的坐标. 
		HSSFRow rowTitle = sheet.createRow(1);
		for (int i = 0; i < Title.length; i++) {
			String title = Title[i];
			HSSFCell cell = rowTitle.createCell((short) i);
			cell.setEncoding((short) 1);
			cell.setCellType(1);
			cell.setCellValue(title);
			cell.setCellStyle(titleStyle);
			sheet.setColumnWidth((short) i, (short) widths[i]);    
		}
		for (int i = 0; i < list.size(); i++) {
			Map resultitem = (Map) list.get(i);
			HSSFRow rowContext = sheet.createRow((short) i + 2);
			for (int j = 0; j < fields.length && fields.length > 0; j++) {
				String value = MapUtil.getMapValue(resultitem, fields[j]);
				HSSFCell cell = rowContext.createCell((short) j);
				cell.setEncoding((short) 1);
				cell.setCellType(1);
				cell.setCellValue(value);
			}
		}
		try {
			//压缩文件
			String save_dir =ConfigUtil.sys_export ;
			File f = new File(save_dir+File.separator+sheetName+timeStr+".xls");  
			OutputStream os = new FileOutputStream(f);  
			wb.write(os);  
			os.flush();  
			os.close(); 
			System.gc();
			StringBuilder uri = new StringBuilder();  
			uri.append(save_dir);  
			uri.append(File.separator+sheetName+".zip");  
			zipFile(save_dir,sheetName,f,fileName+".xls");
			downloadFile(response,uri,f,fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	  /**导出 
	  * @param response 
	  * @param fileName 
	  * @return 
	  * @throws IOException 
	  */  
	 public static void downloadFile(HttpServletResponse response,StringBuilder uri,File f,String zipname)   
	     throws IOException {  
	         StringBuffer filename = new StringBuffer();  
	         filename.append(uri);  
	         File file = new File(filename.toString());  
	         StringBuffer sb = new StringBuffer();  
	         sb.append("attachment;  filename=").append(zipname+".zip");  
	         response.setHeader("Expires", "0");  
	         response.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");  
	         response.setHeader("Pragma", "public");  
	         response.setContentType("application/x-msdownload;charset=UTF-8");  
	         response.setHeader("Content-Disposition", new String( sb.toString().getBytes(), "ISO8859-1"));  
	         //将此文件流写入到response输出流中  
	         FileInputStream inputStream = new FileInputStream(file);  
	         OutputStream outputStream = response.getOutputStream();   
	         byte[] buffer = new byte[1024];  
	         int i = -1;  
	         while ((i = inputStream.read(buffer)) != -1) {  
	             outputStream.write(buffer, 0, i);  
	         }   
	         outputStream.flush();  
	         outputStream.close();  
	         inputStream.close();   
	   }
	  /** 
	   * 将指定文件夹打包成zip 
	   * @param folder 
	   * @throws IOException  
	   */ 
	private static void zipFile(String folder,String zipName,File f,String fileName) throws IOException {  
		         File zipFile = new File(folder +File.separator+zipName+ ".zip");  
		         if (zipFile.exists()) {  
		             zipFile.delete();  
		         }  
		         ZipOutputStream zipout = new ZipOutputStream(new FileOutputStream(zipFile));
		         File dir = new File(folder);  
		         byte[] buf = null;  
                 zipout.putNextEntry(new ZipEntry(fileName));  
                 FileInputStream fileInputStream = new FileInputStream(f);  
                 buf = new byte[2048];  
                 BufferedInputStream origin = new BufferedInputStream(fileInputStream,2048);  
                 int len;  
                 while ((len = origin.read(buf,0,2048))!=-1) {  
                     zipout.write(buf,0,len);  
                 }  
                 zipout.flush();  
                 origin.close();  
                 fileInputStream.close();   
		         zipout.flush();  
		         zipout.close();  
	}
	/**
	 * 数据导出工具fs方法
	 * @param Title  列标题
	 * @param fields  导出字段
	 * @param list 数据类别 对象数据
	 * @param sheetName sheet名称
	 * @param fileName导出的文件名称
	 * @return
	 */
	public static void dataExpForObj(HttpServletResponse response,
			String[] Title, String[] fields, List list, String sheetName,String fileName) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName);
		HSSFCellStyle titleStyle = wb.createCellStyle();
		HSSFFont titleFont = wb.createFont();
		titleFont.setFontName("宋体");
		titleFont.setColor((short) 8);
		titleFont.setFontHeightInPoints((short) 10);
		titleFont.setBoldweight((short) 700);
		titleStyle.setAlignment((short) 2);
		titleStyle.setVerticalAlignment((short) 1);
		titleStyle.setBorderLeft((short) 1);
		titleStyle.setBorderRight((short) 1);
		titleStyle.setBorderTop((short) 1);
		titleStyle.setBorderBottom((short) 1);
		titleStyle.setFont(titleFont);
		sheet.setDefaultColumnWidth((short) 17);
		HSSFRow rowTitle = sheet.createRow(1);
		for (int i = 0; i < Title.length; i++) {
			String title = Title[i];
			HSSFCell cell = rowTitle.createCell((short) i);
			cell.setEncoding((short) 1);
			cell.setCellType(1);
			cell.setCellValue(title);
			cell.setCellStyle(titleStyle);
		}
		for (int i = 0; i < list.size(); i++) {
			Object o = (Object) list.get(i);
			HSSFRow rowContext = sheet.createRow((short) i + 2);
			for (int j = 0; j < fields.length && fields.length > 0; j++) {
				String value = BeanUtil.getBeanValueByFieldName(o, fields[j]);
				HSSFCell cell = rowContext.createCell((short) j);
				cell.setEncoding((short) 1);
				cell.setCellType(1);
				cell.setCellValue(value);
			}
		}
		try {
			response.setContentType("application/force-download");
			response.setHeader("Content-Disposition", "attachment; filename="
					+ new String(fileName.getBytes("gb2312"), "ISO-8859-1"));
			OutputStream os = response.getOutputStream();
			wb.write(os);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
