public class Hanoi {
	
	public static void main(String[] args) {
		
		new Hanoi().hanoiRunner();
	}
	
	private void hanoiRunner() {

		int disc = 64;
		System.out.println(disc + " discs took " + hanoiRecurse(disc) + " moves");

	}
	
	private double hanoiRecurse(int disc) {
		
		if(disc ==1) {
			return 2;
		}
		return disc ==1 ? 2 : hanoiRecurse(disc-1) * 3 + 2;
	}
}