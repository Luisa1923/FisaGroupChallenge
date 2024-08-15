package challengeFisaGroup.utils;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class PianoSequences {

    private static final Map<String, List<String>> sequences = new HashMap<>();

    static {
        sequences.put("secuencia1", NoteMapper.getKeysForSequence(List.of(
                "si", "si", "do", "re", "re", "do", "si", "la", "sol", "sol", "la", "si", "si", "la", "la")));

        sequences.put("secuencia2", NoteMapper.getKeysForSequence(List.of(
                "si", "si", "do", "re", "re", "do", "si", "la", "sol", "sol", "la", "si", "si", "la", "la",
                "si", "si", "do", "re", "re", "do", "si", "la", "sol", "sol", "la", "si", "si", "la", "la")));

        sequences.put("secuencia3", NoteMapper.getKeysForSequence(List.of(
                "si", "si", "do", "re", "re", "do", "si", "la", "sol", "sol", "la", "si", "la", "sol", "sol",
                "la", "si", "sol", "la", "si", "do", "si", "sol", "la", "si", "do", "si", "sol", "sol", "fa", "re",
                "si", "si", "do", "re", "re", "do", "si", "la", "sol", "sol", "la", "si", "si", "la", "la")));
    }

    public static List<String> getSequence(String key) {
        return sequences.getOrDefault(key, List.of());
    }
}
