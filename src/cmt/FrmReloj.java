package cmt;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.font.TextAttribute.FONT;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Timer;

public class FrmReloj extends javax.swing.JPanel implements Serializable{
    
    public FrmReloj() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        
        actualizadorHora.start();
        letra = new Font("Arial", 18, Font.PLAIN);
    }
////////////////////////////////////////////////////////////////////////////////
    private Font letra;
    
    Timer actualizadorHora = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Calendar calendario = GregorianCalendar.getInstance();
            
            lblHora.setText("" + obtenerHora(calendario) + ":" + obtenerMin(calendario) + ":" + obtenerSeg(calendario) + agregarPM(calendario));
        }
    });
    
    //Calender
    private String obtenerHora(Calendar a){
        int hora = a.get(Calendar.HOUR);
        
        if(f==true){
            return "" + a.get(Calendar.HOUR_OF_DAY);
        }
        
        if(hora<10){
            return "0" + hora;
        }
        
        return "" + hora;
    }
    
    private String obtenerMin(Calendar a){
        int minuto = a.get(Calendar.MINUTE);
        
        if(minuto<10){
            return "0" + minuto;
        }
        
        return "" + minuto;
    }
    
    private String agregarPM(Calendar a){
        if(f==true) return "";
        
        int hora = a.get(Calendar.HOUR_OF_DAY);
        if(hora<12){
            return " AM";
        }
        
        return " PM";
    }
    
    private String obtenerSeg(Calendar a){
        int segundo = a.get(Calendar.SECOND);
        
        if(segundo<10){
            return "0" + segundo;
        }
        
        return "" + segundo;
    }
    
    //Color
    public void setColorText(Color c){
        lblHora.setForeground(c);
    }
    
    public Color getColorText(){
        return lblHora.getForeground();
    }
    
    //Formato
    Boolean f = false;
    public void setFormat24(Boolean Formato){
        f = Formato;
    }
    
    public Boolean getFormat24(){
        return f;
    }
    
    //Font
    @Override
    public void setFont(Font a){
        try{
            letra = a;
            lblHora.setFont(letra);
        }catch(Exception e){
            
        }
    }
    
    @Override
    public Font getFont(){
        try{
            return letra;
        }catch(Exception e){
            
        }
        return null;
    }
    
    
// <editor-fold defaultstate="collapsed" desc="Timer personal">            
    /*
    Thread reloj;
    this.reloj = new Thread((Runnable) relojAnimado());
    private Runnable relojAnimado(){
       Runnable cast = null;
       Timer tm = new Timer(5, new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e){
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
            }
        }); 
       tm.start();
       return cast;
    }
    */
// </editor-fold>     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHora = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lblHora.setFont(new java.awt.Font("Bender", 0, 24)); // NOI18N
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHora, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHora, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblHora;
    // End of variables declaration//GEN-END:variables
}
