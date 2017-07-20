package com.wikia.webdriver.elements.mercury.components.discussions.common;

import lombok.Builder;

public final class ReplyEntity {

  private ReplyEntity() {
    // no-op
  }

  @Builder
  @lombok.Data
  public static class Data {
    private final String id;
    private final String body;
    private final String authorId;
    private final String threadId;
  }
}
