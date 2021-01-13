/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import javax.swing.*;
public class testeMouse extends JFrame
        implements MouseListener, MouseMotionListener{
    
    JLabel mousePosition;

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mousePosition.setText("Mouse movido para: ["+e.getX()+","+e.getY()+"]");
        System.out.println("["+e.getX()+","+e.getY()+"]");
    }
        public void start()
    {
        mousePosition=new JLabel();
         addMouseListener( this );        // listens for own mouse and
          addMouseMotionListener( this );  // mouse-motion events
          setLayout(new FlowLayout(1));
          add(mousePosition);
          //Jframe com o tamanho total da tela
          //Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
          Toolkit t = Toolkit.getDefaultToolkit();
          Dimension size = t.getScreenSize();
          this.setSize((size.width + 5), (size.height - 38));

          setSize(size );
          setUndecorated(true);
          setVisible( true );
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          
    }
        
        public static void main(String[] args) {
        new testeMouse().start();
    }

    
    
}
