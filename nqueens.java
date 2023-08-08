package recursions;

import java.util.Scanner;

public class nqueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a;
		Scanner scan= new Scanner(System.in);
		a= scan.nextInt();
		scan.close();
		boolean[][] board= new boolean[a][a];
		int b= countNqueens(board,0);
		System.out.println(b);
	}
	public static int countNqueens(boolean[][] board, int row) {
		
		int count=0;
		if(row==board.length) {
			return 1;
		}
		
		for(int col=0; col<board[row].length; col++) {
			if(isItSafe(board, row, col)) {
				board[row][col]=true;
				count = count+countNqueens(board,row+1);
				board[row][col]=false;
			}
		}
		return count;
	}
	
	public static boolean isItSafe(boolean[][]board, int row , int col) {
		int i, j;
		for(i=row;i>=0;i--) {
			if(board[i][col]) {
				return false;
			}
		}
		for(i=row, j=col; i>=0&&j>=0; i--,j--) {
			if(board[i][j]) {
				return false;
			}
		}
		
		for (i=row, j=col;i>=0&&j<board.length;i--,j++) {
			if(board[i][j]) {
				return false;
			}
		}
		return true;
	}
}
