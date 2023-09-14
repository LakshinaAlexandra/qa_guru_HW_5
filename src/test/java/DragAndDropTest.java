import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;


public class DragAndDropTest {
    @Test
    void dragAndDropRectangle() {
        Configuration.browserSize = "2040x1200";
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").$("header").shouldHave(text("A"));
        $("#column-b").$("header").shouldHave(text("B"));
        $("#column-a").dragAndDrop(to("#column-b"));
        $("#column-a").$("header").shouldHave(text("B"));
        $("#column-b").$("header").shouldHave(text("A"));
    }
}
