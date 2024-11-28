package com.yuiko.soa.model.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.annotation.Generated;

/**
 * Колонка по которой необходимо сортировать
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-27T20:35:13.379440+03:00[Europe/Moscow]", comments = "Generator version: 7.8.0")
public enum CityField {
  
  ID("id"),
  
  NAME("name"),
  
  X("x"),
  
  Y("y"),
  
  CREATION_DATE("creationDate"),
  
  AREA("area"),
  
  POPULATION("population"),
  
  METERS_ABOVE_SEA_LEVEL("metersAboveSeaLevel"),
  
  ESTABLISHMENT_DATE("establishmentDate"),
  
  CAPITAL("capital"),
  
  GOVERNMENT("government"),
  
  GOVERNOR("governor");

  private String value;

  CityField(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static CityField fromValue(String value) {
    for (CityField b : CityField.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

