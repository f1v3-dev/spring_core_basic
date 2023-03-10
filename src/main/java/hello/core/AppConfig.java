package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // @Bean MemberService -> new MemoryMembrRepository()
    // @Bean orderService -> new MemoryMembrRepository() 싱글톤이 깨지나?

    /***
     *      [생각했던 내용]
     *      1. call AppConfig.memberService
     *      2. call AppConfig.memberRepository
     *      3. call AppConfig.memberRepository
     *      4. call AppConfig.orderService
     *      5. call AppConfig.memberRepository
     *
     *
     *      [실제 호출된 내용]
     *      1. call AppConfig.memberService
     *      2. call AppConfig.memberRepository
     *      3. call AppConfig.orderService
     *      => memberRepository를 한 번만 호출하여 Singleton을 유지한 모습 !
     *         '@Configuration의 역할'
     */


    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy(); <- 이 부분만 RateDiscountPolicy로 변경
        return new RateDiscountPolicy();
    }

}