package live.goapi.domain.member.entity;

import live.goapi.domain.api_key.entity.ApiKey;
import live.goapi.global.role.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "student_number")
    private String studentNumber;

    @Column(name = "major")
    private String major;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(optional = true)
    private ApiKey apiKey;

    private boolean apiKeyAuthenticated = false;

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updateApiKey(ApiKey apiKey) {
        this.apiKey = apiKey;
    }

    public void updateApiKeyAuthenticated(boolean apiKeyAuthenticated) {
        this.apiKeyAuthenticated = apiKeyAuthenticated;
    }

}
