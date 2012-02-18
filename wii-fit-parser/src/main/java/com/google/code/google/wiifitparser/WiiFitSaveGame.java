package com.google.code.google.wiifitparser;

import org.codehaus.preon.annotation.BoundList;
import org.codehaus.preon.annotation.BoundString;

public class WiiFitSaveGame {

	@BoundString(size = "8")
	String header;
	
	@BoundList(size="8") Player[] players;
}
