package by.epam.composite;

import java.util.List;

public class SymbolLeaf implements TextComponent{
    private char symbol;

    public SymbolLeaf(char symbol){
        this.symbol = symbol;
    }

    @Override
    public void add(TextComponent textComponent) {
        throw new UnsupportedOperationException("Method 'add' is not supported for this class");
    }

    @Override
    public void remove(TextComponent textComponent) {
        throw new UnsupportedOperationException("Method 'remove' is not supported for this class");
    }

    @Override
    public TextComponent get(int index) {
        throw new UnsupportedOperationException("Method 'get' is not supported for this class");
    }

    @Override
    public List<TextComponent> getAll() {
        throw new UnsupportedOperationException("Method 'getAll' is not supported for this class");
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
