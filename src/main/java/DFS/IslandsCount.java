package DFS;

public class IslandsCount {

    public int numIslands(char[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='1' && !visited[i][j]) {
                    islands++;
                    traverse(grid, visited, i, j);
                }
            }
        }
        return islands;
    }

    int[] rowMoves = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] colMoves = {0, 1, -1, -1, 1, 0, -1, 1};
    void traverse(char[][] grid, boolean[][] visited, int row, int col) {
        visited[row][col] = true;

        for (int i = 0; i < 8; i++) {
            int currRow = rowMoves[i] + row;
            int currCol = colMoves[i] + col;
            if (isValidMove(grid, currRow, currCol,visited)) {
                traverse(grid, visited, currRow, currCol);
            }
        }
    }

    boolean isValidMove(char[][] grid, int row, int col, boolean[][] visited) {
        return  row>=0 && row<grid.length
                && col>=0 && col<grid[0].length
                && !visited[row][col]
                && grid[row][col]=='1' ;
    }


}


