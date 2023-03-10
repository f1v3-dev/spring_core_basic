package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    // 필드 주입 -> @Autowired 붙여주기
    // DI 프레임워크가 없으면 아무것도 할 수 없음 -> 사용하지말자.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // [setter] 수정자 주입 (선택, 변경 가능성이 있는 의존관계에서 사용)
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

//     생성자 주입 (불변, 필수 의존관계에서 사용)
//     생성자가 1개인 경우 @Autowired 생략 가능
//     new OrderServiceImpl(memberRepository, discountPolicy);
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
