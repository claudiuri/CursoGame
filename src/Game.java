import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Game extends JPanel{
	private Bola bola;
	public Game() {
		bola = new Bola();
		setFocusable(true);
		setLayout(null);
		
		new Thread(new Runnable() { // instancia da Thread + classe interna an�nima
			@Override
			public void run() {
				gameloop(); // inicia o gameloop
			}
		}).start(); // dispara a Thread
	}
	// GAMELOOP -------------------------------
	public void gameloop() {
		while(true) { // repeti��o intermitente do gameloop
			handlerEvents();
			update();
			render();
			try {
				Thread.sleep(17);
			}catch (Exception e) {}
		}
	}
	public void handlerEvents() {}
	public void update() {
                testeColisoes();
		bola.positionX = bola.positionX + bola.velolicityX;
		bola.positionY = bola.positionY + bola.velocityY;
	}
	public void render() {
		repaint();
	}
	
	// OUTROS METODOS -------------------------
        public void testeColisoes(){
            
            if (bola.positionX + (bola.raio * 2) >= Principal.LARGURA_TELA || bola.positionX <=0 ) {
                bola.velolicityX = bola.velolicityX * -1;
            }
            
            if (bola.positionY + (bola.raio *2) >= Principal.ALTURA_TELA || bola.positionY <= 0) {
                bola.velocityY = bola.velocityY * -1;
            }
        }
        
	// METODO SOBRESCRITO ---------------------
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.LIGHT_GRAY);
		g.setColor(Color.RED);
//		g.fillOval(bola.positionX, bola.positionY, bola.raio*2, bola.raio*2);
                g.drawImage(bola.parada, bola.positionX, bola.positionY, null);
	}
}