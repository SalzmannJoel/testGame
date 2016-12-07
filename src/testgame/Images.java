package testgame;

import java.awt.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joel
 */
public class Images extends JPanel{
	public int w = TestGame.w;
	public int h = TestGame.h;
	
	public boolean imagesLoaded = false;
	
	public Image bg;
	
	public Images() {
		this.setBackground(Color.BLACK);
	}
	
	public void loadImages() {
		this.bg = new ImageIcon("C:\\Users\\Joel\\Pictures\\mesaArch.jpg").getImage();
		this.imagesLoaded = true;
	}
}
