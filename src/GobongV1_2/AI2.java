package GobongV1_2;

public class AI2 {
	
	int val;
	public int AlphaBeta(int depth, int alpha, int beta) { 
		if (depth == 0) { 
		return Evaluate(); 
		} 
		GenerateLegalMoves(); 
		while (MovesLeft()) { 
		MakeNextMove(); 
		val = -AlphaBeta(depth - 1, -beta, -alpha); 
		UnmakeMove(); 
		if (val >= beta) { 
		return beta; 
		} 
		if (val > alpha) { 
		alpha = val; 
		} 
	} 
		return alpha; 
		}

	private int Evaluate() {
		// TODO Auto-generated method stub
		return 0;
	}

	private void UnmakeMove() {
		// TODO Auto-generated method stub
		
	}

	private void MakeNextMove() {
		// TODO Auto-generated method stub
		
	}

	private boolean MovesLeft() {
		// TODO Auto-generated method stub
		return false;
	}

	private void GenerateLegalMoves() {
		// TODO Auto-generated method stub
		
	} 

}
