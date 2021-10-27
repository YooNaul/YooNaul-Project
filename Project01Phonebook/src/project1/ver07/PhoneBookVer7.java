package project1.ver07;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;




public class PhoneBookVer7 
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
				if(choice<1 || choice>5) {
					MenuSelectException ex = new MenuSelectException();
					throw ex;
				}
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
		catch(MenuSelectException e) {
			System.out.println("1~5까지 입력하세요.");
		}
		catch(InputMismatchException e) {
			e.printStackTrace();
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
	}
	
}

