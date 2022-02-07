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

//    public MemberService memberService() {
//        return new MemberServiceImpl(new MemoryMemberRepository());
//    }

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    //"역할에 따른 구현이 명확해지도록 분리 및 중복 제거"(멤버 서비스는 멤버서비스만을 구현, 멤버리포지토리는 멤버리포지토리만을 구현)
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.orderService");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
//        return new OrderServiceImpl(memberRepository(), new FixDiscountPolicy());
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
