package by.epam.service;

import by.epam.composite.TextComponent;
import by.epam.exception.CustomException;
import by.epam.parser.impl.TextParser;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ServiceTextTest {
    ServiceText serviceText;

    @BeforeClass
    public void setUp() {
        serviceText = new ServiceText();
    }

    @AfterClass
    public void tearDown() {
        serviceText = null;
    }

    @Test(dataProvider = "paragraphSortData")
    public void  paragraphSortTest(TextComponent textComponent, String expected) throws CustomException {
        TextComponent actual = serviceText.paragraphSort(textComponent);
        Assert.assertEquals(actual.toString(),expected);
    }

    @Test(dataProvider = "longestSentenceData")
    public void  findLongestSentenceTest(TextComponent textComponent, String expected) throws CustomException {
        TextComponent actual = serviceText.findLongestSentence(textComponent);
        Assert.assertEquals(actual.toString(),expected);
    }

    @Test(dataProvider = "removeSentencesData")
    public void removeSentencesTest(TextComponent textComponent, String expected,int amountOfWords) throws CustomException {
        TextComponent actual = serviceText.removeSentences(textComponent,amountOfWords);
        Assert.assertEquals(actual.toString(),expected);
    }

    @DataProvider(name = "paragraphSortData")
    public Object[][] createParagraphSortData(){
        TextParser textParser = TextParser.getInstance();
        String text1 = "World hello.How are you? Im fine.\nOK?\nYes.Very ok!";
        String sortedText1 = "OK? \n\tYes.Very ok! \n\tWorld hello.How are you? Im fine. \n\t";
        TextComponent textComponent1 = textParser.parse(text1);
        String text2 = "World hello. How are you?\nOK?\nYes. Very ok!";
        String sortedText2 = "OK? \n\tWorld hello. How are you? \n\tYes. Very ok! \n\t";
        TextComponent textComponent2 = textParser.parse(text2);
        String text3 = "World hello. How are you? Im fine.";
        String sortedText3 = "World hello. How are you? Im fine. \n\t";
        TextComponent textComponent3 = textParser.parse(text3);
        return new Object[][]{
                {textComponent1, sortedText1},
                {textComponent2, sortedText2},
                {textComponent3, sortedText3}
        };
    }

    @DataProvider(name = "longestSentenceData")
    public Object[][] createLongestSentenceData(){
        TextParser textParser = TextParser.getInstance();
        String longestSentence1 = "Hello world, its me Mario! ";
        String text1 = "Hello world, its me Mario! I live in Japan. I jump on turtles";
        TextComponent textComponent1 = textParser.parse(text1);
        String longestSentence2 = "How are you? ";
        String text2 = "World hello. How are you? Im fine.\nOK?\nYes.Very ok!";
        TextComponent textComponent2 = textParser.parse(text2);
        return new Object[][]{
            {textComponent1, longestSentence1},
            {textComponent2,longestSentence2}
        };
    }

    @DataProvider(name = "removeSentencesData")
    public Object[][] createRemoveSentencesData(){
        TextParser textParser = TextParser.getInstance();
        String text1 = "World hello.How are you? Im fine.\nOK?\nYes Very ok!";//2
        String expected1 = "World hello.How are you? Im fine. \n\t\n\tYes Very ok! \n\t";
        TextComponent textComponent1 = textParser.parse(text1);
        String text2 = "Hello world, its me Mario! I live in Japan. I jump on turtles";//5
        String expected2 = "Hello world, its me Mario! \n\t";
        TextComponent textComponent2 = textParser.parse(text2);

        return new Object[][]{
                {textComponent1,expected1,2},
                {textComponent2,expected2,5}
        };
    }
}
