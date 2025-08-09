package coztion.springai.core.chat.infrastructure.model.entity;

import coztion.springai.core.chat.domain.Chat;
import coztion.springai.core.chat.infrastructure.mapper.ChatEntityMapper;
import coztion.springai.core.shared.infrastructure.converter.BooleanConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "CHAT")
@NoArgsConstructor
@AllArgsConstructor
public class ChatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHAT_ID", nullable = false, unique = true, updatable = false)
    private Long chatId;

    @Column(name = "SEQ", nullable = false, updatable = false)
    private Integer sequence;

    @Column(name = "MODEL", nullable = false, updatable = false, length = 30)
    private String model;

    @Column(name = "USER_YN", nullable = false, updatable = false, length = 1)
    @Convert(converter = BooleanConverter.class)
    private Boolean isUser;

    public Chat toDomain() {
        return ChatEntityMapper.INSTANCE.toDomain(this);
    }
}
