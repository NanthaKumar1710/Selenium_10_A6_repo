package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * @author S.Nantha
 */
public class ExcelUtility {
	/**
	 * this is the method read the data from excel file in string format
	 * @param sheetname
	 * @param rowindex
	 * @param colIndex
	 * @return string
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	
	public String getStringDataFromExcel(String sheetname,int rowindex,int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheetname).getRow(rowindex).getCell(colIndex).getStringCellValue();
		
	
	}
	/**
	 *  this is the method read the data from excel file in number format
	 * @param sheetname
	 * @param rowindex
	 * @param colIndex
	 * @return number
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getNumberDataFromExcel(String sheetname,int rowindex,int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		return (int) wb.getSheet(sheetname).getRow(rowindex).getCell(colIndex).getNumericCellValue();
	
	
	}
/**
 *  this is the method read the data from excel file in boolean format
 * @param sheetname
 * @param rowindex
 * @param colIndex
 * @return boolean
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public boolean getBooleanDataFromExcel(String sheetname,int rowindex,int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		return  wb.getSheet(sheetname).getRow(rowindex).getCell(colIndex).getBooleanCellValue();
	
	}
	/**
	 *  this is the method read the data from excel file in date and time format
	 * @param sheetname
	 * @param rowindex
	 * @param colIndex
	 * @return date and time
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public LocalDateTime getDateAndTimeDataFromExcel(String sheetname,int rowindex,int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		return  wb.getSheet(sheetname).getRow(rowindex).getCell(colIndex).getLocalDateTimeCellValue();
	

    }	
}
