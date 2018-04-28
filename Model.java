
//*******************************************************************
//  Tristan Tapson
//	001319964
//
// Console Battleship Java Implementation (MVC)
// Player's begin by placing ships via scanner inputs, and then take
// shots at each other after all ships have been placed on their 
// game boards accordingly. This is the MODEL component, which checks
// to see if actions done by a player are valid.
//*******************************************************************

public class Model {

	// ship sizes
	public static int[] ship_sizes = {2,3,4,5};

	// game board p1
	static char[] p1_row8 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p1_row7 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p1_row6 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p1_row5 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p1_row4 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p1_row3 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p1_row2 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p1_row1 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p1_row0 = {'O','O','O','O','O','O','O','O','O','O'};
		
	static char[][] p1_board = {p1_row0,p1_row1, p1_row2, p1_row3, p1_row4, p1_row5, p1_row6, p1_row7, p1_row8};
	
	// hit/miss board p1
	static char[] p1_hit8 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p1_hit7 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p1_hit6 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p1_hit5 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p1_hit4 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p1_hit3 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p1_hit2 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p1_hit1 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p1_hit0 = {'O','O','O','O','O','O','O','O','O','O'};
		
	static char[][] p1_hitboard = {p1_hit0,p1_hit1, p1_hit2, p1_hit3, p1_hit4, p1_hit5, p1_hit6, p1_hit7, p1_hit8};
		
	// game board p2
	static char[] p2_row8 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p2_row7 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p2_row6 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p2_row5 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p2_row4 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p2_row3 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p2_row2 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p2_row1 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p2_row0 = {'O','O','O','O','O','O','O','O','O','O'};
		
	static char[][] p2_board = {p2_row0, p2_row1, p2_row2, p2_row3, p2_row4, p2_row5, p2_row6, p2_row7, p2_row8};
	
	// hit/miss board p2
	static char[] p2_hit8 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p2_hit7 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p2_hit6 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p2_hit5 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p2_hit4 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p2_hit3 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p2_hit2 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p2_hit1 = {'O','O','O','O','O','O','O','O','O','O'};
	static char[] p2_hit0 = {'O','O','O','O','O','O','O','O','O','O'};
			
	static char[][] p2_hitboard = {p2_hit0,p2_hit1, p2_hit2, p2_hit3, p2_hit4, p2_hit5, p2_hit6, p2_hit7, p2_hit8};
	
	
	// checks if player 1's shot is valid
	public static char[][] is_valid_shot_p1(int x1, int y1){
		
		 // updates hit/miss board if hit found, and so no duplicate hits can occur
		if(p2_board[y1][x1] == 'S' & p1_hitboard[y1][x1] == 'O'){
			p1_hitboard[y1][x1] = 'H';
	    	System.out.println("HIT!");
	    	Controller.p2_targets -=1;
	    	System.out.println("Remaining target locations for P1's victory: " + Controller.p2_targets);
	    	System.out.println("");
	    }
		
		 // updates hit/miss board if location previously selected
		else if(p1_hitboard[y1][x1] == 'H' | p1_hitboard[y1][x1] == 'M'){
			System.out.println("Location already hit/missed.");
	    	System.out.println("Remaining target locations for P1's victory: " + Controller.p2_targets);
	    	System.out.println("");
		}
		
		// updates player hit/miss board if miss found
		else {
			System.out.println("MISS!");
			p1_hitboard[y1][x1] = 'M';
			System.out.println("Remaining target locations for P1's victory: " + Controller.p2_targets);
	    	System.out.println("");
		}
		is_game_over();
		
		// switches to player 2's turn
		Controller.player_switch = true;
		
		View.print_separator();
		return p1_hitboard;
	}
	
	// checks if player 2's shot is valid
	public static char[][] is_valid_shot_p2(int x1, int y1){
		
		 // updates hit/miss board if hit found, and so no duplicate hits can occur
		if(p1_board[y1][x1] == 'S' & p2_hitboard[y1][x1] == 'O'){
			System.out.println("HIT!");
			p2_hitboard[y1][x1] = 'H'; 
			Controller.p1_targets -=1;
	    	System.out.println("Remaining target locations for P2's victory: " + Controller.p1_targets);
	    	System.out.println("");
		}
		
		// updates hit/miss board if location previously selected
		else if(p2_hitboard[y1][x1] == 'H' | p2_hitboard[y1][x1] == 'M' ){
			System.out.println("Location already hit/missed.");
	    	System.out.println("Remaining target locations for P2's victory: " + Controller.p1_targets);
	    	System.out.println("");
		}
		
		// updates player hit/miss board if miss found
		else{
			System.out.println("MISS!");
			p2_hitboard[y1][x1] = 'M';
			System.out.println("Remaining target locations for P2's victory: " + Controller.p1_targets);
	    	System.out.println("");
		}
		
		// checks to see if game is over after players turn
		is_game_over();
		
		// switches to player 1's turn
		Controller.player_switch = false;
		View.print_separator();
		return p2_hitboard;
	}
	
	// checks if player 1's placement of ship is valid
	@SuppressWarnings("unused")
	public static char[][] is_valid_placement_p1(int x1, int y1, int x2, int y2) throws OutOfBoundsException {
		
		int i;
		int j;
		int k;
		
		boolean isValidSize = false;
		boolean isValidPosition = false;
		boolean isValidBoard = false;
		double ship_length =   1 + (Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2)));
		
		// when a ship is place in the vertical plane (x co-ords are same)
		if(x1 == x2){
			for (i = 0;i < ship_sizes.length; i++){
				if (ship_sizes[i] == ship_length){
					System.out.println("Valid ship size!");
					isValidSize = true;
					break;
				}
			}
		
			// checks is position is valid if size given is valid
			if(isValidSize == true){
				for(j = y1; j < y2+1; j++){
					// if ship collides with another ship on the board
					if(p1_board[j][x1] == 'S'){;
						isValidPosition = false;
						System.out.println("Invalid ship position!");
						System.out.println("Request was not placed on gameboard");
						System.out.println("");
						break;
					}
					
					else{
						isValidPosition = true;
						System.out.println("Valid ship position!");
						System.out.println("");
						break;
					}
				}
			}
			
			if(isValidSize == true && isValidPosition == true){
				for(k = y1; k < y2+1; k++){
					// fill board
					p1_board[k][x1] = 'S';
					isValidBoard = true;
				}
			}
		}	// end of vertical check 
		
		// when a ship is place in the horizontal plane (y co-ords are same)
		else if(y1 == y2){
			for (i = 0;i < ship_sizes.length; i++){
				if (ship_sizes[i] == ship_length){
					System.out.println("Valid ship size!");
					isValidSize = true;
					//System.out.println(isValidSize);
					break;
				}
			}
				
			// checks if position is valid if size given is valid
			if(isValidSize == true){
				for(j = x1; j < x2+1; j++){
					// if ship collides with another ship on the game board
					if(p1_board[y1][j] == 'S'){;
						isValidPosition = false;
						System.out.println("Invalid ship position!");
						System.out.println("Request was not placed on gameboard");
						System.out.println("");
						break;
					}
							
					else{
						isValidPosition = true;
						System.out.println("Valid ship position!");
						System.out.println("");
						break;
					}
				}
			}
					
			if(isValidSize == true && isValidPosition == true){
				for(k = x1; k < x2+1; k++){
					// fill game board
					p1_board[y1][k] = 'S';
					isValidBoard = true;
				}
			}	
		}	// end of vertical check
		
		// ship can be placed on game board after all quality checks
		if(isValidBoard == true){
			Controller.p1_targets +=ship_length;	
			Controller.shipCountCurrent++;
			Controller.remaining_placements_p1--;
		}
		
		// coordinates chosen place ship outside of game board, throw exception
		if(x1 > Constants.ROW_SIZE | x2 > Constants.ROW_SIZE | y1 > Constants.ROW_SIZE | y2 > Constants.ROW_SIZE){
			throw new OutOfBoundsException("A selected point exists outside of the gameboard");
		}
		
		// ship size too small or too big
		if(ship_length > 5 | ship_length < 2){
			System.out.println("Please enter (x,y) coordinates for a ship of appropriate length (2-5)");
			System.out.println("Request was not placed on gameboard");
			System.out.println("");
		}
		
		// non-dominating horizontal coordinates
		if(x2 < x1){
			System.out.println("Please enter dominating x coordinates for horizontal placement (x2 > x1)");
			System.out.println("Request was not placed on gameboard");
			System.out.println("");
		}
		
		// non-dominating vertical coordinates
		if(y2 < y1){
			System.out.println("Please enter dominating y coordinates for vertical placement (y2 > x1)");
			System.out.println("Request was not placed on gameboard");
			System.out.println("");
		}
		
		// ship placed on a diagonal
		else if(x1 != x2 & y1 != y2){
			System.out.println("Please enter non-diagonal (x,y) coordinates");
			System.out.println("Request was not placed on gameboard");
			System.out.println("");
		}
		
		System.out.println("----- player 1's boat locations -----");
		System.out.println("O = open, S = ship, H = hit, M = miss");
		System.out.println("");
		View.printboard_p1();
		View.print_separator();
		return p1_board;
	}
	
	// checks if player 2's placement of ship is valid
	@SuppressWarnings("unused")
	public static char[][] is_valid_placement_p2(int x1, int y1, int x2, int y2) throws OutOfBoundsException{
		
		int i;
		int j;
		int k;
		
		boolean isValidSize = false;
		boolean isValidPosition = false;
		boolean isValidBoard = false;
		double ship_length =   1 + (Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2)));
		
		// when a ship is place in the vertical plane (x co-ords are same)
		if(x1 == x2){
			for (i = 0;i < ship_sizes.length; i++){
				if (ship_sizes[i] == ship_length){
					System.out.println("Valid ship size!");
					isValidSize = true;
					break;
				}
			}
		
			// checks if position is valid if size given is valid
			if(isValidSize == true){
				for(j = y1; j < y2+1; j++){
					// if ship collides with another ship on the game board
					if(p2_board[j][x1] == 'S'){;
						isValidPosition = false;
						System.out.println("Invalid ship position!");
						System.out.println("Request was not placed on gameboard");
						System.out.println("");
						break;
					}
					
					else{
						isValidPosition = true;
						System.out.println("Valid ship position!");
						System.out.println("");
						break;
					}
				}
			}
			
			if(isValidSize == true && isValidPosition == true){
				for(k = y1; k < y2+1; k++){
					// fill game board
					p2_board[k][x1] = 'S';
					isValidBoard = true;
				}
			}
		}	// end of vertical check 
		
		// when a ship is place in the horizontal plane (y co-ords are same)
		else if(y1 == y2){
			for (i = 0;i < ship_sizes.length; i++){
				if (ship_sizes[i] == ship_length){
					System.out.println("Valid ship size!");
					isValidSize = true;
					break;
				}
			}
				
			// checks if position is valid if size given is valid
			if(isValidSize == true){
				for(j = x1; j < x2+1; j++){
					// if ship collides with another ship on the game board
					if(p2_board[y1][j] == 'S'){;
						isValidPosition = false;
						System.out.println("Invalid ship position!");
						System.out.println("Request was not placed on gameboard");
						System.out.println("");
						break;
					}
							
					else{
						isValidPosition = true;
						System.out.println("Valid ship position!");
						System.out.println("");
						break;
					}
				}
			}
					
			if(isValidSize == true && isValidPosition == true){
				for(k = x1; k < x2+1; k++){
					// fill game board
					p2_board[y1][k] = 'S';
					isValidBoard = true;
				}
			
			
			}	
		}	// end of vertical check
		
		// ship can be placed on game board after all quality checks
		if(isValidBoard == true){
			Controller.p2_targets +=ship_length;	
			Controller.shipCountCurrent++;
			Controller.remaining_placements_p2--;
		}
		
		// coordinates chosen place ship outside of game board, throw exception
		if(x1 > Constants.ROW_SIZE | x2 > Constants.ROW_SIZE | y1 > Constants.ROW_SIZE | y2 > Constants.ROW_SIZE){
			throw new OutOfBoundsException("A selected point exists outside of the gameboard");
		}
		
		// ship size too small or too big
		if(ship_length > 5 | ship_length < 2){
			System.out.println("Please enter (x,y) coordinates for a ship of appropriate length (2-5)");
			System.out.println("Request was not placed on gameboard");
			System.out.println("");
		}
		
		// non-dominating horizontal coordinates
		if(x2 < x1){
			System.out.println("Please enter dominating x coordinates for horizontal placement (x2 > x1)");
			System.out.println("Request was not placed on gameboard");
			System.out.println("");
		}
				
		// non-dominating vertical coordinates
		if(y2 < y1){
			System.out.println("Please enter dominating y coordinates for vertical placement (y2 > x1)");
			System.out.println("Request was not placed on gameboard");
			System.out.println("");
		}
				
		// ship placed on a diagonal
		else if(x1 != x2 & y1 != y2){
			System.out.println("Please enter non-diagonal (x,y) coordinates");
			System.out.println("Request was not placed on gameboard");
			System.out.println("");
		}
		
		System.out.println("----- player 2's boat locations -----");
		System.out.println("O = open, S = ship, H = hit, M = miss");
		System.out.println("");
		View.printboard_p2();
		View.print_separator();
		return p2_board;
	}
	
	// checks character in a players' hit board
	public static char inspect_cell(int x, int y){
		
		// when its player 1's turn
		if(Controller.player_switch = false){
			return p1_hitboard[y][x];
		}
		
		// when its player 2's turn
		else if(Controller.player_switch = true){
			return p2_hitboard[y][x];
		}
		return 0;
	}
	
	// checks to see if a specific ship has been sunk, need to implement this still :(
	public static void is_ship_sunk(){
		
	}
	
	// checks to see if the game is over
	public static void is_game_over(){
		
		// player 1 hits all possible targets, end the game
		if(Controller.p2_targets == 0){
			System.out.println("--- ! GAME OVER ~ PLAYER 1 WINS ! ---");
			Controller.game_over = true;
			System.exit(0);
		}
		
		// player 2 hits all possible targets, end the game
		else if(Controller.p1_targets == 0){
			System.out.println("--- ! GAME OVER ~ PLAYER 2 WINS ! ---");
			Controller.game_over = true;
			System.exit(0);
		}
	}
}
