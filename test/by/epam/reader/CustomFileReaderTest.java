package by.epam.reader;

import by.epam.exception.CustomException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CustomFileReaderTest {
    CustomFileReader customFIleReader;

    @BeforeClass
    public void setUp() {
        customFIleReader = new CustomFileReader();
    }

    @AfterClass
    public void tearDown() {
        customFIleReader = null;
    }

    @Test(dataProvider = "readTextData")
    public void readTextTest(String fileName, String expected) throws CustomException {
        String actual = customFIleReader.readFile(fileName);
        Assert.assertEquals(actual, expected);
    }

    @DataProvider(name = "readTextData")
    public Object[][] createReadTextData() {
        String text = "It  has  survived -not  only  (five)  centuries,  but  also  the  leap  into  13<<2  electronic typesetting,  remaining  3>>5 essentially  ~6&9|(3&4)  unchanged.  It  was  popularised  in  the 5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1)  with  the  release  of  Letraset  sheets  containing Lorem  Ipsum  passages,  and  more  recently  with  desktop  publishing  software  like  Aldus PageMaker includingversions of Lorem Ipsum.\n" +
                "    It is a long established fact that a reader will be distracted by the readable content of a page  when  looking  at  its  layout.  The  point  of  using  (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English.\n" +
                "    It  is  a  (7^5|1&2<<(2|5>>2&71))|1200  established  fact  that  a  reader  will  be  of  a  page when looking at its layout.\n" +
                "    Bye.";
        String text2 = "Значимость этих проблем настолько очевидна, что постоянное информационно-техническое обеспечение нашей деятельности способствует подготовке и реализации модели развития. Соображения высшего порядка, а также начало повседневной работы по формированию позиции требует определения и уточнения системы масштабного изменения ряда параметров. Задача организации, в особенности же консультация с профессионалами из IT играет важную роль в формировании позиций, занимаемых участниками в отношении поставленных задач?\n" +
                "   Практический опыт показывает, что постоянный количественный рост и сфера нашей активности требует определения и уточнения новых предложений! С другой стороны постоянное информационно-техническое обеспечение нашей деятельности в значительной степени обуславливает создание системы масштабного изменения ряда параметров. Разнообразный и богатый опыт новая модель организационной деятельности играет важную роль в формировании экономической целесообразности принимаемых решений.\n" +
                "   Таким образом, курс на социально-ориентированный национальный проект позволяет оценить значение всесторонне сбалансированных нововведений. Задача организации, в особенности же рамки и место обучения кадров способствует повышению актуальности позиций, занимаемых участниками в отношении поставленных задач! Равным образом рамки и место обучения кадров обеспечивает актуальность экономической целесообразности принимаемых решений. Равным образом новая модель организационной деятельности в значительной степени обуславливает создание соответствующих условий активизации!\n" +
                "   Постоянный количественный рост и сфера нашей активности. Это настолько очевидно...";
        return new Object[][]{
                {"data/MathData.txt", text},
                {"data/SimpleData.txt", text2}
        };
    }
}
