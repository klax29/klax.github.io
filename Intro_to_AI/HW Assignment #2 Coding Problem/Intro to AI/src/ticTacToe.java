
public class ticTacToe {

	static class Move{
		int row, col;
	}
	static char player = 'x', opponent = 'o';
	
	static Boolean isMovesLeft(char board[][]) {		//true if there are moves remaining, false if no moves to left.
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				if(board[i][j] == '_') {
					return true;
				}
			}
		}
		return false;
	}
	static int evaluate(char b[][]) {		//checking for rows for  winner
		for(int row = 0; row<3; row++) {
			if(b[row][0] == b[row][1] && b[row][1] == b[row][2]) {
				if(b[row][0] == player) {
					return +10;
				}
				
				else if(b[row][0] == opponent) {
					return -10;
				}
			}
			if(b[0][0] == b[1][1] && b[1][1] == b[2][2]) {		// checking diagnols for winner
				 if (b[0][0] == player) {
					 return +10;
				 }
				 else if(b[0][0] == opponent) {
					 return -10;
				 }
			}
			 if (b[0][2] == b[1][1] && b[1][1] == b[2][0]) {
				 if (b[0][2] == player) {
					 return +10;
				 }
				 else if (b[0][2] == opponent) {
					 return -10;
				 }
			 }
		}
		return 0;			// if no winner return 0
	}
	static int minimax(char board[][], int depth, Boolean isMax) {		//function determines all ways game goes and returns board
		int score = evaluate(board);
		 
		if(score == 10) {
			return score;		//returns if MAX Value wins
		}
		if(score == -10) {
			return score;		// returns if MIN Value wins
		}
		if(isMovesLeft(board)==false) {
			return 0;			//returns if stale mate
		}
		if(isMax) {			//Max Value Move
			int best = -1000;
			
			for(int i = 0; i<3; i++) {
				for(int j = 0; j<3; j++) {
					if(board[i][j] == '_') {
						board[i][j] = player;
						best = Math.max(best, minimax(board, depth + 1, !isMax));
						board[i][j] = '_';
					}
				}
			}
			return best;
		}
		else {			//Min Value Move
			int best = 1000;
			for(int i = 0; i<3; i++) {
				for(int j = 0; j<3; j++) {
					if(board[i][j] == '_') {
						board[i][j] = opponent;
						best = Math.min(best, minimax(board, depth+1, !isMax));
						board[i][j] = '_';
					}
				}
			}
			return best;
		}
	}
	static Move findBestMove(char board[][]) {
		int bestVal = -1000;
		Move bestMove = new Move();
		bestMove.row = -1;
		bestMove.col = -1;
		
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				if(board[i][j] == '_') {		//check cells and return best move
					board[i][j] = player;		// move
					int moveVal = minimax(board, 0, false);
					board[i][j] = '_';		// undo
					if(moveVal>bestVal) {
						bestMove.row = i;
						bestMove.col = j;
						bestVal = moveVal;
					}
				}
			}
		}
		System.out.printf("Value of best move " + "is: %d\n\n", bestVal);
		return bestMove;
	}
	
	
	public static void main(String[] args) {
		char board [][] = {{ 'x', 'x', 'o'},
						{ '_', '_', 'o'},
						{ '_', '_', 'o'}};
		
		
		Move bestMove = findBestMove(board);
		System.out.printf("The Optimal Move is :\n");
	    System.out.printf("ROW: %d COL: %d\n\n",
	               bestMove.row, bestMove.col );
		
	}
}
