import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class UseHoverTest {
    @Test
    void useHover() {
        Configuration.browserSize = "2040x1200";
        open("https://github.com/");
        $(".header-menu-wrapper").$(byText("Solutions")).hover();
        $(byAttribute("aria-labelledby","solutions-for-heading")).$(byText("Enterprise")).click();
        $(".font-mktg").shouldHave(text("Build like the best"));
    }
}