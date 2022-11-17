package cz.czechitas.automation;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

/**
 * Login/logout specific selenium actions
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
@ParametersAreNonnullByDefault
final class LoginAction {

    private final ElementFinder elementFinder;

    LoginAction(ElementFinder elementFinder)
    {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    void klikniNaTlacitkoPrihlasit() {
        var loginButton = elementFinder.findByXPath("/html/body/div/header/nav/div/div[2]/a");
        loginButton.click();
    }

    void vyplnEmail(String email) {
        Objects.requireNonNull(email);

        var emailInputBox = elementFinder.findByXPath("//*[@id=\"email\"]");
        emailInputBox.sendKeys(email);
    }

    void vyplnHeslo(String heslo) {
        Objects.requireNonNull(heslo);

        var passwordInputBox = elementFinder.findByXPath("//*[@id=\"password\"]");
        passwordInputBox.sendKeys(heslo);
    }

    void provedPrihlaseni() {
        var loginButton = elementFinder.findByXPath("/html/body/div/div/div/div/div/div/form/div[3]/div/button");
        loginButton.click();
    }

    void provedOdhlaseni() {
        var signedInUserElement = elementFinder.findByXPath("//*[@id=\"navbarSupportedContent\"]/div[2]/div/a");
        signedInUserElement.click();
        var logoutButton = elementFinder.findByXPath("//*[@id=\"logout-link\"]");
        logoutButton.click();
    }

    void klikniNaPrihlasit() {
        var tlacitkoPrihlasit = elementFinder.findByXPath("/html/body/div/div/div/div/div/div/form/div[3]/div/button");
        tlacitkoPrihlasit.click();
    }

    void vypHeslo(String heslo) {
        var formularNaHeslo = elementFinder.findByXPath("//*[@id=\"password\"]");
        formularNaHeslo.sendKeys(heslo);
    }
}
