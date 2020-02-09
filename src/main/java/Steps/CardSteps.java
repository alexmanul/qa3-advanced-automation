package Steps;

import Utils.CardActionHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CardSteps {

    private CardActionHelper cardActionHelper = new CardActionHelper();

    @Given("^I shuffle (a|another) deck$")
    public void shuffleDeck(String keyword) {
        cardActionHelper.shuffleDeck();
    }

    @Given("^I validate that deck (has all parameters|is unique)$")
    public void shuffleDeckValidation(String keyword) {
        cardActionHelper.shuffleDeckValidation(keyword);

    }

    @Given("I remember the deck number")
    public void rememberTheDeckNumber() {
        cardActionHelper.shuffleDeck();
        cardActionHelper.setDeckId();
    }

    @When("I draw {int} cards")
    public void drawCards(int cardCount) {
        cardActionHelper.drawCards(cardCount);
    }

    @When("I validate cards")
    public void validateCards() {
        cardActionHelper.validateCards();
    }

    @Then("I validate card amount {int}")
    public void validateCardAmount(int cardamount) {
        cardActionHelper.validateCardAmount(cardamount);
    }
}
