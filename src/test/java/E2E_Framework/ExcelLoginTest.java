package E2E_Framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginLoadingPage;
import pageObjects.LoginPage;
import resources.BaseClass;

public class ExcelLoginTest extends BaseClass{

		@BeforeTest
	public void initialize() throws IOException
	{
		driver=InitializeDriver();
		driver.get(prop.getProperty("url"));
		
	}
		@Test
	public void login() throws IOException
	{
		ExcelLoginTest demo=new ExcelLoginTest();
        ArrayList<String> list=new ArrayList<String>();
        list= demo.getData("login");
        LoginLoadingPage l=new LoginLoadingPage(driver);
    	l.SignIn().click();
    	LoginPage login=new LoginPage(driver);
    	login.email().sendKeys(list.get(1));
    	login.password().sendKeys(list.get(2));
    	login.submit().click();

      	}
     public ArrayList<String> getData(String testcase) throws IOException 
 	{
 		ArrayList<String> a=new ArrayList<String>();
 	FileInputStream f=new FileInputStream("C://Users//sunde//OneDrive//Desktop//ExcelDriven.xlsx");
 	XSSFWorkbook wb=new XSSFWorkbook(f);
 	int sheetCount=wb.getNumberOfSheets();
 	for(int i=0;i<sheetCount;i++)
 	{
 	if(wb.getSheetName(i).equalsIgnoreCase("sheet2"))
 			{
 		       XSSFSheet sheet=wb.getSheetAt(i);
 		       Iterator<Row> rows=sheet.iterator();
 		       Row firstrow=rows.next();
 		       Iterator<Cell> firstcell=firstrow.cellIterator();
 		       int k=0;
 		       int column=0;
 		       while(firstcell.hasNext())
 		       {
 		    	   Cell fc=firstcell.next();
 		    	   if(fc.getStringCellValue().equalsIgnoreCase("Testcase"))
 		    	   {
 		    		   column=k;
 		    		   break;
 		    	   }
 		    		   k++;
 		       }
 	
 		       while(rows.hasNext())
 		       {
 		    	   Row r=rows.next();
 		    	  if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcase))
 		    			  {
 		    		        Iterator<Cell> data=r.cellIterator();
 		    		        while(data.hasNext())
 		    		        {
 		    		        	Cell val=data.next();
 		    		        	if(val.getCellTypeEnum()==CellType.STRING)
 		    		        	{
 		    		        		a.add(val.getStringCellValue());
 		    		        		//System.out.println(val);
 		    		        	}
 		    		        	else
 		    		        	{
 		    		        		a.add(NumberToTextConverter.toText(val.getNumericCellValue()));
 		    		        	}
 		    		        }
 		    			  }
 		    	   
 		       }
 			}
 	
 	}return a;
 	
 		
 	}

     
     @AfterTest
 	public void teardown()
 	{
 		driver.close();
 		driver=null;
 	}
	}

