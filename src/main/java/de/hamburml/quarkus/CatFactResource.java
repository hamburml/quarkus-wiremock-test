package de.hamburml.quarkus;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import de.hamburml.quarkus.client.CatFactModel;
import de.hamburml.quarkus.client.CatFactRestClient;
import lombok.extern.slf4j.Slf4j;

@Path("/catfact")
@Slf4j
public class CatFactResource {

  @RestClient
  CatFactRestClient catFactRestClient;

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public CatFactModel getFact() {
    CatFactModel catFact = catFactRestClient.getRandomFact();
    log.info("catFact: {}", catFact.getFact());
    return catFact;
  }
}
