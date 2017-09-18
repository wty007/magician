package org.terry.magician.service;

import org.terry.magician.common.util.IdService;
import org.terry.magician.domain.Member;
import org.terry.magician.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/7/24.
 */
@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    IdService idService;

    @Override
    public Member getByMobilePhone(String mobilePhone) {
        return memberRepository.findByMobilePhone(mobilePhone);
    }

    @Override
    public Member getById(String id) {
        return memberRepository.findOne(id);
    }

    @Override
    public Member createGuest() {
        Member member = new Member();

        member.setId(idService.newOne());
        member.setToken(newToken());
        member.setRegisterTime(new Date());

        memberRepository.save(member);

        return member;
    }

    @Override
    public Member loginByMobilePhoneAndPassword(String mobilePhone, String password) {
        List<Member> memberList = memberRepository.findByMobilePhoneAndPassword(mobilePhone, password);

        if (CollectionUtils.isEmpty(memberList)) {
            return null;
        }

        Member member = memberList.get(0);

        String token = newToken();

        member.setToken(token);

        memberRepository.save(member);

        return member;
    }

    @Override
    public Boolean logout(String token) {

        Member member = memberRepository.findByToken(token);

        if (member == null) {
            return Boolean.FALSE;
        }
        member.setToken(null);
        memberRepository.save(member);
        return Boolean.TRUE;
    }

    @Override
    public Member loginByLoginNameAndPassword(String username, String password) {

        List<Member> memberList = memberRepository.findByLoginNameAndPassword(username, password);

        if (CollectionUtils.isEmpty(memberList)) {
            return null;
        }

        final Member member = memberList.get(0);

        String token = newToken();

        member.setToken(token);

        memberRepository.save(member);

        return member;
    }

    @Override
    public String phoneLogin(String mobilePhone) {

        Member member = memberRepository.findByMobilePhone(mobilePhone);

        String token = newToken();

        member.setToken(token);

        memberRepository.save(member);

        return token;
    }

    @Override
    public Member resetPassword(String mobilePhone, String pwd) {
        Member member = memberRepository.findByMobilePhone(mobilePhone);
        member.setPassword(pwd);
        member = memberRepository.save(member);
        return member;
    }

    @Override
    public Member memberInfo(String token) {
        return memberRepository.findByToken(token);
    }

    private String newToken() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
