package by.epam.composite;

import java.util.List;

public class SymbolLeaf implements TextComponent{
    private char symbol;

    public SymbolLeaf(char symbol){
        this.symbol = symbol;
    }

    @Override
    public void add(TextComponent textComponent) {
    }

    @Override
    public void remove(TextComponent textComponent) {
    }

    @Override
    public TextComponent get(int index) {
        return null;
    }

    @Override
    public List<TextComponent> getAll() {
        return null;
    }

    @Override
    public TextType getTextType() {
        return TextType.SYMBOL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SymbolLeaf that = (SymbolLeaf) o;
        return symbol == that.symbol;
    }

    @Override
    public int hashCode() {
        int result = 31;
        result += result * 17 + symbol;
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
