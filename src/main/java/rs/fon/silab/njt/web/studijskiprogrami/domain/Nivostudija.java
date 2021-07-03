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
public class Nivostudija implements Entity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nivoStudijaId")
    private Long nivoStudijaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "naziv")
    private String naziv;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivostudijaid")
//    private Collection<Studijskiprogram> studijskiprogramCollection;

    public Nivostudija() {
    }

    public Nivostudija(Long nivoStudijaId) {
        this.nivoStudijaId = nivoStudijaId;
    }

    public Nivostudija(Long nivoStudijaId, String naziv) {
        this.nivoStudijaId = nivoStudijaId;
        this.naziv = naziv;
    }

    public Long getNivoStudijaId() {
        return nivoStudijaId;
    }

    public void setNivoStudijaId(Long nivoStudijaId) {
        this.nivoStudijaId = nivoStudijaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

//    @XmlTransient
//    public Collection<Studijskiprogram> getStudijskiprogramCollection() {
//        return studijskiprogramCollection;
//    }
//
//    public void setStudijskiprogramCollection(Collection<Studijskiprogram> studijskiprogramCollection) {
//        this.studijskiprogramCollection = studijskiprogramCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nivoStudijaId != null ? nivoStudijaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nivostudija)) {
            return false;
        }
        Nivostudija other = (Nivostudija) object;
        if ((this.nivoStudijaId == null && other.nivoStudijaId != null) || (this.nivoStudijaId != null && !this.nivoStudijaId.equals(other.nivoStudijaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.fon.silab.njt.web.strukturastudijskihprograma.domain.Nivostudija[ nivoStudijaId=" + nivoStudijaId + " ]";
    }
    
}
