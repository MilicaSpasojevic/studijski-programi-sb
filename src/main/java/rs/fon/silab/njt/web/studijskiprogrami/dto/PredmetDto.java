/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.dto;

import java.util.Objects;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author Milica
 */
public class PredmetDto implements Dto{
    
    Long predmetid;
    
    Long espb;
    
    String naziv;
    
    Long tipPredmetaId;

    public PredmetDto() {
    }

    public PredmetDto(Long predmetId, Long espb, String naziv) {
        this.predmetid = predmetId;
        this.espb = espb;
        this.naziv = naziv;
    }

    public PredmetDto(Long predmetid, Long espb, String naziv, Long tipPredmetaId) {
        this.predmetid = predmetid;
        this.espb = espb;
        this.naziv = naziv;
        this.tipPredmetaId = tipPredmetaId;
    }
    
    

    public Long getTipPredmetaId() {
        return tipPredmetaId;
    }

    public void setTipPredmetaId(Long tipPredmetaId) {
        this.tipPredmetaId = tipPredmetaId;
    }
    
    

   

    public Long getPredmetid() {
        return predmetid;
    }

    public Long getEspb() {
        return espb;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setPredmetid(Long predmetid) {
        this.predmetid = predmetid;
    }

    public void setEspb(Long espb) {
        this.espb = espb;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.predmetid);
        hash = 53 * hash + Objects.hashCode(this.espb);
        hash = 53 * hash + Objects.hashCode(this.naziv);
        return hash;
    }

   

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PredmetDto other = (PredmetDto) obj;
        if (this.espb != other.espb) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.predmetid, other.predmetid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PredmetDto{" + "predmetId=" + predmetid + ", espb=" + espb + ", naziv=" + naziv + '}';
    }
    
    
}
