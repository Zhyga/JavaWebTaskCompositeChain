package by.epam.reader;

import by.epam.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomFileReader {
    private static Logger logger = LogManager.getLogger();

    public List<String> readFile(String filename) throws CustomException {
        Path path = Paths.get(filename);
        try(Stream<String> linedTextStream  = Files.lines(path)){
            List<String> linedTextList  = linedTextStream.collect(Collectors.toList());
            return linedTextList;
        }
        catch(IOException e){
            logger.error("File {} cant be open, or read",filename,e);
            throw new CustomException("File cant be open, or read",e);
        }
    }
}
