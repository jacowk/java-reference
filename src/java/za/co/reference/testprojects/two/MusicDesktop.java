package za.co.reference.testprojects.two;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JDesktopPane;

public class MusicDesktop extends JDesktopPane{
	
	public MusicDesktop(){
		
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
//		BufferedImage backgroundImageBuffer = ImageUtilities.loadBufferedImage("./background.jpg");
//		Dimension screenSize = SwingUtilities.getScreenSizeViaDefaultToolkit();
//		Graphics2D g2 = setPerformanceOptimisedGraphics((Graphics2D)g.create());
//		g2.drawImage(backgroundImageBuffer, 0, 0, (int)this.getSize().getWidth(), (int)this.getSize().getHeight(), null);
//		g2.dispose();
	}
	
	private Graphics2D setPerformanceOptimisedGraphics(Graphics2D g2){
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
		g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_SPEED);
		g2.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints
			.VALUE_ALPHA_INTERPOLATION_SPEED);
		g2.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_DISABLE);
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints
			.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
		return g2;
	}

}
