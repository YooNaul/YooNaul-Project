package project1.ver07;

public class PhoneInfo
{
	public String name;//이름
	String phoneNumber;//전화번호 
	
	
	//3개의 매개변수를 가진 생성자
	public PhoneInfo(String name, String phoneNumber)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		
	}
	
	public void showPhoneInfo() 
	{
		System.out.println("이름:"+name);
		System.out.println("전화번호:"+phoneNumber);
		
	}
	@Override
	public boolean equals(Object obj)
	{
		PhoneInfo pInfo = (PhoneInfo)obj;
		
		if(name.compareTo(pInfo.name)==0) {
			return true;
		}
		else {
			return false;			
		}
	}
	@Override
	public int hashCode()
	{
		return name.hashCode();
	}
	
}


 
