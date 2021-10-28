package project1.ver08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.imageio.IIOException;

 

public class PhoneBookManager {
	
	HashSet<PhoneInfo> set = new HashSet<PhoneInfo>();
	
	
	
	
	public PhoneBookManager(int num) {	
		
	}
	public void addPhone(int choice) {
		
		Scanner scan = new Scanner(System.in);
		String iName,iPhone,iMajor,iCompanyName;
		int iGrade;
		int iChoice;
		
		System.out.println("1.일반, 2.동창, 3.회사"); iChoice = scan.nextInt();
		scan.nextLine();
		
		//PhoneInfo phoneInfo = null;
		boolean overwrite = true;
		PhoneInfo phoneInfo = null;
		
		switch(iChoice) {
			case SubMenuItem.nomal:
				System.out.println("이름:"); iName = scan.nextLine();
				System.out.println("전화번호:"); iPhone = scan.nextLine();
				phoneInfo = new PhoneInfo(iName, iPhone);
				overwrite = set.add(phoneInfo);
				break;
			case SubMenuItem.school: 
				
				System.out.println("이름:"); iName = scan.nextLine();
				System.out.println("전화번호:"); iPhone = scan.nextLine();
				System.out.print("전공:"); iMajor = scan.nextLine();
				System.out.print("학년:"); iGrade = scan.nextInt();
				phoneInfo = new PhoneSchoolInfo(iName, iPhone, iMajor, iGrade);
				overwrite = set.add(phoneInfo);
				break;
			case SubMenuItem.company:
				System.out.println("이름:"); iName = scan.nextLine();
				System.out.println("전화번호:"); iPhone = scan.nextLine();
				System.out.println("회사:"); iCompanyName = scan.nextLine();
				phoneInfo = new PhoneCompanyInfo(iName, iPhone, iCompanyName);
				overwrite = set.add(phoneInfo);
				break;	
		}
		if(overwrite==true) {
			System.out.println("입력완료");
		}
		else {
				System.out.println("이미 저장된 데이터입니다.");
				System.out.println("덮어쓸까요? Y(y) / N(n) ");
				String ans = scan.nextLine();
				if(ans.equalsIgnoreCase("Y")) {
					set.remove(phoneInfo);
					set.add(phoneInfo);
					System.out.println("입력한 정보가 저장되었습니다");
				}
				else {
					System.out.println("입력하신 정보는 저장되지 않습니다.");
				}
		}	
	}
	public void dataSearch() {
		
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();
		
		
		Iterator<PhoneInfo> itr = set.iterator();
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
		Iterator<PhoneInfo> iterSet = set.iterator();
		while(iterSet.hasNext()) {
			iterSet.next().showPhoneInfo();
		}
		System.out.println("==전체정보가 출력되었습니다==");
	}
	
	public void dataDelete() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		
		int deleteIndex = -1;
		
		
		for(PhoneInfo fr : set) {
			
			if(deleteName.compareTo(fr.name)==0) {
				set.remove(fr);
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
	public void dataSaveOption(AutoSaver sa) {
		Scanner scan = new Scanner(System.in);
		System.out.println("저장옵션을 선택하세요.");
		System.out.println("1.자동저장On, 2.자동저장off\n선택:");
		int menu = scan.nextInt();
		if(menu==1) {
			if(!sa.isAlive()) {
				sa.setDaemon(true);
				sa.start();
				System.out.println("자동저장을 시작합니다.");
			}
			else {
				System.out.println("이미 자동저장이 실행중입니다.");
			}
		}
		else if(menu==2) {
			if(sa.isAlive()) {
				sa.interrupt();
				System.out.println("자동저장을 종료합니다.");
			}
		}
		else {
			System.out.println("메뉴를 잘못입력하셨습니다.");
		}
	}
	
	public void savePhoneBook() {
		try {
			ObjectOutputStream out = 
					new ObjectOutputStream(
							new FileOutputStream(
									"src/project1/ver08/PhoneBook.obj"));
			
			for (PhoneInfo phoneInfo : set) {
				out.writeObject(phoneInfo);
			}
			out.close();
		}
		catch (Exception e) {
			System.out.println("예외 발생");
			e.printStackTrace();
		}
		System.out.println("저장 완료");
	}
	
	public void roadPhoneBook() {
		try {
			ObjectInputStream in = 
					new ObjectInputStream(
							new FileInputStream(
									"src/project1/ver08/PhoneBook.obj"));
			
			while (true) {
				PhoneInfo phoneInfo = (PhoneInfo)in.readObject();
				set.add(phoneInfo);
				if(phoneInfo == null) break;
			}
			in.close();
		}
		catch (Exception e) {
			System.out.println("예외발생");
		}
		System.out.println("완료");
	}
	
	

	
	
}

