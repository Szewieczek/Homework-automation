package cz.czechitas.automation;

import org.junit.jupiter.api.Test;

/**
 * Test class for custom student tests
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
final class LowCodeAutomationTest extends TestRunner {

    @Test
    void overProfilAObec() {
        prohlizec.prihlasovani.klikniNaTlacitkoPrihlasit();
        prohlizec.prihlasovani.vyplnEmail("carevna@email.com");
        prohlizec.prihlasovani.vyplnHeslo("Rusko1729");
        prohlizec.prihlasovani.provedPrihlaseni();

        prohlizec.horniMenu.jdiDoSekcePrihlasky();
        prohlizec.sekcePrihlasky.klikniNaVytvoreniNovePrihlasky();
        prohlizec.sekcePrihlasky.vyberObdobiProgramovani();
        prohlizec.sekcePrihlasky.klikniNaVytvoritPrihlaskuJava();

        prohlizec.detailPrihlasky.vyberTermin("21.11.-30.11.2022");
        prohlizec.detailPrihlasky.vyplnKrestniJmenoZaka("Helena");
        prohlizec.detailPrihlasky.vyplnPrijmeniZaka(prohlizec.vygenerujNahodnePrijmeni(8));
        prohlizec.detailPrihlasky.vyplnDatumNarozeni("19.01.2010");
        prohlizec.detailPrihlasky.vyplnPoznamku("nastoupím později");
        prohlizec.detailPrihlasky.zvolZpusobUhradyHotove();
        prohlizec.detailPrihlasky.klikniNaSouhlasSPodminkami();
        prohlizec.detailPrihlasky.klikniNaVytvoritPrihlasku();

        prohlizec.horniMenu.jdiDoSekcePrihlasky();
        overeni.sekcePrihlasky.overTlacitkoDetailUPrvniPrihlasky();
        prohlizec.sekcePrihlasky.klikniNaDetailUPrvniPrihlasky();

        prohlizec.profil.otevriProfil();
        overeni.overJmenoAPrijmeniUzivatele("Kateřina Veliká");

        prohlizec.horniMenu.jdiDoSekceKontakt();
        overeni.overObec("Horní Dolní");
    }
}
