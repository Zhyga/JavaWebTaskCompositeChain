package by.epam.parser.impl;

import by.epam.composite.SymbolLeaf;
import by.epam.composite.TextComponent;
import by.epam.composite.TextComposite;
import by.epam.parser.BaseParser;

public class LexemeParser implements BaseParser {

    @Override
    public TextComponent parse(String lexeme) {
        TextComponent wordComponent = new TextComposite();
        char[] symbols = lexeme.toCharArray();
        for (char s : symbols) {
            SymbolLeaf leaf = new SymbolLeaf(s);
            wordComponent.add(leaf);
        }
        return wordComponent;
    }
}
