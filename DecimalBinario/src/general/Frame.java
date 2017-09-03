package general;

import javax.swing.JFrame;
        
public class Frame extends JFrame{
    /**
    * <h1>Frame</h1>
    * Crea una nueva instancia de Frame, heredando las propiedades de JFrame
    * y pregonfigurandolo
    */
    public Frame(){
        super();
        
        this.setSize(360, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        
    }
}
