/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.dto;

import java.util.Objects;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Studijskiprogram;

/**
 *
 * @author milos
 */
public class ModulDto implements Dto {

    private Long modulId;
    private int pocetak;
    private int kraj;
    private String naziv;
    private Long studijskiProgramId;

    public ModulDto(Long modulId, int pocetak, int kraj, String naziv, Long studijskiProgramId) {
        this.modulId = modulId;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.naziv = naziv;
        this.studijskiProgramId = studijskiProgramId;
    }

    public ModulDto() {
    }

    public Long getModulId() {
        return modulId;
    }

    public void setModulId(Long modulId) {
        this.modulId = modulId;
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

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Long getStudijskiProgramId() {
        return studijskiProgramId;
    }

    public void setStudijskiProgramId(Long studijskiProgramId) {
        this.studijskiProgramId = studijskiProgramId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final ModulDto other = (ModulDto) obj;
        if (this.pocetak != other.pocetak) {
            return false;
        }
        if (this.kraj != other.kraj) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.modulId, other.modulId)) {
            return false;
        }
        if (!Objects.equals(this.studijskiProgramId, other.studijskiProgramId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ModulDto{" + "modulId=" + modulId + ", pocetak=" + pocetak + ", kraj=" + kraj + ", naziv=" + naziv + ", studijskiProgramId=" + studijskiProgramId + '}';
    }

    
}
