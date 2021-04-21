package hacker;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Data
@Entity
public class SecurityPost {

    @NotNull(message = "Name is required")
    @Size(min = 3, message = "Name must be at least 3 characters long")
    private String fullName;
    private LocalDateTime createdAt;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Description must be at least 5 characters.")
    @Size(min = 5, max = 255, message = "Description must be at least 5 characters and at most 255 characters.")
    private String description;

    @NotNull(message = "You must choose one type of post.")
    private String posttype;

    @ManyToOne
    private User user;

    @PrePersist
    void createdAt() {
        this.createdAt = LocalDateTime.now();
    }

    @NotNull(message = "You must include a title.")
    private String title;

    private String jobRole;
}
