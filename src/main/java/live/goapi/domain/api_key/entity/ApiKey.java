package live.goapi.domain.api_key.entity;

import live.goapi.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Table(name = "api_key")
@Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "api_key_id")
    private Long apiKeyId;

    @Column(name = "random_key")
    private String randomKey;

    @OneToOne(optional = true)
    private Member member;
}
