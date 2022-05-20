package com.company;

/**
 * Sudoku Solver
 * The 0s (zeroes) represent blank spaces in the sudoku board
 * Initialize the board and just run the program to check if it can be solved or not
 * The board can be of different sizes ( i.e. 4x4, 9x9, 16x16 ... N²xN² )
 * NOTE : The program will only work if the board is of size (N² x N²)
 */

public class Sudoku {

// initialize the sudoku board here and just run the program
// the board can be of different sizes ( i.e. 4x4, 9x9, 16x16 ... N²xN² )
    public static int[][] board = {
            {0,0,0,0,0,0,5,0,2},
            {8,0,0,0,9,0,0,0,0},
            {0,0,0,0,0,0,6,0,0},
            {7,0,0,2,0,0,0,0,0},
            {0,0,0,1,0,5,0,0,0},
            {0,3,0,0,0,0,0,9,0},
            {0,1,5,0,0,0,0,0,0},
            {0,0,0,0,4,0,0,3,0},
            {6,0,2,0,0,0,0,0,0}
    };

    public static void main(String[] args) {
        System.out.println("The initial board : ");
        System.out.println();
        SudokuSolver.displayBoard(board);
        System.out.println();

        if(SudokuSolver.solveBoard(board))
            System.out.println("Solved successfully!!!");
        else
            System.out.println("Unsolvable");

        System.out.println();
        SudokuSolver.displayBoard(board);
    }
}

/*
*   Sample Board  :
*
*           {6,0,0,3,0,0,0,0,0},
            {3,1,5,2,0,8,0,0,6},
            {0,9,0,0,6,0,0,3,0},
            {0,0,0,0,8,0,6,0,0},
            {9,0,0,0,0,0,0,0,2},
            {0,0,1,0,4,0,0,0,0},
            {0,6,0,0,2,0,0,8,0},
            {2,0,0,9,0,6,5,4,1},
            {0,0,0,0,0,4,0,0,3}
* */
