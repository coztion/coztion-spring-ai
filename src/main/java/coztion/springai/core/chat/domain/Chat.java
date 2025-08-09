package coztion.springai.core.chat.domain;

import lombok.Data;

@Data
public class Chat {

    private Long chatId;

    private Integer sequence;

    private String model;

    private Boolean isUser;
}
