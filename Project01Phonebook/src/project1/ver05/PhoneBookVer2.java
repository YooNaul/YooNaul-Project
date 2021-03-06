package project1.ver05;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import project1.ver01.PhoneCompanyInfo;
import project1.ver01.PhoneInfo;
import project1.ver01.PhoneSchoolInfo;


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
		try {
			Scanner scanner = new Scanner(System.in);
			
			while(true) {
				showMenu();
				
				int choice = scanner.nextInt();
				switch(choice) {
					case MenuItem.addPhone:
						scanner.nextLine();
						handler.addPhone(choice);
						break;
					case MenuItem.dataSearch:
						scanner.nextLine();
						handler.dataSearch();
						break;
					case MenuItem.dataDelete:
						scanner.nextLine();
						handler.dataDelete();
						break;
					case MenuItem.dataAllShow:
						scanner.nextLine();
						handler.dataAllShow();
						break;
					case MenuItem.exit:
						System.out.println("프로그램을 종료합니다.");
						return;
				}	
				
			}
		}
		catch(InputMismatchException e) {
			e.printStackTrace();
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
	}
}

