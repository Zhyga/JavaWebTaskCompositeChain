package by.epam.parser.impl;

import by.epam.composite.SymbolLeaf;
import by.epam.composite.TextComponent;
import by.epam.composite.TextComposite;
import by.epam.parser.BaseParser;

public class SentenceParser implements BaseParser {
    private static final String SENTENCE_DELIMITER = "\\s+";

    @Override
    public TextComponent parse(String sentence) {
        TextComponent sentenceComponent = new TextComposite();
        String[] words = sentence.split(SENTENCE_DELIMITER);
        LexemeParser wordParser = new LexemeParser();
        for (String word: words) {
            TextComponent wordComponent = wordParser.parse(word);
            sentenceComponent.add(wordComponent);
            sentenceComponent.add(new SymbolLeaf(' '));
        }
        return sentenceComponent;
    }
}
