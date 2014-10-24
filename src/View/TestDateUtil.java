package View;

import java.util.Date;

public class TestDateUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = DateUtil.toString
				(new Date(), DateUtil.yyyyMMddHHmmss);
		System.out.println(s);
		System.out.println(new Date());
	}

}
