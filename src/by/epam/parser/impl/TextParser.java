package by.epam.parser.impl;

import by.epam.composite.TextComponent;
import by.epam.composite.TextComposite;
import by.epam.parser.BaseParser;

public class TextParser implements BaseParser {
    private static final String TEXT_DELIMITER = "\n\\s+";

    @Override
    public TextComponent parse(String text) {
        TextComponent textComponent = new TextComposite();
        String[] paragraphs = text.split(TEXT_DELIMITER);
        ParagraphParser paragraphParser = new ParagraphParser();
        for (String paragraph : paragraphs) {
            TextComponent paragraphComponent = paragraphParser.parse(paragraph);
            textComponent.add(paragraphComponent);
        }
        return textComponent;
    }
}
