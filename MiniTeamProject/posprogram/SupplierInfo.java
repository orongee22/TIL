package posprogram;

import util.*;

public class SupplierInfo{
	String name; // 거래처 이름
	String phoneNum; // 거래처 번호
	String address; // 거래처 주소
	String addInfo; // 거래처 추가정보
	
	SupplierInfo(String name, String phoneNum,String address, String addInfo) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.address = address;
		this.addInfo = addInfo;
	}
	
	SupplierInfo(String name, String phoneNum, String address){
		this(name,phoneNum,address,"-");
	}
	
	void showData(){
		System.out.println("거래처 이름: "+name);
		System.out.println("거래처 번호: "+phoneNum);
		System.out.println("거래처 주소: "+address);
		System.out.println("거래처 정보: "+addInfo);
	}
	
}