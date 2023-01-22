package de.hamburml.quarkus.client;

import javax.ws.rs.GET;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
public interface CatFactRestClient {

  @GET
  public CatFactModel getRandomFact();
}
