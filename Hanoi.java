public class Hanoi {
	
	public static void main(String[] args) {
		
		new Hanoi().hanoiRunner();
	}
	
	private void hanoiRunner() {

		int disc = 64;
		System.out.println("Tower of Hanoi with " + disc + " discs took " + hanoiRecurse(disc) + " moves");
		System.out.println("Swapping " + disc + " odd and even discs took " + swapEvenAndOddRecurse(disc) + " moves");

	}
	
	private double hanoiRecurse(int disc) {
		

		return disc ==1 ? 2 : hanoiRecurse(disc-1) * 3 + 2;
	}
	
	private double swapEvenAndOddRecurse(int disc) {

		return disc == 2 ? 4 : swapEvenAndOddRecurse(disc-2) * 9 + 4;
	}
}