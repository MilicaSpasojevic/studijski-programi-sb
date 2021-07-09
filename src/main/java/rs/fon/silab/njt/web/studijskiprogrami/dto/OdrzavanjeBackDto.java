/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.dto;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Milica
 */
public class OdrzavanjeBackDto {
    private List<PredmetDto> predmeti;
    private PozicijaDto pozicija;

    public OdrzavanjeBackDto() {
    }

    public OdrzavanjeBackDto(List<PredmetDto> predmeti, PozicijaDto pozicija) {
        this.predmeti = predmeti;
        this.pozicija = pozicija;
    }

    public List<PredmetDto> getPredmeti() {
        return predmeti;
    }

    public PozicijaDto getPozicija() {
        return pozicija;
    }

    public void setPredmeti(List<PredmetDto> predmeti) {
        this.predmeti = predmeti;
    }

    public void setPozicija(PozicijaDto pozicija) {
        this.pozicija = pozicija;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.predmeti);
        hash = 97 * hash + Objects.hashCode(this.pozicija);
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
        final OdrzavanjeBackDto other = (OdrzavanjeBackDto) obj;
        if (!Objects.equals(this.predmeti, other.predmeti)) {
            return false;
        }
        if (!Objects.equals(this.pozicija, other.pozicija)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OdrzavanjeBackDto{" + "predmet=" + predmeti + ", pozicija=" + pozicija + '}';
    }
    
    
    
    
}
