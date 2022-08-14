package com.jameswaweru.jwt.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @Column(columnDefinition = "TEXT", length = 30)
    String userName;
    @Column(columnDefinition = "TEXT")
    String password;
    @CreationTimestamp @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private ZonedDateTime createdAt;
    @UpdateTimestamp @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private ZonedDateTime updatedAt;
}
