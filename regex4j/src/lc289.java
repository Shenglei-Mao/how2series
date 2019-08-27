import java.util.*;
import java.util.function.Consumer;

/**
 * @author : Michael M
 */
public class lc289 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        solution.gameOfLife(board);
        System.out.println(Arrays.deepToString(board));

        String s = "Hello.world";
        System.out.println(s.split("\\.")[0]);
        System.out.println(s.split("\\.")[1]);

        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        map.put("ada", list);
        map.forEach((Object k, List<Integer> v) -> {
            System.out.println(k);
            System.out.println(v);
            System.out.println(k instanceof String);
            v.add(1);
            System.out.println(v);
        });

        List<Integer> list0 = Arrays.asList(1, 2, 3);
        List<? extends Integer> list1 = new ArrayList<>(list0);
//        list1.add(1);
        System.out.println(list1.get(0));



    }

}


class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }

        //-1 for prev 1 but now 0, 2 for prev 0 but now 1
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                mark(board, i, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                remark(board, i, j);
            }
        }
    }

    private void remark(int[][] board, int i, int j) {
        if (board[i][j] == -1) {
            board[i][j] = 0;
        } else if (board[i][j] == 2) {
            board[i][j] = 1;
        }
    }

    private void mark(int[][] board, int i, int j) {
        int count = markHelper(board, i - 1, j - 1) +
            markHelper(board, i - 1, j) +
            markHelper(board, i - 1, i + 1) +
            markHelper(board, i, j - 1) +
            markHelper(board, i, j + 1) +
            markHelper(board, i + 1, j - 1) +
            markHelper(board, i + 1, j) +
            markHelper(board, i + 1, j + 1);
        if (count < 2) {
            board[i][j] = board[i][j] == 1? -1: 0;
        } else if (count == 2) {
            return;
        } else if (count == 3) {
            board[i][j] = board[i][j] == 1? 1: 2;
        } else {
            board[i][j] = board[i][j] == 1? -1: 0;
        }
    }

    private int markHelper(int[][]board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return 0;
        }
        if (board[i][j] == -1) {
            return 1;
        } else if (board[i][j] == 2) {
            return 0;
        }
        return board[i][j];
    }


}
