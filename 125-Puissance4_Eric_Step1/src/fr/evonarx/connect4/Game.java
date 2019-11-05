package fr.evonarx.connect4;

import java.util.Scanner;
import java.lang.Integer;

public class Game {
	
	Grid grid = new Grid();
	Player player = new Player();
	
	public Game() {
		grid.initGrid();
		grid.printGrid();
		player.initCurrent_player();
	}


	public void go() {
		
		boolean EndOfTheGame= false;
		boolean change_player = false;
		
		while (!EndOfTheGame) {
			if (!grid.isThereAWinner(player.getCurrent_player())) {
				if (!grid.isGridFull()) {
					if (change_player == true ) player.changePlayer(player.getCurrent_player());
					change_player = play(player.getCurrent_player());
				}
				else {
						EndOfTheGame= true;
						System.out.println("Match nul");
				}
			}
				
			else {
				EndOfTheGame= true;
				System.out.println("There is a winner...It is player "+ player.getCurrent_player());
			}
		}
		
		
	}
	

	private boolean play(char current_player) {
		 Scanner input = new Scanner(System.in);
		 String answer ="";
		
		 while (!isAnswerInRange(answer))
		    {
			    System.out.print("Player " + current_player + " : Enter the column number (1 to 7) => ");
			    answer = input.next();
			    answer.toLowerCase();
		    }
		 
		 if (grid.putTokenInTheColum(answer, current_player)) {
			 grid.printGrid();
			 return true;
			 }
		 else {
			 System.out.println("This column is full !!!!");
			 return false;
		 }
			 
	}
	
	
	private boolean isAnswerInRange(String s) {
		if (s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4") || s.equals("5") || s.equals("6") || s.equals("7"))
			return true;
		return false;
	}


	public static void main(String[] args) {
		Game j = new Game();
		j.go();
	}
	
}
