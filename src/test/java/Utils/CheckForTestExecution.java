package Utils;

import org.testng.SkipException;

public class CheckForTestExecution {
	public static void toCheckForTestExecution(String executionRequired) {

			if(executionRequired.equalsIgnoreCase("no")) {
				throw new SkipException("Skipping this exception");
			}
			
			// if execution required field is empty
			if(executionRequired.equalsIgnoreCase("")) {
				
				throw new SkipException("Skipping this exception");
			}
	}		
}
