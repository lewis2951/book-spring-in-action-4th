package spittr;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spittr.config.RmiConfig;

public class RmiApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(RmiConfig.class);
        System.out.println("Rmi Service is running.");
    }

}
