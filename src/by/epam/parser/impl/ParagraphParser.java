package by.epam.parser.impl;

import by.epam.composite.TextComponent;
import by.epam.composite.TextComposite;
import by.epam.composite.TextType;
import by.epam.parser.BaseParser;

public class ParagraphParser implements BaseParser {
    private static final ParagraphParser INSTANCE = new ParagraphParser();
    private static final String PARAGRAPH_SPLIT_REGEX = "(?<=\\.)\\s|(?<=\\?)\\s|(?<=!)\\s|(?<=\\.{3})\\s+";
    private SentenceParser sentenceParser = SentenceParser.getInstance();

    private ParagraphParser(){}

    public static ParagraphParser getInstance() {
        return INSTANCE;
    }

    @Override
    public TextComponent parse(String paragraph) {
        TextComponent paragraphComponent = new TextComposite(TextType.PARAGRAPH);
        String[] sentences = paragraph.split(PARAGRAPH_SPLIT_REGEX);
        for (String p : sentences) {
            TextComponent sentenceComponent = sentenceParser.parse(p);
            paragraphComponent.add(sentenceComponent);
        }
        return paragraphComponent;
    }
}
