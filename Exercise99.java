
import java.util.HashMap;
import java.util.Map;

public class Exercise99 {

    private boolean[][] board = new boolean[8][8];
    private boolean[][] visited = new boolean[8][8];
    private final int damesRequired = 8;
    private int damesCount = 0;
    private long solutions = 0;
    private final Map<String, Boolean> solutionsMap = new HashMap<>();
    //
//    private final String locationValueMsgFormat = "Location [%d,%d] is %b.";
    private final String locationValueMsgFormat = "[%d,%d]";

    public static void main(String[] args) {

        new Exercise99().exercise99Runner();
    }

    private void exercise99Runner() {

        for (int outer = 0; outer < board.length; outer++) {
            for (int inner = 0; inner < board[outer].length; inner++) {
                initBoard();
                initVisited();
                Point startPoint = new Point(outer, inner);
//                System.out.println("Starting at [" + startPoint.getRow() + "][" + startPoint.getColumn() + "]");
                occupyPoint(startPoint);
                recurseOverBoard(startPoint);
            }
        }

        for (String solution: solutionsMap.keySet()) {
            System.out.println(solution);            
        }
        System.out.println(solutionsMap.keySet().size() + " solutions found");
    }

    private void recurseOverBoard(Point point) {

        if (point == null) {
            return;
        }
        visited[point.getRow()][point.getColumn()] = true;
//        Point[] nextPoints = getNextPath(point);
        Point[] nextPoints = getAdjacentLocations(point);
//        System.out.println(nextPoints.length + " paths to follow");
        for (Point nextPoint : nextPoints) {
            if (nextPoint == null) {
                continue;
            }
//            System.out.println("Next point is [" + nextPoint.getRow() + "][" + nextPoint.getColumn() + "]");
            if (freeLocation(nextPoint)) {
                occupyPoint(nextPoint);
                if (damesCount == damesRequired) {
                    solutions++;
                    displayBoard();
                    clearPoint(nextPoint);
                    continue;
                }
            }
            recurseOverBoard(nextPoint);
            clearPoint(nextPoint);
        }
    }

    private void occupyPoint(Point point) {

        if (point != null && !board[point.getRow()][point.getColumn()]) {
            board[point.getRow()][point.getColumn()] = true;
//            System.out.println("[" + point.getRow() + "][" + point.getColumn() + "] now occupied");
//            System.out.println("Dames count is now " + ++damesCount);
            damesCount++;
        }
    }

    private void clearPoint(Point point) {

        if (point != null && board[point.getRow()][point.getColumn()]) {
            board[point.getRow()][point.getColumn()] = false;
//            System.out.println("Dames count is now " + --damesCount);
//            System.out.println("[" + point.getRow() + "][" + point.getColumn() + "] cleared");
            damesCount--;
        }
    }

    private boolean freeLocation(Point point) {

        if (point == null) {
            return false;
        }
        // Check surrounding squares for occupancy
        // Up and down
        if ((point.getRow() > 0 && board[point.getRow() - 1][point.getColumn()]) || (point.getRow() < 7 && board[point.getRow() + 1][point.getColumn()])) {
            return false;
        }
        // Left and right
        if ((point.getColumn() > 0 && board[point.getRow()][point.getColumn() - 1]) || (point.getColumn() < 7 && board[point.getRow()][point.getColumn() + 1])) {
            return false;
        }
        // Diagonals
        if ((point.getRow() > 0 && point.getColumn() > 0) && board[point.getRow() - 1][point.getColumn() - 1]) {
            return false;
        }
        if ((point.getRow() > 0 && point.getColumn() < 7) && board[point.getRow() - 1][point.getColumn() + 1]) {
            return false;
        }
        if ((point.getRow() < 7 && point.getColumn() > 0) && board[point.getRow() + 1][point.getColumn() - 1]) {
            return false;
        }
        if ((point.getRow() < 7 && point.getColumn() < 7) && board[point.getRow() + 1][point.getColumn() + 1]) {
            return false;
        }
        return true;
    }

    private Point[] getAdjacentLocations(Point start) {

        Point[] returnValue = new Point[8];
        int arrayIndex = 0;

        for (int row = start.getRow() - 1; row <= start.getRow() + 1; row++) {
            for (int column = start.getColumn() - 1; column <= start.getColumn() + 1; column++) {
                if (row == start.getRow() && column == start.getColumn()) {
                    continue;
                }
//                System.out.println("Row: " + row + " Column: " + column);
                if (row >= 0 && row <= 7 && column >= 0 && column <= 7) {
                    if (!visited[row][column]) {
                        returnValue[arrayIndex++] = new Point(row, column);
                    }

                }
            }
        }
        return returnValue;
    }

    private Point[] getNextPath(Point start) {

        Point[] returnValue = new Point[3];
        int arrayIndex = 0;

        if (start.getRow() < 7 && start.getColumn() == 7) {
            returnValue[arrayIndex++] = new Point(start.getRow() + 1, start.getColumn());
        }
        if (start.getRow() == 7 && start.getColumn() < 7) {
            returnValue[arrayIndex++] = new Point(start.getRow(), start.getColumn() + 1);
        }
        if (start.getRow() < 7 && start.getColumn() < 7) {
            returnValue[arrayIndex++] = new Point(start.getRow(), start.getColumn() + 1);
            returnValue[arrayIndex++] = new Point(start.getRow() + 1, start.getColumn());
            returnValue[arrayIndex++] = new Point(start.getRow() + 1, start.getColumn() + 1);
        }
        return returnValue;
    }

    private void displayBoard() {

        StringBuilder sb = new StringBuilder();
        for (int outer = 0; outer < board.length; outer++) {
            for (int inner = 0; inner < board[outer].length; inner++) {

                if (board[outer][inner]) {
                    sb.append("[").append(outer).append(",").append(inner).append("]");
//                    System.out.print(String.format(locationValueMsgFormat, outer, inner, board[outer][inner]));
                }

            }
        }
//        System.out.println("");
        solutionsMap.put(sb.toString(), Boolean.TRUE);
//        System.out.println(sb.toString());

    }

    private void initBoard() {

        board = new boolean[8][8];
        damesCount = 0;
    }

    private void initVisited() {

        visited = new boolean[8][8];
    }

    class Point {

        private final int row;
        private final int column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

        @Override
        public String toString() {

            return "Point[" + row + "]]" + column + "]";
        }

    }
}

