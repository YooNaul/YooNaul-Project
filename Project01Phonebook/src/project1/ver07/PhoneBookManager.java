package project1.ver07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

 

class PhoneInfoHandler2 {
	
	HashSet<PhoneInfo> info;
	
	ArrayList<PhoneInfo> lists = new ArrayList<PhoneInfo>();
	
	
	public PhoneInfoHandler2(int num) {
		
		info = new HashSet<PhoneInfo>();
			
	}
	public void addPhone(int choice) {
		
		Scanner scan = new Scanner(System.in);
		String iName,iPhone,iMajor,iCompanyName;
		int iGrade;
		int iChoice;
		
		System.out.println("1.일반, 2.동창, 3.회사"); iChoice = scan.nextInt();
		scan.nextLine();
		
		PhoneInfo phoneIF = null;
		
		
		switch(iChoice) {
			case SubMenuItem.nomal:
				System.out.println("이름:"); iName = scan.nextLine();
				System.out.println("전화번호:"); iPhone = scan.nextLine();
				lists.add(new PhoneInfo(iName, iPhone));
				break;
			case SubMenuItem.school: 
				
				System.out.println("이름:"); iName = scan.nextLine();
				System.out.println("전화번호:"); iPhone = scan.nextLine();
				System.out.print("전공:"); iMajor = scan.nextLine();
				System.out.print("학년:"); iGrade = scan.nextInt();
	
				lists.add(new PhoneSchoolInfo(iName, iPhone, iMajor, iGrade));
				break;
			case SubMenuItem.company:
				System.out.println("이름:"); iName = scan.nextLine();
				System.out.println("전화번호:"); iPhone = scan.nextLine();
				System.out.println("회사:"); iCompanyName = scan.nextLine();
				
				lists.add(new PhoneCompanyInfo(iName, iPhone, iCompanyName));
				break;	
		}
		boolean overwrite = info.add(phoneIF);
		if(overwrite==false) {
			System.out.println("이미 저장된 데이터입니다.");
			System.out.println("덮어쓸까요? Y(y) / N(n) ");
			char choice2 = scan.next().charAt(0);
			if(choice2=='Y' || choice2=='y') {
				info.remove(phoneIF);
				info.add(phoneIF);
				System.out.println("입력한 정보가 저장되었습니다");
			}
			else if(choice2=='N' || choice2=='n') {
				lists.add(phoneIF);
			}
		}
		else {
			System.out.println("입력완료");
		}
		
			
		
		
		
		
		
		
	}
	public void dataSearch() {
		
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();
		
		
		Iterator<PhoneInfo> itr = lists.iterator();
		while(itr.hasNext()) {
			PhoneInfo fr = itr.next();
			if(searchName.compareTo(fr.name)==0) {
				
				fr.showPhoneInfo();
				System.out.println("##귀하가 요청하는 정보를 찾았습니다.##");
				isFind = true;
			}
		}
		if(isFind==false)
			System.out.println("***찾는 정보가 없습니다***");
	}
	public void dataAllShow() {
		for(int i=0 ; i<lists.size() ; i++) {
			lists.get(i).showPhoneInfo();
		}
		System.out.println("==전체정보가 출력되었습니다==");
	}
	public void dataDelete() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		
		int deleteIndex = -1;
		
		
		for(PhoneInfo fr : lists) {
			
			if(deleteName.compareTo(fr.name)==0) {
				lists.remove(fr);
				deleteIndex = 1;
				break;
			}
		}
		if(deleteIndex==-1) {
			
			System.out.println("==삭제된 데이터가 없습니다==");
		}
		else {
			System.out.println("==데이터가 삭제되었습니다==");
		}
	}
}

