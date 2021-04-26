import java.util.List;

import com.javaking.excel.CustomerExcelReader;
import com.javaking.vo.CustomerVo;


public class MainApplication {
	
	public static void main(String[] args) {
		
		CustomerExcelReader excelReader = new CustomerExcelReader();
		
		/*System.out.println("*****xls*****");
		List<CustomerVo> xlsList = excelReader.xlsToCustomerVoList("C:\\Users\\Desktop\\xlsxTest.xlsx");
		printList(xlsList );*/
		
		System.out.println("*****xlsx*****");
		List<CustomerVo> xlsxList = excelReader.xlsxToCustomerVoList("C:\\Users\\KKJ\\Desktop\\xlsxTest.xlsx");
		printList(xlsxList );
	}
	
	public static void printList(List<CustomerVo> list) {
		CustomerVo vo;
		
		for (int i = 0; i < list.size(); i++) {
			vo = list.get(i);
			System.out.println(vo.toString());
		}
	}
}
