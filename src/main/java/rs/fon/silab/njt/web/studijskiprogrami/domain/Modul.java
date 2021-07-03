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
public class Modul implements Entity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "modulId")
    private Long modulId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "naziv")
    private String naziv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pocetak")
    private int pocetak;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kraj")
    private int kraj;
    @JoinColumn(name = "studijskiProgramId", referencedColumnName = "studijskiProgramId")
    @ManyToOne(optional = false)
    private Studijskiprogram studijskiProgramId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modul")
    private Collection<Odrzavanje> odrzavanjeCollection;

    public Modul() {
    }

    public Modul(Long modulId) {
        this.modulId = modulId;
    }

    public Modul(Long modulId, String naziv, int pocetak, int kraj) {
        this.modulId = modulId;
        this.naziv = naziv;
        this.pocetak = pocetak;
        this.kraj = kraj;
    }

    public Long getModulId() {
        return modulId;
    }

    public void setModulId(Long modulId) {
        this.modulId = modulId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getPocetak() {
        return pocetak;
    }

    public void setPocetak(int pocetak) {
        this.pocetak = pocetak;
    }

    public int getKraj() {
        return kraj;
    }

    public void setKraj(int kraj) {
        this.kraj = kraj;
    }

    public Studijskiprogram getStudijskiProgramId() {
        return studijskiProgramId;
    }

    public void setStudijskiProgramId(Studijskiprogram studijskiProgramId) {
        this.studijskiProgramId = studijskiProgramId;
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
        hash += (modulId != null ? modulId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modul)) {
            return false;
        }
        Modul other = (Modul) object;
        if ((this.modulId == null && other.modulId != null) || (this.modulId != null && !this.modulId.equals(other.modulId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.fon.silab.njt.web.strukturastudijskihprograma.domain.Modul[ modulId=" + modulId + " ]";
    }
    
}
