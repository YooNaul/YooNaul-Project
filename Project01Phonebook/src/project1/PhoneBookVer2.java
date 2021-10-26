package project1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import project1.ver01.PhoneCompanyInfo;
import project1.ver01.PhoneInfo;
import project1.ver01.PhoneSchoolInfo;

class PhoneInfoHandler2 {
	ArrayList<PhoneInfo> lists;
	private PhoneInfo[] myPhone;
	
	private int numOfPhone;
	
	public PhoneInfoHandler2(int num) {
		lists = new ArrayList<PhoneInfo>();	
	}
	public void addPhone(int choice) {
		
		Scanner scan = new Scanner(System.in);
		String iName,iPhone,iMajor,iCompanyName;
		int iGrade;
		int iChoice;
		
		System.out.println("1.일반, 2.동창, 3.회사"); iChoice = scan.nextInt();
		scan.nextLine();
		
		System.out.println("이름:"); iName = scan.nextLine();
		System.out.println("전화번호:"); iPhone = scan.nextLine();
		
		lists.add(new PhoneInfo(iName, iPhone));
		
		if(iChoice==1) {
			lists.add(new PhoneInfo(iName, iPhone));
		}
		else if(iChoice==2) {
			
			System.out.print("전공:"); 
			iMajor = scan.nextLine();
			System.out.print("학년:"); 
			iGrade = scan.nextInt();

			lists.add(new PhoneSchoolInfo(iName, iPhone, iMajor, iGrade));
		}
		else if(iChoice==3) {
			System.out.println("회사:"); 
			iCompanyName = scan.nextLine();
			
			lists.add(new PhoneCompanyInfo(iName, iPhone, iCompanyName));
		}
		System.out.println("친구정보 입력이 완료되었습니다.");
		
		
		
		System.out.println("정보입력이 완료되었습니다.");
	}
	public void dataSearch() {
		
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();
		
		
		Iterator<PhoneInfo> itr = lists.iterator();
		while(itr.hasNext()) {
			PhoneInfo fr = itr.next();
			if(searchName.compareTo(itr.next().name)==0) {
				
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
public class PhoneBookVer2
{
	public static void showMenu() {
		System.out.println("1.데이터 입력");
		System.out.println("2.데이터 검색");
		System.out.println("3.데이터 삭제");
		System.out.println("4.주소록 출력");
		System.out.println("5.프로그램 종료");
	}
	
	public static void main(String[] args)
	{
		PhoneInfoHandler2 handler = new PhoneInfoHandler2(100);
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			showMenu();
			
			int choice = scanner.nextInt();
			switch(choice) {
			case 1:
				handler.addPhone(choice);
				break;
			case 2:
				handler.dataSearch();
				break;
			case 3:
				handler.dataDelete();
				break;
			case 4:
				handler.dataAllShow();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			}	
		}
			
	}
}

