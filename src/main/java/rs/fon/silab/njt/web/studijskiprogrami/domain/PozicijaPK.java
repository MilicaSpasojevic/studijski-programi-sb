/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Milica
 */
@Embeddable
public class PozicijaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "pozicijaId")
    private long pozicijaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "godina")
    private long godina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "studijskiProgramId")
    
    private long studijskiProgramId;

    public PozicijaPK() {
    }

    public PozicijaPK(long pozicijaId, long godina, long studijskiProgramId) {
        this.pozicijaId = pozicijaId;
        this.godina = godina;
        this.studijskiProgramId = studijskiProgramId;
    }

    public long getPozicijaId() {
        return pozicijaId;
    }

    public void setPozicijaId(long pozicijaId) {
        this.pozicijaId = pozicijaId;
    }

    public long getGodina() {
        return godina;
    }

    public void setGodina(long godina) {
        this.godina = godina;
    }

    public long getStudijskiProgramId() {
        return studijskiProgramId;
    }

    public void setStudijskiProgramId(long studijskiProgramId) {
        this.studijskiProgramId = studijskiProgramId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pozicijaId;
        hash += (int) godina;
        hash += (int) studijskiProgramId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PozicijaPK)) {
            return false;
        }
        PozicijaPK other = (PozicijaPK) object;
        if (this.pozicijaId != other.pozicijaId) {
            return false;
        }
        if (this.godina != other.godina) {
            return false;
        }
        if (this.studijskiProgramId != other.studijskiProgramId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.fon.silab.njt.web.strukturastudijskihprograma.domain.PozicijaPK[ pozicijaId=" + pozicijaId + ", godina=" + godina + ", studijskiProgramId=" + studijskiProgramId + " ]";
    }
    
}
