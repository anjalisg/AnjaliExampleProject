import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class OuterSpace extends Canvas implements KeyListener, Runnable {

	private Ship ship;
	private Bullets shots;

	private int tick;

	private AlienHorde horde;
	private boolean[] keys;
	private BufferedImage back;

	public OuterSpace() {
		setBackground(Color.black);

		keys = new boolean[5];

		ship = new Ship(400, 500, 35, 35, 2);
		
		int hordeWidth = 7;
		int hordeHeight = 4;
		int hordeSize = hordeWidth * hordeHeight;
		
		horde = new AlienHorde(hordeSize);
		shots = new Bullets();
		
		for(int x = 8; x < StarFighter.WIDTH - 100; x += (StarFighter.WIDTH) / 8) {
			for(int y = 22; y < StarFighter.HEIGHT / 1.5; y += (StarFighter.HEIGHT / 1.5) / 4) {
				horde.add(new Alien(x + 20, y, 25, 25, 1));
			}
		}

		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		Graphics2D twoDGraph = (Graphics2D) window;
		if (back == null)
			back = (BufferedImage) (createImage(getWidth(), getHeight()));
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50);
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0, 0, 800, 600);

		tick++;

		// processInputs
		if(ship.getX()>0){
		if(keys[0] == true)
		{
			ship.move("LEFT");
		}
	}
	if(ship.getX()<740){
		if(keys[1] == true)
		{
			ship.move("RIGHT");
		}
	}
	if(ship.getY()>0){
		if(keys[2] == true)
		{
			ship.move("UP");
		}
	}
	if(ship.getY()<510){
		if(keys[3] == true)
		{
			ship.move("DOWN");
		}
	}
		if (keys[4] == true) {
//			if (tick >= 70) {
				shots.add(new Ammo(ship.getX() + ship.getWidth() / 2 - 2, ship.getY(), 5));
				keys[4] = false;
				tick = 0;
//			}
		}

		// update
		horde.moveEmAll();
		shots.moveEmAll();
		horde.removeDeadOnes(shots.getList());
		shots.cleanEmUp();
		horde.checkShipDeath(ship);

		if (horde.getSize() == 0) {
//			SoundEffects noise = new SoundEffects("YouWin.wav");
			System.out.println("You win!");
			System.exit(0);
		}

		// render
		graphToBack.setColor(Color.WHITE);
		graphToBack.drawString(""+horde.getSize(), 740, 530);
		ship.draw(graphToBack);
		shots.drawEmAll(graphToBack);
		horde.drawEmAll(graphToBack);

		// draw back image
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			keys[4] = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			keys[4] = false;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void run() {
		try {
			while (true) {
				Thread.currentThread();
				Thread.sleep(5);
				repaint();
			}
		} catch (Exception e) {
		}
	}
}