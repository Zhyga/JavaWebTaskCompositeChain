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

    @DataProvider(name = "paragraphSortData")
    public Object[][] createParagraphSortData(){
        TextParser textParser = TextParser.getInstance();
        String text1 = "World hello.How are you? Im fine.\n    OK?\n   Yes. Very ok!";
        String sortedText1 = "OK? \n\tYes. Very ok!\n\tWorld hello." +
                "How are you? Im fine.\n\t";
        TextComponent textComponent1 = textParser.parse(text1);
        String text2 = "World hello. How are you?\nOK?\nYes. Very ok!";
        String sortedText2 = "OK? \nWorld hello. How are you? \nYes. Very ok! \n";
        TextComponent textComponent2 = textParser.parse(text2);
        String text3 = "World hello. How are you? Im fine.";
        String sortedText3 = "World hello. How are you? Im fine. \n";
        TextComponent textComponent3 = textParser.parse(text3);
        return new Object[][]{
                {textComponent1, sortedText1},
                {textComponent2, sortedText2},
                {textComponent3, sortedText3}
        };
    }
}
