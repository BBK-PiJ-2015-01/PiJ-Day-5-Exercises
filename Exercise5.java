public class Exercise5 {
	

			
	public static void main(String[] args) {
		
		new Exercise5().exercise5Runner();
	}
	
	private void exercise5Runner() {
		

	}
	
	private int power(int base , int exponent) {
		
		return
		return stringToTest != null && stringToTest.matches(regExpTest);
	}
		
	private void convertDecimal(String stringToConvert) {
		
		if (!testStringAsNumber(stringToConvert, numberRegExp)) {
			System.out.println(String.format(errorMessageFormat, stringToConvert, "decimal number"));
			return;
		}
		String hexValue = toHexString(stringToConvert);
		System.out.println(String.format(successMessageFormat, stringToConvert, (hexPrefix + hexValue)));
	}
	
	private String toHexString(String stringToConvert) {
		return Integer.toHexString(Integer.parseInt(stringToConvert));
	}
	
	private void convertHexadecimal(String stringToConvert) {
		
		if (!testStringAsNumber(stringToConvert, hexNumberRegExp)) {
			System.out.println(String.format(errorMessageFormat, stringToConvert, "hexadecimal number"));
			return;
		} 
		String intValue = toDecimalString(stringToConvert);
		System.out.println(String.format(successMessageFormat, stringToConvert, intValue));
	}
	
	private String toDecimalString(String stringToConvert) {
		
		return Integer.toString(Integer.parseInt(stringToConvert.substring(hexPrefix.length()), 16));
	}
}