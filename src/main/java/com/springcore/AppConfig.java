package com.springcore;

import com.springcore.discount.DiscountPolicy;
import com.springcore.discount.FixDiscountPolicy;
import com.springcore.discount.RateDiscountPolicy;
import com.springcore.member.MemberRepository;
import com.springcore.member.MemberService;
import com.springcore.member.MemberServiceImpl;
import com.springcore.member.MemoryMemberRepository;
import com.springcore.order.OrderService;
import com.springcore.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
