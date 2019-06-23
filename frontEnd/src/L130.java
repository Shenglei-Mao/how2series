import java.util.Arrays;


class L130 {
    /*
        DFS
    */
    public static char[][] visiting_map;
    public static char[][] mark_map;
    public static char[][] board;
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        this.visiting_map = new char[board.length][board[0].length];
        this.mark_map = new char[board.length][board[0].length];
        this.board = board;

        //initialize the mark_map
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                mark_map[i][j] = '0';
            }
        }
        //first mark the boundary, "1" - means needs to be 'O' and "0" - means 'X'
        mark_boundary();
        System.out.println("Mark_map after mark_boundary function call:" + "\n" + Arrays.deepToString(mark_map));

        //go through the middle pixels one by one and using dfs to find out the it's mark
        for (int r = 1; r < board.length - 1; r++){
            for (int c = 1; c < board[0].length - 1; c++){
                if (board[r][c] == 'O') {

                    mark_map[r][c] = dfs(r, c);
                }

            }
        }

        //generate the answer by the marked map
        System.out.println("Mark_map after the dps algorithm" + "\n" + Arrays.deepToString(mark_map));
        System.out.println("Visited_map after the dps algorithm" + "\n" + Arrays.deepToString(visiting_map));
        for (int r = 1; r < board.length - 1; r++) {
            for (int c = 1; c < board[0].length - 1; c++) {

                if (board[r][c] == 'O' && mark_map[r][c] == '0') {
                    board[r][c] = 'X';
                }
            }
        }
        System.out.println("The final result is: " + "\n" + Arrays.deepToString(board));
    }

    private char dfs(int r, int c){  //'1' - should stay 0, no flip, '0' need a flip
        //check if at the boundary
        if (r == 0 || r == board.length - 1 || c == 0 || c == board[0].length - 1){
            return mark_map[r][c];
        }

        //check if the pixel is 'X'
        if (board[r][c] == 'X'){
            return '0';
        }

        //check if visiting
        if (visiting_map[r][c] == '1'){
            return '0';
        }


        visiting_map[r][c] = '1';



        //val == 1 means this pixel connect to a 'O' at the boundary
        boolean val = ( dfs(r-1, c) == '1' ||
                        dfs(r+1, c) == '1' ||
                        dfs(r, c-1) == '1' ||
                        dfs(r, c+1) == '1'
                        );

        visiting_map[r][c] = '0';

        return (val == true)? '1': '0';

    }

    private void mark_boundary(){
       //row-0 && row-last
        for (int i = 0; i < board[0].length; i++){
            mark_map[0][i] = (board[0][i] == 'X')? '0' : '1';
            mark_map[board.length-1][i] = (board[board.length-1][i] == 'X')? '0' : '1';
        }

        //column-0 && colume -last
        for (int i = 1; i < board.length - 1; i++){
            mark_map[i][0] = (board[i][0] == 'X')? '0': '1';
            mark_map[i][board[0].length-1] = (board[i][board[0].length-1] == 'X')? '0': '1';
        }
    }

    //Driver Function
    public static void main(String[] args) {
//        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};

//        char[][] board = {{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};

        char[][] board = {{'O','X','O','O','O','X'},{'O','O','X','X','X','O'},{'X','X','X','X','X','O'},{'O','O','O','O','X','X'},{'X','X','O','O','X','O'},{'O','O','X','X','X','X'}};
        System.out.println("The input is: " + "\n" +  Arrays.deepToString(board));
        L130 sol = new L130();
        sol.solve(board);
    }
}
