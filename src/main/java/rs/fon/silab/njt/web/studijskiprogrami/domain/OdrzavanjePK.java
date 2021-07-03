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
public class OdrzavanjePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "predmetId")
    private long predmetId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modulId")
    private long modulId;

    public OdrzavanjePK() {
    }

    public OdrzavanjePK(long predmetId, long modulId) {
        this.predmetId = predmetId;
        this.modulId = modulId;
    }

    public long getPredmetId() {
        return predmetId;
    }

    public void setPredmetId(long predmetId) {
        this.predmetId = predmetId;
    }

    public long getModulId() {
        return modulId;
    }

    public void setModulId(long modulId) {
        this.modulId = modulId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) predmetId;
        hash += (int) modulId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OdrzavanjePK)) {
            return false;
        }
        OdrzavanjePK other = (OdrzavanjePK) object;
        if (this.predmetId != other.predmetId) {
            return false;
        }
        if (this.modulId != other.modulId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.fon.silab.njt.web.strukturastudijskihprograma.domain.OdrzavanjePK[ predmetId=" + predmetId + ", modulId=" + modulId + " ]";
    }
    
}
