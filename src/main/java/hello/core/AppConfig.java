package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

//    public MemberService memberService() {
//        return new MemberServiceImpl(new MemoryMemberRepository());
//    }

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    //"역할에 따른 구현이 명확해지도록 분리 및 중복 제거"(멤버 서비스는 멤버서비스만을 구현, 멤버리포지토리는 멤버리포지토리만을 구현)
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
//        return new OrderServiceImpl(memberRepository(), new FixDiscountPolicy());
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
