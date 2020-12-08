package cmt;


public class Toolbar extends javax.swing.JPanel {
    private Lienzo l = new Lienzo(this);
    protected String nombreIconos = "icono1.png,icono1.png,icono1.png,icono1.png";
   
    public Toolbar() {
        initComponents();
        l.setSize(500,100);
        l.setLocation(0, 0);
        cargarImagenes();
        this.add(l);
    }
    
    public int iconoSeleccionado(){
        return l.iconoSeleccionado;
    }
    
    public void resetSeleccion(){
        l.iconoSeleccionado = -1;
    }
    
    public void setNombreIconos(String nombres) {
        nombreIconos = nombres;
    }

    public String getNombreIconos() {
        return nombreIconos;
    }
    
    public void cargarImagenes(){
        l.cargarImagenes();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
