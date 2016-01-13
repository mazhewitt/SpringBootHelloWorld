/**
 * Created by Mazda on 13/01/2016.
 */

import hello.Application;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest
@IntegrationTest("server.port:8080")
public class HelloWorldFixture {

    private String user;

    @Test
    public void helloWorldAcceptanceTests() throws Exception {
        aBehaviouralTestRunner()
                .usingStepsFrom(this)
                .withStory("hello-world.story")
                .run();
    }

    @When("I Say Hello To $")
    public void whenISayHelloTo(String user) {
        this.user = user;
    }

    @Then("The greeting should be $")
    public void thenTheGreetingShouldBe(String expectedGreeting) {
        given().
                param("name", user).
                when().
                get("/greeting").
                then().
                statusCode(200).
                body("content", equalTo(expectedGreeting));

    }
}

