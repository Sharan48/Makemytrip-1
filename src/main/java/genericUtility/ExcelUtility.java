package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
//	public String readExcel() throws Throwable{
//		FileInputStream fis=new FileInputStream("./Book1.xlsx");
//		Workbook book = WorkbookFactory.create(fis);
//		Sheet sht = book.getSheet("Sheet1");
//		for (int i = 0; i < sht.getLastRowNum(); i++) {
//			String data = sht.getRow(i).getCell(0).getStringCellValue();
//			return data;
//		}
//		
//	}
	
	public void setData(int count) throws Throwable{
		FileInputStream fis=new FileInputStream("./Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sht = book.getSheet("Sheet1");
		int lr = sht.getLastRowNum();
		int lc = sht.getRow(1).getLastCellNum();
		for (int i = 0; i < lr; i++) {
				Row r = sht.createRow(i+1);
				r.createCell(lc).setCellValue(count);
		}
		FileOutputStream fout=new FileOutputStream("./Book1.xlsx");
		book.write(fout);
	}

}
