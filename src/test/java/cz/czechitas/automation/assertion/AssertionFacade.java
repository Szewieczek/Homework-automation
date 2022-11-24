package cz.czechitas.automation.assertion;

import cz.czechitas.automation.ElementFinder;
import org.openqa.selenium.WebDriver;

import javax.annotation.ParametersAreNonnullByDefault;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Assertion facade for user-friendly assertions
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
@ParametersAreNonnullByDefault
public final class AssertionFacade {

    private final ElementFinder elementFinder;
    public final ApplicationAssertion sekcePrihlasky;
    public final ApplicationDetailAssertion detailPrihlasky;

    public AssertionFacade(WebDriver webDriver)
    {
        this.elementFinder = new ElementFinder(webDriver);
        this.sekcePrihlasky = new ApplicationAssertion(elementFinder);
        this.detailPrihlasky = new ApplicationDetailAssertion(elementFinder);
    }

    public void overJmenoAPrijmeniUzivatele(String celeJmeno) {
        var nameElement = elementFinder.findByXPath("//*[@id=\"name\"]");
        assertThat(nameElement.getAttribute("value").contains(celeJmeno));
    }

    public void overObec(String obec) {
        var cityElement = elementFinder.findByXPath("/html/body/div/div/div/div/div/div/div/div[1]/p[1]");
        assertThat(cityElement.getText()).contains(obec);
    }

    public void overAdresuWwwStranky(String wwwAdresa) {
        var url = elementFinder.findByXPath("/html/body/div/div/div/div/div/div/div/div[1]/p[2]/a");
        assertThat(url.getText()).isEqualTo(wwwAdresa);
    }

    public void overPrihlaseniUzivatele() {
        var loggedInText = elementFinder.findByXPath("/html/body/div/header/nav[1]/div/div[2]/div/span");
        assertThat(loggedInText.getText()).isEqualTo("Přihlášen");
    }

    public void overExistenciDlazdiceProgramovani() {
        var programmingText = elementFinder.findByXPath("/html/body/div/div/div[1]/div/div/div[1]/div");
        assertThat(programmingText.getText()).isEqualTo("Programování");
    }

    public void overPritomnostTlacitkaZaregistrujteSe() {
        var registerButton = elementFinder.findByXPath("/html/body/div/div/div/div/div/div[2]/form/div[4]/div/a");
        assertThat(registerButton.getText()).isEqualTo("Zaregistrujte se");
    }

    public void overSpravnyOdkazNavodyProUcitele(String odkaz) {
        var url = elementFinder.findByXPath("/html/body/div/div/div/div/div/div/ul/li/a");
        assertThat(url.getAttribute("href")).isEqualTo(odkaz);
    }
}
