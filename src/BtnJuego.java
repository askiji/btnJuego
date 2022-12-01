import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BtnJuego extends JButton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3899564091291223064L;

	private ImageIcon imageOn;
	private static ImageIcon imageOff;
	private static int vGap;
	private static int hGap;
	
	public BtnJuego(ImageIcon imageOn) {
		super();
		this.imageOn = imageOn;

	}
	
	public void setOn(){
		dinamicResize(imageOn);
	}
	public void setOf(){
		dinamicResize(imageOff);
	}
	private void dinamicResize(ImageIcon icon) {
		Thread t1 = new Thread() { 
			public synchronized void run() {
				for (int i = 2; i < Math.max(vGap, hGap); i++) {
					setIcon(setIconBtnJuego(icon, i ,i));
				}
			}
		};t1.start();
	}
	
	private Icon setIconBtnJuego(ImageIcon icon, int h , int v) {
		int ancho = getWidth();
		int alto = getHeight();
		ancho = ancho - (h-ancho);
		alto = alto - (v-alto);
		ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
		return icono;
	}
	
	//Getters and Setters
	

	public static int getvGap() {
		return vGap;
	}
	public ImageIcon getImageOn() {
		return imageOn;
	}

	public void setImageOn(ImageIcon imageOn) {
		this.imageOn = imageOn;
	}

	public static ImageIcon getImageOff() {
		return imageOff;
	}

	public static void setImageOff(ImageIcon imageOff) {
		BtnJuego.imageOff = imageOff;
	}

	public static void setvGap(int vGap) {
		BtnJuego.vGap = vGap;
	}
	public static int gethGap() {
		return hGap;
	}
	public static void sethGap(int hGap) {
		BtnJuego.hGap = hGap;
	}
}
