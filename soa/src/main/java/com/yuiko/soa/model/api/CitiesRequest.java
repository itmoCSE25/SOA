package com.yuiko.soa.model.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.annotation.Generated;


/**
 * Запрос на получение списка городов
 */

@JacksonXmlRootElement(localName = "CitiesRequest")
@XmlRootElement(name = "CitiesRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-27T20:35:13.379440+03:00[Europe/Moscow]", comments = "Generator version: 7.8.0")
public class CitiesRequest {

  private Integer page = 1;

  private Integer pageSize = 20;

  private SortingStrategy sortingStrategies;

  @Valid
  private List<@Valid FilterStrategy> filterStrategies = new ArrayList<>();

  public CitiesRequest page(Integer page) {
    this.page = page;
    return this;
  }

  /**
   * Номер страницы
   * minimum: 1
   * @return page
   */
  @Min(1)
  @JsonProperty("page")
  @JacksonXmlProperty(localName = "page")
  @XmlElement(name = "page")
  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public CitiesRequest pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  /**
   * Размер страницы
   * minimum: 1
   * @return pageSize
   */
  @Min(1) 
  @JsonProperty("pageSize")
  @JacksonXmlProperty(localName = "pageSize")
  @XmlElement(name = "pageSize")
  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public CitiesRequest sortingStrategies(SortingStrategy sortingStrategies) {
    this.sortingStrategies = sortingStrategies;
    return this;
  }

  /**
   * Get sortingStrategies
   * @return sortingStrategies
   */
  @Valid 
  @JsonProperty("sortingStrategies")
  @JacksonXmlProperty(localName = "sortingStrategies")
  @XmlElement(name = "sortingStrategies")
  public SortingStrategy getSortingStrategies() {
    return sortingStrategies;
  }

  public void setSortingStrategies(SortingStrategy sortingStrategies) {
    this.sortingStrategies = sortingStrategies;
  }

  public CitiesRequest filterStrategies(List<@Valid FilterStrategy> filterStrategies) {
    this.filterStrategies = filterStrategies;
    return this;
  }

  public CitiesRequest addFilterStrategiesItem(FilterStrategy filterStrategiesItem) {
    if (this.filterStrategies == null) {
      this.filterStrategies = new ArrayList<>();
    }
    this.filterStrategies.add(filterStrategiesItem);
    return this;
  }

  /**
   * Список с описанием фильтрации
   * @return filterStrategies
   */
  @Valid 
  @JsonProperty("filterStrategies")
  @JacksonXmlProperty(localName = "filterStrategies")
  @JacksonXmlElementWrapper(useWrapping = false)
  @XmlElement(name = "filterStrategies")
  public List<@Valid FilterStrategy> getFilterStrategies() {
    return filterStrategies;
  }

  public void setFilterStrategies(List<@Valid FilterStrategy> filterStrategies) {
    this.filterStrategies = filterStrategies;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CitiesRequest citiesRequest = (CitiesRequest) o;
    return Objects.equals(this.page, citiesRequest.page) &&
        Objects.equals(this.pageSize, citiesRequest.pageSize) &&
        Objects.equals(this.sortingStrategies, citiesRequest.sortingStrategies) &&
        Objects.equals(this.filterStrategies, citiesRequest.filterStrategies);
  }

  @Override
  public int hashCode() {
    return Objects.hash(page, pageSize, sortingStrategies, filterStrategies);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CitiesRequest {\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    sortingStrategies: ").append(toIndentedString(sortingStrategies)).append("\n");
    sb.append("    filterStrategies: ").append(toIndentedString(filterStrategies)).append("\n");
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

