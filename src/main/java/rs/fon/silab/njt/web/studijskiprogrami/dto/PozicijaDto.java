/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.dto;

import java.util.Objects;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Grupapredmeta;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Studijskiprogram;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Tippredmeta;


/**
 *
 * @author Milica
 */
public class PozicijaDto implements Dto{
    Long pozicijaId;
    Long godina;
    Long espb;
    Studijskiprogram studijskiProgram;
    Tippredmeta tipPredmeta;
    Grupapredmeta grupaPredmeta;

    public PozicijaDto() {
    }

    public PozicijaDto(Long pozicijaId, Long godina, Long espb, Studijskiprogram studijskiProgram, Tippredmeta tipPredmeta, Grupapredmeta grupaPredmeta) {
        this.pozicijaId = pozicijaId;
        this.godina = godina;
        this.espb = espb;
        this.studijskiProgram = studijskiProgram;
        this.tipPredmeta = tipPredmeta;
        this.grupaPredmeta = grupaPredmeta;
    }

    public Long getPozicijaId() {
        return pozicijaId;
    }

    public Long getGodina() {
        return godina;
    }

    public Long getEspb() {
        return espb;
    }

    public Studijskiprogram getStudijskiProgram() {
        return studijskiProgram;
    }

    public Tippredmeta getTipPredmeta() {
        return tipPredmeta;
    }

    public Grupapredmeta getGrupaPredmeta() {
        return grupaPredmeta;
    }

    public void setPozicijaId(Long pozicijaId) {
        this.pozicijaId = pozicijaId;
    }

    public void setGodina(Long godina) {
        this.godina = godina;
    }

    public void setEspb(Long espb) {
        this.espb = espb;
    }

    public void setStudijskiProgram(Studijskiprogram studijskiProgram) {
        this.studijskiProgram = studijskiProgram;
    }

    public void setTipPredmeta(Tippredmeta tipPredmeta) {
        this.tipPredmeta = tipPredmeta;
    }

    public void setGrupaPredmeta(Grupapredmeta grupaPredmeta) {
        this.grupaPredmeta = grupaPredmeta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.pozicijaId);
        hash = 23 * hash + Objects.hashCode(this.godina);
        hash = 23 * hash + Objects.hashCode(this.espb);
        hash = 23 * hash + Objects.hashCode(this.studijskiProgram);
        hash = 23 * hash + Objects.hashCode(this.tipPredmeta);
        hash = 23 * hash + Objects.hashCode(this.grupaPredmeta);
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
        final PozicijaDto other = (PozicijaDto) obj;
        if (!Objects.equals(this.pozicijaId, other.pozicijaId)) {
            return false;
        }
        if (!Objects.equals(this.godina, other.godina)) {
            return false;
        }
        if (!Objects.equals(this.espb, other.espb)) {
            return false;
        }
        if (!Objects.equals(this.studijskiProgram, other.studijskiProgram)) {
            return false;
        }
        if (!Objects.equals(this.tipPredmeta, other.tipPredmeta)) {
            return false;
        }
        if (!Objects.equals(this.grupaPredmeta, other.grupaPredmeta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PozicijaDto{" + "pozicijaId=" + pozicijaId + ", godina=" + godina + ", espb=" + espb + ", studijskiProgram=" + studijskiProgram + ", tipPredmeta=" + tipPredmeta + ", grupaPredmeta=" + grupaPredmeta + '}';
    }

    
    
}
