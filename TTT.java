package TicTacToe_Interface;
/**
 * TTT class.
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

public class TTT implements ActionListener{ //implements event listener superclass
	//instance variables
	private String player1 = "X", player2 = "O";
	private JButton[][] tttBoard;
	private JFrame frame = new JFrame();
	private String currPlayer = player1;
	private int movesMade;
	private int gamesPlayed = 0;
	private int XWins = 0;
	private int OWins = 0;
	private boolean gameInProg = false;
	private JButton startButton = new JButton("Start New Game");
	private JButton instructButton = new JButton("How to Play");
	private JButton restartButton = new JButton("Restart Game");
	private JButton backButton = new JButton("Back to Main");
	private JPanel gamePanel = new JPanel();
	private JPanel topPanel = new JPanel();
	private JPanel introPanel = new JPanel();
	private JLabel titleLabel = new JLabel();
	private JLabel creditLabel = new JLabel();
	private JLabel scoreLabel = new JLabel();
	private JLabel xwinsLabel = new JLabel();
	private JLabel owinsLabel = new JLabel();
	private JLabel turnLabel = new JLabel();
	
	
	/**
	 * 
	 * constructor
	 * pre: none
	 * post: intro panel is shown. tttBoard has been initialized. player1 is X and player2 is O.
	 * 
	 */
	public TTT() {
		player1 = "X";
		player2 = "O";
		tttBoard = new JButton [3][3];
		
		titleLabel.setFont(new Font("Century Gothic", Font.BOLD,70));
		titleLabel.setVisible(true);
		titleLabel.setBounds(100,100,600,200);
		titleLabel.setText("Tic-Tac-Toe");
		introPanel.add(titleLabel);
		
		creditLabel.setFont(new Font("Arial", Font.PLAIN,30));
		creditLabel.setVisible(true);
		creditLabel.setBounds(100,200,600,200);
		creditLabel.setText("By: Hubert Chan & Oliver Ren");
		introPanel.add(creditLabel);
		
		startButton.setFont(new Font("Century Gothic", Font.ROMAN_BASELINE, 30));
		startButton.setVisible(true);
		startButton.addActionListener(this);
		startButton.setBounds(150,350,300,100);
		introPanel.add(startButton);
		
		instructButton.setFont(new Font("Century Gothic", Font.ROMAN_BASELINE, 30));
		instructButton.setVisible(true);
		instructButton.addActionListener(this);
		instructButton.setBounds(150,460,300,100);
		introPanel.add(instructButton);
		
		introPanel.setBackground(Color.decode("#87CEEB"));
		introPanel.setVisible(true);
		introPanel.setBounds(0,0,600,735);
		introPanel.setLayout(null);
		
		gamePanel.setBackground(Color.black);
		gamePanel.setLayout(new GridLayout(3,3,5,5));
		gamePanel.setVisible(false);
		gamePanel.setBounds(0,100,600,600);
		
		restartButton.setVisible(true);
		restartButton.setBounds(0,0,100,50);
		restartButton.addActionListener(this);
		restartButton.setFont(new Font("Arial", Font.BOLD, 10));
		topPanel.add(restartButton);
		
		backButton.setVisible(true);
		backButton.setBounds(0,50,100,50);
		backButton.addActionListener(this);
		backButton.setFont(new Font("Arial", Font.BOLD, 10));
		backButton.setBackground(Color.YELLOW);
		topPanel.add(backButton);
		
		scoreLabel.setVisible(true);
		scoreLabel.setBounds(125,0,400,50);
		scoreLabel.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		scoreLabel.setBackground(Color.decode("#ADD8E6"));
		scoreLabel.setText("Number of Games Played: "+gamesPlayed);
		topPanel.add(scoreLabel);
		xwinsLabel.setVisible(true);
		xwinsLabel.setBounds(425,0,500,50);
		xwinsLabel.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		xwinsLabel.setBackground(Color.decode("#ADD8E6"));
		xwinsLabel.setText("X's Wins: "+XWins);
		topPanel.add(xwinsLabel);
		owinsLabel.setVisible(true);
		owinsLabel.setBounds(425,50,500,50);
		owinsLabel.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		owinsLabel.setBackground(Color.decode("#ADD8E6"));
		owinsLabel.setText("O's Wins: "+OWins);
		topPanel.add(owinsLabel);
		
		turnLabel.setVisible(true);
		turnLabel.setBounds(125,50,200,50);
		turnLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		turnLabel.setForeground(Color.CYAN);
		turnLabel.setText(currPlayer + "'s turn.");
		topPanel.add(turnLabel);
		
		topPanel.setBackground(Color.decode("#d3d3d3"));
		topPanel.setVisible(false);
		topPanel.setBounds(0,0,600,200);
		topPanel.setLayout(null);
		

		frame.setTitle("Tic-Tac-Toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(600,735);
		frame.setVisible(true);
		frame.add(gamePanel);
		frame.add(topPanel);
		frame.add(introPanel);
		frame.setLayout(null);
		frame.setResizable(false);
		
		//instantiates JButton arraylist, sets text as space
		for(int row=0; row<3;row++) {
			for(int col=0;col<3;col++) {
				tttBoard[row][col] = new JButton(" ");
				gamePanel.add(tttBoard[row][col]);
				tttBoard[row][col].setFont(new Font("Arial", Font.BOLD, 150));
				tttBoard[row][col].setVisible(true);
				tttBoard[row][col].addActionListener(this);
			}
		}
	}
	

	/** 
	 * Plays a game of tic-tac-toe with two users, keeping track
	 * of player (X or O) turns. player1 and player 2 take turns going first.
	 */
	public void play() {
		//resets variables
		movesMade = 0;
		restartButton.setBackground(Color.decode("#FFCCCB"));
		xwinsLabel.setForeground(Color.BLACK);
		owinsLabel.setForeground(Color.BLACK);
		
		//updates trackers
		scoreLabel.setText("Number of Games Played: "+gamesPlayed);
		xwinsLabel.setText("X's Wins: "+XWins);
		owinsLabel.setText("O's Wins: "+OWins);
		turnLabel.setText(currPlayer + "'s turn.");
		
		//resets board
		for(int row=0; row<3;row++) {
			for(int col=0;col<3;col++) {
				tttBoard[row][col].setText(" ");	
			}
		}
	}
	
	public void actionPerformed(ActionEvent event) {
		String prevPlayer = currPlayer; //stores player that went most recently
		for(int row=0;row<3;row++) {
			for(int col=0;col<3;col++) {
				//checks which button was pressed, and updates board if move is valid
				if(event.getSource()==tttBoard[row][col]&&makeMove(currPlayer,row,col)==true) {
					tttBoard[row][col].setText(prevPlayer);
					movesMade += 1;
					
					// Set color of tile depending on player that most recently went
					if (prevPlayer == "X") {
						tttBoard[row][col].setForeground(Color.decode("#ADD8E6"));
					} else if (prevPlayer == "O") {
						tttBoard[row][col].setForeground(Color.decode("#FFD8A7"));
					}

					//checks win conditions
					if (movesMade==9||winner()!=" ") {
						gameInProg=false;
						gamesPlayed+=1;
						restartButton.setBackground(Color.GREEN);
						
						if (winner()!=" "){
							if(winner()=="X") {
								XWins+=1;
								xwinsLabel.setText("X's Wins: "+XWins);
								xwinsLabel.setForeground(Color.YELLOW);
							}else if(winner()=="O") {
								OWins+=1;
								owinsLabel.setText("O's Wins: "+OWins);
								owinsLabel.setForeground(Color.YELLOW);
							}
							
							scoreLabel.setText("Number of Games Played: "+gamesPlayed);
							turnLabel.setText("GAME OVER!");
							//gives result + gives user option to replay the game
							int finishAns = JOptionPane.showConfirmDialog(null, winner()+" is the winner! Play Again?", "Victory!", JOptionPane.YES_NO_OPTION);
								if (finishAns==0) {
									play();
									gameInProg=true;
								}
						}else if (winner()==" ") {
							scoreLabel.setText("Number of Games Played: "+gamesPlayed);
							turnLabel.setText("GAME OVER!");
							
							int finishAns = JOptionPane.showConfirmDialog(null, "It's a Draw! Play Again?", "Tie!", JOptionPane.YES_NO_OPTION);
							if (finishAns==0) {
								play();
								gameInProg=true;
							}
						}
					}
				}
			}
		}
		//starts/restarts the tictactoe game
		if(event.getSource()==startButton||event.getSource()==restartButton) {
			introPanel.setVisible(false);
			gamePanel.setVisible(true);
			topPanel.setVisible(true);
			//notifies user of in progress game, confirms choice
			if (gameInProg==true&&movesMade!=0) {
				int progAns = JOptionPane.showConfirmDialog(null, "Are you sure? You have a game in progress!", "Confirm", JOptionPane.YES_NO_OPTION);
				if (progAns==0) {
					play();
					gameInProg=true;
				}
			}else{
				play();
				gameInProg=true;
			}
		}
		//returns user to home screen
		if(event.getSource()==backButton) {
			if (gameInProg==true||gamesPlayed!=0) {
				//confirms they will lose tracker stats
				int backAns= JOptionPane.showConfirmDialog(null, "Are you sure? You will lose your progress!", "Confirm", JOptionPane.YES_NO_OPTION);
				if (backAns==0) {
					gamesPlayed=0;
					XWins = 0;
					OWins = 0;
					introPanel.setVisible(true);
					gamePanel.setVisible(false);
					topPanel.setVisible(false);
					gameInProg=false;	
				}
		}else {
			introPanel.setVisible(true);
			gamePanel.setVisible(false);
			topPanel.setVisible(false);
			gameInProg=false;
		}
	}
		//opens new window containing instructions when "how to play" button is pressed
		if(event.getSource()==instructButton) {
			NewWindow instructWindow = new NewWindow();
			
		}
		
	}


	/** 
	 * Prompt user for a move until a valid move has been made.
	 * pre: none
	 * post: A mark has been made in an empty tic-tac-toe board square.
	 * @return 
	 */
	private boolean makeMove(String player, int row, int col) {
		//checks if move is valid
		if ((row >= 0 && row < tttBoard.length && col >= 0 && col < tttBoard[0].length) && tttBoard[row][col].getText().equals(" ")) {
			//changes turn to next player	
			if (player == "X"){
						currPlayer=player2;
				}else if (player == "O") {
					currPlayer=player1;
				}
				turnLabel.setText(currPlayer + "'s turn.");
				return true;
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Move! Try again.", "Error", JOptionPane.ERROR_MESSAGE);
					return false;
				}				

	}


	/** 
	 * Determine winner. Return " " if no winner.
	 * pre: none
	 * post: X, O, or " " has been returned as the winner.
	 */
	private String winner() {
		/* test rows */
		for (int row = 0; row < tttBoard.length; row++) {
			if (tttBoard[row][0].getText().equals(tttBoard[row][1].getText()) && tttBoard[row][1].getText().equals(tttBoard[row][2].getText()) &&
				!(tttBoard[row][0].getText().equals(" "))) {
					return(tttBoard[row][0].getText());	
			}
		}
		/* test columns */
		for (int col = 0; col < tttBoard[0].length; col++) {
			if (tttBoard[0][col].getText().equals(tttBoard[1][col].getText()) && tttBoard[1][col].getText().equals(tttBoard[2][col].getText()) &&
				!(tttBoard[0][col].getText().equals(" "))) {
					return(tttBoard[0][col].getText());
			}
		}
		/* test diagonal */
		if (tttBoard[0][0].getText().equals(tttBoard[1][1].getText()) && tttBoard[1][1].getText().equals(tttBoard[2][2].getText()) &&
			!(tttBoard[0][0].getText().equals(" "))) {
			return(tttBoard[0][0].getText());
		}
		/* test other diagonal */
		if (tttBoard[0][2].getText().equals(tttBoard[1][1].getText()) && tttBoard[1][1].getText().equals(tttBoard[2][0].getText()) &&
			!(tttBoard[0][2].getText().equals(" "))) {
			return(tttBoard[0][2].getText());
		}
		return(" ");
	}
}