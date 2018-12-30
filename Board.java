import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.io.IOException;
import java.lang.ProcessBuilder;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;

public class Board extends JFrame {

	private Square buttons[][] = new Square[8][8];
	private int clickedx;
	private int clickedy;

	public Board() {

		JFrame frame = new JFrame();
		frame.setSize(1000, 1000);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setLayout(new GridLayout(8, 8));

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				buttons[i][j] = new Square(i, j, this);
				frame.add(buttons[i][j]);
				if ((i + j) % 2 == 0) {
					buttons[i][j].setBackground(Color.RED);

				} else {
					buttons[i][j].setBackground(Color.BLACK);

					if (i < 3) {
						buttons[i][j].setpiece(21);
					} else if (i > 4) {
						buttons[i][j].setpiece(11);
					}

				}

				frame.add(buttons[i][j]);
			}
		}

		frame.setVisible(true);
	}

	public Square[][] getbuttons() {
		return buttons;
	}

	public void makeAllSquaresUnclickable() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				buttons[i][j].setclickable(false);
			}
		}

	}

	public void resetColors() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i + j) % 2 == 0) {
					buttons[i][j].setBackground(Color.RED);

				} else {
					buttons[i][j].setBackground(Color.BLACK);
				}
			}
		}
	}

	public void resetclickable() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((buttons[i][j].getpiece()).getid() != 0 && (buttons[i][j].getpiece()).getid() < 20) {
					buttons[i][j].setclickable(true);
				} else {
					buttons[i][j].setclickable(false);
				}
			}
		}

	}

	public void resetanyclicked() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				buttons[i][j].setanyclicked(false);
			}
		}
	}

	public void setanyclicked(boolean b) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				buttons[i][j].setanyclicked(b);
			}
		}
	}

	public void resetclick() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				buttons[i][j].setclick(0);
			}
		}
	}

	public void resetclicked() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				buttons[i][j].setclicked(false);
			}
		}
	}

	public void setMoveLocationsclickable(int x, int y) {

		if (buttons[x][y].getpiece().getid() == 11) {
			redPiececlickable(x, y);
		} else if (buttons[x][y].getpiece().getid() == 12) {

		}
	}

	public void redPiececlickable(int row, int col) {
		/*
		 * if (row > 0 && col > 0 && buttons[row - 2][col - 2].getpiece().getid() == 0
		 * && buttons[row - 1][col - 1].getpiece().getid() == 12) {
		 * 
		 * }else {
		 */
		if (row > 0 && col > 0 && buttons[row - 1][col - 1].getpiece().getid() == 0) {
			buttons[row - 1][col - 1].setclickable(true);
			buttons[row - 1][col - 1].setBackground(Color.CYAN);
		}

		if (row > 0 && col < 7 && buttons[row - 1][col + 1].getpiece().getid() == 0) {
			buttons[row - 1][col + 1].setclickable(true);
			buttons[row - 1][col + 1].setBackground(Color.CYAN);
		}

	}

	public void getxfromPress() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (buttons[i][j].getclicked()) {
					clickedx = buttons[i][j].getxCord();
				}
			}
		}
	}

	public void getyfromPress() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (buttons[i][j].getclicked()) {
					clickedy = buttons[i][j].getyCord();
				}
			}
		}
	}

	public void movePieces(int newx, int newy) {
		buttons[newx][newy].setpiece(buttons[clickedx][clickedy].getpiece().getid());
		buttons[clickedx][clickedy].setpiece(0);
	}

}