package com.google.code.wiifitparser;

import java.util.Date;

import org.codehaus.preon.annotation.BoundList;
import org.codehaus.preon.annotation.BoundNumber;
import org.codehaus.preon.annotation.BoundString;
import org.codehaus.preon.buffer.ByteOrder;

public class Player {

	@BoundString(size = "22", encoding = "UTF-16")
	String mii_name;

	@BoundNumber(size = "8")
	byte unknown1;

	@BoundNumber(size = "8")
	int heightInCm;

	@BoundNumber(size = "16", byteOrder = ByteOrder.BigEndian)
	int birthYearHex;
	@BoundNumber(size = "8", byteOrder = ByteOrder.BigEndian)
	int birthMonthHex;
	@BoundNumber(size = "8", byteOrder = ByteOrder.BigEndian)
	int birthDayHex;

	Date getBirthday() {
		try {
			int year = Integer.parseInt(Integer.toHexString(birthYearHex));
			int month = Integer.parseInt(Integer.toHexString(birthMonthHex));
			int day = Integer.parseInt(Integer.toHexString(birthDayHex));
			return MyTools.getDate(year, month, day);
		}
		catch(NumberFormatException e) {
			return null;
		}
	}

	@BoundString(size = "8+9")
	String unknown2;

	@BoundNumber(size = "8")
	byte idPart1;
	@BoundNumber(size = "8")
	byte idPart2;
	@BoundNumber(size = "8")
	byte idPart3;
	@BoundNumber(size = "8")
	byte idPart4;

	String getPlayerID() {
		return MyTools.getHexString(idPart1) + MyTools.getHexString(idPart2)
				+ MyTools.getHexString(idPart3) + MyTools.getHexString(idPart4);
	}

	// @BoundNumber(size="113*8") byte[] unknown2;
	@BoundString(size = "14432+7+1")
	String otherPlayerInfoDontCare;

	
	@BoundList(size="1096") BodyTest[] bodyTests;
}
	


	//@BoundNumber(size = "8")
	//byte date1;
	//@BoundNumber(size = "8")
	//byte date2;
	//@BoundNumber(size = "8")
	//byte date3;
	//@BoundNumber(size = "8")
	//byte date4;
	
	//Date getDate() {
	//	String s1 = MyTools.right(Integer.toBinaryString(date1), 8, '0');
	//	String s2 = MyTools.right(Integer.toBinaryString(date2), 8, '0');
	//	String s3 = MyTools.right(Integer.toBinaryString(date3), 8, '0');
	//	String s4 = MyTools.right(Integer.toBinaryString(date4), 8, '0');
	//
	//	int year = Integer.parseInt(s1 + s2.substring(0, 4), 2);
	//	int month = Integer.parseInt(s2.substring(4), 2) + 1; // zero based,
	//															// therefore +1
	//	int day = Integer.parseInt(s3.substring(0, 5), 2);
	//	int hour = Integer.parseInt(s3.substring(5) + s4.substring(0, 2), 2);
	//	int minute = Integer.parseInt(s4.substring(2), 2);
	//
	//	return MyTools.getDate(year, month, day, hour, minute);
	//}

	// @BoundNumber(size = "8") byte kg1;
	// @BoundNumber(size = "8") byte kg2;
	//
	// float getKg() {
	// Integer kgTimes10 = Integer.parseInt(MyTools.getHexString(kg1) +
	// MyTools.getHexString(kg2), 16);
	// return kgTimes10.floatValue()/10;
	// // return Integer.parseInt(MyTools.getHexString(kg1) +
	// MyTools.getHexString(kg2), 16) /10;
	// }

	// @BoundNumber(size = "8") byte bmi1;
	// @BoundNumber(size = "8") byte bmi2;

	// @BoundString(size = "2") String kgTimes10;
	// @BoundString(size = "2") String bmiTimes100;
	// @BoundString(size = "2") String rightBalanceTimes10;

	// @BoundNumber(size = "16")
	// int kgTimes10;
	//
	// @BoundNumber(size = "16")
	// int bmiTimes100;
	//
	// @BoundNumber(size = "16")
	// int balanceTimes10;

	// @BoundString(size="4") String birth;

	// @BoundNumber(size="1") int birth1;
	// @BoundNumber(size="1") int birth2;
	// @BoundNumber(size="1") int birth3;
	// @BoundNumber(size="1") int birth4;

	// public class Birthday {
	// @BoundNumber(size="8") int year1;
	// @BoundNumber(size="8") int year2;
	// @BoundNumber(size="8") int month;
	// @BoundNumber(size="8") int day;
	// }
	// @Bound Birthday birthday;

	// Date getBirthDate() {
	// String century = Integer.toHexString(birth1);
	// String year = Integer.toHexString(birth2);
	// String month = Integer.toHexString(birth3);
	// String day = Integer.toHexString(birth4);
	//
	// if(year.length() > 2)
	// year = year.substring(year.length()-2, year.length());
	// else if(year.length() == 1)
	// year = "0" + year;
	// if(month.length() == 1)
	// month = "0" + month;
	// if(day.length() == 1)
	// day = "0" + day;
	//
	// return century + year + "-" + month + "-" + day;
	// }
	
	// @BoundNumber(size = "8")
	// byte birth1;
	// @BoundNumber(size = "8")
	// byte birth2;
	// @BoundNumber(size = "8")
	// byte birth3;
	// @BoundNumber(size = "8")
	// byte birth4;

	// values below 10 must be filled with a zero (if wanted)
	// values above 64? (negative part) we must cut away the fffff stuff
	// Date getBirthDate() {
	// // return MyTools.getHexString(birth1) + MyTools.getHexString(birth2)
	// // + "-" + MyTools.getHexString(birth3) + "-"
	// // + MyTools.getHexString(birth4);
	//
	// int year = Integer.parseInt(MyTools.getHexString(birth1) +
	// MyTools.getHexString(birth2));
	// int month = Integer.parseInt(MyTools.getHexString(birth3));
	// int day = Integer.parseInt(MyTools.getHexString(birth4));
	//
	// return MyTools.getDate(year, month, day);
	// }
