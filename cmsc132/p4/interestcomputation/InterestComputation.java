package interestcomputation;

import java.text.NumberFormat;

public class InterestComputation {
	static String formatter;
	
	/* Simple Interest Computation */
	public static double simpleInterest(double principal, double rate, double years) {
		return (principal + principal * (rate/100) * years);
	}
	
	/* Display Simple Interest */
	public static String formattedSimpleInterest(double principal, double rate, double years) {
		return formattedInterest(simpleInterest(principal, rate, years));
	}	
	
	/* Simple Interest Table */
	public static String simpleInterestTable(double principal, double rate, double years) {
		String displaySimpleInterest = ""; 
		for (int i = 1; i <= years; i++) {
			displaySimpleInterest += "\n" + i + " --> " + 
					formattedSimpleInterest(principal, rate, i);
		}
		return displaySimpleInterest;
	}
	
	/* Compound Interest Computation */
	public static double compoundInterest(double principal, double rate, double years) {
		return (principal * Math.pow(1 + rate/100, years));
	}
	
	/* Display Compound Interest */
	public static String formattedCompoundInterest(double principal, double rate, double years) {
		return formattedInterest(compoundInterest(principal, rate, years));
	}
	
	/* Compound Interest Table */
	public static String compoundInterestTable(double principal, double rate, double years) {
		String displayCompoundInterest = "";
		for (int i = 1; i <= years; i++) {
			displayCompoundInterest += "\n" + i + " --> " + 
					formattedCompoundInterest(principal, rate, i);
		}
		return displayCompoundInterest;
	}
	
	/* Both Interests Table */
	public static String bothInterestsTable(double principal, double rate, double years) {
		String displayBothInterests = "";
		for (int i = 1; i <= years; i++) {
			displayBothInterests += "\n" + i + " --> " + 
					formattedSimpleInterest(principal, rate, i) + " --> " + 
					formattedCompoundInterest(principal, rate, i);
		}
		return displayBothInterests;
	}
	
	/* Display currency using NumberFormat class */
	private static String formattedInterest(double interest) {
		return formatter = NumberFormat.getCurrencyInstance().format(interest);
	}
}
