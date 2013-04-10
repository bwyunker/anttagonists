package antsimulation.view;

import antsimulation.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class SimulationDisplay extends JPanel {
    private boolean hudVisible, numbersVisible;
    private HUD hud;
    private BufferedImage dispImage;
    protected antsimulation.model.Field field;

    public SimulationDisplay() {
        setPreferredSize(new Dimension(250, 300));
        setBackground(Color.GREEN);
        
        hud = new HUD();
        hudVisible = true;
    }
    
    public void update(antsimulation.model.Field f) {
        if (dispImage == null)
            dispImage = new BufferedImage(250,300, BufferedImage.TYPE_INT_RGB);
        field = f;
        Graphics g = dispImage.getGraphics();

        
        //start Cameron area 
        {
        	g.setColor(Color.white);
        	g.fillRect(0,0, dispImage.getWidth(), dispImage.getHeight());
        	
        	//Draw Colonies
        	{
	        	int x, y, colonySize = 15;
	        	Colony colony;
	        	for(int i = 0; i < field.colonies.size(); i++)
	        	{
	        		colony = field.colonies.get(i);
	        		
	        		x = colony.xLoc;
	        		y = colony.yLoc;
	        		g.setColor(Color.orange);
	        			        		
	        		g.fillArc(x-(colonySize/2), y-(colonySize), colonySize, colonySize*2, 0, 180);
	        	}
        	} // END Draw Colonies
        	
        	//Draw Ants
        	{
	        	int x, y, antSize=6;
	        	for(int i = 0; i < field.ants.size(); i++)
	        	{
	        		x = field.ants.get(i).xLoc;
	        		y = field.ants.get(i).yLoc;
	        		
	        		switch(field.ants.get(i).faction)
	        		{
	        		case 1:
	        			g.setColor(Color.blue);
	        			break;
	        		case 2: 
	        			g.setColor(Color.red);
	        			break;
	        		case 3:
	        			g.setColor(Color.yellow);
	        			break;
	        		case 4:
	        			g.setColor(Color.pink);
	        			break;
	        		default:
	        			g.setColor(Color.magenta);
	        			break;
	        		}
	        		g.fillRect(x-(antSize/2), y-(antSize), antSize, antSize);
	        	}
        	} //END Draw ants
        	
        	//Draw FoodPiles
        	{
	        	int x, y, pileSize;
	        	Foodpile foodPile;
	        	for(int i = 0; i < field.foodpiles.size(); i++)
	        	{
	        		foodPile = field.foodpiles.get(i);
	        		
	        		x = foodPile.xLoc;
	        		y = foodPile.yLoc;
	        		g.setColor(Color.green);
	        		pileSize = foodPile.foodCount;
	        		
	        		g.fillOval(x-(pileSize/2), y-(pileSize), pileSize, pileSize);
	        	}
        	} // END Draw FoodPiles
        	
        	//Draw Predators
        	{
	        	int x, y, predatorSize = 8;
	        	Predator predator;
	        	for(int i = 0; i < field.predators.size(); i++)
	        	{
	        		predator = field.predators.get(i);
	        		
	        		x = predator.xLoc;
	        		y = predator.yLoc;
	        		g.setColor(Color.black);
	        			        		
	        		g.fillRect(x-(predatorSize/2), y-(predatorSize), predatorSize, predatorSize);
	        	}
        	} // END Draw Predators
        	
        } 
        //end Cameron area

        
        hud.update(field);
        repaint();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (dispImage != null) {
            g.drawImage(dispImage, 0,0, 250,300, this);
            if(hudVisible)
            	hud.paint(g, field);
        }
    }
}
