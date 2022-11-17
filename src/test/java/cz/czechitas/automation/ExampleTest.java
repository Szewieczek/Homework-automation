package cz.czechitas.automation;

import org.junit.jupiter.api.Test;

/**
 * Example test class for functionality showcase
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
final class ExampleTest extends TestRunner {

    @Test
    void overKontaktniWwwAdresu() {
        prohlizec.horniMenu.jdiDoSekceKontakt();
        overeni.overAdresuWwwStranky("www.czechitas.cz");
    }

    @Test
    void overUspesnePrihlaseni() {
        prohlizec.prihlasovani.klikniNaTlacitkoPrihlasit();
        prohlizec.prihlasovani.vyplnEmail("admin@czechitas-app.loc");
        prohlizec.prihlasovani.vyplnHeslo("Czechitas123");
        prohlizec.prihlasovani.provedPrihlaseni();
        overeni.overPrihlaseniUzivatele();
    }

    @Test
    void vyplnHeslo() {
        prohlizec.prihlasovani.klikniNaTlacitkoPrihlasit();
        prohlizec.cekejNekolikVterin(5);
        prohlizec.prihlasovani.vypHeslo("carevna1729");
        prohlizec.cekejNekolikVterin(5);
        prohlizec.prihlasovani.klikniNaPrihlasit();
    }

    @Test
    void overUrlAdresuOdkazu() {
        prohlizec.horniMenu.jdiDoSekceNavodyAFormulareProUcitele();
        overeni.overSpravnyOdkazNavodyProUcitele("https://google.com/");
    }

    /*Napište test, který přejde do sekce Pro učitelé -> Objednávka pro MŠ/ZŠ, vyplní do pole IČO
libovolné existující IČO a v dolní části formuláře se přepne na záložku Škola v přírodě, kde do
pole Počet dětí vyplní libovolný počet dětí.*/
    @Test
    void vyplnIcoSkolaVPrirode() {
        prohlizec.horniMenu.jdiDoSekceObjednavkaProMSZS();
        prohlizec.sekceObjednavky.vyplnICO("12345678");
        prohlizec.sekceObjednavky.vyberMoznostSkolaVPrirode();
        prohlizec.sekceObjednavky.vyplnPocetDeti(25);
    }

    /*Napište test, který se přihlásí do aplikace, přejde pomocí horního menu do sekce Přihlášky a
ověří, že v tabulce přihlášek jsou sloupce pojmenované Jméno a Kategorie.*/
    @Test
    void overSloupceJmenoKategorie() {
        prohlizec.prihlasovani.klikniNaTlacitkoPrihlasit();
        prohlizec.prihlasovani.vyplnEmail("carevna@email.com");
        prohlizec.prihlasovani.vyplnHeslo("Rusko1729");
        prohlizec.prihlasovani.provedPrihlaseni();
        prohlizec.horniMenu.jdiDoSekcePrihlasky();
        overeni.sekcePrihlasky.overExistenciSloupce("Jméno");
        overeni.sekcePrihlasky.overExistenciSloupce("Kategorie");
    }

   /* Napište test, který bude plnit následující posloupnost úkonů:*/
    /*a. Přihlaste se do aplikace*/
    @Test
    void overDetailPrihlasky() {
        prohlizec.prihlasovani.klikniNaTlacitkoPrihlasit();
        prohlizec.prihlasovani.vyplnEmail("carevna@email.com");
        prohlizec.prihlasovani.vyplnHeslo("Rusko1729");
        prohlizec.prihlasovani.provedPrihlaseni();
        /*b. Přejděte pomocí horního menu do sekce Přihlášky*/
        prohlizec.horniMenu.jdiDoSekcePrihlasky();
        /*c. Klikněte zde na tlačítko Vytvořit novou přihlášku.*/
        prohlizec.sekcePrihlasky.klikniNaVytvoreniNovePrihlasky();
        /*d. Vyberte období akce programování */
        prohlizec.sekcePrihlasky.vyberObdobiProgramovani();
        /*e. Klikněte na tlačítko Vytvořit přihlášku pro akcí JavaScript a NodeJS.*/
        prohlizec.sekcePrihlasky.klikniNaVytvoritPrihlasku();
        /*f. Vyplňte pole ve formuláři (Termín, Křestní jméno, Příjmení, Datum narození,
Poznámka) pro vytvoření přihlášky (Jako způsob platby zvolte možnost hotově) a na
závěr přihlášku vytvořte.*/
        prohlizec.detailPrihlasky.vyberTermin("21.11.-30.11.2022");
        prohlizec.detailPrihlasky.vyplnKrestniJmenoZaka("Helena");
        prohlizec.detailPrihlasky.vyplnPrijmeniZaka("Řadová");
        prohlizec.detailPrihlasky.vyplnDatumNarozeni("19.01.2010");
        prohlizec.detailPrihlasky.vyplnPoznamku("nastoupím později");
        prohlizec.detailPrihlasky.zvolZpusobUhradyHotove();
        prohlizec.detailPrihlasky.klikniNaSouhlasSPodminkami();
        prohlizec.detailPrihlasky.klikniNaVytvoritPrihlasku();
        /*g. Ověřte, že nově vytvořená přihláška má Vámi nastavené hodnoty (Termín, Křestní
jméno, Příjmení, Datum narození, Poznámka) správně uložené.*/
        overeni.detailPrihlasky.overTermin("21.11. - 30.11.2022");
        overeni.detailPrihlasky.overKrestniJmeno("Helena");
        overeni.detailPrihlasky.overPrijmeni("Řadová");
        overeni.detailPrihlasky.overDatumNarozeni("19.01.2010");
        overeni.detailPrihlasky.overPoznamku("nastoupím později");
        overeni.detailPrihlasky.overZpusobUhradyPrihlasky("Hotově");
    }

    /*Napište test, který bude plnit následující posloupnost úkonů:
    a. Přihlaste se do aplikace*/
    @Test
    void overDetailPrihlasky2 () {
        prohlizec.prihlasovani.klikniNaTlacitkoPrihlasit();
        prohlizec.prihlasovani.vyplnEmail("carevna@email.com");
        prohlizec.prihlasovani.vyplnHeslo("Rusko1729");
        prohlizec.prihlasovani.provedPrihlaseni();
        /*b. Přejděte pomocí horního menu do sekce Přihlášky*/
        prohlizec.horniMenu.jdiDoSekcePrihlasky();
        /*c. Do vyhledávacího pole nad tabulkou přihlášek zadejte příjmení žáka z
    předcházejícího úkolu*/
        prohlizec.sekcePrihlasky.vyhledej("Tester001");
        /*d. Pro vyhledanou přihlášku zvolte možnost upravit a nastavte způsob platby na
    Bankovní převod*/
        prohlizec.sekcePrihlasky.klikniNaUpravitUPrvniPrihlasky();
        prohlizec.detailPrihlasky.zvolZpusobUhradyBankovnimPrevodem();
        /*e. Uložte otevřenou přihlášku*/
        prohlizec.detailPrihlasky.klikniNaUpravitPrihlasku();
        /*f. Opět pomocí vyhledávacího pole nad tabulkou vyhledejte příjmení žáka z
    předchozího úkolu*/
        /*g. Pro vyhledanou přihlášku otevřete její detail*/
        prohlizec.sekcePrihlasky.klikniNaDetailUPrvniPrihlasky();
        /*h. Ověřte, že způsob platby je nastaven na Bankovní převod*/
        overeni.detailPrihlasky.overZpusobUhradyPrihlasky("Bankovní převod");
        /*i. Ověřte, že zbývající částka k uhrazení je 1 500 Kč*/
        overeni.detailPrihlasky.overZbyvajiciCastkuKUhrazeni("1 500 Kč");
        /*j. Ověřte, že zpráva pro příjemce obsahuje příjmení žáka z předchozího úkolu*/
        overeni.detailPrihlasky.overZpravaProPrijemceObsahujePrijmeniZaka("Tester001");
    }
}
