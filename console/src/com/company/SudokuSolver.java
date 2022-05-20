package com.company;

public class SudokuSolver {

//    == static fields ==

    private static final int GRID_SIZE = Sudoku.board.length;
    private static final int sizeOfBox = (int) Math.sqrt(GRID_SIZE);

//    == public methods ==

    public static void displayBoard(int[][] board){
        for(int i=0; i<GRID_SIZE; i++){
            if(i%sizeOfBox == 0 && i != 0)
                System.out.println("======================");
            for(int j=0; j<GRID_SIZE; j++){
                if(j%sizeOfBox == 0 && j != 0)
                    System.out.print("| ");
                System.out.print( board[i][j] + " ");
            }

            System.out.println();
        }
    }

//  In below method, recursion is used in order to backtrack and correct the previous values
    public static boolean solveBoard(int[][] board){
        for(int row=0; row<GRID_SIZE; row++){
            for(int col=0; col<GRID_SIZE; col++){
                if(board[row][col] == 0){
                    for(int num=1; num<=GRID_SIZE; num++){
                        if(isValidPlacement(board, num, row, col)){
                            board[row][col] = num;

                            if(solveBoard(board))
                                return true;
                            else
                                board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

//    == private methods ==

    private static boolean isNumberInRow(int[][] board, int num, int row){
        for(int i=0; i<GRID_SIZE; i++){
            if(board[row][i] == num)
                return true;
        }
        return false;
    }

    private static boolean isNumberInCol(int[][] board, int num, int col){
        for(int i=0; i<GRID_SIZE; i++){
            if(board[i][col] == num)
                return true;
        }
        return false;
    }

    private static boolean isNumberInBox(int[][] board, int num, int row, int col){
        int startRow = row - (row%sizeOfBox);
        int startCol = col - (col%sizeOfBox);

        for(int i=startRow; i<(startRow+sizeOfBox); i++){
            for(int j=startCol; j<(startCol+sizeOfBox); j++){
                if(board[i][j] == num)
                    return true;
            }
        }
        return false;
    }

    private static boolean isValidPlacement(int[][] board, int num, int row, int col){
        return !isNumberInRow(board, num, row) &&
                !isNumberInCol(board, num, col) &&
                !isNumberInBox(board, num, row, col);
    }
}
