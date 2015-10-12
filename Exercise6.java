public class Exercise6 {

	private final String messageFormat = "To move %d discs requires %f moves";
	private final String notEvenMessageFormat = "%d is not a valid number of discs";
	
	public static void main(String[] args) {
		new Exercise6().exercise6Runner();
	}
	
	private void exercise6Runner() {
		
		for(int i = 2; i <= 58; i+=2) {
			System.out.println(String.format(messageFormat, i , + calculateMoves(i)));
		}
	}
	
	private double calculateMoves(int discsToMove) {
		
		if (discsToMove < 0 || discsToMove %2 != 0) {
			System.out.println(String.format(notEvenMessageFormat, discsToMove));
			return 0.0;
		}
		return calculateMovesRecursive(discsToMove) + 1;
	}
	
	private double calculateMovesRecursive(int discs) {
	
		return discs == 0 ? 0 : Math.pow(2, discs-1) + calculateMovesRecursive(discs -2);
	}
}