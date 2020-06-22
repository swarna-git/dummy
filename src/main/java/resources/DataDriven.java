package resources;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public static String[] Data() throws IOException
	{
		String[] s = null;
		ArrayList<String> a = new ArrayList<String>();
		HashMap<String,String> hs =new HashMap<String,String>();
		FileInputStream file = new FileInputStream("C://Users//sunde//OneDrive//Desktop//Excel_Data_FinalProject.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			if (workbook.getSheetAt(i).getSheetName().equalsIgnoreCase("login")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> row = sheet.iterator();
				Row firstrow = row.next();
				 Iterator<Cell> fcells=firstrow.cellIterator();
				 int c=0,k=0;
				 while(fcells.hasNext())
				 {
					Cell firstcell=fcells.next();
					 if(firstcell.getStringCellValue().trim().equalsIgnoreCase("username"))
					 {
				        c=k;		 
					 }
			      k++;
			
			}
				// System.out.println(c);	 
				while(row.hasNext())
				{
					Row srow=row.next();
					
					Iterator<Cell> scells=srow.cellIterator();
					scells.next();
					while(scells.hasNext())
					{
						Cell scell=scells.next();
						if(scell.getCellType()==CellType.STRING)
						{
							a.add(scell.getStringCellValue());
						}
						else
						{
							a.add(NumberToTextConverter.toText(scell.getNumericCellValue()));
						}
					}
					
				}
					
	    s=new String[10];
		s=a.toArray(s);
				 
		}
	}
		return s;
			
					
	}
	public static void main(String[] args) throws IOException
	{
		String[] s1=Data();
		System.out.println(Arrays.toString(s1));
	}

}
