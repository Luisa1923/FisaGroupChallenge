package challengeFisaGroup.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CaptureClassDuringClick implements Interaction {

    private final WebElement element;
    private final List<String> results;

    public CaptureClassDuringClick(WebElement element, List<String> results) {
        this.element = element;
        this.results = results;
    }

    public static CaptureClassDuringClick forElement(WebElement element, List<String> results) {
        return instrumented(CaptureClassDuringClick.class, element, results);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String className = (String) js.executeScript(
                "arguments[0].dispatchEvent(new MouseEvent('mousedown', {'bubbles': true}));" +
                        "var className = arguments[0].className;" +
                        "arguments[0].dispatchEvent(new MouseEvent('mouseup', {'bubbles': true}));" +
                        "return className;", element);

        if (className.contains("active")) {
            results.add("Ok");
        } else {
            results.add("Fail");
        }
    }
}
