package by.epam.parser.impl;

import by.epam.composite.TextComponent;
import by.epam.composite.TextComposite;
import by.epam.parser.BaseParser;

public class ParagraphParser implements BaseParser {
    private static final String PARAGRAPH_SPLIT_REGEX = "(?<=\\.)\\s|(?<=\\?)\\s|(?<=!)\\s|(?<=\\.{3})\\s+";

    @Override
    public TextComponent parse(String paragraph) {
        TextComponent paragraphComponent = new TextComposite();
        String[] strings = paragraph.split(PARAGRAPH_SPLIT_REGEX);
        SentenceParser sentenceParser = new SentenceParser();
        for (String p : strings) {
            TextComponent sentenceComponent = sentenceParser.parse(p);
            paragraphComponent.add(sentenceComponent);
        }
        return paragraphComponent;
    }
}
