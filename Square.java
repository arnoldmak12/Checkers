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

public class Square extends JButton implements ActionListener {

	private int xCord;
	private int yCord;
	private Piece piece;
	private boolean clickable;
	private boolean clicked;
	private boolean anyclicked;
	private int click;
	private Board board;

	public Square(int x, int y, Board boardPar) {

		xCord = x;
		yCord = y;
		piece = new Piece(this, 0);
		click = 0;
		clicked = false;
		anyclicked = false;
		board = boardPar;

		this.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		// if()

		if (clickable) {
			if (!anyclicked) {
				clicked = true;
				click++;
				click %= 2;
				if (click == 0) {
					this.setBackground(Color.CYAN);

				} else if (click == 1) {
					this.setBackground(Color.GREEN);
					board.getxfromPress();
					board.getyfromPress();
					board.makeAllSquaresUnclickable();
					this.clickable = true;
					this.clicked = true;
					board.setanyclicked(true);
					board.setMoveLocationsclickable(xCord, yCord);
				}
			} else if (anyclicked) {
				if (clicked) {
					board.resetColors();
					board.resetclickable();
					board.setanyclicked(false);
					this.clicked = false;
					board.resetclick();
				} else if (!clicked) {
					board.movePieces(xCord, yCord);
					board.resetColors();
					board.resetclickable();
					board.resetclick();
					board.setanyclicked(false);
					board.resetanyclicked();
					board.resetclicked();
				}

			}
		}

	}

	public int getxCord() {
		return xCord;
	}

	public int getyCord() {
		return yCord;
	}

	public boolean getclicked() {
		return clicked;
	}

	public Piece getpiece() {
		return piece;
	}

	public void xCord(int x) {
		xCord = x;
	}

	public void yCord(int y) {
		yCord = y;
	}

	public void piece(Piece p) {
		piece = p;
	}

	public void setclickable(boolean b) {
		clickable = b;
	}

	public void setanyclicked(boolean b) {
		anyclicked = b;
	}

	public void setclick(int i) {
		click = i;
	}

	public void setclicked(boolean b) {
		clicked = b;
	}

	public void setpiece(int p) {
		piece = new Piece(this, p);
		piece.setid(p);

		if (piece.getid() != 0 && piece.getid() < 20) {
			clickable = true;// System.out.println("bi");
		} else {
			clickable = false;
		}
	}

}
