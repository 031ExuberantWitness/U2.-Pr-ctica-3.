package cmt;


import java.awt.Image;
import javax.swing.ImageIcon;


public class Imagen {
    int x, y;
    Image Imagen;
    int ancho, alto;    
    
    public Imagen(String nombreImagen, int posX, int posY, Lienzo Puntero){
        y = posY;
        x = posX;
        
        Imagen = new ImageIcon(Puntero.getClass().getResource(nombreImagen)).getImage();
        ancho = Imagen.getWidth(Puntero);
        alto = Imagen.getHeight(Puntero);
    }
    
    public boolean estaEnArea(int posXM, int posYM){
        int x2 = x + ancho;
        int y2 = y + alto;
        
        if(posXM >= x && posXM <= x2){
            if(posYM >= y && posYM <= y2){
                return true;
            }
        }
        
        return false;
    }
    
    public void mover(int posXM, int posYM){
        x = posXM - ancho/2;
        y = posYM - alto/2;
    }
    
    public boolean colision(Imagen objA){
        /*
            4. Puntos
                1 = X2, Y
                2 = X, Y2
                3 = X, Y
                4 = X2, Y2
        
        */
        
        int X2ObjetoA = objA.x + objA.ancho;
        int Y2ObjetoA = objA.y + objA.alto;
        
        if(estaEnArea(X2ObjetoA, objA.y)){
            return true;
        }
        
        if(estaEnArea(objA.x, Y2ObjetoA)){
            return true;
        }
        
        if(estaEnArea(objA.x, objA.y)){
            return true;
        }
        
        if(estaEnArea(X2ObjetoA, Y2ObjetoA)){
            return true;
        }
        return false;
    }
}
