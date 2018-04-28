
//*******************************************************************
//
// Console Battleship Java Implementation (MVC)
// Player's begin by placing ships via scanner inputs, and then take
// shots at each other after all ships have been placed on their 
// game boards accordingly. This is the OUTOFBOUNDSEXCEPTION component,
// which throws an exception if illegal input coordinates are given
// to the scanner.
//
//*******************************************************************

@SuppressWarnings("serial")
// throws exception for out of bounds coordinates
public class OutOfBoundsException extends Exception{
	public OutOfBoundsException(String message) {
		super(message); 
	}
}
