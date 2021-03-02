package by.epam.parser.impl;

import by.epam.composite.SymbolLeaf;
import by.epam.composite.TextComponent;
import by.epam.composite.TextComposite;
import by.epam.composite.TextType;
import by.epam.interpreter.LexemeInterpreter;
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
        LexemeInterpreter lexemeInterpreter = new LexemeInterpreter();
        String exp = lexemeInterpreter.interpretateLexem(word);
        char[] symbols = exp.toCharArray();
        for (char s : symbols) {
            SymbolLeaf leaf = new SymbolLeaf(s);
            wordComponent.add(leaf);
        }
        return wordComponent;
    }
}
