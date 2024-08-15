package challengeFisaGroup.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo implements Task {

    private final String siteUrl;
    public NavigateTo(String siteUrl) { this.siteUrl = siteUrl; }

    public static NavigateTo webPage(String siteUrl) {
        return new NavigateTo(siteUrl);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Open.url(siteUrl)
        );
    }
}
