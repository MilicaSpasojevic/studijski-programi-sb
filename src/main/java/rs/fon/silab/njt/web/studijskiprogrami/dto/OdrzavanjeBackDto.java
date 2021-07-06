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
    private GrupaPredmetaDto grupaPredmeta;
    private TipPredmetaDto tipPredmetaDto;
    private int semestar;
    private int espb;

    public OdrzavanjeBackDto() {
    }

    public OdrzavanjeBackDto(PredmetDto predmet, GrupaPredmetaDto grupaPredmeta, TipPredmetaDto tipPredmetaDto, int semestar, int espb) {
        this.predmet = predmet;
        this.grupaPredmeta = grupaPredmeta;
        this.tipPredmetaDto = tipPredmetaDto;
        this.semestar = semestar;
        this.espb = espb;
    }

    public PredmetDto getPredmet() {
        return predmet;
    }

    public GrupaPredmetaDto getGrupaPredmeta() {
        return grupaPredmeta;
    }

    public TipPredmetaDto getTipPredmetaDto() {
        return tipPredmetaDto;
    }

    public int getSemestar() {
        return semestar;
    }

    public int getEspb() {
        return espb;
    }

    public void setPredmet(PredmetDto predmet) {
        this.predmet = predmet;
    }

    public void setGrupaPredmeta(GrupaPredmetaDto grupaPredmeta) {
        this.grupaPredmeta = grupaPredmeta;
    }

    public void setTipPredmetaDto(TipPredmetaDto tipPredmetaDto) {
        this.tipPredmetaDto = tipPredmetaDto;
    }

    public void setSemestar(int semestar) {
        this.semestar = semestar;
    }

    public void setEspb(int espb) {
        this.espb = espb;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.predmet);
        hash = 11 * hash + Objects.hashCode(this.grupaPredmeta);
        hash = 11 * hash + Objects.hashCode(this.tipPredmetaDto);
        hash = 11 * hash + this.semestar;
        hash = 11 * hash + this.espb;
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
        if (this.semestar != other.semestar) {
            return false;
        }
        if (this.espb != other.espb) {
            return false;
        }
        if (!Objects.equals(this.predmet, other.predmet)) {
            return false;
        }
        if (!Objects.equals(this.grupaPredmeta, other.grupaPredmeta)) {
            return false;
        }
        if (!Objects.equals(this.tipPredmetaDto, other.tipPredmetaDto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OdrzavanjeBackDto{" + "predmet=" + predmet + ", grupaPredmeta=" + grupaPredmeta + ", tipPredmetaDto=" + tipPredmetaDto + ", semestar=" + semestar + ", espb=" + espb + '}';
    }
    
    
}
