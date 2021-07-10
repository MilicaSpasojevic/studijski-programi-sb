/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.validator;

import java.util.List;
import org.springframework.validation.Errors;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Pozicija;
import rs.fon.silab.njt.web.studijskiprogrami.domain.PozicijaPK;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Studijskiprogram;
import rs.fon.silab.njt.web.studijskiprogrami.dto.OdrzavanjeDto;
import rs.fon.silab.njt.web.studijskiprogrami.dto.PozicijaDto;
import rs.fon.silab.njt.web.studijskiprogrami.dto.PredmetDto;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.impl.PozicijaMapper;
import rs.fon.silab.njt.web.studijskiprogrami.service.PozicijaService;

/**
 *
 * @author milos
 */
public class Validator {

//    public static void validirajObjavljivanjeSP(List<PozicijaDto> param) throws Exception {
//        int brojEspb = 0;
//        for (PozicijaDto poz : param) {
//            brojEspb += poz.getEspb();
//        }
//        if (brojEspb != 60) {
//            throw new Exception("Broj espb mora biti 60!");
//        }
//    }
    public static void validirajOdrzavanja(OdrzavanjeDto odrz, List<OdrzavanjeDto> odrzavanjeDto, PozicijaMapper pozicijaMapper, PozicijaService pozicijaServ) throws Exception {
        Pozicija p = pozicijaMapper.toEntity(pozicijaServ.getById(new PozicijaPK(odrz.getPozicijaDto().getPozicijaId(), odrz.getPozicijaDto().getGodina(),
                odrz.getPozicijaDto().getStudijskiProgramId())));
        for (PredmetDto pred : odrz.getPredmetDto()) {
            if (pred.getEspb() != p.getEspb()) {
                throw new Exception("Neodgvarajuci broj espb za poziciju");
            }
            if (pred.getTipPredmetaId() != odrz.getPozicijaDto().getTipPredmetaId()) {
                throw new Exception("Neodgvarajuci tip predmeta za poziciju");
            }
        }

    }

    public static void validirajObjavljivanjeSP(Studijskiprogram studijskiprogram, List<Pozicija> pozicije) throws Exception {
        for (int i = 1; i <= studijskiprogram.getBrojSemestara() / 2; i++) {
            int zbirEspb = 0;
            for (Pozicija pozicija : pozicije) {
                if (pozicija.getPozicijaPK().getGodina() == i) {
                    zbirEspb += pozicija.getEspb();
                }
            }
            if (zbirEspb != 60) {
                throw new Exception("Zbir ESPB za " + i + ". godinu nije 60");
            }
        }
    }
}
