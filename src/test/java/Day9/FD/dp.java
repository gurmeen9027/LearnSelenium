package Day9.FD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.testng.annotations.DataProvider;

public class dp {

	@DataProvider(name = "dp_Ecomm")
	public static Iterator<Object[]> loginCredentials() throws Exception {

		Excel_ReadWrite ex = new Excel_ReadWrite(System.getProperty("user.dir") + "/src/test/resources/Ecommerce.xlsx");
		int rowcount = ex.getRowcount("Sheet1");
		int colcount = ex.getColcount("Sheet1");

		ArrayList<Object[]> ls = new ArrayList<Object[]>();

		// Iterate through each row
		for (int iRow = 1; iRow < rowcount; iRow++) {

			Object[] obj = new Object[1];
			HashMap<String, String> hm = new HashMap<String, String>();

			for (int iCol = 0; iCol < colcount; iCol++) {

				String key = ex.readCellValue("Sheet1", 0, iCol);
				String value = ex.readCellValue("Sheet1", iRow, iCol);
				hm.put(key, value);
			}
			obj[0] = hm;
			ls.add(obj);

		}
		return ls.iterator();

	}
}
