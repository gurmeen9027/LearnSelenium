package Day9.FD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

public class dp_EMI {
	
	@DataProvider(name="dp_emi")
	public static  Iterator<Object[]> data_EMI() throws Exception{
		
		
		//Excel_ReadWrite ex = new Excel_ReadWrite("C:\\Users\\DELL\\Desktop\\EMI.xlsx");
		Excel_ReadWrite ex = new Excel_ReadWrite(System.getProperty("user.dir") + "/src/test/resources/EMI.xlsx");
		int rowcount = ex.getRowcount("Sheet1");
		int colcount = ex.getColcount("Sheet1");
		
		List<Object[]> ls = new ArrayList<Object[]>();
		
//		iterate thru each row
		for(int iRow=1;iRow<=rowcount;iRow++){
			
//			object array
			Object[] obj = new Object[1];
//			create a map
			Map<String, String> hm = new HashMap<String, String>();
			
//			column iteration
			for(int iCol=0;iCol<colcount;iCol++){
				
				String key=ex.readCellValue("Sheet1", 0, iCol);
				String val=ex.readCellValue("Sheet1", iRow, iCol);
				hm.put(key, val);
				
				System.out.println("hm = "+hm);
				
			}	//			column iteration	
			obj[0]=hm;
			System.out.println("obj = "+obj[0]);
			ls.add(obj);
			
		}//		iterate thru each row
		
		System.out.println("ls = "+ls);
		return ls.iterator();
		
		
	}
}
