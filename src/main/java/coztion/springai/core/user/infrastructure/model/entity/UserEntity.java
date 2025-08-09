package coztion.springai.core.user.infrastructure.model.entity;

import coztion.springai.core.user.domain.User;
import coztion.springai.core.user.infrastructure.mapper.UserEntityMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "USER")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false, unique = true, updatable = false)
    private Long userId;

    @Column(name = "USERNAME", nullable = false, unique = true, length = 50, updatable = false)
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    public User toDomain() {
        return UserEntityMapper.INSTANCE.toDomain(this);
    }
}
