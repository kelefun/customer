package customer.test;

import org.apache.commons.lang3.time.DateFormatUtils;

public class DateTest {

	public static void main(String[] args) {
		String dat=DateFormatUtils.format(1503504000000L, "yyyy-MM-dd HH:mm:ss");
		System.out.println(dat);
	}
}
