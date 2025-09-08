package com.xqcode.builder;

import lombok.AllArgsConstructor;

/** HairType enumeration. */
@AllArgsConstructor
public enum HairType {
  BALD("bald"),
  SHORT("short"),
  CURLY("curly"),
  LONG_STRAIGHT("long straight"),
  LONG_CURLY("long curly");

  private final String title;

  @Override
  public String toString() {
    return title;
  }
}
