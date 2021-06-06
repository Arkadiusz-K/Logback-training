import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import ch.qos.logback.classic.Level;


public class Main {
    public static void main(String[] args){
        Logger logger = LoggerFactory.getLogger("Logback-training.src.main.java.Main");
        logger.trace("Trace message.");
        logger.debug("Debug message.");
        logger.info("Info message.");
        logger.warn("Warning message");
        logger.error("Error message");
        //printInternalState();
        testEnabledLevels();
        String[] example = {"One","Two","Three"};
        logger.warn("Message with 3 parameters {}, {}, {}",example[0],example[1],example[2]);
    }
    static void printInternalState(){
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);
    }
    static void testEnabledLevels(){
        ch.qos.logback.classic.Logger logger2 =
                (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com");
        logger2.setLevel(Level.INFO);
        Logger barlogger = LoggerFactory.getLogger("com.logback-training");
        barlogger.warn("Warning is enabled");
        //Trace is disabled, because trace < info (inheritance)
        logger2.trace("Nothing in output");
        logger2.setLevel(Level.TRACE);
        logger2.trace("Now trace is enabled");
    }
}
