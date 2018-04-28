
//*******************************************************************
//
// Console Battleship Java Implementation (MVC)
// Player's begin by placing ships via scanner inputs, and then take
// shots at each other after all ships have been placed on their 
// game boards accordingly. This is the CONTROLLER component, which 
// implements the actions to be done by a player.
//
//*******************************************************************

import java.util.Scanner;

public class Controller {
	
	// counters to track how many ships each player has left to place on the game board
	static int remaining_placements_p1 = Constants.SHIPS_P1;
	static int remaining_placements_p2 = Constants.SHIPS_P2;
	static int shipCountCurrent = 0;
	
	// boolean to switch player turn
	static boolean player_switch = false;
	
	// boolean to change game state to over
	static boolean game_over = false;
	
	// counters to track remaining hit targets for players
	static int p1_targets = 0;
	static int p2_targets = 0; 
	
	// linear set up of player 1 and player 2 placing ships
	public static void init_gameboard() throws OutOfBoundsException {
		while(shipCountCurrent < Constants.TOTAL_SHIPS){
			if(shipCountCurrent < Constants.SHIPS_P1){
				place_ship_p1();
			}
			if(shipCountCurrent >= Constants.SHIPS_P1 & shipCountCurrent < Constants.TOTAL_SHIPS){
				place_ship_p2();
			}
		}
		
		// done placing ships, begin taking shots
		if (shipCountCurrent == Constants.TOTAL_SHIPS){
			System.out.println("P1 & P2 are done ship placement, begin playing!");
			shot_turn();
		}
	}
	
	// alternates between player 1 and player 2 taking shots
	public static void shot_turn(){
		while (true){
			// player 1 takes shot
			if (player_switch == false){
				take_shot_p1();
			}
			
			// player 2 takes shot
			if (player_switch == true){
				take_shot_p2();
			}
		}
	}
	
	// allows player 1 to enter coordinates to place ship on game board
	public static void place_ship_p1() throws OutOfBoundsException {
		
		Scanner in = new Scanner(System.in); 
		System.out.println("P1 has " +Controller.remaining_placements_p1 + " ship(s) remaining to place");
		System.out.println("P1 - Enter in two (x,y) coordinates to place a ship");
		System.out.println("Values for x must be between (0-9), values for y must be between (0-8)");
		System.out.println("Ships must be entered in a vertical or horizontal direction");
		System.out.println("Direction chosen must have (x2 > x1) or (y2 > y1)");
	    System.out.printf(" Enter x1 value:  ");
	    int x1 = in.nextInt();
	    System.out.printf(" Enter y1 value:  ");
	    int y1 = in.nextInt();
	    System.out.printf(" Enter x2 value:  ");
	    int x2 = in.nextInt();
	    System.out.printf(" Enter y2 value:  ");
	    int y2 = in.nextInt();
	    
	    // check if ship placement is valid via quality checks in Model class
	    Model.is_valid_placement_p1(x1, y1, x2, y2);
	   
	    // close input scanner when game has ended
	    if (game_over == true){
	    	in.close();
		}
	}
	
	
	// allows player 2 to enter coordinates to place ship on game board
	public static void place_ship_p2() throws OutOfBoundsException {
		
		Scanner in = new Scanner(System.in); 
		System.out.println("P2 has " +Controller.remaining_placements_p2 + " ship(s) remaining to place");
		System.out.println("P2 - Enter in two (x,y) coordinates to place a ship");
		System.out.println("Values for x must be between (0-9), values for y must be between (0-8)");
		System.out.println("Ships must be entered in a vertical or horizontal direction");
		System.out.println("Direction chosen must have (x2 > x1) or (y2 > y1)");
	    System.out.printf(" Enter x1 value:  ");
	    int x1 = in.nextInt();
	    System.out.printf(" Enter y1 value:  ");
	    int y1 = in.nextInt();
	    System.out.printf(" Enter x2 value:  ");
	    int x2 = in.nextInt();
	    System.out.printf(" Enter y2 value:  ");
	    int y2 = in.nextInt();
	  
	    // check if ship placement is valid via quality checks in Model class
	    Model.is_valid_placement_p2(x1, y1, x2, y2);
	 
	    // close input scanner when game has ended
	    if (game_over == true){
	    	in.close();
		}
	}
	
	// allows player 1 to enter coordinates to shoot at player 2
	public static void take_shot_p1(){
		
		System.out.println("");
		System.out.println("----- player 1's hit/misses -----");
		System.out.println("O = open, S = ship, H = hit, M = miss");
		System.out.println("");
		View.print_hitboard_p1();
		
		Scanner in = new Scanner(System.in); 
		System.out.println("P1 - Enter in (x,y) coordinate to take a shot at P2");
	    System.out.printf("Enter x value:  ");
	    int x1 = in.nextInt();
	    System.out.printf("Enter y value:  ");
	    int y1 = in.nextInt();
	    
	    // check if shot placement is valid via quality checks in Model class
	    Model.is_valid_shot_p1(x1, y1);
	    
	    // close input scanner when game has ended
	    if(game_over == true){
	    	in.close();
	    }
	}
	
	// allows player 2 to enter coordinates to shoot at player 1
	public static void take_shot_p2(){
		
		System.out.println("");
		System.out.println("----- player 2's hit/misses -----");
		System.out.println("O = open, S = ship, H = hit, M = miss");
		System.out.println("");
		View.print_hitboard_p2();
		
		Scanner in = new Scanner(System.in); 
		System.out.println("P2 - Enter in (x,y) coordinate to take a shot at P1");
	    System.out.printf(" Enter x value:  ");
	    int x1 = in.nextInt();
	    System.out.printf(" Enter y value:  ");
	    int y1 = in.nextInt();
	   
	    // check if shot placement is valid via quality checks in Model class
	    Model.is_valid_shot_p2(x1, y1);
	    
	    // close input scanner when game has ended
	    if(game_over == true){
	    	in.close();
	    }
	}
}
