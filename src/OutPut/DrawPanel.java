package OutPut;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import InterFace.View;
import Program.Main;

public class DrawPanel {

	static Graphics g;
	public static double size;
	
	public static void drawpanel()
	{
		//*****JPanel��e��*****//
		g = View.show.getGraphics();
				
		//*****�M�ŵe��*****//
		g.setColor(Color.white);
								
		//*****�M�Žd��*****//
		g.fillRect(0, 0, View.show.getWidth(), View.show.getHeight());
				
		//*****�]�w�C��*****//
		g.setColor(Color.black);
				
		//*****�e���W���I*****//
		for(int i = 0; i < Main.total; i++)
		{
			int x = (int)((Main.x[i])*size);
			int y = (int)((Main.y[i])*size);
			g.fillRect(x, y, 3, 3);
		}
	}
	
	//*****�e�u*****//
	public static void drawline(int A,int B)
	{
		int x1 = (int)((Main.oplx[A])*size);
		int y1 = (int)((Main.oply[A])*size);
		int x2 = (int)((Main.oplx[B])*size);
		int y2 = (int)((Main.oply[B])*size);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(1.0f));
	    g2d.drawLine(x1, y1, x2, y2);
	}
}
