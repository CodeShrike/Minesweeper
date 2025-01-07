import java.util.*;

public class BombSquare extends GameSquare
{
    private GameBoard board;                            // Object reference to the GameBoard this square is part of.
    private boolean hasBomb;                            // True if this squre contains a bomb. False otherwise.
    private boolean checked = false;                    // False if square untouched, set to true when checked
    private boolean flagged = false;                    // False if square not flagged
    
	public static final int MINE_PROBABILITY = 10;

	public BombSquare(int x, int y, GameBoard board)
	{
		super(x, y, "images/blank.png");

        this.board = board;
        Random rand = new Random();
        this.hasBomb = (rand.nextInt(MINE_PROBABILITY)) == 0;
    }    

    public boolean getBomb(){
        return this.hasBomb; //checks square to see if there's a bomb
    }
    public boolean getChecked(){
        return this.checked; //checks square to see if checked
    }

    public void checkArea(){
        int bombs = 0; //variable increments when bombs discovered
        
        for (int i = -1; i < 2; i++){
            for (int n = -1; n < 2;n++){
                BombSquare square = (BombSquare) board.getSquareAt((getXLocation()+i),(getYLocation()+n)); //square generated with each iteration of loop so new bomb values can be given

                if (square != null){               //makes sure the square is within the gameboard boundaries
                    if (square.getChecked() == false){      //makes sure the square has not been checked before
                        if (square.getBomb()){
                            bombs++;        //if bombs are in the square, increment variable for square and set image
                            square.setImage("images/blank.png");   
                        }            
                    } 
                }

            }             
        }

        board.getSquareAt(getXLocation(),getYLocation()).setImage("images/"+ bombs +".png");    //change the image of squares to display # of bombs in vicinity and checks
        checked = true;

        if (bombs == 0){ // if no bombs are found, iterates through another loop
            for (int i = -1; i < 2; i++){
                for (int n = -1; n < 2; n++){
                    BombSquare square = (BombSquare) board.getSquareAt((getXLocation()+i),(getYLocation()+n));
                    if(square != null){
                        if(square.getChecked() == false){                   
                            square.checkArea(); //recursively goes through the same method with values of square instead of the left click
                            square.checked = true;

                        }
                    }
                }
            }
        }
    }

    

    @Override
    public void leftClicked() {
        if(this.hasBomb){ //if square has the bomb, sets the image (Doesn't end the game though, as that's not on the specification)
            setImage("images/bomb.png");
            checked=true;
        }
        else{
            checkArea();
            checked=true;
        }
    }

    @Override
    public void rightClicked() {

        BombSquare square = (BombSquare) board.getSquareAt((getXLocation()),(getYLocation()));

        if (square.checked == false){        //checks to ensure the square hasn't been checked
            setImage("images/flag.png");
            square.checked = true;          //changes boolean variables for the square so it won't be revealed
            square.flagged = true;        
        }

        else if (square.flagged == true){   //will revert what the initial click did - back to unchecked and unflagged
            setImage("images/blank.png");
            square.checked = false;
            square.flagged = false;
        }
    }

}
