package by.epam.comparator;

import by.epam.composite.TextComponent;
import java.util.Comparator;

public class ParagraphSizeComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        return Integer.compare(o1.getAll().size(),o2.getAll().size());
    }
}
