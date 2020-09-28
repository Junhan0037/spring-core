package com.springcore;

import com.springcore.discount.DiscountPolicy;
import com.springcore.discount.FixDiscountPolicy;
import com.springcore.member.MemberRepository;
import com.springcore.member.MemberService;
import com.springcore.member.MemberServiceImpl;
import com.springcore.member.MemoryMemberRepository;
import com.springcore.order.OrderService;
import com.springcore.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
