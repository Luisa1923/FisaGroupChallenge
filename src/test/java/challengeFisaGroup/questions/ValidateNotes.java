package challengeFisaGroup.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import java.util.List;
import java.util.stream.Collectors;

public class ValidateNotes implements Question<Boolean> {
    private final List<String> results;
    private List<String> failedNotes;

    public ValidateNotes(List<String> results) {
        this.results = results;
    }
    public static ValidateNotes in(List<String> results) {
        return new ValidateNotes(results);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        failedNotes = results.stream()
                .filter(result -> !result.endsWith("Ok"))
                .collect(Collectors.toList());
        return failedNotes.isEmpty();
    }

    public List<String> getFailedNotes() {
        return failedNotes;
    }
}