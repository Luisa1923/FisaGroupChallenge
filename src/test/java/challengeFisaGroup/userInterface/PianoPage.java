package challengeFisaGroup.userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class PianoPage {

    public static final Target PIANO_KEY = Target
            .the("Tecla de piano según Nota")
            .locatedBy("[data-note='{0}']");
}