package com.ripper.budding.word;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

//读取excle
public class Excle {
	
	// demo.xlsx
	// public static void main(String[] args) {
	// HSSFWorkbook wb = null;
	// POIFSFileSystem fs = null;
	// try {
	// // 设置要读取的文件路径
	// fs = new POIFSFileSystem(new FileInputStream("d:\\book1.xls"));
	// // HSSFWorkbook相当于一个excel文件，HSSFWorkbook是解析excel2007之前的版本（xls）
	// // 之后版本使用XSSFWorkbook（xlsx）
	// wb = new HSSFWorkbook(fs);
	// // 获得sheet工作簿
	// HSSFSheet sheet = wb.getSheetAt(0);
	// // 获得行
	// HSSFRow row = sheet.getRow(3);
	// // 获得行中的列，即单元格
	// HSSFCell cell = row.getCell(0);
	// // 获得单元格中的值，这里该单元格的值为数字，所以使用getNumericCellValue，如为字符串则会报错
	// // 如何取别的值，见print2方法
	// double msg = cell.getNumericCellValue();
	// System.out.println(msg);
	// print1();
	// print2();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// }
	//
	// public static void print1() throws Exception {
	// InputStream is = new FileInputStream("d:\\book1.xls");
	// HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(is));
	// // A text extractor for Excel files.
	// // Returns the textual content of the file, suitable for indexing by
	// // something like Lucene,
	// // but not really intended for display to the user.
	// // 用来获得整个excel文件的内容，表示为字符串
	// ExcelExtractor extractor = new ExcelExtractor(wb);
	// // 字符串所包含的类型，详见api
	// extractor.setIncludeSheetNames(true);
	// extractor.setFormulasNotResults(false);
	// extractor.setIncludeCellComments(true);
	// // 获得字符串形式
	// String text = extractor.getText();
	// System.out.println(text);
	// }
	//
	// public static void print2() throws Exception {
	// HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream("d:\\book1.xls"));
	// HSSFSheet sheet = wb.getSheetAt(0);
	// }
}
