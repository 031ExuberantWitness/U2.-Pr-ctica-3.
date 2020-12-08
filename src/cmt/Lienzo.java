package cmt;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

public class Lienzo extends Canvas implements MouseListener, MouseMotionListener{
    Imagen c1 = new Imagen("icono1.png", 50, 25, this);
    Imagen c2 = new Imagen("icono1.png", 150, 25, this);
    Imagen c3 = new Imagen("icono1.png", 250, 25, this);
    Imagen c4 = new Imagen("icono1.png", 350, 25, this);
    Imagen icon = null;//Se genera un objeto puntero, que puede referenciar cualquier icono
    int iconoSeleccionado = -1;
    
    ArrayList<Imagen> imagenes  = new ArrayList<Imagen>();
    
    
    Toolbar puntero;
    
    boolean mostrarIconosCargas = true;
    
    int itX = 500, itY = 50, sbX = 100;
    
    public Lienzo(Toolbar p){
        //Activar el oyente.
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        
        puntero = p;
    }
  
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        
        this.setBackground(Color.gray);
        g2.setColor(new Color(255,255,255,140));
        g2.fillRoundRect(10, 10, 450, 120, 45, 45);
        
        this.setBackground(Color.gray);
        
        if(mostrarIconosCargas){
            for(int i = 0; i < imagenes.size(); i++){
                Imagen temp  = imagenes.get(i);
                
                g2.drawImage(temp.Imagen, temp.x, temp.y, this);
            }
        }else{
            g2.drawImage(c1.Imagen, c1.x, c1.y, this);
            g2.drawImage(c2.Imagen, c1.x, c1.y, this);
            g2.drawImage(c3.Imagen, c1.x, c1.y, this);
            g2.drawImage(c4.Imagen, c1.x, c1.y, this);
        }
    }
    
    public void cargarImagenes(){
        try{
            puntero.nombreIconos = puntero.nombreIconos.replaceAll("", "");
            String[] nombreArchivos = puntero.nombreIconos.split(",");
            int distanciaX = 50;
            imagenes  = new ArrayList<Imagen>();
            
            for(int i = 0; i < nombreArchivos.length; i++){
                imagenes.add(new Imagen(nombreArchivos[i], distanciaX, 25, this));
                distanciaX += 100;
            }
            
            mostrarIconosCargas = true;
        }catch(Exception e){
            
        }
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
         for(int i = 0; i < imagenes.size(); i++){
            Imagen temp  = imagenes.get(i);
            
            if(temp.estaEnArea(e.getX(), e.getY()) == true){
                iconoSeleccionado = i; 
                showMessageDialog(null, iconoSeleccionado);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        icon = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for(int i = 0; i < imagenes.size(); i++){
            Imagen temp  = imagenes.get(i);
            
            if(temp.estaEnArea(e.getX(), e.getY()) == true){
                temp.y = 20;
            }else{
                temp.y = 25;
            }
        }
        
        repaint();
    }
}
