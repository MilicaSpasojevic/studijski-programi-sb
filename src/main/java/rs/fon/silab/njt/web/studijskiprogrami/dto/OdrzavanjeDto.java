/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.dto;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Milica
 */
public class OdrzavanjeDto implements Dto{
    private Long odrzavanjeId;
    private int semestar;
    private PozicijaDto pozicijaDto;
    private List<PredmetDto> predmetDto;
    private Long modulId;

    public OdrzavanjeDto() {
    }

    public OdrzavanjeDto(PozicijaDto pozicijaDto, List<PredmetDto> predmetDto) {
        this.pozicijaDto = pozicijaDto;
        this.predmetDto = predmetDto;
    }

    public OdrzavanjeDto(Long odrzavanjeId, int semestar, PozicijaDto pozicijaDto, List<PredmetDto> predmetDto) {
        this.odrzavanjeId = odrzavanjeId;
        this.semestar = semestar;
        this.pozicijaDto = pozicijaDto;
        this.predmetDto = predmetDto;
    }

    public Long getModulId() {
        return modulId;
    }

    public void setModulId(Long modulId) {
        this.modulId = modulId;
    }
    
    

    public Long getOdrzavanjeId() {
        return odrzavanjeId;
    }

    public int getSemestar() {
        return semestar;
    }

    public void setOdrzavanjeId(Long odrzavanjeId) {
        this.odrzavanjeId = odrzavanjeId;
    }

    public void setSemestar(int semestar) {
        this.semestar = semestar;
    }
    
    

    public PozicijaDto getPozicijaDto() {
        return pozicijaDto;
    }

    public List<PredmetDto> getPredmetDto() {
        return predmetDto;
    }

    public void setPozicijaDto(PozicijaDto pozicijaDto) {
        this.pozicijaDto = pozicijaDto;
    }

    public void setPredmetDto(List<PredmetDto> predmetDto) {
        this.predmetDto = predmetDto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.pozicijaDto);
        hash = 79 * hash + Objects.hashCode(this.predmetDto);
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
        final OdrzavanjeDto other = (OdrzavanjeDto) obj;
        if (this.semestar != other.semestar) {
            return false;
        }
        if (!Objects.equals(this.odrzavanjeId, other.odrzavanjeId)) {
            return false;
        }
        if (!Objects.equals(this.pozicijaDto, other.pozicijaDto)) {
            return false;
        }
        if (!Objects.equals(this.predmetDto, other.predmetDto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OdrzavanjeDto{" + "odrzavanjeId=" + odrzavanjeId + ", semestar=" + semestar + ", pozicijaDto=" + pozicijaDto + ", predmetDto=" + predmetDto + '}';
    }

    
    
    
    
}
