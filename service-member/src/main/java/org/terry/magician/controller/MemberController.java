package org.terry.magician.controller;

import org.terry.magician.common.controller.BaseCRUDController;
import org.terry.magician.common.service.MemberServiceDefinition;
import org.terry.magician.constant.PageConstants;
import org.terry.magician.domain.Member;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.repository.MemberRepository;
import org.terry.magician.service.MemberService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Terry
 */
@RefreshScope
@Api
@RestController
public class MemberController extends BaseCRUDController<Member, String> implements MemberServiceDefinition {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Override
    protected JpaRepository<Member, String> getRepository() {
        return memberRepository;
    }

    @Override
    public PageImplWrapper<Member> getPage(
            @RequestParam(value = "page", required = false, defaultValue = PageConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(value = "size", required = false, defaultValue = PageConstants.DEFAULT_PAGE_SIZE) Integer size,
            @RequestParam(value = "sort", required = false, defaultValue = "") List<String> sort) {
        return baseGetPage(page, size, sort);
    }

    @Override
    public Member createGuest() {
        return memberService.createGuest();
    }

    @Override
    public List<Member> getList() {
        return baseGetList();
    }

    @Override
    public Member save(@RequestParam("dtoJson") String dtoJson) {
        return baseSave(dtoJson);
    }

    @Override
    public Member deleteById(@RequestParam("id") String id) {
        return memberService.getById(id);
    }

    @Override
    public Member getByMobilePhone(@RequestParam("mobilePhone") String mobilePhone) {
        return memberService.getByMobilePhone(mobilePhone);
    }

    @Override
    public Member getById(@RequestParam("id") String id) {
        return baseGetById(id);
    }

    @Override
    public Member usernameAndPwdLogin(@RequestParam String username, @RequestParam String password) {
        System.out.print("我找到这里了！");
        Member member = memberService.loginByLoginNameAndPassword(username, password);
        System.out.print(member + "-----------");
        return member;
    }

    @Override
    public Boolean logout(@RequestParam("token") String token) {
        return memberService.logout(token);
    }

    @Override
    public Member phoneAndPwdLogin(@RequestParam("mobilePhone") String mobilePhone, @RequestParam("password") String password) {
        return memberService.loginByMobilePhoneAndPassword(mobilePhone, password);
    }

    @Override
    public String login(@RequestParam String mobilePhone) {
        return memberService.phoneLogin(mobilePhone);
    }

    @Override
    public Member resetPassword(@RequestParam String mobilePhone, @RequestParam String newPassword) {
        return memberService.resetPassword(mobilePhone, newPassword);
    }

    @Override
    public Member getByToken(@RequestParam String token) {
        return memberService.memberInfo(token);
    }
}
