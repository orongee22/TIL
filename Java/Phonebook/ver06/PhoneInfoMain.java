package ver06;

import util.Util;
import util.Select;
public class PhoneInfoMain{

	public static void main(String[] args) {
		
		PhoneInfoManage pbManager = PhoneInfoManage.getInstance();
		
		while(true) {
			
			int choice = pbManager.printMenu();
			
			switch(choice) {
			case Select.INSERT:
				pbManager.insert();
				
				break;
			case Select.SEARCH:
				pbManager.searchPrint();
				break;
			case Select.DELETE:
				pbManager.searchDelete();
				break;
			case Select.MODIFY:
				pbManager.modifyData();
				break;
			case Select.PRINT:
				pbManager.showAllData();
				break;
			case Select.QUIT:
				System.out.println("종료");
				return;
	
			}
		}
	}

}
