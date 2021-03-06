//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bullets
{
	private List<Ammo> ammo;

	public Bullets()
	{
		ammo = new ArrayList<Ammo>(20);
	}

	public void add(Ammo al)
	{
		ammo.add(al);
	}

	//post - draw each Ammo
	public void drawEmAll( Graphics window )
	{
		
		for(Ammo a : ammo){
			a.draw(window);
		}

	}

	public void moveEmAll()
	{
		for(Ammo a : ammo){
			a.move("UP");
		}
	}

	public void cleanEmUp()
	{
		for(int i=0; i<ammo.size(); i++){
			if(ammo.get(i).getY()<0){
				ammo.remove(i);
				System.out.println("destroying ammo");
			}
		}
	}

	public List<Ammo> getList()
	{
		return ammo;
	}

	public String toString()
	{
		return ""+Arrays.toString(ammo.toArray());
	}

	public List<Ammo> getAmmo() {
		return ammo;
	}
}
