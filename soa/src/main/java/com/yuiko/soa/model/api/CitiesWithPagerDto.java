package com.yuiko.soa.model.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
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
 * CitiesWithPagerDto
 */

@JacksonXmlRootElement(localName = "CitiesWithPagerDto")
@XmlRootElement(name = "CitiesWithPagerDto")
@XmlAccessorType(XmlAccessType.FIELD)
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-27T20:35:13.379440+03:00[Europe/Moscow]", comments = "Generator version: 7.8.0")
public class CitiesWithPagerDto {

  @Valid
  private List<@Valid City> cities = new ArrayList<>();

  private Pager pager;

  public CitiesWithPagerDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CitiesWithPagerDto(List<@Valid City> cities, Pager pager) {
    this.cities = cities;
    this.pager = pager;
  }

  public CitiesWithPagerDto cities(List<@Valid City> cities) {
    this.cities = cities;
    return this;
  }

  public CitiesWithPagerDto addCitiesItem(City citiesItem) {
    if (this.cities == null) {
      this.cities = new ArrayList<>();
    }
    this.cities.add(citiesItem);
    return this;
  }

  /**
   * Get cities
   * @return cities
   */
  @NotNull @Valid 
  @JsonProperty("cities")
  @JacksonXmlProperty(localName = "cities")
  @JacksonXmlElementWrapper(useWrapping = false)
  @XmlElement(name = "cities")
  public List<@Valid City> getCities() {
    return cities;
  }

  public void setCities(List<@Valid City> cities) {
    this.cities = cities;
  }

  public CitiesWithPagerDto pager(Pager pager) {
    this.pager = pager;
    return this;
  }

  /**
   * Get pager
   * @return pager
   */
  @NotNull @Valid 
  @JsonProperty("pager")
  @JacksonXmlProperty(localName = "pager")
  @XmlElement(name = "pager")
  public Pager getPager() {
    return pager;
  }

  public void setPager(Pager pager) {
    this.pager = pager;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CitiesWithPagerDto citiesWithPagerDto = (CitiesWithPagerDto) o;
    return Objects.equals(this.cities, citiesWithPagerDto.cities) &&
        Objects.equals(this.pager, citiesWithPagerDto.pager);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cities, pager);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CitiesWithPagerDto {\n");
    sb.append("    cities: ").append(toIndentedString(cities)).append("\n");
    sb.append("    pager: ").append(toIndentedString(pager)).append("\n");
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

