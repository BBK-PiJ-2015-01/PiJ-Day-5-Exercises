public class Exercise7 {
	
	private final long maxDepth = 1000000;
	private long depth = maxDepth;
	private final String exceptionMessageFormat = "Caught exception after %d iterations";
			
	public static void main(String[] args) {
		
		new Exercise7().exercise7Runner();
	}
	
	private void exercise7Runner() {

		try {
	//		stackNoArgs();
			stackIntArg(1);
	//		stackLongArg(1L);
	//		stackStringArg("String");
		} catch (Throwable t) {
			System.out.println(String.format(exceptionMessageFormat, (maxDepth - depth)));
			System.out.println(t);
		}
	}
	
	private void stackNoArgs () {
		
		if (depth == 1) {
			return;
		}
		depth--;
		stackNoArgs();
	}
	
	private void stackIntArg (int arg) {
		
		if (depth == 1) {
			return;
		}
		int newArg = arg;
		depth--;
		stackIntArg(newArg);
	}
	
	private void stackLongArg (long arg) {
		
		if (depth == 1) {
			return;
		}
		depth--;
		stackLongArg(arg);
	}
	
	private void stackStringArg (String arg) {
		
		if (depth == 1) {
			return;
		}
		depth--;
		stackStringArg(arg);
	}
}