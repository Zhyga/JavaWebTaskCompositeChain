package by.epam.parser.impl;

import by.epam.composite.SymbolLeaf;
import by.epam.composite.TextComponent;
import by.epam.composite.TextComposite;
import by.epam.composite.TextType;
import by.epam.parser.BaseParser;

public class WordParser implements BaseParser {
    private static final WordParser INSTANCE = new WordParser();

    private WordParser(){}

    public static WordParser getInstance() {
        return INSTANCE;
    }

    @Override
    public TextComponent parse(String word) {
        TextComponent wordComponent = new TextComposite(TextType.WORD);
        char[] symbols = word.toCharArray();
        for (char s : symbols) {
            SymbolLeaf leaf = new SymbolLeaf(s);
            wordComponent.add(leaf);
        }
        return wordComponent;
    }
}
