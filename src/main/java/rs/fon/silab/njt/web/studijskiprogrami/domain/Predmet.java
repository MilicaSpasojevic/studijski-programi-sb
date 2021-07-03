/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.domain;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Milica
 */
@javax.persistence.Entity
public class Predmet implements Entity{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "predmetid")
    private Long predmetid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "espb")
    private long espb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "naziv")
    private String naziv;
    @JoinColumn(name = "tipPredmetaId", referencedColumnName = "tipPredmetaID")
    @ManyToOne
    private Tippredmeta tipPredmetaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "predmet")
    private Collection<Odrzavanje> odrzavanjeCollection;

    public Predmet() {
    }

    public Predmet(Long predmetid) {
        this.predmetid = predmetid;
    }

    public Predmet(Long predmetid, long espb, String naziv) {
        this.predmetid = predmetid;
        this.espb = espb;
        this.naziv = naziv;
    }

    public Long getPredmetid() {
        return predmetid;
    }

    public void setPredmetid(Long predmetid) {
        this.predmetid = predmetid;
    }

    public long getEspb() {
        return espb;
    }

    public void setEspb(long espb) {
        this.espb = espb;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Tippredmeta getTipPredmetaId() {
        return tipPredmetaId;
    }

    public void setTipPredmetaId(Tippredmeta tipPredmetaId) {
        this.tipPredmetaId = tipPredmetaId;
    }

    @XmlTransient
    public Collection<Odrzavanje> getOdrzavanjeCollection() {
        return odrzavanjeCollection;
    }

    public void setOdrzavanjeCollection(Collection<Odrzavanje> odrzavanjeCollection) {
        this.odrzavanjeCollection = odrzavanjeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (predmetid != null ? predmetid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Predmet)) {
            return false;
        }
        Predmet other = (Predmet) object;
        if ((this.predmetid == null && other.predmetid != null) || (this.predmetid != null && !this.predmetid.equals(other.predmetid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.fon.silab.njt.web.strukturastudijskihprograma.domain.Predmet[ predmetid=" + predmetid + " ]";
    }

    
    
}
