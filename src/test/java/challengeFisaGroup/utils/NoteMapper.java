package challengeFisaGroup.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NoteMapper {

    private static final Map<String, String> NOTE_TO_KEY_MAP = new HashMap<>();

    static {
        NOTE_TO_KEY_MAP.put("do", "2c");
        NOTE_TO_KEY_MAP.put("re", "2d");
        NOTE_TO_KEY_MAP.put("mi", "2e");
        NOTE_TO_KEY_MAP.put("fa", "1f");
        NOTE_TO_KEY_MAP.put("sol", "1g");
        NOTE_TO_KEY_MAP.put("la", "2a");
        NOTE_TO_KEY_MAP.put("si", "4b");
    }

    public static String getKeyFor(String note) {
        return NOTE_TO_KEY_MAP.get(note.toLowerCase());
    }

    public static List<String> getKeysForSequence(List<String> notes) {
        return notes.stream()
                .map(NoteMapper::getKeyFor)
                .collect(Collectors.toList());
    }
}
