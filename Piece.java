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

//color square 
public class Piece {
	private int id;// 0=empty 11=red 21=black 12=red king 22=black king
	private Square tile;

	public Piece(Square s, int p) {
		tile = s;
		id = p;
	}

	public int getid() {
		return id;
	}

	public Square gettile() {
		return tile;
	}

	public void setid(int i) {
		id = i;
		setPNG(id);
	}

	public void settile(Square s) {
		tile = s;
	}

	private void setPNG(int i) {
		ImageIcon imageIcon;

		if (i == 0) {
			tile.setIcon(null);
		} else if (i == 11) {
			imageIcon = new ImageIcon(this.getClass().getResource("redPiece.png"));
			tile.setIcon(imageIcon);
		} else if (i == 21) {
			imageIcon = new ImageIcon(this.getClass().getResource("blackPiece.png"));
			tile.setIcon(imageIcon);
		} else if (i == 12) {
			imageIcon = new ImageIcon(this.getClass().getResource("redPieceKing.png"));
			tile.setIcon(imageIcon);
		} else if (i == 22) {
			imageIcon = new ImageIcon(this.getClass().getResource("redPieceKing.png"));
			tile.setIcon(imageIcon);
		}
	}

}
