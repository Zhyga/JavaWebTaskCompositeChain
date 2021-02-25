package by.epam.service;

import by.epam.composite.TextComponent;
import by.epam.composite.TextComposite;
import by.epam.parser.impl.TextParser;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ServiceText {
    public TextComponent paragraphSort(TextComponent text){
        TextComponent sortedText = new TextComposite();
        List<TextComponent> paragraphs = new ArrayList<>(text.getAll());
        paragraphs.sort(new Comparator<TextComponent>() {
            @Override
            public int compare(TextComponent o1, TextComponent o2) {
                return Integer.compare(o1.getAll().size(),o2.getAll().size());
            }
        });
        for (TextComponent paragraph : paragraphs) {
            sortedText.add(paragraph);
        }
        return sortedText;
    }
}
