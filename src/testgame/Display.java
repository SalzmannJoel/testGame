/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgame;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Joel
 */
public class Display extends JFrame{
	public JPanel gp = (JPanel) getGlassPane();
	public Images i;
	public Keying k;
	
	public Display() {
		i = new Images();
		gp.setVisible(true);
		k = new Keying(this, i);
		i.loadImages();
		
		
		gp.setLayout(new GridLayout(1, 1, 0, 0));
		this.setLayout(new GridLayout(1, 1, 0, 0));
		
		gp.add(k);
		this.add(i);
	}
}
