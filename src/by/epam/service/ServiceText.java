package by.epam.service;

import by.epam.comparator.ParagraphSizeComparator;
import by.epam.composite.TextComponent;
import by.epam.composite.TextComposite;
import by.epam.composite.TextType;
import by.epam.exception.CustomException;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ServiceText {
    public TextComponent paragraphSort(TextComponent text) throws CustomException {
        if (text.getTextType() != TextType.TEXT) {
            throw new CustomException("Incorrect text type");
        }
        TextComponent sortedText = new TextComposite(TextType.PARAGRAPH);
        List<TextComponent> paragraphs = new ArrayList<>(text.getAll());
        paragraphs.sort(new ParagraphSizeComparator());
        for (TextComponent paragraph : paragraphs) {
            sortedText.add(paragraph);
        }
        return sortedText;
    }

    public TextComponent findLongestSentence(TextComponent text) throws CustomException {
        if (text.getTextType() != TextType.TEXT) {
            throw new CustomException("Incorrect text type");
        }
        TextComponent longestSentence = new TextComposite(TextType.SENTENCE);
        List<TextComponent> paragraphList = text.getAll();
        int maxLength = 0;
        for (TextComponent t : paragraphList) {
            List<TextComponent> sentenceList = t.getAll();
            for (TextComponent t2 : sentenceList) {
                if (t2.getTextType() == TextType.SENTENCE) {
                    if (t2.getAll().size() > maxLength) {
                        maxLength = t2.getAll().size();
                        longestSentence = t2;
                    }

                }
            }
        }
        return longestSentence;
    }

    public TextComponent removeSentences(TextComponent text,int amountOfWords) throws CustomException {
        if (text.getTextType() != TextType.TEXT) {
            throw new CustomException("Incorrect text type");
        }
        List<TextComponent> paragraphList = text.getAll();
        List<TextComponent> listToRemove = new ArrayList<>();
        for (TextComponent t : paragraphList) {
            List<TextComponent> sentenceList = t.getAll();
            for (TextComponent t2 : sentenceList) {
                if (t2.getTextType() == TextType.SENTENCE) {
                    if (t2.getAll().size() < amountOfWords) {
                        listToRemove.add(t2);
                    }
                }
            }
            for (TextComponent t3 : listToRemove) {
                t.remove(t3);
            }
            listToRemove.clear();
        }
        return text;
    }
}
