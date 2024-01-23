package commonutils;

import java.util.Random;

public class JavaUtils {
	public int getrandomnumber() {
		Random r = new Random();
		int ran = r.nextInt(1000);
		return ran;
	}


}
