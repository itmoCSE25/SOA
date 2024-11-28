package com.yuiko.soa.model.api;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Стратегия сортировки
 */

@JacksonXmlRootElement(localName = "SortingStrategy")
@XmlRootElement(name = "SortingStrategy")
@XmlAccessorType(XmlAccessType.FIELD)
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-27T20:35:13.379440+03:00[Europe/Moscow]", comments = "Generator version: 7.8.0")
public class SortingStrategy {

  private SortingType sortingType;

  private CityField sortingColumn;

  public SortingStrategy() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SortingStrategy(SortingType sortingType, CityField sortingColumn) {
    this.sortingType = sortingType;
    this.sortingColumn = sortingColumn;
  }

  public SortingStrategy sortingType(SortingType sortingType) {
    this.sortingType = sortingType;
    return this;
  }

  /**
   * Get sortingType
   * @return sortingType
   */
  @NotNull @Valid 
  @JsonProperty("sortingType")
  @JacksonXmlProperty(localName = "sortingType")
  @XmlElement(name = "sortingType")
  public SortingType getSortingType() {
    return sortingType;
  }

  public void setSortingType(SortingType sortingType) {
    this.sortingType = sortingType;
  }

  public SortingStrategy sortingColumn(CityField sortingColumn) {
    this.sortingColumn = sortingColumn;
    return this;
  }

  /**
   * Get sortingColumn
   * @return sortingColumn
   */
  @NotNull @Valid 
  @JsonProperty("sortingColumn")
  @JacksonXmlProperty(localName = "sortingColumn")
  @XmlElement(name = "sortingColumn")
  public CityField getSortingColumn() {
    return sortingColumn;
  }

  public void setSortingColumn(CityField sortingColumn) {
    this.sortingColumn = sortingColumn;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SortingStrategy sortingStrategy = (SortingStrategy) o;
    return Objects.equals(this.sortingType, sortingStrategy.sortingType) &&
        Objects.equals(this.sortingColumn, sortingStrategy.sortingColumn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sortingType, sortingColumn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SortingStrategy {\n");
    sb.append("    sortingType: ").append(toIndentedString(sortingType)).append("\n");
    sb.append("    sortingColumn: ").append(toIndentedString(sortingColumn)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

