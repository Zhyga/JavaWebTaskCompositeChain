package by.epam.composite;

import java.util.List;

public interface TextComponent {
    void add(TextComponent textComponent);

    void remove(TextComponent textComponent);

    TextComponent get(int index);

    List<TextComponent> getAll();

    TextType getTextType();
}
