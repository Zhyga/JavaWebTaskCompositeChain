package by.epam.interpreter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class LexemeInterpreter {
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("js");

    public String interpretateLexem(String lexem){
        String expression = lexem;
        if(lexem.matches(".*\\d.*")) {
            try {
                Object result = engine.eval(lexem);
                expression = result.toString();
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        }
        return expression;
    }
}
