/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
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
public class Fakultet implements Entity{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fakultetId")
    private Long fakultetId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "naziv")
    private String naziv;
    @Size(max = 100)
    @Column(name = "adresa")
    private String adresa;
    @Size(max = 100)
    @Column(name = "godinaOsnivanja")
    private String godinaOsnivanja;
    @JoinColumn(name = "univerzitetId", referencedColumnName = "univerzitetId")
    @JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Univerzitet univerzitetId;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fakultetid")
//    private Collection<Studijskiprogram> studijskiprogramCollection;

    public Fakultet() {
    }

    public Fakultet(Long fakultetId) {
        this.fakultetId = fakultetId;
    }

    public Fakultet(Long fakultetId, String naziv) {
        this.fakultetId = fakultetId;
        this.naziv = naziv;
    }

    public Long getFakultetId() {
        return fakultetId;
    }

    public void setFakultetId(Long fakultetId) {
        this.fakultetId = fakultetId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGodinaOsnivanja() {
        return godinaOsnivanja;
    }

    public void setGodinaOsnivanja(String godinaOsnivanja) {
        this.godinaOsnivanja = godinaOsnivanja;
    }

    public Univerzitet getUniverzitetId() {
        return univerzitetId;
    }

    public void setUniverzitetId(Univerzitet univerzitetId) {
        this.univerzitetId = univerzitetId;
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
        hash += (fakultetId != null ? fakultetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fakultet)) {
            return false;
        }
        Fakultet other = (Fakultet) object;
        if ((this.fakultetId == null && other.fakultetId != null) || (this.fakultetId != null && !this.fakultetId.equals(other.fakultetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.fon.silab.njt.web.strukturastudijskihprograma.domain.Fakultet[ fakultetId=" + fakultetId + " ]";
    }
    
}
