package tech.developerdhairya.securityclient.Entity;

import lombok.Data;

import javax.persistence.*;

@Data @Entity
public class ForgetPasswordTokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String token;

    @OneToOne
    @JoinColumn(name = "user_entity_id",nullable = false,foreignKey = @ForeignKey(name = "FK_PASSWORD_RESET_TOKEN"))
    private UserEntity userEntity;

}
