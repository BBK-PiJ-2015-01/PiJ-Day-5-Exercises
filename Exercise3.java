public class Exercise3 {

    private final double A0Length = 1189;
    private final double A0Width = 841;
	private final double A0Area = A0Length * A0Width;
    //
    private final String sizeMatcher = "^A[0-9]+";
    private final String sizeMatcherError = "'%s' is NOT a valid paper size";
    private final String sizeMsg = "Length = %fmm, width = %fmm: Area=%f";

    public static void main(String[] args) {

        new Exercise3().exercise3Runner();
    }

    private void exercise3Runner() {

		double result;
        result = paperSize("A0");		
		
        result = paperSize("A1");
		assert (result == (A0Area / Math.pow(2,1)));
        result = paperSize("A22");
		assert (result == (A0Area / Math.pow(2,22)));
    }

    private double paperSize(String paperSize) {

        if (!paperSize.matches(sizeMatcher)) {
            System.out.println(String.format(sizeMatcherError, paperSize));
            return 0;
        }
        int sizeIndex = Integer.parseInt(paperSize.substring(1));
        System.out.println("Generate paper size for " + paperSize);
        return subdivide(sizeIndex, A0Length, A0Width);
    }

    private double subdivide(int index, double length, double width) {

        if (0 == index) {
            System.out.println(String.format(sizeMsg,  length, width, length * width));
			return length * width;
		}
		return subdivide(--index, width, length / 2);						
    }
}

