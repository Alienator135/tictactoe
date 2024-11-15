package TicTacToe_Interface;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class NewWindow {
	//instance variables
	JFrame instructFrame = new JFrame();
	JLabel instructLabelone = new JLabel();
	JLabel instructLabeltwo = new JLabel();
	JLabel instructLabelthree = new JLabel();
	
	NewWindow(){
		instructLabelone.setVisible(true);
		instructLabelone.setBounds(25,0,700,50);
		instructLabelone.setFont(new Font("Arial", Font.PLAIN, 15));
		instructLabelone.setBackground(Color.decode("#ADD8E6"));
		instructLabelone.setText("1. Player 1 is X , Player 2 is O. Players take turns putting their marks by clicking in empty squares.");
		
		instructLabeltwo.setVisible(true);
		instructLabeltwo.setBounds(25,30,700,50);
		instructLabeltwo.setFont(new Font("Arial", Font.PLAIN, 15));
		instructLabeltwo.setBackground(Color.decode("#ADD8E6"));
		instructLabeltwo.setText("2. The first player to get 3 of their marks in a row (up, down, across, or diagonally) is the winner.");
		
		instructLabelthree.setVisible(true);
		instructLabelthree.setBounds(25,60,700,50);
		instructLabelthree.setFont(new Font("Arial", Font.PLAIN, 15));
		instructLabelthree.setBackground(Color.decode("#ADD8E6"));
		instructLabelthree.setText("3. When all 9 squares are full, if no player has 3 marks in a row, the game ends in a tie.");
	
		instructFrame.setSize(700,150);
		instructFrame.setVisible(true);
		instructFrame.add(instructLabelone);
		instructFrame.add(instructLabeltwo);
		instructFrame.add(instructLabelthree);
		instructFrame.setLayout(null);
	}
	
}
