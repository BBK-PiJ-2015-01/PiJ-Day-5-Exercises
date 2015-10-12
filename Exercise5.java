public class Exercise5 {
	

			
	public static void main(String[] args) {
		
		new Exercise5().exercise5Runner();
	}
	
	private void exercise5Runner() {
		
		int base = 2;
		int maxExponent = 63;
		for (int exponent = 1; exponent <= maxExponent; exponent++ ){
			
			System.out.println(base + " raised to " + exponent + " = " + power(base,exponent));
		}
	}
	
	private long power(long base , long exponent) {
		
		return exponent == 1 ? base : base * power(base, exponent -1);
	}
}