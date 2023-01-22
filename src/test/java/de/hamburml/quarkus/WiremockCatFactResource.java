package de.hamburml.quarkus;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import java.util.Collections;
import java.util.Map;

import com.github.tomakehurst.wiremock.WireMockServer;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

public class WiremockCatFactResource implements QuarkusTestResourceLifecycleManager {

  private WireMockServer wireMockServer;

  @Override
  public Map<String, String> start() {
    wireMockServer = new WireMockServer();
    wireMockServer.start();

    wireMockAlwaysReturnStaticResponse();
    return Collections.singletonMap("de.hamburml.quarkus.client.CatFactRestClient/mp-rest/url",
        wireMockServer.baseUrl());
  }

  private void wireMockAlwaysReturnStaticResponse() {
    stubFor(
        get(urlEqualTo("/")).willReturn(aResponse().withHeader("Content-Type", "application/json")
            .withBody("{\n" + "\"fact\": \"MIAUMIAUMI\",\n" + "\"length\": 10\n" + "}")));
  }

  @Override
  public void stop() {
    wireMockServer.stop();
  }
}
