
package Modelo.Beans;

public class StatusBeans {
    
    private int idSts;
    private String nomeSts;

    /**
     * @return the idSts
     */
    public int getIdSts() {
        return idSts;
    }

    /**
     * @param idSts the idSts to set
     */
    public void setIdSts(int idSts) {
        this.idSts = idSts;
    }

    /**
     * @return the nomeSts
     */
    public String getNomeSts() {
        return nomeSts;
    }

    /**
     * @param nomeSts the nomeSts to set
     */
    public void setNomeSts(String nomeSts) {
        this.nomeSts = nomeSts;
    }

    @Override
    public String toString() {
        return getNomeSts();
    }
    
    
}
