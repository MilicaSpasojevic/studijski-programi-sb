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
    Long studijskiProgramId;
    Long tipPredmetaId;
    Long grupaPredmetaId;

    public PozicijaDto() {
    }

    public PozicijaDto(Long pozicijaId, Long godina, Long espb, Long studijskiProgramId, Long tipPredmetaId, Long grupaPredmetaId) {
        this.pozicijaId = pozicijaId;
        this.godina = godina;
        this.espb = espb;
        this.studijskiProgramId = studijskiProgramId;
        this.tipPredmetaId = tipPredmetaId;
        this.grupaPredmetaId = grupaPredmetaId;
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

    public Long getStudijskiProgramId() {
        return studijskiProgramId;
    }

    public Long getTipPredmetaId() {
        return tipPredmetaId;
    }

    public Long getGrupaPredmetaId() {
        return grupaPredmetaId;
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

    public void setStudijskiProgramId(Long studijskiProgramId) {
        this.studijskiProgramId = studijskiProgramId;
    }

    public void setTipPredmetaId(Long tipPredmetaId) {
        this.tipPredmetaId = tipPredmetaId;
    }

    public void setGrupaPredmetaId(Long grupaPredmetaId) {
        this.grupaPredmetaId = grupaPredmetaId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        if (!Objects.equals(this.studijskiProgramId, other.studijskiProgramId)) {
            return false;
        }
        if (!Objects.equals(this.tipPredmetaId, other.tipPredmetaId)) {
            return false;
        }
        if (!Objects.equals(this.grupaPredmetaId, other.grupaPredmetaId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PozicijaDto{" + "pozicijaId=" + pozicijaId + ", godina=" + godina + ", espb=" + espb + ", studijskiProgramId=" + studijskiProgramId + ", tipPredmetaId=" + tipPredmetaId + ", grupaPredmetaId=" + grupaPredmetaId + '}';
    }

   
    
    
}
