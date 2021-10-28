package project1.ver08;

import java.io.FileWriter;
import java.io.PrintWriter;

import project1.ver08.PhoneBookManager;

public class AutoSaver extends Thread
{
	PhoneBookManager pm;
	
	public AutoSaver(PhoneBookManager pm) {
		this.pm = pm;
	}
	
	@Override
	public void run()
	{
		try {
			while(true) {
				PrintWriter out = new PrintWriter(
						new FileWriter("src/project1/ver08/PhoneBook.txt"));
				
				for(PhoneInfo phoneInfo : pm.set) {
					System.out.println(phoneInfo.toString());
				}
				out.close();
				sleep(5000);
			}
				
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
