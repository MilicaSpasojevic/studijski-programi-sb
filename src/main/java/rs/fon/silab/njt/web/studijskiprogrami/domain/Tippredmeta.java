/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Tippredmeta implements Entity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipPredmetaID")
    private Long tipPredmetaID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "naziv")
    private String naziv;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipPredmetaId")
//    private Collection<Pozicija> pozicijaCollection;
//    @OneToMany(mappedBy = "tipPredmetaId")
//    private Collection<Predmet> predmetCollection;

    public Tippredmeta() {
    }

    public Tippredmeta(Long tipPredmetaID) {
        this.tipPredmetaID = tipPredmetaID;
    }

    public Tippredmeta(Long tipPredmetaID, String naziv) {
        this.tipPredmetaID = tipPredmetaID;
        this.naziv = naziv;
    }

    public Long getTipPredmetaID() {
        return tipPredmetaID;
    }

    public void setTipPredmetaID(Long tipPredmetaID) {
        this.tipPredmetaID = tipPredmetaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

//    @XmlTransient
//    public Collection<Pozicija> getPozicijaCollection() {
//        return pozicijaCollection;
//    }
//
//    public void setPozicijaCollection(Collection<Pozicija> pozicijaCollection) {
//        this.pozicijaCollection = pozicijaCollection;
//    }
//
//    @XmlTransient
//    public Collection<Predmet> getPredmetCollection() {
//        return predmetCollection;
//    }
//
//    public void setPredmetCollection(Collection<Predmet> predmetCollection) {
//        this.predmetCollection = predmetCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipPredmetaID != null ? tipPredmetaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tippredmeta)) {
            return false;
        }
        Tippredmeta other = (Tippredmeta) object;
        if ((this.tipPredmetaID == null && other.tipPredmetaID != null) || (this.tipPredmetaID != null && !this.tipPredmetaID.equals(other.tipPredmetaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.fon.silab.njt.web.strukturastudijskihprograma.domain.Tippredmeta[ tipPredmetaID=" + tipPredmetaID + " ]";
    }
    
}
