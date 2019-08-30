package objectos;


import java.util.Date;

public class Producto {

    private double precio;
    private int codigo;
    private int codigoBarras;
    private Date fechaVencimiento;
    private String categoria;
    private String nombre;

    // Cuando no tenemos claro los datos del producto
    public Producto() {
        this.precio = 0.0;
        this.codigo = 0;
        this.codigoBarras = 0;
        this.fechaVencimiento = null;
        this.categoria = "Vacia o No existe";
        this.nombre = "No definido";
    }
    //Nos permite crear un producto conociendo su informacion

    public Producto(double precio, int codigo, int codigoBarras, Date fechaVencimiento, String categoria, String nombre) {
        this.precio = precio;
        this.codigo = codigo;
        this.codigoBarras = codigoBarras;
        this.fechaVencimiento = fechaVencimiento;
        this.categoria = categoria;
        this.nombre = nombre;
    }

    
    
    
    public boolean getVencido(Date fechaActual) {
        boolean bandera = false;
        if (this.getFechaVencimiento().after(fechaActual)) {
            bandera = true;
        }
        return bandera;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @return the codigoBarras
     */
    public int getCodigoBarras() {
        return codigoBarras;
    }

    /**
     * @return the fechaVencimiento
     */
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @param codigoBarras the codigoBarras to set
     */
    public void setCodigoBarras(int codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    /**
     * @param fechaVencimiento the fechaVencimiento to set
     */
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
