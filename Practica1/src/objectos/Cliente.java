package objectos;

public class Cliente extends Persona {

    private boolean credito;

    private int limiteCredito;

    private int plazo;

    private String numeroCuenta;

    
    public Cliente (){
        
    }
    public Cliente(boolean credito, int limiteCredito, int plazo,
        String numeroCuenta, int id, String name) {
        super(id, name);
        this.credito = credito;
        this.limiteCredito = limiteCredito;
        this.plazo = plazo;
        this.numeroCuenta = numeroCuenta;
    }


    public boolean isCredito() {
        return credito;
    }

    public void setCredito(boolean credito) {
        this.credito = credito;
    }

    public int getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(int limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
}
