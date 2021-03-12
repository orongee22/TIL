package ver05;

import util.Util;
public class PhoneInfoMain implements selectNum {

	public static void main(String[] args) {
		
		PhoneInfoManage pbManager = PhoneInfoManage.getInstance();
		
		while(true) {
			
			int choice = pbManager.printMenu();
			
			switch(choice) {
			case INSERT:
				pbManager.insert();
				
				break;
			case SEARCH:
				pbManager.searchPrint();
				break;
			case DELETE:
				pbManager.searchDelete();
				break;
			case PRINT:
				pbManager.showAllData();
				break;
			case QUIT:
				System.out.println("종료");
				break;
	
			}
		}
	}

}
