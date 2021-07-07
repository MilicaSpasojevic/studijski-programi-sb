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
public class OdrzavanjeBackDto {
    private PredmetDto predmet;
    private PozicijaDto pozicija;

    public OdrzavanjeBackDto() {
    }

    public OdrzavanjeBackDto(PredmetDto predmet, PozicijaDto pozicija) {
        this.predmet = predmet;
        this.pozicija = pozicija;
    }

    public PredmetDto getPredmet() {
        return predmet;
    }

    public PozicijaDto getPozicija() {
        return pozicija;
    }

    public void setPredmet(PredmetDto predmet) {
        this.predmet = predmet;
    }

    public void setPozicija(PozicijaDto pozicija) {
        this.pozicija = pozicija;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.predmet);
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
        if (!Objects.equals(this.predmet, other.predmet)) {
            return false;
        }
        if (!Objects.equals(this.pozicija, other.pozicija)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OdrzavanjeBackDto{" + "predmet=" + predmet + ", pozicija=" + pozicija + '}';
    }
    
    
    
    
}
