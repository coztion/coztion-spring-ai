package coztion.springai.core.chat.infrastructure.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "FILE")
@NoArgsConstructor
@AllArgsConstructor
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FILE_ID", nullable = false, unique = true, updatable = false)
    private Long fileId;

    @Column(name = "PATH", nullable = false, unique = true, updatable = false)
    private String path;

    @OneToOne
    @JoinColumn(name = "CHAT_ID")
    private ChatEntity chat;
}
