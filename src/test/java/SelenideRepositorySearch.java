import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {
    @Test
    void shouldFindJUnit5CodeExample() {
        Configuration.browserSize = "2040x1200";
        open("https://github.com/");
        $("[placeholder='Search or jump to...']").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $$("[data-testid='results-list'] div").first().$("a").click();
        $("#wiki-tab").click();
        $(".wiki-more-pages-link").$("button").click();
        $$("[data-filterable-for='wiki-pages-filter'] li").findBy(text("SoftAssertions")).$("a").click();

        $$(".markdown-body h4").filterBy(text("Using JUnit5 extend test class:")).shouldHave(size(1));
        $$(".markdown-body h4").filterBy(text("Using JUnit5 extend test class:")).
                first().sibling(0).$("pre").shouldHave(text("Test"));
    }
}