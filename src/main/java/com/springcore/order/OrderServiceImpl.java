package com.springcore.order;

import com.springcore.discount.DiscountPolicy;
import com.springcore.discount.FixDiscountPolicy;
import com.springcore.member.Member;
import com.springcore.member.MemberRepository;
import com.springcore.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}
