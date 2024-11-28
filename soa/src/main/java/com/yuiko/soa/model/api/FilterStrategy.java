package com.yuiko.soa.model.api;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Стратегия фильтрации
 */

@JacksonXmlRootElement(localName = "FilterStrategy")
@XmlRootElement(name = "FilterStrategy")
@XmlAccessorType(XmlAccessType.FIELD)
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-27T20:35:13.379440+03:00[Europe/Moscow]", comments = "Generator version: 7.8.0")
public class FilterStrategy {

  private CityField filterColumn;

  private FilterType filterType;

  private String filterValue;

  public FilterStrategy() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FilterStrategy(CityField filterColumn, FilterType filterType, String filterValue) {
    this.filterColumn = filterColumn;
    this.filterType = filterType;
    this.filterValue = filterValue;
  }

  public FilterStrategy filterColumn(CityField filterColumn) {
    this.filterColumn = filterColumn;
    return this;
  }

  /**
   * Get filterColumn
   * @return filterColumn
   */
  @NotNull @Valid 
  @JsonProperty("filterColumn")
  @JacksonXmlProperty(localName = "filterColumn")
  @XmlElement(name = "filterColumn")
  public CityField getFilterColumn() {
    return filterColumn;
  }

  public void setFilterColumn(CityField filterColumn) {
    this.filterColumn = filterColumn;
  }

  public FilterStrategy filterType(FilterType filterType) {
    this.filterType = filterType;
    return this;
  }

  /**
   * Get filterType
   * @return filterType
   */
  @NotNull @Valid 
  @JsonProperty("filterType")
  @JacksonXmlProperty(localName = "filterType")
  @XmlElement(name = "filterType")
  public FilterType getFilterType() {
    return filterType;
  }

  public void setFilterType(FilterType filterType) {
    this.filterType = filterType;
  }

  public FilterStrategy filterValue(String filterValue) {
    this.filterValue = filterValue;
    return this;
  }

  /**
   * Значение которое будет использоваться для фильтрации
   * @return filterValue
   */
  @NotNull @Size(min = 1) 
  @JsonProperty("filterValue")
  @JacksonXmlProperty(localName = "filterValue")
  @XmlElement(name = "filterValue")
  public String getFilterValue() {
    return filterValue;
  }

  public void setFilterValue(String filterValue) {
    this.filterValue = filterValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FilterStrategy filterStrategy = (FilterStrategy) o;
    return Objects.equals(this.filterColumn, filterStrategy.filterColumn) &&
        Objects.equals(this.filterType, filterStrategy.filterType) &&
        Objects.equals(this.filterValue, filterStrategy.filterValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(filterColumn, filterType, filterValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FilterStrategy {\n");
    sb.append("    filterColumn: ").append(toIndentedString(filterColumn)).append("\n");
    sb.append("    filterType: ").append(toIndentedString(filterType)).append("\n");
    sb.append("    filterValue: ").append(toIndentedString(filterValue)).append("\n");
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

