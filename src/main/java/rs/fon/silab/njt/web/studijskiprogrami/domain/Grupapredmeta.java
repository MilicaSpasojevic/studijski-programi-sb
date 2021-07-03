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
public class Grupapredmeta implements Entity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "grupaId")
    private Long grupaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "naziv")
    private String naziv;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupaPredmetaId")
//    private Collection<Pozicija> pozicijaCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupaId")
//    private Collection<Odrzavanje> odrzavanjeCollection;

    public Grupapredmeta() {
    }

    public Grupapredmeta(Long grupaId) {
        this.grupaId = grupaId;
    }

    public Grupapredmeta(Long grupaId, String naziv) {
        this.grupaId = grupaId;
        this.naziv = naziv;
    }

    public Long getGrupaId() {
        return grupaId;
    }

    public void setGrupaId(Long grupaId) {
        this.grupaId = grupaId;
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
//    public Collection<Odrzavanje> getOdrzavanjeCollection() {
//        return odrzavanjeCollection;
//    }
//
//    public void setOdrzavanjeCollection(Collection<Odrzavanje> odrzavanjeCollection) {
//        this.odrzavanjeCollection = odrzavanjeCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupaId != null ? grupaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupapredmeta)) {
            return false;
        }
        Grupapredmeta other = (Grupapredmeta) object;
        if ((this.grupaId == null && other.grupaId != null) || (this.grupaId != null && !this.grupaId.equals(other.grupaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.fon.silab.njt.web.strukturastudijskihprograma.domain.Grupapredmeta[ grupaId=" + grupaId + " ]";
    }
    
}
