package project1.ver05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import project1.ver05.PhoneCompanyInfo;
import project1.ver05.PhoneInfo;
import project1.ver05.PhoneSchoolInfo;

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
		switch(choice) {
			case SubMenuItem.nomal:
				lists.add(new PhoneInfo(iName, iPhone));
			
			case SubMenuItem.school: 
				
				System.out.print("전공:"); 
				iMajor = scan.nextLine();
				System.out.print("학년:"); 
				iGrade = scan.nextInt();
	
				lists.add(new PhoneSchoolInfo(iName, iPhone, iMajor, iGrade));
			
			case SubMenuItem.company:
				System.out.println("회사:"); 
				iCompanyName = scan.nextLine();
				
				lists.add(new PhoneCompanyInfo(iName, iPhone, iCompanyName));
			
			System.out.println("친구정보 입력이 완료되었습니다.");
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
public class PhoneBookManager
{

	public static void main(String[] args)
	{
		

	}

	public void saveInfoTxt()
	{
		// TODO Auto-generated method stub
		
	}

}
