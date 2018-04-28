
//*******************************************************************
//  Tristan Tapson
//	001319964
//
// Console Battleship Java Implementation (MVC)
// Player's begin by placing ships via scanner inputs, and then take
// shots at each other after all ships have been placed on their 
// game boards accordingly. This is the VIEW component, which prints
// out the game states in the console for the players to view.
//*******************************************************************


public class View {
	public static void main(String[] args) throws OutOfBoundsException {
		System.out.println(" -------------- ! BATTLESHIP ! ---------------");
		//Controller c = new Controller();
		Controller.init_gameboard();
	}
	
	// prints player 1's game board
	public static void printboard_p1(){
		for(int i = 0; i < Constants.COLUMN_SIZE; i++){
			for(int j = 0; j < Constants.ROW_SIZE; j++){
				if(j < 1){
					System.out.print(" Y"+ i + " ");
				}
				
				System.out.print(Model.p1_board[i][j] + "  ");
				
				if((j%9 == 0) && j > 0){
					System.out.println("\n" );
				}
				
				if(i == Constants.COLUMN_SIZE-1 && j == Constants.ROW_SIZE-1){
					for(int k = 0; k < Constants.ROW_SIZE; k++){
						if (k == 0){
							System.out.print("   " + "X" + k + " ");
						}
						else{
							System.out.print("X" + k + " " );
						}
						
					}
					
					System.out.println("\n");
				}
			}
		}
	}
	
	// prints player 2's game board
	public static void printboard_p2(){
		for(int i = 0; i <Constants.COLUMN_SIZE; i++){
			for(int j = 0; j < Constants.ROW_SIZE; j++){
				if(j < 1){
					System.out.print(" Y"+ i + " ");
				}
				
				System.out.print(Model.p2_board[i][j] + "  ");
				
				if((j%9 == 0) && j > 0){
					System.out.println("\n" );
				}
				
				if(i == Constants.COLUMN_SIZE-1 && j == Constants.ROW_SIZE-1){
					for(int k = 0; k < Model.p2_row0.length; k++){
						if (k == 0){
							System.out.print("   " + "X" + k + " ");
						}
						else{
							System.out.print("X" + k + " " );
						}
						
					}
					
					System.out.println("\n");
				}
			}
		}
	}
	
	// prints player 1's hit/miss board
	public static void print_hitboard_p1(){
		for(int i = 0; i < Constants.COLUMN_SIZE; i++){
			for(int j = 0; j < Constants.ROW_SIZE; j++){
				if(j < 1){
					System.out.print(" Y"+ i + " ");
				}
				
				System.out.print(Model.p1_hitboard[i][j] + "  ");
				
				if((j%9 == 0) && j > 0){
					System.out.println("\n" );
					
				}
				
				if(i == Constants.COLUMN_SIZE-1 && j == Constants.ROW_SIZE-1){
					for(int k = 0; k < Constants.ROW_SIZE; k++){
						if (k == 0){
							System.out.print("   " + "X" + k + " ");
						}
						else{
							System.out.print("X" + k + " " );
						}
						
					}
					
					System.out.println("\n");
				}
			}
		}
	}
	
	// prints player 2's hit/miss board
	public static void print_hitboard_p2(){
		for(int i = 0; i < Constants.COLUMN_SIZE; i++){
			for(int j = 0; j < Constants.ROW_SIZE; j++){
				if(j < 1){
					System.out.print(" Y"+ i + " ");
				}
				
				System.out.print(Model.p2_hitboard[i][j] + "  ");
				
				if((j%9 == 0) && j > 0){
						System.out.println("\n" );
				}
					
				if(i == Constants.COLUMN_SIZE-1 && j == Constants.ROW_SIZE-1){
					for(int k = 0; k < Constants.ROW_SIZE; k++){
						if (k == 0){
							System.out.print("   " + "X" + k + " ");
						}
						else{
							System.out.print("X" + k + " " );
						}
					}
					System.out.println("\n");
				}
			}
		}
	}
	
	// prints a separator for visual clarity
	public static void print_separator(){
		System.out.print(" ---------- next instruction(s) below ----------");
		System.out.println("");
	}
}
