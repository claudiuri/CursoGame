
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Bola {	
        
        public BufferedImage parada;
	public int positionX;
	public int positionY;
	public int raio;
	public int velolicityX;
	public int velocityY;
	
	public Bola() {
                
            try {
                parada = ImageIO.read(getClass().getResource("imgs/parada.gif"));
            } catch (IOException ex) {
                Logger.getLogger(Bola.class.getName()).log(Level.SEVERE, null, ex);
            }
		positionX = 200;
		positionY = 200;
		raio = 50;
		velolicityX = 3;
		velocityY = 3;
	}
}
