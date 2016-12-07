/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Joel
 */
public class Keying extends JPanel{
	
	public Rectangle character;
	public Rectangle bottomBox;
	
	public int charW = 24;
	public int charH = 36;
	public long jumpingTime = 200;
	
	public boolean right = false;
	public boolean left = false;
	public boolean mouseActiv = false;
	public boolean jumping = false;
	
	public Point mouse;
	
	public Keying(Display d, Images i) {
			character = new Rectangle(180, 180, charW, charH);
			bottomBox = new Rectangle(0, 350, 9000, 30);

			d.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_D) {
						mouseActiv = false;
						right = true;
					}
					if(e.getKeyCode() == KeyEvent.VK_A) {
						mouseActiv = false;
						left = true;
					}
					if(e.getKeyCode() == KeyEvent.VK_M) {
						mouseActiv = true;
					}
					if(e.getKeyCode() == KeyEvent.VK_SPACE) {
						mouseActiv = false;
						jumping = true;
						new Thread(new thread()).start();
					}
				}

				public void keyReleased(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_D) {
						right = false;
					}
					if(e.getKeyCode() == KeyEvent.VK_A) {
						left = false;
					}
				}
			});

			d.addMouseMotionListener(new MouseMotionAdapter() {

				public void mouseMoved(MouseEvent e) {
					mouse = new Point(e.getX(), e.getY() -25);

					if(mouseActiv && character.x != TestGame.w - charW) {
						character.x = mouse.x;
						character.y = mouse.y;
					}
					repaint();
				}
			});

			d.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent e) {
					mouse = new Point(e.getX(), e.getY() -25);

					if(e.getButton() == MouseEvent.BUTTON1 && !mouseActiv) {
						character.x = mouse.x;
						character.y = mouse.y;
					}
				}
			});
	}
	
	public void paintComponent(Graphics g) {
		if(TestGame.d.i.imagesLoaded) {
			super.paintComponent(g);
			g.drawImage(TestGame.d.i.bg, 0, 0, 600, 400, null);
			Point pt1 = new Point(character.x, character.y + character.height);
			if(!bottomBox.contains(pt1) && !mouseActiv && !jumping) {
				character.y++;
			}
			this.setBackground(Color.BLACK);
			g.setColor(Color.WHITE);
			g.fillRect(character.x, character.y, character.width, character.height);
			g.fillRect(bottomBox.x, bottomBox.y, bottomBox.width, bottomBox.height);

			if(right && character.x != TestGame.w - charW + 6) {
				character.x += 1;
			}

			if(left && character.x != 0) {
				character.x -= 1;
			}
			
			if(jumping) {
				character.y--;
			}
			repaint();
		}
	}
	
	public class thread implements Runnable {
		
		@Override
		public void run() {
			try {
				Thread.sleep(jumpingTime);
				jumping = false;
			} catch (Exception e) {
				e.printStackTrace();
				new Thread(this).start();
				System.exit(0);
			}
		}
	}
}
