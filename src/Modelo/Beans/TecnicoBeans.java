package Modelo.Beans;


public class TecnicoBeans {
   
    private int idTec;
    private String nomeTec;

    /**
     * @return the idTec
     */
    public int getIdTec() {
        return idTec;
    }

    /**
     * @param idTec the idTec to set
     */
    public void setIdTec(int idTec) {
        this.idTec = idTec;
    }

    /**
     * @return the nomeTec
     */
    public String getNomeTec() {
        return nomeTec;
    }

    /**
     * @param nomeTec the nomeTec to set
     */
    public void setNomeTec(String nomeTec) {
        this.nomeTec = nomeTec;
    }

    @Override
    public String toString() {
        return getNomeTec();
    }
    
    
    
}
