package by.epam.parser.impl;

import by.epam.composite.TextComponent;
import by.epam.composite.TextComposite;
import by.epam.composite.TextType;
import by.epam.parser.BaseParser;

public class TextParser implements BaseParser {
    private static final TextParser INSTANCE = new TextParser();
    private static final String TEXT_DELIMITER = "\n\\s*";
    private ParagraphParser paragraphParser = ParagraphParser.getInstance();

    private TextParser(){}

    public static TextParser getInstance(){
        return INSTANCE;
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent textComponent = new TextComposite(TextType.TEXT);
        String[] paragraphs = text.split(TEXT_DELIMITER);
        for (String paragraph : paragraphs) {
            TextComponent paragraphComponent = paragraphParser.parse(paragraph);
            textComponent.add(paragraphComponent);
        }
        return textComponent;
    }
}
