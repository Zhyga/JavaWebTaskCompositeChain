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

public class WordParserTest {
    private WordParser wordParser;

    @BeforeClass
    public void setUp() {
        wordParser = WordParser.getInstance();
    }

    @AfterClass
    public void tearDown() {
        wordParser = null;
    }

    @Test(dataProvider = "textParserData")
    public void textParserTest(TextComponent expected, String text){
        TextComponent actual = wordParser.parse(text);
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
        SymbolLeaf symbolLeaf25 = new SymbolLeaf('d');
        SymbolLeaf symbolLeaf26 = new SymbolLeaf('a');
        SymbolLeaf symbolLeaf27 = new SymbolLeaf('y');
        TextComponent word3 = new TextComposite(TextType.WORD);
        word3.add(symbolLeaf25);
        word3.add(symbolLeaf26);
        word3.add(symbolLeaf27);
        String textWord1 = "Hello";
        String textWord2 = "world!";
        String textWord3 = "day";
        return new Object[][]{
                {word1,textWord1},
                {word2,textWord2},
                {word3,textWord3}
        };
    }
}
