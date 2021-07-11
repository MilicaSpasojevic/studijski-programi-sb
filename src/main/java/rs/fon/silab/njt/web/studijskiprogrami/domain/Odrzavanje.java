/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "odrzavanjeId")
    private Long odrzavanjeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "semestar")
    private int semestar;
    @JoinColumn(name = "grupaId", referencedColumnName = "grupaId")
    @ManyToOne(optional = false)
    private Grupapredmeta grupaId;
    @JoinColumn(name = "modulId", referencedColumnName = "modulId")
    @ManyToOne(optional = false)
    private Modul modul;
    @JoinColumn(name = "predmetId", referencedColumnName = "predmetid")
    @ManyToOne(optional = false)
    private Predmet predmet;
    @ManyToOne(optional = false)
    @JoinColumns({
        @JoinColumn(name="pozicijaId", referencedColumnName="pozicijaId", insertable = true),
        @JoinColumn(name="godina", referencedColumnName="godina", insertable = true),
        @JoinColumn(name="studijskiProgramId", referencedColumnName="studijskiProgramId", insertable = true)
            
    })
    private Pozicija pozicija;

    
    

    public Odrzavanje() {
    }

    public Odrzavanje(Long odrzavanjeId, int semestar, Grupapredmeta grupaId, Modul modul, Predmet predmet) {
        this.odrzavanjeId = odrzavanjeId;
        this.semestar = semestar;
        this.grupaId = grupaId;
        this.modul = modul;
        this.predmet = predmet;
    }

    public Long getOdrzavanjeId() {
        return odrzavanjeId;
    }

    public Pozicija getPozicija() {
        return pozicija;
    }

    public void setPozicija(Pozicija pozicija) {
        this.pozicija = pozicija;
    }

    
    
    

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setOdrzavanjeId(Long odrzavanjeId) {
        this.odrzavanjeId = odrzavanjeId;
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
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.odrzavanjeId);
        hash = 59 * hash + this.semestar;
        hash = 59 * hash + Objects.hashCode(this.grupaId);
        hash = 59 * hash + Objects.hashCode(this.modul);
        hash = 59 * hash + Objects.hashCode(this.predmet);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Odrzavanje other = (Odrzavanje) obj;
        if (this.semestar != other.semestar) {
            return false;
        }
        if (!Objects.equals(this.odrzavanjeId, other.odrzavanjeId)) {
            return false;
        }
        if (!Objects.equals(this.grupaId, other.grupaId)) {
            return false;
        }
        if (!Objects.equals(this.modul, other.modul)) {
            return false;
        }
        if (!Objects.equals(this.predmet, other.predmet)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Odrzavanje{" + "odrzavanjeId=" + odrzavanjeId + ", semestar=" + semestar + ", grupaId=" + grupaId + ", modul=" + modul + ", predmet=" + predmet + '}';
    }

    
    
}
