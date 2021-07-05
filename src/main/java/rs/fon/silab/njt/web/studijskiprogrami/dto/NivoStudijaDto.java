/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.dto;

import java.util.Objects;

/**
 *
 * @author STEFAN PC
 */
public class NivoStudijaDto implements Dto {
    Long nivoStudijaId;
    String naziv;

    public NivoStudijaDto() {
    }

    public NivoStudijaDto(Long nivoStudijaId, String naziv) {
        this.nivoStudijaId = nivoStudijaId;
        this.naziv = naziv;
    }

    public Long getNivoStudijaId() {
        return nivoStudijaId;
    }

    public void setNivoStudijaId(Long nivoStudijaId) {
        this.nivoStudijaId = nivoStudijaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.nivoStudijaId);
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
        final NivoStudijaDto other = (NivoStudijaDto) obj;
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.nivoStudijaId, other.nivoStudijaId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NivoStudijaDto{" + "nivoStudijaId=" + nivoStudijaId + ", naziv=" + naziv + '}';
    }
    
    
    
}
