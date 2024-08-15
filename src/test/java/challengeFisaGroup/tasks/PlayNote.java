package challengeFisaGroup.tasks;

import challengeFisaGroup.interactions.CaptureClassDuringClick;
import challengeFisaGroup.userInterface.PianoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PlayNote implements Task {
    private final String key;
    private final List<String> results;

    public PlayNote(String key, List<String> results) {
        this.key = key;
        this.results = results;
    }

    public static PlayNote forKey(String key, List<String> results) {
        return instrumented(PlayNote.class, key, results);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target keyTarget = PianoPage.PIANO_KEY.of(key);
        WebElement element = keyTarget.resolveFor(actor);
        actor.attemptsTo(CaptureClassDuringClick.forElement(element, results));
    }
}