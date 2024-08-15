package challengeFisaGroup.stepdefinitions;

import challengeFisaGroup.questions.ValidateNotes;
import challengeFisaGroup.utils.PianoSequences;
import challengeFisaGroup.tasks.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.ArrayList;

import net.serenitybdd.screenplay.Actor;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class StepDefinitions {

    @Dado("que el {actor} ha navegado a la pagina musicca")
    public void que_el_usuario_ha_navegado_a_la_pagina_musicca(Actor actor) {
        actor.attemptsTo(
        NavigateTo.webPage("https://www.musicca.com/es/piano")
        );
    }
    @Cuando("realiza interpretacion de la secuencia {string}")
    public void realiza_interpretacion_de_la_secuencia_Secuencia(String secuency) {
        List<String> results = new ArrayList<>();
        List<String> sequence = PianoSequences.getSequence(secuency);

        sequence.forEach(note -> {
            theActorInTheSpotlight().attemptsTo(PlayNote.forKey(note, results));});

        theActorInTheSpotlight().remember("results", results);
    }

    @Entonces("las notas se ejecutan correctamente en el piano")
    public void las_notas_se_ejecutan_correctamente_en_el_piano() {
        List<String> results = theActorInTheSpotlight().recall("results");
        ValidateNotes question = ValidateNotes.in(results);
        Boolean allNotesCorrect = question.answeredBy(theActorInTheSpotlight());

        theActorInTheSpotlight().should(
                seeThat("Todas las notas se ejecutaron correctamente",
                        actor -> allNotesCorrect, Matchers.equalTo(true))
        );

        if (!allNotesCorrect) {
            List<String> failedNotes = question.getFailedNotes();
            System.out.println("Las siguientes notas no se ejecutaron correctamente: "
                    + String.join(", ", failedNotes));
        }
    }
}