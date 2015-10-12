public class Exercise3 {

    private final double A0Length = 1189;
    private final double A0Width = 841;
    //
    private final String sizeMatcher = "^A[0-9]+";
    private final String sizeMatcherError = "'%s' is NOT a valid paper size";
    private final String sizeMsg = "Length = %fmm, width = %fmm: Area=%f";

    public static void main(String[] args) {

        new Exercise3().exercise3Runner();
    }

    private void exercise3Runner() {

        paperSize("A0");
        paperSize("A1");
        paperSize("A22");
    }

    private void paperSize(String paperSize) {

        if (!paperSize.matches(sizeMatcher)) {
            System.out.println(String.format(sizeMatcherError, paperSize));
            return;
        }
        int sizeIndex = Integer.parseInt(paperSize.substring(1));
        System.out.println("Generate paper size for " + paperSize);
        subdivide(sizeIndex, A0Length, A0Width);
    }

    private void subdivide(int index, double length, double width) {

        if (0 == index) {
            System.out.println(String.format(sizeMsg,  length, width, length * width));
            return;
        }
        subdivide(--index, width, length / 2);
    }
}

