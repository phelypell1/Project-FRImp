package Modelo.Beans;

public class ImpressoraBeans {
 private int idImp;
 private int numPat;
 private int numSut;
 private String dataEnvio;
 private String obsDefeito;
 private TecnicoBeans Tecnico;
 private int serialImp;
 private int os;

    /**
     * @return the idImp
     */
    public int getIdImp() {
        return idImp;
    }

    /**
     * @param idImp the idImp to set
     */
    public void setIdImp(int idImp) {
        this.idImp = idImp;
    }

    /**
     * @return the numSut
     */
    public int getNumSut() {
        return numSut;
    }

    /**
     * @param numSut the numSut to set
     */
    public void setNumSut(int numSut) {
        this.numSut = numSut;
    }

    /**
     * @return the dataEnvio
     */
    public String getDataEnvio() {
        return dataEnvio;
    }

    /**
     * @param dataEnvio the dataEnvio to set
     */
    public void setDataEnvio(String dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    /**
     * @return the obsDefeito
     */
    public String getObsDefeito() {
        return obsDefeito;
    }

    /**
     * @param obsDefeito the obsDefeito to set
     */
    public void setObsDefeito(String obsDefeito) {
        this.obsDefeito = obsDefeito;
    }

    /**
     * @return the serialImp
     */
    public int getSerialImp() {
        return serialImp;
    }

    /**
     * @param serialImp the serialImp to set
     */
    public void setSerialImp(int serialImp) {
        this.serialImp = serialImp;
    }
    /**
     * @return the os
     */
    public int getOs() {
        return os;
    }

    /**
     * @param os the os to set
     */
    public void setOs(int os) {
        this.os = os;
    }

    /**
     * @return the numPat
     */
    public int getNumPat() {
        return numPat;
    }

    /**
     * @param numPat the numPat to set
     */
    public void setNumPat(int numPat) {
        this.numPat = numPat;
    }

    


    /**
     * @return the Tecnico
     */
    public TecnicoBeans getTecnico() {
        return Tecnico;
    }

    /**
     * @param Tecnico the Tecnico to set
     */
    public void setTecnico(TecnicoBeans Tecnico) {
        this.Tecnico = Tecnico;
    }
    
    
    
 
}
