
package Modelo.Beans;

public class ModeloImpressoraBeans {
    private int idModelo;
    private String nomeModelo;

    /**
     * @return the idModelo
     */
    public int getIdModelo() {
        return idModelo;
    }

    /**
     * @param idModelo the idModelo to set
     */
    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    /**
     * @return the nomeModelo
     */
    public String getNomeModelo() {
        return nomeModelo;
    }

    /**
     * @param nomeModelo the nomeModelo to set
     */
    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    @Override
    public String toString() {
        return getNomeModelo();
    }
    
    
}
