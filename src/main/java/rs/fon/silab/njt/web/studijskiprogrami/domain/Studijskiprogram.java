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
public class Studijskiprogram implements Entity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "studijskiProgramId")
    private Long studijskiProgramId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "naziv")
    private String naziv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "brojSemestara")
    private long brojSemestara;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Status")
    private int status;
    @JoinColumn(name = "fakultetid", referencedColumnName = "fakultetId")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Fakultet fakultetid;
    @JoinColumn(name = "nivostudijaid", referencedColumnName = "nivoStudijaId")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Nivostudija nivostudijaid;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studijskiprogram")
//    private Collection<Pozicija> pozicijaCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studijskiProgramId")
//    private Collection<Modul> modulCollection;

    public Studijskiprogram() {
    }

    public Studijskiprogram(Long studijskiProgramId) {
        this.studijskiProgramId = studijskiProgramId;
    }

    public Studijskiprogram(Long studijskiProgramId, String naziv, long brojSemestara, int status) {
        this.studijskiProgramId = studijskiProgramId;
        this.naziv = naziv;
        this.brojSemestara = brojSemestara;
        this.status = status;
    }

    public Long getStudijskiProgramId() {
        return studijskiProgramId;
    }

    public void setStudijskiProgramId(Long studijskiProgramId) {
        this.studijskiProgramId = studijskiProgramId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public long getBrojSemestara() {
        return brojSemestara;
    }

    public void setBrojSemestara(long brojSemestara) {
        this.brojSemestara = brojSemestara;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Fakultet getFakultetid() {
        return fakultetid;
    }

    public void setFakultetid(Fakultet fakultetid) {
        this.fakultetid = fakultetid;
    }

    public Nivostudija getNivostudijaid() {
        return nivostudijaid;
    }

    public void setNivostudijaid(Nivostudija nivostudijaid) {
        this.nivostudijaid = nivostudijaid;
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
//    public Collection<Modul> getModulCollection() {
//        return modulCollection;
//    }
//
//    public void setModulCollection(Collection<Modul> modulCollection) {
//        this.modulCollection = modulCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studijskiProgramId != null ? studijskiProgramId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studijskiprogram)) {
            return false;
        }
        Studijskiprogram other = (Studijskiprogram) object;
        if ((this.studijskiProgramId == null && other.studijskiProgramId != null) || (this.studijskiProgramId != null && !this.studijskiProgramId.equals(other.studijskiProgramId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.fon.silab.njt.web.strukturastudijskihprograma.domain.Studijskiprogram[ studijskiProgramId=" + studijskiProgramId + " ]";
    }
    
}
