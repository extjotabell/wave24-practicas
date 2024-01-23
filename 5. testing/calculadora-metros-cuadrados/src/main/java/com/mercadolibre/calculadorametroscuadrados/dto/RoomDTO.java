package com.mercadolibre.calculadorametroscuadrados.dto;

public class RoomDTO {
  private String name;
  private Integer width;
  private Integer length;

  public RoomDTO(String name, Integer width, Integer length) {
    this.name = name;
    this.width = width;
    this.length = length;
  }

  public String getName() {
    return name;
  }


  public Integer getWidth() {
    return width;
  }


  public Integer getLength() {
    return length;
  }


  public Integer getSquareFeet() {
    int result = 0;
    if(this.width != null && this.length != null)
      result = this.width * this.length;
    return result;
  }

}
