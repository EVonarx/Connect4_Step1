package fr.evonarx.connect4;

public class Grid {

	private char[][] Grid = new char[6][7];

	
	public char[][] getGrid() {
		return Grid;
	}

	
	public void  setGrid(char[][] grid) {
		Grid = grid;
	}
	
	
	public  void initGrid() {
		for (int i=0; i<6; i++) {
			for (int j=0; j<7; j++)
				Grid[i][j] = ' ';
		}
		
	}
	
	public void printGrid() {
		System.out.println();
		for (int i=0; i<6; i++) 
			System.out.println(6-i + "  [  |" + Grid[5-i][0] + "|  |" + Grid[5-i][1] + "|  |" + Grid[5-i][2] + "|  |" + Grid[5-i][3]+ "|  |" + Grid[5-i][4] + "|  |" + Grid[5-i][5] + "|  |" + Grid[5-i][6]+ "|  ]");
		System.out.println("       1    2    3    4    5    6    7 ");
	
	}
	
	public boolean isGridFull() {
		int compt = 0;
		
		for (int i=0; i<6; i++) {
			for (int j=0; j<7; j++)
				if (Grid[i][j] != ' ') compt++;
		}
		
		if (compt == 42) return true;
		
		return false;
	}
	
	
	public boolean putTokenInTheColum(String answer, char current_player ) {
		
		int a = Integer.parseInt(answer);
		for (int i=0; i<6; i++) {
			if (Grid [i][a-1] == ' ') {
				if (current_player == Player.PLAYER_ONE) Grid [i][a-1] = '1';
				if (current_player == Player.PLAYER_TWO) Grid [i][a-1] = '2';
				return true;
			}
		}
		 return false;	
		
	}
	
	
	public boolean isThereAWinner(char current_player) {
		boolean winner = false;
	
		winner = Are4SlotsConnect.Are4SlotsConnectHorizontally(Grid, current_player);
		if (!winner) winner = Are4SlotsConnect.Are4SlotsConnectVertically(Grid, current_player);
		if (!winner) winner = Are4SlotsConnect.Are4SlotsConnectInDiagonalUp(Grid, current_player); // à tester plus profondément
		if (!winner) winner = Are4SlotsConnect.Are4SlotsConnectInDiagonalDown(Grid, current_player);	// à tester plus profondément
			
		return winner;
	} 
	
}
