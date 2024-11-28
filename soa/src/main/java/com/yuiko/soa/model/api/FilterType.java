package com.yuiko.soa.model.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.annotation.Generated;

/**
 * Тип фильтрации
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-27T20:35:13.379440+03:00[Europe/Moscow]", comments = "Generator version: 7.8.0")
public enum FilterType {
  
  CONTAINS("contains"),
  
  MORE("more"),
  
  MORE_OR_EQUALS("moreOrEquals"),
  
  LESS("less"),
  
  LESS_OR_EQUALS("lessOrEquals"),
  
  EQUALS("equals");

  private String value;

  FilterType(String value) {
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
  public static FilterType fromValue(String value) {
    for (FilterType b : FilterType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

