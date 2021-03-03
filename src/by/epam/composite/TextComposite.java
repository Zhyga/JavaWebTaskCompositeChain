package by.epam.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextComposite implements TextComponent{
    private List<TextComponent> textComponents;
    private TextType textType;
    private static final String WORD_DELIMITER = " ";
    private static final String PARAGRAPH_DELIMITER = "\n\t";

    public TextComposite(TextType textType){
        textComponents = new ArrayList<>();
        this.textType = textType;
    }

    public void setTextType(TextType textType) {
        this.textType = textType;
    }

    @Override
    public TextType getTextType() {
        return textType;
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
            switch (t.getTextType()) {
                case WORD -> sb.append(WORD_DELIMITER);
                case PARAGRAPH -> sb.append(PARAGRAPH_DELIMITER);
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TextComposite that = (TextComposite) o;
        return textComponents == that.textComponents &&
                textType == that.textType;
    }

    @Override
    public int hashCode(){
        int result = 11;
        result += result * 3 + (textComponents.isEmpty() ? 0 : 1);
        result += result * 3 + textType.hashCode();
        return result;
    }
}
