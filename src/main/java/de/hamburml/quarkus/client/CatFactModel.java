package de.hamburml.quarkus.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatFactModel {

  public String fact;
  public int length;


}
