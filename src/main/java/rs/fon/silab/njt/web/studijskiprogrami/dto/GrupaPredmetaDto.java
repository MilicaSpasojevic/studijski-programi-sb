/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.dto;

import java.util.Objects;

/**
 *
 * @author Milica
 */
public class GrupaPredmetaDto implements Dto{
    private Long grupaId;
    private String naziv;

    public GrupaPredmetaDto() {
    }

    public GrupaPredmetaDto(Long grupaId, String naziv) {
        this.grupaId = grupaId;
        this.naziv = naziv;
    }

    public Long getGrupaId() {
        return grupaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setGrupaId(Long grupaId) {
        this.grupaId = grupaId;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.grupaId);
        hash = 73 * hash + Objects.hashCode(this.naziv);
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
        final GrupaPredmetaDto other = (GrupaPredmetaDto) obj;
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.grupaId, other.grupaId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GrupaPredmetaDto{" + "grupaId=" + grupaId + ", naziv=" + naziv + '}';
    }
    
    
}
