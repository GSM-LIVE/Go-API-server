package live.goapi.domain.member.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberChangePasswordRequest {
    @NotBlank(message = "비밀번호는 null 이나 공백을 허용하지 않습니다.")
    private String password;
}
