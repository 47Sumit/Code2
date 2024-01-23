package onlineclass;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testng2 {
	@BeforeClass
	public void BC(){
		System.out.println("BC");	
	}
	@Test
	public void facebook() {
		System.out.println("facebbok");
	}
	
	@AfterClass
	public void Ac() {
		System.out.println("Ac");
	}
	

}
