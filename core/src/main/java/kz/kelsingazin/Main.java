package kz.kelsingazin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess the number game");

        //Create context
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        //get numberGenerator bean from context (container)
        NumberGenerator numberGenerator =
                context.getBean("numberGenerator", NumberGenerator.class);

        //Call method next() for random number
        int number = numberGenerator.next();

        //log generated number
        log.info("number = {}", number);

        //get game bean from context (container)
        Game game = context.getBean(Game.class);

        //Game method
        game.reset();

        //close context
        context.close();
    }
}
