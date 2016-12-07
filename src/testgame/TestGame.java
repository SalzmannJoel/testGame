/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgame;

import javax.swing.JFrame;

/**
 *
 * @author Joel
 */
public class TestGame {
	public static Display d = new Display();
	public static int w = 600;
	public static int h = 400;
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		d.setSize(w, h);
		d.setResizable(false);
		d.setVisible(true);
		d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		d.setTitle("MyFirstGame");
		d.setLocationRelativeTo(null);
		d.setAlwaysOnTop(true);
	}
	
}
