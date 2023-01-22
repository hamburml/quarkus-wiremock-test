package de.hamburml.quarkus;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import de.hamburml.quarkus.client.CatFactModel;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@QuarkusTestResource(WiremockCatFactResource.class)
public class CatFactResourceTest {

  @Test
  public void testHelloEndpoint() {
    CatFactModel catFact = given().when().post("/catfact").then().statusCode(200).extract().body()
        .as(CatFactModel.class);

    assertTrue(catFact.getFact().length() > 0);
    assertTrue(catFact.getLength() > 0);

  }

}
