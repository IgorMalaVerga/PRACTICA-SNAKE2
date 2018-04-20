/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pracmp2;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author r.fernandezme.2016
 */
public class ActualizarTablero extends Thread implements KeyListener{
    private int vel;
    private JPanel[][] copiaLista;
    private char direccion;

    public ActualizarTablero() {
        this.vel = 10;        
        this.copiaLista = new JPanel[22][30];
        this.direccion = 'R';
    }
    
    public void run() {
        copiaLista = getListaPaneles();
        copiaLista[22][30].setBackground(Color.red);
        int i = 22;
        int j = 30;
        
        while(true) {
            try {
               Thread.sleep(vel*50);
            }
            catch(InterruptedException ex) {
                System.err.println("Error en ActualizaTablero"); 
            }
            
            panelPrincipal.addKeyListener(this);
            
            actualizarPosicion(i,j);
            j += 1;
        }
    }
    
    public void actualizarPosicion(int i, int j) {
        switch(direccion) {
            case 'R': 
                copiaLista[i][j-1].setBackground(Color.white);
                copiaLista[i][j].setBackground(Color.red);
                break;   
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT) {
            System.out.println("Tecla izquierda");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    

