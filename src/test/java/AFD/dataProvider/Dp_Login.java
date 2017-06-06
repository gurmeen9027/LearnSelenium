package AFD.dataProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import AFD.commonLibrary.Excel_ReadWrite;


public class Dp_Login {
  
  @DataProvider(name="Valid_Login")
  public static Iterator<Object[]> data_Rediff() throws Exception{
	  Excel_ReadWrite ex = new Excel_ReadWrite(System.getProperty("user.dir") + "\\src\\test\\resources\\Rediff_TestData.xlsx");
		
		int rowcount = ex.getRowcount("Login");
		int colcount = ex.getColcount("Login");
		
		List<Object[]> ls = new ArrayList<Object[]>();
		
//		iterate thru each row
		for(int iRow=1;iRow<=rowcount;iRow++){
			String scriptname = ex.readCellValue("Login", iRow, 3).trim() ;
			String flag = ex.readCellValue("Login", iRow, 2).trim();
			if(scriptname.equalsIgnoreCase("validLogin") && flag.equalsIgnoreCase("Y")){
//			object array
			Object[] obj = new Object[1];
//			create a map
			Map<String, String> hm = new HashMap<String, String>();
			
//			column iteration
			for(int iCol=0;iCol<colcount;iCol++){
				
				String key=ex.readCellValue("Login", 0, iCol);
				String val=ex.readCellValue("Login", iRow, iCol);
				hm.put(key, val);
				System.out.println(hm);
				
				
			}	//			column iteration	
			obj[0]=hm;
			ls.add(obj);
						
			}
		}//		iterate thru each row
		
		
		return ls.iterator(); 
    
  }
  
  @DataProvider(name="InValid_Login")
	public static  Iterator<Object[]> data_invalid() throws Exception{		
		
		Excel_ReadWrite ex = new Excel_ReadWrite(System.getProperty("user.dir") + "\\src\\test\\resources\\Rediff_TestData.xlsx");
		
		int rowcount = ex.getRowcount("Login");
		int colcount = ex.getColcount("Login");
		
		List<Object[]> ls = new ArrayList<Object[]>();
		
//		iterate thru each row
		for(int iRow=1;iRow<=rowcount;iRow++){
			String scriptname = ex.readCellValue("Login", iRow, 3).trim() ;
			String flag = ex.readCellValue("Login", iRow, 2).trim();
			if(scriptname.equalsIgnoreCase("inValidLogin") && flag.equalsIgnoreCase("y")){
//			object array
			Object[] obj = new Object[1];
//			create a map
			Map<String, String> hm = new HashMap<String, String>();
			
//			column iteration
			for(int iCol=0;iCol<colcount;iCol++){
				
				String key=ex.readCellValue("Login", 0, iCol);
				String val=ex.readCellValue("Login", iRow, iCol);
				hm.put(key, val);
				
				
				
			}	//			column iteration	
			obj[0]=hm;
			ls.add(obj);
			}
		}//		iterate thru each row
		
		
		return ls.iterator();
		
		
	}
  
}
