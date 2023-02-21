package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){
        // given : ~이런 것을 주었을 때
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when : ~할 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then : 된다 (검증 단계)
        Assertions.assertThat(member).isEqualTo(findMember);


        /**
         *      오류를 눈으로 직접 보는 것이 아님
         *      (MemberApp.java처럼)
         */

    }
}
