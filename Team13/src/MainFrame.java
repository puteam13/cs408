import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;
import java.sql.*;

public class MainFrame extends JPanel implements ActionListener, KeyListener {
	Timer t;
	ImageIcon BackImg;
	Image wall_image;
	Image road_image;
	Image poop_image;
	Image octopus_image;
	int difficulty;
	int grid[][] = new int[Global.Width][Global.Hight];
	int level_size;
	int poopx = 60, poopy = 120, velx = 1, vely = 2;
	int octopusx = 20, octopusy = 100, movex = 0, movey = 0;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.GRAY);
		g.setColor(Color.green);
		g.drawOval(0, 0, 20, 20);
		first_level(g);
		ImageIcon poop_ImageIcon = new ImageIcon("images/poop.png");
		poop_image = poop_ImageIcon.getImage();
		g.drawImage(poop_image, poopx, poopy, null);

		ImageIcon octopus_ImageIcon = new ImageIcon("images/snake3.png");
		octopus_image = octopus_ImageIcon.getImage();
		g.drawImage(octopus_image, octopusx, octopusy, null);

		g.drawRect(20, 20, 20, 20);
		t.start();
		repaint();
	}

	public void first_level(Graphics g) {

		ImageIcon wall_ImageIcon = new ImageIcon("images/wall24.png");
		ImageIcon road_ImageIcon = new ImageIcon("images/road24.png");
		wall_image = wall_ImageIcon.getImage();
		road_image = road_ImageIcon.getImage();
		buildwallroom10();
		for (int i = 0; i < level_size; i++) {
			for (int j = 0; j < level_size; j++) {
				if (grid[i][j] == Global.WALL) {
					// g.drawRect(20, 20, 20, 20);
					g.drawImage(wall_image, i * 20, j * 20, null);

				} else if (grid[i][j] == Global.ROAD) {

					g.drawImage(road_image, i * 20, j * 20, null);

				}

			}

		}
		// g.drawImage(wall_image, 0, 20, null);
		// g.drawImage(wall_image, 20, 0, null);

	}

	public void buildwallroom1() {
		level_size = 12;

		for (int i = 0; i < level_size; i++) {
			setwall(i, 0);
			setwall(i, level_size - 1);
		}
		for (int j = 0; j < level_size; j++) {
			if (j != 1)
				setwall(0, j);
			if (j != level_size - 2)
				setwall(level_size - 1, j);
		}

		setwall(2, 2);
		setwall(2, 3);
		setwall(2, 4);
		setwall(2, 5);
		setwall(2, 7);
		setwall(2, 8);
		setwall(2, 9);
		setwall(3, 2);
		setwall(4, 2);
		setwall(4, 4);
		setwall(4, 6);
		setwall(4, 7);
		setwall(4, 9);
		setwall(4, 10);
		setwall(5, 2);
		setwall(5, 4);
		setwall(5, 6);
		setwall(6, 2);
		setwall(6, 4);
		setwall(6, 6);
		setwall(6, 8);
		setwall(6, 9);
		setwall(6, 10);
		setwall(7, 4);
		setwall(7, 6);
		setwall(8, 2);
		setwall(8, 4);
		setwall(8, 6);
		setwall(8, 8);
		setwall(9, 8);
		setwall(9, 9);
		setwall(9, 10);
		setwall(10, 2);
		setwall(10, 3);
		setwall(10, 4);
		setwall(10, 6);

	}

	public void buildwallroom2() {
		level_size = 12;
		for (int i = 0; i < level_size; i++) {
			setwall(i, 0);
			setwall(i, level_size - 1);
		}
		for (int j = 0; j < level_size; j++) {
			if (j != 1)
				setwall(0, j);
			if (j != level_size - 2)
				setwall(level_size - 1, j);
		}

		setwall(1, 2);
		setwall(1, 4);
		setwall(1, 6);
		setwall(1, 8);
		setwall(1, 9);
		setwall(1, 10);
		setwall(2, 2);
		setwall(2, 6);
		setwall(3, 2);
		setwall(3, 4);
		setwall(3, 8);
		setwall(3, 10);
		setwall(4, 2);
		setwall(4, 6);
		setwall(5, 4);
		setwall(5, 6);
		setwall(5, 8);
		setwall(5, 9);
		setwall(5, 10);
		setwall(6, 2);
		setwall(6, 4);
		setwall(7, 2);
		setwall(7, 4);
		setwall(7, 6);
		setwall(7, 8);
		setwall(7, 10);
		setwall(8, 4);
		setwall(9, 2);
		setwall(9, 6);
		setwall(9, 8);
		setwall(9, 9);
		setwall(9, 10);
		setwall(10, 2);
		setwall(10, 4);
		setwall(10, 6);
	}

	public void buildwallroom3() {
		level_size = 14;
		for (int i = 0; i < level_size; i++) {
			setwall(i, 0);
			setwall(i, level_size - 1);
		}
		for (int j = 0; j < level_size; j++) {
			if (j != 1)
				setwall(0, j);
			if (j != level_size - 2)
				setwall(level_size - 1, j);
		}

		setwall(2, 2);
		setwall(2, 3);
		setwall(2, 4);
		setwall(2, 5);
		setwall(2, 7);
		setwall(2, 8);
		setwall(2, 9);
		setwall(2, 10);
		setwall(2, 11);
		setwall(3, 2);
		setwall(3, 11);
		setwall(4, 2);
		setwall(4, 4);
		setwall(4, 5);
		setwall(4, 7);
		setwall(4, 8);
		setwall(4, 9);
		setwall(4, 11);
		setwall(5, 2);
		setwall(5, 4);
		setwall(5, 9);
		setwall(6, 4);
		setwall(6, 6);
		setwall(6, 7);
		setwall(6, 9);
		setwall(6, 11);
		setwall(7, 2);
		setwall(7, 6);
		setwall(7, 9);
		setwall(7, 10);
		setwall(7, 11);
		setwall(8, 2);
		setwall(8, 4);
		setwall(8, 11);
		setwall(9, 2);
		setwall(9, 4);
		setwall(9, 6);
		setwall(9, 7);
		setwall(9, 8);
		setwall(9, 9);
		setwall(9, 11);
		setwall(10, 2);
		setwall(10, 9);
		setwall(10, 11);
		setwall(11, 2);
		setwall(11, 3);
		setwall(11, 4);
		setwall(11, 5);
		setwall(11, 7);
		setwall(11, 8);
		setwall(11, 9);
		setwall(11, 11);
		setwall(11, 12);
		setwall(12, 9);

	}

	public void buildwallroom4() {
		level_size = 14;
		for (int i = 0; i < level_size; i++) {
			setwall(i, 0);
			setwall(i, level_size - 1);
		}
		for (int j = 0; j < level_size; j++) {
			if (j != 1)
				setwall(0, j);
			if (j != level_size - 2)
				setwall(level_size - 1, j);
		}

		setwall(1, 10);
		setwall(2, 2);
		setwall(2, 3);
		setwall(2, 4);
		setwall(2, 5);
		setwall(2, 7);
		setwall(2, 8);
		setwall(2, 10);
		setwall(2, 11);
		setwall(3, 2);
		setwall(3, 4);
		setwall(3, 8);
		setwall(3, 11);
		setwall(4, 2);
		setwall(4, 4);
		setwall(4, 6);
		setwall(4, 8);
		setwall(4, 9);
		setwall(5, 2);
		setwall(5, 8);
		setwall(5, 11);
		setwall(6, 4);
		setwall(6, 6);
		setwall(6, 8);
		setwall(6, 10);
		setwall(6, 11);
		setwall(7, 2);
		setwall(7, 4);
		setwall(7, 11);
		setwall(8, 2);
		setwall(8, 6);
		setwall(8, 8);
		setwall(8, 9);
		setwall(8, 11);
		setwall(9, 2);
		setwall(9, 4);
		setwall(9, 5);
		setwall(9, 6);
		setwall(9, 11);
		setwall(10, 2);
		setwall(10, 4);
		setwall(10, 8);
		setwall(10, 10);
		setwall(10, 11);
		setwall(11, 2);
		setwall(11, 4);
		setwall(11, 6);
		setwall(11, 8);
		setwall(11, 9);
		setwall(11, 10);
		setwall(12, 6);
		setwall(12, 8);
	}

	public void buildwallroom5() {
		level_size = 17;
		for (int i = 0; i < level_size; i++) {
			setwall(i, 0);
			setwall(i, level_size - 1);
		}
		for (int j = 0; j < level_size; j++) {
			if (j != 1)
				setwall(0, j);
			if (j != level_size - 2)
				setwall(level_size - 1, j);
		}

		setwall(2, 2);
		setwall(2, 3);
		setwall(2, 4);
		setwall(2, 5);
		setwall(2, 6);
		setwall(2, 7);
		setwall(2, 9);
		setwall(2, 10);
		setwall(2, 11);
		setwall(2, 12);
		setwall(2, 13);
		setwall(2, 14);
		setwall(3, 2);
		setwall(3, 14);
		setwall(4, 2);
		setwall(4, 4);
		setwall(4, 5);
		setwall(4, 6);
		setwall(4, 7);
		setwall(4, 9);
		setwall(4, 10);
		setwall(4, 12);
		setwall(5, 2);
		setwall(5, 4);
		setwall(5, 12);
		setwall(5, 14);
		setwall(5, 15);
		setwall(6, 2);
		setwall(6, 4);
		setwall(6, 6);
		setwall(6, 7);
		setwall(6, 9);
		setwall(6, 10);
		setwall(6, 12);
		setwall(6, 14);
		setwall(6, 15);
		setwall(7, 2);
		setwall(7, 4);
		setwall(7, 6);
		setwall(7, 10);
		setwall(7, 12);
		setwall(7, 14);
		setwall(7, 15);
		setwall(8, 10);
		setwall(8, 12);
		setwall(9, 2);
		setwall(9, 4);
		setwall(9, 6);
		setwall(9, 12);
		setwall(9, 13);
		setwall(9, 14);
		setwall(10, 2);
		setwall(10, 4);
		setwall(10, 6);
		setwall(10, 7);
		setwall(10, 8);
		setwall(10, 10);
		setwall(10, 12);
		setwall(10, 13);
		setwall(10, 14);
		setwall(11, 2);
		setwall(11, 12);
		setwall(11, 13);
		setwall(11, 14);
		setwall(12, 2);
		setwall(12, 4);
		setwall(12, 5);
		setwall(12, 6);
		setwall(12, 7);
		setwall(12, 8);
		setwall(12, 9);
		setwall(12, 10);
		setwall(12, 11);
		setwall(12, 12);
		setwall(13, 2);
		setwall(13, 9);
		setwall(13, 10);
		setwall(13, 11);
		setwall(13, 14);
		setwall(13, 15);
		setwall(14, 2);
		setwall(14, 3);
		setwall(14, 5);
		setwall(14, 6);
		setwall(14, 7);
		setwall(14, 9);
		setwall(14, 10);
		setwall(14, 11);
		setwall(15, 5);
		setwall(15, 6);
		setwall(15, 7);
		setwall(15, 13);
		setwall(15, 14);

	}

	public void buildwallroom6() {
		level_size = 16;
		for (int i = 0; i < level_size; i++) {
			setwall(i, 0);
			setwall(i, level_size - 1);
		}
		for (int j = 0; j < level_size; j++) {
			if (j != 1)
				setwall(0, j);
			if (j != level_size - 2)
				setwall(level_size - 1, j);
		}

		setwall(6, 1);
		setwall(12, 1);
		setwall(2, 2);
		setwall(3, 2);
		setwall(4, 2);
		setwall(6, 2);
		setwall(8, 2);
		setwall(9, 2);
		setwall(10, 2);
		setwall(11, 2);
		setwall(12, 2);
		setwall(14, 2);
		setwall(4, 3);
		setwall(6, 3);
		setwall(8, 3);
		setwall(1, 4);
		setwall(2, 4);
		setwall(3, 4);
		setwall(4, 4);
		setwall(6, 4);
		setwall(8, 4);
		setwall(9, 4);
		setwall(11, 4);
		setwall(12, 4);
		setwall(13, 4);
		setwall(14, 4);
		setwall(6, 5);
		setwall(11, 5);
		setwall(2, 6);
		setwall(3, 6);
		setwall(4, 6);
		setwall(5, 6);
		setwall(6, 6);
		setwall(8, 6);
		setwall(9, 6);
		setwall(10, 6);
		setwall(11, 6);
		setwall(13, 6);
		setwall(14, 6);
		setwall(2, 7);
		setwall(11, 7);
		setwall(2, 8);
		setwall(4, 8);
		setwall(5, 8);
		setwall(6, 8);
		setwall(7, 8);
		setwall(8, 8);
		setwall(9, 8);
		setwall(11, 8);
		setwall(13, 8);
		setwall(14, 8);
		setwall(2, 9);
		setwall(4, 9);
		setwall(7, 9);
		setwall(9, 9);
		setwall(11, 9);
		setwall(13, 9);
		setwall(2, 10);
		setwall(4, 10);
		setwall(6, 10);
		setwall(7, 10);
		setwall(9, 10);
		setwall(11, 10);
		setwall(2, 11);
		setwall(4, 11);
		setwall(9, 11);
		setwall(11, 11);
		setwall(13, 11);
		setwall(4, 12);
		setwall(7, 12);
		setwall(11, 12);
		setwall(13, 12);
		setwall(2, 13);
		setwall(3, 13);
		setwall(4, 13);
		setwall(6, 13);
		setwall(7, 13);
		setwall(9, 13);
		setwall(10, 13);
		setwall(11, 13);
		setwall(12, 13);
		setwall(13, 13);
		setwall(2, 14);
		setwall(6, 14);

	}

	public void buildwallroom7() {
		level_size = 18;
		for (int i = 0; i < level_size; i++) {
			setwall(i, 0);
			setwall(i, level_size - 1);
		}
		for (int j = 0; j < level_size; j++) {
			if (j != 2)
				setwall(0, j);
			if (j != level_size - 2)
				setwall(level_size - 1, j);
		}

		setwall(8, 1);
		setwall(12, 1);
		for (int i = 2; i <= 10; i++)
			setwall(i, 2);
		setwall(12, 2);
		setwall(14, 2);
		setwall(15, 2);
		setwall(16, 2);
		setwall(4, 3);
		setwall(10, 3);
		setwall(12, 3);
		setwall(14, 3);
		setwall(16, 3);
		setwall(1, 4);
		setwall(2, 4);
		setwall(4, 4);
		setwall(6, 4);
		setwall(7, 4);
		setwall(8, 4);
		setwall(14, 4);
		setwall(4, 5);
		setwall(6, 5);
		for (int i = 8; i <= 14; i++)
			setwall(i, 5);
		setwall(16, 5);
		setwall(4, 6);
		setwall(10, 6);
		for (int i = 2; i <= 8; i++)
			setwall(i, 7);
		for (int i = 10; i <= 15; i++)
			setwall(i, 7);
		setwall(4, 8);
		setwall(10, 8);
		setwall(1, 9);
		setwall(2, 9);
		setwall(4, 9);
		for (int i = 6; i <= 11; i++)
			setwall(i, 9);
		setwall(11, 9);
		setwall(15, 9);
		setwall(4, 10);
		setwall(7, 10);
		setwall(11, 10);
		for (int i = 13; i <= 16; i++)
			setwall(i, 10);
		setwall(1, 11);
		setwall(3, 11);
		setwall(4, 11);
		setwall(5, 11);
		setwall(7, 11);
		setwall(8, 11);
		setwall(9, 11);
		setwall(11, 11);
		setwall(15, 11);
		setwall(11, 12);
		setwall(13, 12);
		setwall(14, 12);
		setwall(15, 12);
		setwall(1, 13);
		setwall(2, 13);
		setwall(3, 13);
		setwall(5, 13);
		setwall(6, 13);
		setwall(7, 13);
		setwall(9, 13);
		setwall(10, 13);
		setwall(11, 13);
		setwall(13, 13);
		setwall(3, 14);
		setwall(6, 14);
		setwall(11, 14);
		setwall(13, 14);
		setwall(15, 14);
		setwall(16, 14);
		setwall(2, 15);
		setwall(3, 15);
		for (int i = 5; i <= 9; i++)
			setwall(i, 15);
		setwall(11, 15);
		setwall(13, 15);
		setwall(6, 16);
		setwall(11, 16);
		setwall(15, 16);

	}

	public void buildwallroom8() {
		level_size = 18;
		for (int i = 0; i < level_size; i++) {
			setwall(i, 0);
			setwall(i, level_size - 1);
		}
		for (int j = 0; j < level_size; j++) {
			if (j != 1)
				setwall(0, j);
			if (j != level_size - 2)
				setwall(level_size - 1, j);
		}
		setwall(4, 1);
		setwall(10, 1);
		setwall(1, 2);
		setwall(2, 2);
		setwall(6, 2);
		setwall(10, 2);
		setwall(12, 2);
		setwall(13, 2);
		setwall(14, 2);
		setwall(15, 2);
		setwall(2, 3);
		setwall(4, 3);
		setwall(5, 3);
		setwall(6, 3);
		setwall(7, 3);
		setwall(9, 3);
		setwall(10, 3);
		setwall(12, 3);
		setwall(14, 3);
		setwall(2, 4);
		setwall(7, 4);
		setwall(14, 4);
		setwall(16, 4);
		setwall(2, 5);
		setwall(3, 5);
		setwall(4, 5);
		setwall(5, 5);
		setwall(7, 5);
		setwall(8, 5);
		setwall(9, 5);
		setwall(10, 5);
		setwall(11, 5);
		setwall(12, 5);
		setwall(13, 5);
		setwall(14, 5);
		setwall(2, 6);
		setwall(7, 6);
		setwall(2, 7);
		setwall(5, 7);
		setwall(7, 7);
		setwall(9, 7);
		setwall(10, 7);
		setwall(11, 7);
		setwall(12, 7);
		setwall(13, 7);
		setwall(14, 7);
		setwall(15, 7);
		setwall(2, 8);
		setwall(4, 8);
		setwall(5, 8);
		setwall(6, 8);
		setwall(7, 8);
		setwall(9, 8);
		setwall(2, 9);
		setwall(7, 9);
		setwall(9, 9);
		setwall(10, 9);
		setwall(11, 9);
		setwall(12, 9);
		setwall(13, 9);
		setwall(14, 9);
		setwall(15, 9);
		setwall(16, 9);
		setwall(2, 10);
		setwall(4, 10);
		setwall(7, 10);
		setwall(10, 10);
		setwall(11, 10);
		setwall(12, 10);
		setwall(13, 10);
		setwall(2, 11);
		setwall(4, 11);
		setwall(5, 11);
		setwall(7, 11);
		setwall(13, 11);
		setwall(15, 11);
		setwall(2, 12);
		setwall(5, 12);
		setwall(7, 12);
		setwall(9, 12);
		setwall(10, 12);
		setwall(11, 12);
		setwall(13, 12);
		setwall(15, 12);
		setwall(2, 13);
		setwall(3, 13);
		setwall(4, 13);
		setwall(5, 13);
		setwall(7, 13);
		setwall(10, 13);
		setwall(13, 13);
		setwall(15, 13);
		setwall(5, 14);
		setwall(7, 14);
		setwall(8, 14);
		setwall(10, 14);
		setwall(13, 14);
		setwall(14, 14);
		setwall(15, 14);
		setwall(1, 15);
		setwall(2, 15);
		setwall(4, 15);
		setwall(5, 15);
		setwall(7, 15);
		setwall(10, 15);
		setwall(11, 15);
		setwall(7, 16);
		setwall(9, 16);
		setwall(10, 16);
		setwall(11, 16);
		setwall(12, 16);
		setwall(14, 16);
		setwall(15, 16);

	}

	public void buildwallroom9() {
		level_size = 20;
		for (int i = 0; i < level_size; i++) {
			setwall(i, 0);
			setwall(i, level_size - 1);
		}
		for (int j = 0; j < level_size; j++) {
			if (j != 1)
				setwall(0, j);
			if (j != level_size - 2)
				setwall(level_size - 1, j);
		}

		setwall(2, 2);
		setwall(4, 2);
		setwall(5, 2);
		setwall(6, 2);
		setwall(7, 2);
		setwall(8, 2);
		setwall(9, 2);
		setwall(11, 2);
		setwall(12, 2);
		setwall(13, 2);
		setwall(14, 2);
		setwall(15, 2);
		setwall(16, 2);
		setwall(17, 2);
		setwall(2, 3);
		setwall(7, 3);
		setwall(11, 3);
		setwall(2, 4);
		setwall(3, 4);
		setwall(4, 4);
		setwall(7, 4);
		setwall(8, 4);
		setwall(10, 4);
		setwall(11, 4);
		setwall(12, 4);
		setwall(13, 4);
		setwall(14, 4);
		setwall(15, 4);
		setwall(16, 4);
		setwall(17, 4);
		setwall(18, 4);
		setwall(2, 5);
		setwall(4, 5);
		setwall(6, 5);
		setwall(7, 5);
		setwall(11, 5);
		setwall(4, 6);
		setwall(7, 6);
		setwall(8, 6);
		setwall(9, 6);
		setwall(10, 6);
		setwall(11, 6);
		setwall(13, 6);
		setwall(14, 6);
		setwall(15, 6);
		setwall(16, 6);
		setwall(17, 6);
		setwall(18, 6);
		setwall(1, 7);
		setwall(2, 7);
		setwall(3, 7);
		setwall(4, 7);
		setwall(6, 7);
		setwall(7, 7);
		setwall(11, 7);
		setwall(13, 7);
		setwall(17, 7);
		setwall(2, 9);
		setwall(4, 9);
		setwall(5, 9);
		setwall(6, 9);
		setwall(7, 9);
		setwall(8, 9);
		setwall(9, 9);
		setwall(10, 9);
		setwall(11, 9);
		setwall(13, 9);
		setwall(15, 9);
		setwall(16, 9);
		setwall(17, 9);
		setwall(4, 10);
		setwall(11, 10);
		setwall(13, 10);
		setwall(17, 10);
		setwall(1, 11);
		setwall(2, 11);
		setwall(4, 11);
		setwall(6, 11);
		setwall(7, 11);
		setwall(8, 11);
		setwall(9, 11);
		setwall(11, 11);
		setwall(13, 11);
		setwall(14, 11);
		setwall(15, 11);
		setwall(16, 11);
		setwall(17, 11);
		setwall(4, 12);
		setwall(7, 12);
		setwall(9, 12);
		setwall(11, 12);
		setwall(2, 13);
		setwall(3, 13);
		setwall(4, 13);
		setwall(5, 13);
		setwall(7, 13);
		setwall(9, 13);
		setwall(11, 13);
		setwall(12, 13);
		setwall(13, 13);
		setwall(14, 13);
		setwall(15, 13);
		setwall(16, 13);
		setwall(17, 13);
		setwall(7, 14);
		setwall(9, 14);
		setwall(15, 14);
		setwall(17, 14);
		setwall(1, 15);
		setwall(2, 15);
		setwall(4, 15);
		setwall(5, 15);
		setwall(6, 15);
		setwall(7, 15);
		setwall(9, 15);
		setwall(11, 15);
		setwall(12, 15);
		setwall(13, 15);
		setwall(17, 15);
		setwall(9, 16);
		setwall(11, 16);
		setwall(13, 16);
		setwall(15, 16);
		setwall(17, 16);
		setwall(2, 17);
		setwall(3, 17);
		setwall(4, 17);
		setwall(5, 17);
		setwall(6, 17);
		setwall(7, 17);
		setwall(9, 17);
		setwall(13, 17);
		setwall(15, 17);
		setwall(16, 17);
		setwall(17, 17);
		setwall(7, 18);
		setwall(8, 18);
		setwall(9, 18);
		setwall(11, 18);
		setwall(13, 18);

	}

	public void buildwallroom10() {
		level_size = 20;
		for (int i = 0; i < level_size; i++) {
			setwall(i, 0);
			setwall(i, level_size - 1);
		}
		for (int j = 0; j < level_size; j++) {
			if (j != 1)
				setwall(0, j);
			if (j != level_size - 2)
				setwall(level_size - 1, j);
		}
		setwall(2, 1);
		setwall(12, 1);
		setwall(2, 2);
		setwall(4, 2);
		setwall(5, 2);
		setwall(6, 2);
		setwall(7, 2);
		setwall(8, 2);
		setwall(10, 2);
		setwall(11, 2);
		setwall(12, 2);
		setwall(14, 2);
		setwall(15, 2);
		setwall(16, 2);
		setwall(17, 2);
		setwall(2, 3);
		setwall(3, 3);
		setwall(4, 3);
		setwall(6, 3);
		setwall(10, 3);
		setwall(12, 3);
		setwall(14, 3);
		setwall(16, 3);
		setwall(17, 3);
		setwall(2, 4);
		setwall(6, 4);
		setwall(7, 4);
		setwall(8, 4);
		setwall(10, 4);
		setwall(12, 4);
		setwall(14, 4);
		setwall(16, 4);
		setwall(17, 4);
		setwall(2, 5);
		setwall(4, 5);
		setwall(5, 5);
		setwall(6, 5);
		setwall(8, 5);
		setwall(10, 5);
		setwall(12, 5);
		setwall(14, 5);
		setwall(16, 5);
		setwall(2, 6);
		setwall(14, 6);
		setwall(4, 7);
		setwall(5, 7);
		setwall(6, 7);
		setwall(7, 7);
		setwall(9, 7);
		setwall(10, 7);
		setwall(11, 7);
		setwall(12, 7);
		setwall(13, 7);
		setwall(14, 7);
		setwall(16, 7);
		setwall(17, 7);
		setwall(2, 8);
		setwall(7, 8);
		setwall(9, 8);
		setwall(11, 8);
		setwall(14, 8);
		setwall(17, 8);
		setwall(18, 8);
		setwall(2, 9);
		setwall(5, 9);
		setwall(11, 9);
		setwall(14, 9);
		setwall(2, 10);
		setwall(4, 10);
		setwall(5, 10);
		setwall(6, 10);
		setwall(7, 10);
		setwall(8, 10);
		setwall(9, 10);
		setwall(10, 10);
		setwall(11, 10);
		setwall(14, 10);
		setwall(16, 10);
		setwall(17, 10);
		setwall(2, 11);
		setwall(6, 11);
		setwall(16, 11);
		setwall(17, 11);
		setwall(2, 12);
		setwall(3, 12);
		setwall(5, 12);
		setwall(6, 12);
		setwall(7, 12);
		setwall(8, 12);
		setwall(9, 12);
		setwall(10, 12);
		setwall(11, 12);
		setwall(12, 12);
		setwall(14, 12);
		setwall(15, 12);
		setwall(16, 12);
		setwall(17, 12);
		setwall(5, 13);
		setwall(6, 13);
		setwall(11, 13);
		setwall(12, 13);
		setwall(14, 13);
		setwall(2, 14);
		setwall(3, 14);
		setwall(4, 14);
		setwall(5, 14);
		setwall(6, 14);
		setwall(8, 14);
		setwall(9, 14);
		setwall(11, 14);
		setwall(12, 14);
		setwall(14, 14);
		setwall(13, 14);
		setwall(16, 14);
		setwall(17, 14);
		setwall(18, 14);
		setwall(8, 15);
		setwall(13, 15);
		setwall(14, 15);
		setwall(2, 16);
		setwall(3, 16);
		setwall(4, 16);
		setwall(5, 16);
		setwall(6, 16);
		setwall(7, 16);
		setwall(8, 16);
		setwall(10, 16);
		setwall(11, 16);
		setwall(12, 16);
		setwall(13, 16);
		setwall(14, 16);
		setwall(15, 16);
		setwall(16, 16);
		setwall(18, 16);
		setwall(5, 17);
		setwall(16, 17);
		setwall(3, 18);
		setwall(7, 18);
		setwall(9, 18);
		setwall(10, 18);
		setwall(11, 18);
		setwall(12, 18);
		setwall(13, 18);
		setwall(14, 18);
		setwall(16, 18);
		setwall(17, 18);

	}

	public void setwall(int x, int y) {
		grid[x][y] = Global.WALL;
	}

	public void draw_wall(Graphics g, int x, int y) {

		g.drawImage(wall_image, x, y, null);

	}

	public MainFrame() {

		JFrame f = new JFrame("Title");
		JMenu menuRestart = new JMenu("Restart");
		menuRestart.add(makeMenuItem("Open"));
		JMenu menuBack = new JMenu("Back");
		JMenu menuScore = new JMenu("Score");
		JMenu menuExit = new JMenu("Exit");

		JMenuBar Menub = new JMenuBar();
		Menub.add(menuRestart);
		Menub.add(menuBack);
		Menub.add(menuScore);
		Menub.add(menuExit);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setJMenuBar(Menub);
		// f.add(Menub);

		f.add(this);

		f.setVisible(true);
		f.addKeyListener(this);

		f.setSize(400, 400);

		difficulty = Global.Hard;
		t = new Timer(difficulty, this);
	}

	public boolean check_collision(int x1, int y1, int x2, int y2) {
		int d = Math.abs((x1 - x2) ^ 2 + (y1 - y2) ^ 2);
		if (((x1 - x2) ^ 2 + (y1 - y2) ^ 2) < 20) {
			System.out.println("mmmm" + d);
			System.out.println(x1 + "---------" + y1);
			System.out.println(x2 + "---------" + y2);
			return true;
		} else
			return false;
	}

	private JMenuItem makeMenuItem(String name) {
		JMenuItem m = new JMenuItem(name);
		m.addActionListener(this);
		return m;
	}

	public void actionPerformed(ActionEvent e) {

		if (poopx < 0 || poopx > 380) {
			velx = -velx;

		}
		if (poopy < 0 || poopy > 380) {
			vely = -vely;
		}
		if (velx>0&&grid[(poopx+20)/20][poopy/20]==Global.WALL){
			velx = -velx;
			
			
		}
		if (velx<0&&grid[(poopx-1)/20][poopy/20]==Global.WALL){
			velx = -velx;
			
			
		}
		
		
		// poopy+=vely;

		// if(check_collision(octopusx,octopusy,(octopusx/20+1)*20,(octopusy/20)*20))
		// {
		//
		//
		// octopusx = octopusx + movex;
		// octopusy = octopusy + movey;
		// //
		// // poopy+=vely;
		// }

		changedirection();

		if (octopusx > 400 || octopusx < 0)
			movex = -movex;
		if (octopusy > 400 || octopusy < 0)
			movey = -movey;

		//System.out.print(octopusy + "___________");
		repaint();

	}

	public void start() {

	}

	public void stop() {

	}

	public void run() {
		// do stuff here
	}

	public void goup() {

		movex = 0;
		movey = -difficulty /2;// 1
		octopusx = octopusx + movex;
		octopusy = octopusy + movey;
	}

	public void godown() {

		movex = 0;
		movey = difficulty /5;
		octopusx = octopusx + movex;
		octopusy = octopusy + movey;
	}

	public void goright() {
		movex = difficulty/5 ;
		movey = 0;
		octopusx = octopusx + movex;
		octopusy = octopusy + movey;
	}

	public void goleft() {
		movex = -difficulty /5;
		movey = 0;
		octopusx = octopusx + movex;
		octopusy = octopusy + movey;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		if (octopusx < 400 && octopusx > 0 || octopusy < 400 && octopusy > 0) {
			if (c == KeyEvent.VK_LEFT) {
				// System.out.print("Left");

				if (grid[octopusx / 20 ][octopusy / 20] != Global.WALL)
					// if(check_collision(octopusx,octopusy,(octopusx/20+1)*20,(octopusy/20)*20))
				{
					
				//	System.out.println("x"+octopusx);
					
				//	System.out.println("     y"+octopusy);
					
				//	if(!(octopusx % 20==0)&& )
					
					goleft();
					if(grid[octopusx / 20 ][octopusy / 20] == Global.WALL)
						octopusx = octopusx - movex;

						System.out.println("x"+octopusx);
				
					System.out.println("     y"+octopusy);

				
				//	octopusy = octopusy + movey;
				
				}
				
				
			}
			if (c == KeyEvent.VK_UP) {
				if (grid[octopusx / 20][octopusy / 20 ] != Global.WALL){
				//	if(!(octopus % 20==0) )
					goup();
					if(grid[octopusx / 20 ][octopusy / 20] == Global.WALL)
				//	octopusx = octopusx + movex;
					octopusy = octopusy - movey;
				}
				
			}
			if (c == KeyEvent.VK_RIGHT) {
				int tempy=(octopusy+17)/20;
				
				if (grid[octopusx / 20 + 1][octopusy / 20] != Global.WALL&&grid[octopusx / 20 + 1][tempy] != Global.WALL) {
					goright();
			
					
					
					//	System.out.println("The x:" + octopusx / 20 + 1
					//		+ "   The y:" + octopusy / 20);

				}
			}
			if (c == KeyEvent.VK_DOWN) {
				if (grid[octopusx / 20][octopusy / 20 + 1] != Global.WALL)
					godown();
			}

		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	//	movex = 0;
	//	movey = 0;

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void changedirection() {
		// int value = rand.nextInt(50);
		poopx += velx;

	}

	public static void main(String[] agrs) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:data.db");
			
		} catch ( Exception e){
			System.exit(0);//CORRECT ERROR
			System.out.println(e.getClass().getName() + e.getMessage());
			//JOptionPane.showMessageDialog(frame, "error connecting to db to creating tables");
		}
		System.out.println("Connection created.");
		try {
			stmt = c.createStatement();
			//create user table unique ID, Username, and password(pass doesnt have to be unique)
			String userPass = 	"CREATE TABLE IF NOT EXISTS USER" +
						"(ID INTEGER PRIMARY KEY AUTOINCREMENT ," +
						"NAME		CHAR(30)	NOT NULL UNIQUE );" ;
					//	"PASS		CHAR(30)	NOT NULL)";

			
			String userScore = 	"CREATE TABLE IF NOT EXISTS SCORE" +
						"(ID INTEGER  			NOT NULL," +
						"HS 		 INT		NOT NULL," +
						"FOREIGN KEY (ID) REFERENCES USER(ID) 		)";
			String test = "INSERT INTO USER (ID, NAME) VALUES (NULL, 'MATT');";
			stmt.executeUpdate(test);
			ResultSet rs = stmt.executeQuery("SELECT * FROM USER;");
			while(rs.next()) { 
				System.out.println(rs.getString("NAME"));
			}
			
			stmt.executeUpdate(userPass);
			stmt.executeUpdate(userScore);
			stmt.close();
			c.close();
						
		}
		catch ( Exception e ){
			//CORRECT ERROR
			System.out.println("error in table creation");
			System.out.println(e.getClass().getName() + e.getMessage());
			//System.exit.(0);
			//JOptionPane.showMessageDialog(frame, "error creating tables");
			
		}


		// start add temp user and scores
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:data.db");
			
		} catch ( Exception e){
			System.exit(0);//CORRECT ERROR
		}
		try {
			
			stmt = c.createStatement();
		//	String addUser1 = 	"INSERT INTO USER (ID, NAME) VALUES (NULL, 'Matt');";
			String addUser2 = 	"INSERT INTO USER (ID, NAME) " +
								"VALUES (NULL, 'Art');";
		//	stmt.executeUpdate(addUser1);
			
			stmt.executeUpdate(addUser2);
			/*
			String addScore1 = 	"INSERT INTO SCORE (ID, HS) " +
						"VALUES (1, 100);";
			String addScore2 = 	"INSERT INTO SCORE (ID, HS) " +
						"VALUES (1, 200);";
			String addScore3 = 	"INSERT INTO SCORE (ID, HS) " +
						"VALUES (2, 300);";
			String addScore4 = 	"INSERT INTO SCORE (ID, HS) " +
						"VALUES (1, 700);";
			String addScore5 = 	"INSERT INTO SCORE (ID, HS) " +
						"VALUES (2, 50);";
			String addScore6 = 	"INSERT INTO SCORE (ID, HS) " +
						"VALUES (1, 10);";

			stmt.executeUpdate(addScore1);
			stmt.executeUpdate(addScore2);
			stmt.executeUpdate(addScore3);
			stmt.executeUpdate(addScore4);
			stmt.executeUpdate(addScore5);
			stmt.executeUpdate(addScore6);
			*/
			stmt.close();
			c.close();
				
			
		}
		catch (Exception e){
			//CORRECT ERROR
			System.out.println(e.getClass().getName() + e.getMessage());
			System.out.println("error");
			//JOptionPane.showMessageDialog(frame, "error creating temp uses and scores");
		}
		// end add temp user and scores
		
		MainFrame f = new MainFrame();

	}

}
