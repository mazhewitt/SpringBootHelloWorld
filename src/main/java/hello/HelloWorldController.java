package hello;

/**
 * Created by Mazda on 13/01/2016.
 */
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {

        private final AtomicLong counter = new AtomicLong();

        @RequestMapping("/greeting")
        public HelloWorld greeting() {
            return new HelloWorld("Hello World!");
        }

}
