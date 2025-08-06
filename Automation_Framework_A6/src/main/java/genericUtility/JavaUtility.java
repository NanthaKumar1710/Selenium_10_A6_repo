package genericUtility;

import java.time.LocalDateTime;
import java.util.Random;
/**
 * @author S.Nantha
 */
public class JavaUtility {
	/**
	 * this method will give the current system date and time in string format
	 * @return string
	 * 
	 */
	public String getSystemTime() {
		return LocalDateTime.now().toString().replace(":", "-");
	}
	/**
	 * this method will return random number within 1000
	 * @return int
	 */
	public int getRandomNumber() {
		Random ran=new Random();
		return ran.nextInt(1000);
	}

}
