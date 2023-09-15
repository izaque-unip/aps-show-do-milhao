import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends Janela {

    public Menu() {
        super("Menu", 500, 500, JFrame.EXIT_ON_CLOSE);
    }

    @Override
    protected void setupComponents() {
        // Use um layout manager, por exemplo, FlowLayout
        setLayout(null);

        JLabel ola = new JLabel("OLá mundo, teste java");
        ola.setSize(getPreferredSize());
        ola.setLocation(10, 40);
        add(ola);
    }
}
