package com.yuiko.soa.model.api;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import jakarta.annotation.Generated;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Пагинатор
 */

@JacksonXmlRootElement(localName = "Pager")
@XmlRootElement(name = "Pager")
@XmlAccessorType(XmlAccessType.FIELD)
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-11-27T20:35:13.379440+03:00[Europe/Moscow]", comments = "Generator version: 7.8.0")
public class Pager {

  private Long totalPages;

  private Integer pageNum;

  public Pager totalPages(Long totalPages) {
    this.totalPages = totalPages;
    return this;
  }

  /**
   * Сколько всего страниц
   * @return totalPages
   */
  
  @JsonProperty("totalPages")
  @JacksonXmlProperty(localName = "totalPages")
  @XmlElement(name = "totalPages")
  public Long getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Long totalPages) {
    this.totalPages = totalPages;
  }

  public Pager pageNum(Integer pageNum) {
    this.pageNum = pageNum;
    return this;
  }

  /**
   * Номер текущей страницы
   * @return pageNum
   */
  
  @JsonProperty("pageNum")
  @JacksonXmlProperty(localName = "pageNum")
  @XmlElement(name = "pageNum")
  public Integer getPageNum() {
    return pageNum;
  }

  public void setPageNum(Integer pageNum) {
    this.pageNum = pageNum;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pager pager = (Pager) o;
    return Objects.equals(this.totalPages, pager.totalPages) &&
        Objects.equals(this.pageNum, pager.pageNum);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalPages, pageNum);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pager {\n");
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
    sb.append("    pageNum: ").append(toIndentedString(pageNum)).append("\n");
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

