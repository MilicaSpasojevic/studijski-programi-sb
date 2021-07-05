/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.dto;

import java.util.Objects;

/**
 *
 * @author milos
 */
public class StudijskiProgramDto implements Dto{
    private Long studijskiProgramId;
    private Long brojSemestara;
    private String naziv;
    private int status;
    private Long fakultetid;
    private Long nivostudijaid;

    public StudijskiProgramDto() {
    }

    public StudijskiProgramDto(Long studijskiProgramId, Long brojSemestara, String naziv, int status, Long fakultetid, Long nivostudijaid) {
        this.studijskiProgramId = studijskiProgramId;
        this.brojSemestara = brojSemestara;
        this.naziv = naziv;
        this.status = status;
        this.fakultetid = fakultetid;
        this.nivostudijaid = nivostudijaid;
    }

    public Long getStudijskiProgramId() {
        return studijskiProgramId;
    }

    public void setStudijskiProgramId(Long studijskiProgramId) {
        this.studijskiProgramId = studijskiProgramId;
    }

    public Long getBrojSemestara() {
        return brojSemestara;
    }

    public void setBrojSemestara(Long brojSemestara) {
        this.brojSemestara = brojSemestara;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getFakultetid() {
        return fakultetid;
    }

    public void setFakultetid(Long fakultetid) {
        this.fakultetid = fakultetid;
    }

    public Long getNivostudijaid() {
        return nivostudijaid;
    }

    public void setNivostudijaid(Long nivostudijaid) {
        this.nivostudijaid = nivostudijaid;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final StudijskiProgramDto other = (StudijskiProgramDto) obj;
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.studijskiProgramId, other.studijskiProgramId)) {
            return false;
        }
        if (!Objects.equals(this.brojSemestara, other.brojSemestara)) {
            return false;
        }
        if (!Objects.equals(this.fakultetid, other.fakultetid)) {
            return false;
        }
        if (!Objects.equals(this.nivostudijaid, other.nivostudijaid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StudijskiProgramDto{" + "studijskiProgramId=" + studijskiProgramId + ", brojSemestara=" + brojSemestara + ", naziv=" + naziv + ", status=" + status + ", fakultetid=" + fakultetid + ", nivostudijaid=" + nivostudijaid + '}';
    }
    
}
