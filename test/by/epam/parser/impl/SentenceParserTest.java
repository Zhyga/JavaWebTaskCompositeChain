package by.epam.parser.impl;

import by.epam.composite.SymbolLeaf;
import by.epam.composite.TextComponent;
import by.epam.composite.TextComposite;
import by.epam.composite.TextType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SentenceParserTest {
    private SentenceParser sentenceParser;

    @BeforeClass
    public void setUp() {
        sentenceParser = SentenceParser.getInstance();
    }

    @AfterClass
    public void tearDown() {
        sentenceParser = null;
    }

    @Test(dataProvider = "textParserData")
    public void textParserTest(TextComponent expected, String text){
        TextComponent actual = sentenceParser.parse(text);
        Assert.assertEquals(actual.toString(),expected.toString());
    }

    @DataProvider(name = "textParserData")
    public Object[][] createTextParserData(){
        SymbolLeaf symbolLeaf1 = new SymbolLeaf('H');
        SymbolLeaf symbolLeaf2 = new SymbolLeaf('e');
        SymbolLeaf symbolLeaf3 = new SymbolLeaf('l');
        SymbolLeaf symbolLeaf4 = new SymbolLeaf('l');
        SymbolLeaf symbolLeaf5 = new SymbolLeaf('o');
        TextComponent word1 = new TextComposite(TextType.WORD);
        word1.add(symbolLeaf1);
        word1.add(symbolLeaf2);
        word1.add(symbolLeaf3);
        word1.add(symbolLeaf4);
        word1.add(symbolLeaf5);
        SymbolLeaf symbolLeaf6 = new SymbolLeaf('w');
        SymbolLeaf symbolLeaf7 = new SymbolLeaf('o');
        SymbolLeaf symbolLeaf8 = new SymbolLeaf('r');
        SymbolLeaf symbolLeaf9 = new SymbolLeaf('l');
        SymbolLeaf symbolLeaf10 = new SymbolLeaf('d');
        SymbolLeaf symbolLeaf11 = new SymbolLeaf('!');
        TextComponent word2 = new TextComposite(TextType.WORD);
        word2.add(symbolLeaf6);
        word2.add(symbolLeaf7);
        word2.add(symbolLeaf8);
        word2.add(symbolLeaf9);
        word2.add(symbolLeaf10);
        word2.add(symbolLeaf11);
        TextComponent sentence1 = new TextComposite(TextType.SENTENCE);
        sentence1.add(word1);
        sentence1.add(word2);
        SymbolLeaf symbolLeaf12 = new SymbolLeaf('H');
        SymbolLeaf symbolLeaf13 = new SymbolLeaf('i');
        SymbolLeaf symbolLeaf14 = new SymbolLeaf('.');
        TextComponent word3 = new TextComposite(TextType.WORD);
        word3.add(symbolLeaf12);
        word3.add(symbolLeaf13);
        word3.add(symbolLeaf14);
        TextComponent sentence2 = new TextComposite(TextType.SENTENCE);
        sentence2.add(word3);
        SymbolLeaf symbolLeaf15 = new SymbolLeaf('I');
        SymbolLeaf symbolLeaf16 = new SymbolLeaf('t');
        SymbolLeaf symbolLeaf17 = new SymbolLeaf('s');
        TextComponent word4 = new TextComposite(TextType.WORD);
        word4.add(symbolLeaf15);
        word4.add(symbolLeaf16);
        word4.add(symbolLeaf17);
        SymbolLeaf symbolLeaf19 = new SymbolLeaf('a');
        TextComponent word5 = new TextComposite(TextType.WORD);
        word5.add(symbolLeaf19);
        SymbolLeaf symbolLeaf21 = new SymbolLeaf('n');
        SymbolLeaf symbolLeaf22 = new SymbolLeaf('e');
        SymbolLeaf symbolLeaf23 = new SymbolLeaf('w');
        TextComponent word6 = new TextComposite(TextType.WORD);
        word6.add(symbolLeaf21);
        word6.add(symbolLeaf22);
        word6.add(symbolLeaf23);
        SymbolLeaf symbolLeaf25 = new SymbolLeaf('d');
        SymbolLeaf symbolLeaf26 = new SymbolLeaf('a');
        SymbolLeaf symbolLeaf27 = new SymbolLeaf('y');
        TextComponent word7 = new TextComposite(TextType.WORD);
        word7.add(symbolLeaf25);
        word7.add(symbolLeaf26);
        word7.add(symbolLeaf27);
        TextComponent sentence3 = new TextComposite(TextType.SENTENCE);
        sentence3.add(word4);
        sentence3.add(word5);
        sentence3.add(word6);
        sentence3.add(word7);
        String textSentence1 = "Hello world!";
        String textSentence2 = "Hi.\n";
        String textSentence3 = "Its a new day\n";
        return new Object[][]{
                {sentence1,textSentence1},
                {sentence2,textSentence2},
                {sentence3,textSentence3}
        };
    }
}
