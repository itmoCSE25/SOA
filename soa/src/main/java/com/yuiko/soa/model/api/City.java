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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Город
 */

@JacksonXmlRootElement(localName = "City")
@XmlRootElement(name = "City")
@XmlAccessorType(XmlAccessType.FIELD)
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-27T20:35:13.379440+03:00[Europe/Moscow]", comments = "Generator version: 7.8.0")
public class City {

  private Long id;

  private String name;

  private Coordinates coordinates;

  private String creationDate;

  private Float area = null;

  private Long population;

  private Double metersAboveSeaLevel;

  private Boolean capital;

  private Government government;

  private Human governor;

  @Valid
  private List<@Valid Human> inhabitant = new ArrayList<>();

  private String establishmentDate;

  public City() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public City(Long id, String name, Coordinates coordinates, String creationDate, Float area, Long population, Boolean capital, Government government, Human governor) {
    this.id = id;
    this.name = name;
    this.coordinates = coordinates;
    this.creationDate = creationDate;
    this.area = area;
    this.population = population;
    this.capital = capital;
    this.government = government;
    this.governor = governor;
  }

  public City id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Идентификатор города
   * minimum: 1
   * @return id
   */
  @NotNull @Min(1L)
  @JsonProperty("id")
  @JacksonXmlProperty(localName = "id")
  @XmlElement(name = "id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public City name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Название города
   * @return name
   */
  @NotNull @Size(min = 1) 
  @JsonProperty("name")
  @JacksonXmlProperty(localName = "name")
  @XmlElement(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public City coordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
    return this;
  }

  /**
   * Get coordinates
   * @return coordinates
   */
  @NotNull @Valid 
  @JsonProperty("coordinates")
  @JacksonXmlProperty(localName = "coordinates")
  @XmlElement(name = "coordinates")
  public Coordinates getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

  public City creationDate(String creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * Дата создания
   * @return creationDate
   */
  @NotNull 
  @JsonProperty("creationDate")
  @JacksonXmlProperty(localName = "creationDate")
  @XmlElement(name = "creationDate")
  public String getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }

  public City area(Float area) {
    this.area = area;
    return this;
  }

  /**
   * TODO
   * @return area
   */
  @NotNull 
  @JsonProperty("area")
  @JacksonXmlProperty(localName = "area")
  @XmlElement(name = "area")
  public Float getArea() {
    return area;
  }

  public void setArea(Float area) {
    this.area = area;
  }

  public City population(Long population) {
    this.population = population;
    return this;
  }

  /**
   * TODO
   * minimum: 1
   * @return population
   */
  @NotNull @Min(1L) 
  @JsonProperty("population")
  @JacksonXmlProperty(localName = "population")
  @XmlElement(name = "population")
  public Long getPopulation() {
    return population;
  }

  public void setPopulation(Long population) {
    this.population = population;
  }

  public City metersAboveSeaLevel(Double metersAboveSeaLevel) {
    this.metersAboveSeaLevel = metersAboveSeaLevel;
    return this;
  }

  /**
   * Get metersAboveSeaLevel
   * @return metersAboveSeaLevel
   */
  
  @JsonProperty("metersAboveSeaLevel")
  @JacksonXmlProperty(localName = "metersAboveSeaLevel")
  @XmlElement(name = "metersAboveSeaLevel")
  public Double getMetersAboveSeaLevel() {
    return metersAboveSeaLevel;
  }

  public void setMetersAboveSeaLevel(Double metersAboveSeaLevel) {
    this.metersAboveSeaLevel = metersAboveSeaLevel;
  }

  public City capital(Boolean capital) {
    this.capital = capital;
    return this;
  }

  /**
   * Get capital
   * @return capital
   */
  @NotNull 
  @JsonProperty("capital")
  @JacksonXmlProperty(localName = "capital")
  @XmlElement(name = "capital")
  public Boolean getCapital() {
    return capital;
  }

  public void setCapital(Boolean capital) {
    this.capital = capital;
  }

  public City government(Government government) {
    this.government = government;
    return this;
  }

  /**
   * Get government
   * @return government
   */
  @NotNull @Valid 
  @JsonProperty("government")
  @JacksonXmlProperty(localName = "government")
  @XmlElement(name = "government")
  public Government getGovernment() {
    return government;
  }

  public void setGovernment(Government government) {
    this.government = government;
  }

  public City governor(Human governor) {
    this.governor = governor;
    return this;
  }

  /**
   * Get governor
   * @return governor
   */
  @NotNull @Valid 
  @JsonProperty("governor")
  @JacksonXmlProperty(localName = "governor")
  @XmlElement(name = "governor")
  public Human getGovernor() {
    return governor;
  }

  public void setGovernor(Human governor) {
    this.governor = governor;
  }

  public City inhabitant(List<@Valid Human> inhabitant) {
    this.inhabitant = inhabitant;
    return this;
  }

  public City addInhabitantItem(Human inhabitantItem) {
    if (this.inhabitant == null) {
      this.inhabitant = new ArrayList<>();
    }
    this.inhabitant.add(inhabitantItem);
    return this;
  }

  /**
   * Жители города
   * @return inhabitant
   */
  @Valid 
  @JsonProperty("inhabitant")
  @JacksonXmlProperty(localName = "inhabitant")
  @JacksonXmlElementWrapper(useWrapping = false)
  @XmlElement(name = "inhabitant")
  public List<@Valid Human> getInhabitant() {
    return inhabitant;
  }

  public void setInhabitant(List<@Valid Human> inhabitant) {
    this.inhabitant = inhabitant;
  }

  public City establishmentDate(String establishmentDate) {
    this.establishmentDate = establishmentDate;
    return this;
  }

  /**
   * Get establishmentDate
   * @return establishmentDate
   */
  
  @JsonProperty("establishmentDate")
  @JacksonXmlProperty(localName = "establishmentDate")
  @XmlElement(name = "establishmentDate")
  public String getEstablishmentDate() {
    return establishmentDate;
  }

  public void setEstablishmentDate(String establishmentDate) {
    this.establishmentDate = establishmentDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    City city = (City) o;
    return Objects.equals(this.id, city.id) &&
        Objects.equals(this.name, city.name) &&
        Objects.equals(this.coordinates, city.coordinates) &&
        Objects.equals(this.creationDate, city.creationDate) &&
        Objects.equals(this.area, city.area) &&
        Objects.equals(this.population, city.population) &&
        Objects.equals(this.metersAboveSeaLevel, city.metersAboveSeaLevel) &&
        Objects.equals(this.capital, city.capital) &&
        Objects.equals(this.government, city.government) &&
        Objects.equals(this.governor, city.governor) &&
        Objects.equals(this.inhabitant, city.inhabitant) &&
        Objects.equals(this.establishmentDate, city.establishmentDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, coordinates, creationDate, area, population, metersAboveSeaLevel, capital, government, governor, inhabitant, establishmentDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class City {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    coordinates: ").append(toIndentedString(coordinates)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    area: ").append(toIndentedString(area)).append("\n");
    sb.append("    population: ").append(toIndentedString(population)).append("\n");
    sb.append("    metersAboveSeaLevel: ").append(toIndentedString(metersAboveSeaLevel)).append("\n");
    sb.append("    capital: ").append(toIndentedString(capital)).append("\n");
    sb.append("    government: ").append(toIndentedString(government)).append("\n");
    sb.append("    governor: ").append(toIndentedString(governor)).append("\n");
    sb.append("    inhabitant: ").append(toIndentedString(inhabitant)).append("\n");
    sb.append("    establishmentDate: ").append(toIndentedString(establishmentDate)).append("\n");
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

