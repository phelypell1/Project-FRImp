
package Modelo.Beans;

public class StatusEnvioBeans {
    
    private int idStsEnvio;
    private String nomeStsEnvio;

    /**
     * @return the idStsEnvio
     */
    public int getIdStsEnvio() {
        return idStsEnvio;
    }

    /**
     * @param idStsEnvio the idStsEnvio to set
     */
    public void setIdStsEnvio(int idStsEnvio) {
        this.idStsEnvio = idStsEnvio;
    }

    /**
     * @return the nomeStsEnvio
     */
    public String getNomeStsEnvio() {
        return nomeStsEnvio;
    }

    /**
     * @param nomeStsEnvio the nomeStsEnvio to set
     */
    public void setNomeStsEnvio(String nomeStsEnvio) {
        this.nomeStsEnvio = nomeStsEnvio;
    }

    @Override
    public String toString() {
        return getNomeStsEnvio();
    }
    
    
}
