package com.yuiko.soa.model.api;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Человек
 */

@JacksonXmlRootElement(localName = "Human")
@XmlRootElement(name = "Human")
@XmlAccessorType(XmlAccessType.FIELD)
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-27T20:35:13.379440+03:00[Europe/Moscow]", comments = "Generator version: 7.8.0")
public class Human {

  private Float height = null;

  private OffsetDateTime birthday = null;

  public Human height(Float height) {
    this.height = height;
    return this;
  }

  /**
   * Рост
   * @return height
   */
  
  @JsonProperty("height")
  @JacksonXmlProperty(localName = "height")
  @XmlElement(name = "height")
  public Float getHeight() {
    return height;
  }

  public void setHeight(Float height) {
    this.height = height;
  }

  public Human birthday(OffsetDateTime birthday) {
    this.birthday = birthday;
    return this;
  }

  /**
   * День рождение
   * @return birthday
   */
  @Valid 
  @JsonProperty("birthday")
  @JacksonXmlProperty(localName = "birthday")
  @XmlElement(name = "birthday")
  public OffsetDateTime getBirthday() {
    return birthday;
  }

  public void setBirthday(OffsetDateTime birthday) {
    this.birthday = birthday;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Human human = (Human) o;
    return Objects.equals(this.height, human.height) &&
        Objects.equals(this.birthday, human.birthday);
  }

  @Override
  public int hashCode() {
    return Objects.hash(height, birthday);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Human {\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    birthday: ").append(toIndentedString(birthday)).append("\n");
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

