package by.epam.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextComposite implements TextComponent{
    private final List<TextComponent> textComponents;

    public TextComposite(){
        textComponents = new ArrayList<>();
    }

    @Override
    public void add(TextComponent textComponent) {
        textComponents.add(textComponent);
    }

    @Override
    public void remove(TextComponent textComponent) {
        textComponents.remove(textComponent);
    }

    @Override
    public TextComponent get(int index) {
        return textComponents.get(index);
    }

    @Override
    public List<TextComponent> getAll() {
        return textComponents;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (TextComponent t : textComponents) {
            sb.append(t.toString());
        }
        return sb.toString();
    }
}
