package by.epam.parser.impl;

import by.epam.composite.SymbolLeaf;
import by.epam.composite.TextComponent;
import by.epam.composite.TextComposite;
import by.epam.composite.TextType;
import by.epam.parser.BaseParser;

public class SentenceParser implements BaseParser {
    private static final SentenceParser INSTANCE = new SentenceParser();
    private static final String SENTENCE_DELIMITER = "\\s+";
    private WordParser wordParser = WordParser.getInstance();

    private SentenceParser(){}

    public static SentenceParser getInstance() {
        return INSTANCE;
    }

    @Override
    public TextComponent parse(String sentence) {
        TextComponent sentenceComponent = new TextComposite(TextType.SENTENCE);
        String[] words = sentence.split(SENTENCE_DELIMITER);
        for (String word: words) {
            TextComponent wordComponent = wordParser.parse(word);
            sentenceComponent.add(wordComponent);
        }
        return sentenceComponent;
    }
}
