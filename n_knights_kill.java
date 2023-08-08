package backtracking;

import java.util.Scanner;

public class n_knights_kill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a;
		Scanner scan = new Scanner(System.in);
		a= scan.nextInt();
		scan.close();
		boolean[][] board= new boolean[a][a];
	
		get_combination(board, board.length,0,0,0,"");
		
	}
	public static void get_combination(boolean[][]board, int tk, int kpsf, int row , int col,String ans ) {
		
		if(kpsf==tk) {
			System.out.println(ans);
			return;
		}
		
		if(col==board[0].length) {
			row++;
			col=0;
		}
		
		if(row==board.length) {
			return ;
		}
		
		if(IsItSafe(board,row,col)==true) {
			board[row][col]=true;
			get_combination(board,tk,kpsf+1,row,col+1,ans+"{"+row+","+col+"}");
			board[row][col]=false;
	}
		get_combination(board,tk,kpsf,row,col+1,ans);
	}
	
	public static boolean IsItSafe(boolean[][] board, int row, int col) {
		int r;
		int c;
		c= col+1;
		r= row-2;
		
		if(r>=0&&c>=0&& r<board.length&&c<board[0].length) {
		if(board[r][c]) {
			
			return false;
			
		}}
		 r= row-1;
		 c= col+2;
		 if(r>=0&&c>=0&&r<board.length&&c<board[0].length) {
		if(board[r][c]) {
			
			return false;
		}
		 }
		r= row-2;
		 c= col-1;
		 if(r>=0&&c>=0&&r<board.length&&c<board[0].length) {
		if(board[r][c]) {
			
			return false;
		}
		 }
		 r= row-1;
		 c= col-2;
		 if(r>=0&&c>=0&&r<board.length&&c<board[0].length) {
		if(board[r][c]) {
			
			return false;
		}
		
		 }
		 
		 return true;
	}
}
