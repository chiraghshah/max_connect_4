/**
 * This is the AiPlayer class.  It implements a Alpha Beta MinMax Algorithm 
 * to play the connect4 game. It keeps track of the player making
 * the next play based on the number of pieces on the game board. It provides
 * all of the methods needed to implement the playing of a max connect four
 * game.
 * 
 * @author Chirag Shah
 *
 */
public class AiPlayer {

	public int alpha = -10000;//let alpha be -infinity
	public int beta = 10000;//let beta be +infinity
	public int playChoice = 1000; //let choiceColumn be any random number..

	public int depthLevel = 0;
	
	public AiPlayer(int depthLevel) {
		this.depthLevel = depthLevel;
	}

	/**
     * This method plays a piece by Alpha Beta MinMax Algorithm
     * @param currentGame The GameBoard object that is currently being used to
     * play the game.
     * @return an integer indicating from findBestPlay method which column the AiPlayer would like
     * to play in.
     */
	
	public int findBestPlay(GameBoard current_game) {
		if (current_game.getCurrentTurn() == 1) // max player's turn.. which is computer's turn.
		{
			int v = 10000;//one time initialization
			for (int i = 0; i < 7; i++) {
				if (current_game.isValidPlay(i)) {
					GameBoard bestPlayNext = new GameBoard(current_game.getGameBoard());
					//lets start by placing the piece on the board an check if thats the best optimal move by branching it..
					bestPlayNext.playPiece(i);
					int max_value = MaxValue(bestPlayNext, alpha, beta, 1);//we start with depth = 1
					if (v > max_value) {
						//System.out.println("Is v > Max_value, v :"+ v + " And max_value : "+max_value	);		
						playChoice = i;
						v = max_value;
					}
				}
			}
		} 
		else {
			int v = -10000;
			for (int i = 0; i < 7; i++) {
				if (current_game.isValidPlay(i)) {
					GameBoard bestPlayNext = new GameBoard(current_game.getGameBoard());
					//lets start by placing the piece on the board an check if thats the best optimal move by branching it..
					bestPlayNext.playPiece(i);
					int min_value = MinValue(bestPlayNext, alpha, beta, 1);//we start with depth = 1
					if (v < min_value) {
						playChoice = i;
						v = min_value;
					}
				}
			}
		}
		return playChoice;//return the optimal play choice..
	}

	public int MaxValue(GameBoard game, int alpha, int beta, int depth) {
		if (game.getPieceCount() < 42 && depth != depthLevel)
		{
			int v = -10000;// initialize to -infinity for max function
			for (int i = 0; i < 7; i++) {
				if (game.isValidPlay(i)) {
					GameBoard max_game_state = new GameBoard(game.getGameBoard());
					max_game_state.playPiece(i);
					int min_value = MinValue(max_game_state, alpha, beta, depth + 1);// incrementing depth..
					
					//v = Math.max(v, MinValue(max_game, alpha, beta, depth + 1));
					if (v < min_value) {
						//System.out.println("MinValue() v < min_value then v = min_value");
						v = min_value;
					}
					//alpha= Math.max(alpha, v);
					if (alpha < v) {
						alpha = v;
					}
					if (v >= beta) {
						return v;
					}
				}
			}
			return v;
		} else
			return game.getScore(2) - game.getScore(1);// if depth reached Depth level then returning evaluation..
		
	}

	public int MinValue(GameBoard game, int alpha, int beta, int depth) {
		if (game.getPieceCount() < 42 && depth != depthLevel) {
			int v = 10000;// initialize to +infinity for max function
			for (int i = 0; i < 7; i++) {
				if (game.isValidPlay(i)) {
					GameBoard min_game_state = new GameBoard(game.getGameBoard());
					min_game_state.playPiece(i);
					int max_value = MaxValue(min_game_state, alpha, beta, depth + 1);// incrementing depth..
					
					//v = Math.min(v, MaxValue(min_game, alpha, beta, depth + 1));
					if (v > max_value) {
						//System.out.println("MinValue() v > max_value then v = max_value");
						v = max_value;
					}
					//beta = Math.min(beta, v);
					if (beta > v) {
						beta = v;
					}
					if (v <= alpha) {
						return v;
					}
				}
			}
			return v;
		} else
			return game.getScore(2) - game.getScore(1);// if depth reached Depth level then returning evaluation..
	}
}
