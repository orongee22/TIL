package ver04;

import util.Util;
public class PhoneInfoMain {

	public static void main(String[] args) {
		
		PhoneInfoManage pbManager = PhoneInfoManage.getInstance();
		
		while(true) {
			
			int choice = pbManager.printMenu();
			
			switch(choice) {
			case Util.INSERT:
				pbManager.insert();
				
				
				break;
			case Util.SEARCH:
				pbManager.searchPrint();
				break;
			case Util.DELETE:
				pbManager.searchDelete();
				break;
			case Util.ALLDATA:
				pbManager.showAllData();
				break;
			case Util.QUIT:
				System.out.println("종료");
				break;
	
			}
		}
	}

}
