package de.quandoo;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * UI test for search filter https://www.quandoo.de/en/berlin
 */
public class SearchFilterTest {

	@Test
	public void userCanSeeTopRatedRestaurants() {
		// open site www.quandoo.de/en/berlin
		open("https://www.quandoo.de/en/berlin");
		// save variable - total restaurants number as "600+"
		// assert total number of restaurants is 600+
		$(By.cssSelector(".mavxr3-2")).shouldHave(Condition.text("600+ results"));
		// click on filter button "Top rated"
		$(By.xpath("//button[contains(.,'Top rated')]")).click();
		// assertion of clicked Top rated button
		// 1st way: assert total number of restaurants changed, first (600+) and second (500+) values aren't equal
		// assert total number of restaurants is 500+
		$(By.cssSelector(".mavxr3-2")).shouldHave(Condition.text("500+ results"));

		// 2nd way: assert Review score first value (1) changed on new value (4)
		// 3rd way: assert Filtered by changed "Review score: 4-6"
		// 4th way: assert rating of the first card of the list is more than 4
	}
}
