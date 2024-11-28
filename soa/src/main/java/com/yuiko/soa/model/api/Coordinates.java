package com.yuiko.soa.model.api;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Координаты
 */

@JacksonXmlRootElement(localName = "Coordinates")
@XmlRootElement(name = "Coordinates")
@XmlAccessorType(XmlAccessType.FIELD)
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-27T20:35:13.379440+03:00[Europe/Moscow]", comments = "Generator version: 7.8.0")
public class Coordinates {

  private Float x = null;

  private Integer y;

  public Coordinates() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Coordinates(Integer y) {
    this.y = y;
  }

  public Coordinates x(Float x) {
    this.x = x;
    return this;
  }

  /**
   * Х координата
   * @return x
   */
  
  @JsonProperty("x")
  @JacksonXmlProperty(localName = "x")
  @XmlElement(name = "x")
  public Float getX() {
    return x;
  }

  public void setX(Float x) {
    this.x = x;
  }

  public Coordinates y(Integer y) {
    this.y = y;
    return this;
  }

  /**
   * Y координата
   * @return y
   */
  @NotNull 
  @JsonProperty("y")
  @JacksonXmlProperty(localName = "y")
  @XmlElement(name = "y")
  public Integer getY() {
    return y;
  }

  public void setY(Integer y) {
    this.y = y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Coordinates coordinates = (Coordinates) o;
    return Objects.equals(this.x, coordinates.x) &&
        Objects.equals(this.y, coordinates.y);
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Coordinates {\n");
    sb.append("    x: ").append(toIndentedString(x)).append("\n");
    sb.append("    y: ").append(toIndentedString(y)).append("\n");
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

