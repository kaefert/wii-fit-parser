package cc.kaefer.wiifitparser;

import java.util.Date;

import org.codehaus.preon.annotation.BoundNumber;
import org.codehaus.preon.annotation.BoundString;
import org.codehaus.preon.buffer.ByteOrder;

public class BodyTest {

	@BoundNumber(size = "12", byteOrder = ByteOrder.BigEndian)
	int year;
	@BoundNumber(size = "4", byteOrder = ByteOrder.BigEndian)
	int monthMinus1;
	@BoundNumber(size = "5", byteOrder = ByteOrder.BigEndian)
	int day;
	@BoundNumber(size = "5", byteOrder = ByteOrder.BigEndian)
	int hour;
	@BoundNumber(size = "6", byteOrder = ByteOrder.BigEndian)
	int minute;
	
	Date getDate() {
		return MyTools.getDate(year, monthMinus1+1, day, hour, minute);
	}
	

	@BoundNumber(size = "16", byteOrder = ByteOrder.BigEndian)
	int kgTimes10;
	
	float getKg() {
		return new Integer(kgTimes10).floatValue()/10;
	}
	
	@BoundNumber(size = "16", byteOrder = ByteOrder.BigEndian)
	int bmiTimes100;
	
	float getBmi() {
		return new Integer(bmiTimes100).floatValue()/100;
	}
	
	@BoundNumber(size = "16", byteOrder = ByteOrder.BigEndian)
	int balanceRightTimes10;
	
	float getBalanceRight() {
		return new Integer(balanceRightTimes10).floatValue()/10;
	}
	
	
	@BoundString(size = "4") String unknown3;
	
	@BoundNumber(size = "8") int wiiFitAge;
	
	@BoundString(size = "6") String unknown4;
	
}
