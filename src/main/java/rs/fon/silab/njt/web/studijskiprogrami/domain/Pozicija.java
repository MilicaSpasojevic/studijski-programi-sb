/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Milica
 */
@javax.persistence.Entity
public class Pozicija implements Entity{

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PozicijaPK pozicijaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "espb")
    private long espb;
    @JoinColumn(name = "grupaPredmetaId", referencedColumnName = "grupaId")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Grupapredmeta grupaPredmetaId;
    @JoinColumn(name = "studijskiProgramId", referencedColumnName = "studijskiProgramId", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Studijskiprogram studijskiprogram;
    @JoinColumn(name = "tipPredmetaId", referencedColumnName = "tipPredmetaID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tippredmeta tipPredmetaId;

    public Pozicija() {
    }

    public Pozicija(PozicijaPK pozicijaPK) {
        this.pozicijaPK = pozicijaPK;
    }

    public Pozicija(PozicijaPK pozicijaPK, long espb) {
        this.pozicijaPK = pozicijaPK;
        this.espb = espb;
    }

    public Pozicija(long pozicijaId, long godina, long studijskiProgramId) {
        this.pozicijaPK = new PozicijaPK(pozicijaId, godina, studijskiProgramId);
    }

    public Pozicija(PozicijaPK pozicijaPK, long espb, Grupapredmeta grupaPredmetaId, Studijskiprogram studijskiprogram, Tippredmeta tipPredmetaId) {
        this.pozicijaPK = pozicijaPK;
        this.espb = espb;
        this.grupaPredmetaId = grupaPredmetaId;
        this.studijskiprogram = studijskiprogram;
        this.tipPredmetaId = tipPredmetaId;
    }
    
    

    public PozicijaPK getPozicijaPK() {
        return pozicijaPK;
    }

    public void setPozicijaPK(PozicijaPK pozicijaPK) {
        this.pozicijaPK = pozicijaPK;
    }

    public long getEspb() {
        return espb;
    }

    public void setEspb(long espb) {
        this.espb = espb;
    }

    public Grupapredmeta getGrupaPredmetaId() {
        return grupaPredmetaId;
    }

    public void setGrupaPredmetaId(Grupapredmeta grupaPredmetaId) {
        this.grupaPredmetaId = grupaPredmetaId;
    }

    public Studijskiprogram getStudijskiprogram() {
        return studijskiprogram;
    }

    public void setStudijskiprogram(Studijskiprogram studijskiprogram) {
        this.studijskiprogram = studijskiprogram;
    }

    public Tippredmeta getTipPredmetaId() {
        return tipPredmetaId;
    }

    public void setTipPredmetaId(Tippredmeta tipPredmetaId) {
        this.tipPredmetaId = tipPredmetaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pozicijaPK != null ? pozicijaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pozicija)) {
            return false;
        }
        Pozicija other = (Pozicija) object;
        if ((this.pozicijaPK == null && other.pozicijaPK != null) || (this.pozicijaPK != null && !this.pozicijaPK.equals(other.pozicijaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.fon.silab.njt.web.strukturastudijskihprograma.domain.Pozicija[ pozicijaPK=" + pozicijaPK + " ]";
    }
    
}
