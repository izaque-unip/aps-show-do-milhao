import java.awt.*;
import javax.swing.*;

public abstract class Janela extends JFrame {
	private int x = 0; // Adicione a declaração e inicialização de x
	private int y = 0; // Adicione a declaração e inicialização de y
	private int gap = 0; // Adicione a declaração e inicialização de gap
  public Janela(String title, int x, int y, int width, int height, int closing) {
    setupFrame(title, x, y, width, height, closing);
    setupComponents(); // Primeiro configure os componentes
    setVisible(true);  // Em seguida, torne a janela visível
  }
  
  public Janela(String title, int width, int height, int closing) {
    this(title, -1, -1, width, height, closing);
  }
  
  private void setupFrame(String title, int x, int y, int width, int height, int closing) {
    setTitle(title);
    setSize(width, height);
    setDefaultCloseOperation(closing);
    if (x == -1 && y == -1) {
      setLocationByPlatform(true);
    } else {
      setLocation(x, y);
    }
  }
  
  protected void initLayout(int gap) {
	  setLayout(null);
	  this.x = this.y = this.gap = gap;
  }
  
  protected void addRow(JComponent... components) {
	  int h = 0;
	  for(JComponent component: components) {
		  component.setLocation(x, y);
		  component.setSize(component.getPreferredSize());
		  add(component);
		  x += component.getSize().width + gap;
		  if(component.getSize().height > h) {
			  h = component.getSize().height;
		  }
		  x = gap;
		  y += h + gap;
	  }
  }
  
//  protected void configurarCirculo(float raio, String direcao) {
//	    this.raio = raio;
//	    if(direcao == "horario") {
//	    	/*seta distribuição no sentido horario*/
//	    }else {
//	    	/*seta direcao no sentido anti-horario*/
//	    }
//	}
  
  protected void addCirculo(JComponent... components) {
	  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	  int raio = screenSize.height/4;
	  Point centro = new Point(raio+10,raio+10);
	  double angleIncrement = 2 * Math.PI / components.length; // Incremento de ângulo para cada componente
	  
	  for (int i = 0; i < components.length; i++) {
	        int x = (int) (centro.getX() + raio * Math.cos(i * angleIncrement));
	        int y = (int) (centro.getY() + raio * Math.sin(i * angleIncrement));

	        JComponent component = components[i];
	        component.setSize(component.getPreferredSize());
	        component.setLocation(x - component.getWidth() / 2, y - component.getHeight() / 2);
	        add(component);
	    }
	  }
  
  
  protected abstract void setupComponents();
}
