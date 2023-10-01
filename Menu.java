import javax.swing.*;



public class Menu extends Janela {

    public Menu() {
        super("Menu", -1, -1, 500, 500, JFrame.EXIT_ON_CLOSE);
    }

    @Override
    protected void setupComponents() {
    	setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JLabel um = new JLabel("1");
        JLabel dois = new JLabel("2");
        JLabel tres = new JLabel("3");
        JLabel quatro = new JLabel("4");
        JLabel cinco = new JLabel("5");
        JLabel seis = new JLabel("6");
        
        addCirculo(um, dois, tres, quatro, cinco, seis);
        
        
    }
}
