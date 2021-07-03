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
public class Odrzavanje implements Entity {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OdrzavanjePK odrzavanjePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "semestar")
    private int semestar;
    @JoinColumn(name = "grupaId", referencedColumnName = "grupaId")
    @ManyToOne(optional = false)
    private Grupapredmeta grupaId;
    @JoinColumn(name = "modulId", referencedColumnName = "modulId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Modul modul;
    @JoinColumn(name = "predmetId", referencedColumnName = "predmetid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Predmet predmet;

    public Odrzavanje() {
    }

    public Odrzavanje(OdrzavanjePK odrzavanjePK) {
        this.odrzavanjePK = odrzavanjePK;
    }

    public Odrzavanje(OdrzavanjePK odrzavanjePK, int semestar) {
        this.odrzavanjePK = odrzavanjePK;
        this.semestar = semestar;
    }

    public Odrzavanje(long predmetId, long modulId) {
        this.odrzavanjePK = new OdrzavanjePK(predmetId, modulId);
    }

    public OdrzavanjePK getOdrzavanjePK() {
        return odrzavanjePK;
    }

    public void setOdrzavanjePK(OdrzavanjePK odrzavanjePK) {
        this.odrzavanjePK = odrzavanjePK;
    }

    public int getSemestar() {
        return semestar;
    }

    public void setSemestar(int semestar) {
        this.semestar = semestar;
    }

    public Grupapredmeta getGrupaId() {
        return grupaId;
    }

    public void setGrupaId(Grupapredmeta grupaId) {
        this.grupaId = grupaId;
    }

    public Modul getModul() {
        return modul;
    }

    public void setModul(Modul modul) {
        this.modul = modul;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (odrzavanjePK != null ? odrzavanjePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Odrzavanje)) {
            return false;
        }
        Odrzavanje other = (Odrzavanje) object;
        if ((this.odrzavanjePK == null && other.odrzavanjePK != null) || (this.odrzavanjePK != null && !this.odrzavanjePK.equals(other.odrzavanjePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.fon.silab.njt.web.strukturastudijskihprograma.domain.Odrzavanje[ odrzavanjePK=" + odrzavanjePK + " ]";
    }
    
}
