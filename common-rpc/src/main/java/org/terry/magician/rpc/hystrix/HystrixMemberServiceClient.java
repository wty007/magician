package org.terry.magician.rpc.hystrix;

import com.google.common.collect.Lists;
import org.terry.magician.domain.Member;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.rpc.MemberServiceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Terry
 */
@Service
public class HystrixMemberServiceClient implements MemberServiceClient {

    @Autowired
    private MemberServiceClient memberServiceClient;

    @Override
    @HystrixCommand(fallbackMethod = "getByMobilePhoneFallBackCall")
    public Member getByMobilePhone(String mobilePhone) {
        return memberServiceClient.getByMobilePhone(mobilePhone);
    }

    public Member getByMobilePhoneFallBackCall(String mobilePhone) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "createGuestFallBackCall")
    public Member createGuest() {
        return memberServiceClient.createGuest();
    }

    public Member createGuestFallBackCall() {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "phoneAndPwdLoginFallBackCall")
    public Member phoneAndPwdLogin(String mobilePhone, String password) {
        return memberServiceClient.phoneAndPwdLogin(mobilePhone, password);
    }

    @Override
    @HystrixCommand(fallbackMethod = "logoutFallBackCall")
    public Boolean logout(String token) {
        return memberServiceClient.logout(token);
    }

    public Boolean logoutFallBackCall(String token) {
        return Boolean.FALSE;
    }

    public Member phoneAndPwdLoginFallBackCall(String mobilePhone, String password) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "loginFallBackCall")
    public String login(String mobilePhone) {
        return memberServiceClient.login(mobilePhone);
    }

    @Override
    @HystrixCommand(fallbackMethod = "resetPasswordFallBackCall")
    public Member resetPassword(String mobilePhone, String newPassword) {
        return memberServiceClient.resetPassword(mobilePhone, newPassword);
    }

    @Override
    @HystrixCommand(fallbackMethod = "memberInfoFallBackCall")
    public Member getByToken(String token) {
        return memberServiceClient.getByToken(token);
    }

    public String loginFallBackCall(String mobilePhone) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "deleteFallBackCall")
    public Member deleteById(String id) {
        return memberServiceClient.deleteById(id);
    }

    @Override
    @HystrixCommand(fallbackMethod = "saveFallBackCall")
    public Member save(String dtoJson) {
        return memberServiceClient.save(dtoJson);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getByIdFallBackCall")
    public Member getById(String id) {
        return memberServiceClient.getById(id);
    }

    @Override
    @HystrixCommand(fallbackMethod = "usernameAndPwdLoginFallBackCall")
    public Member usernameAndPwdLogin(String username, String password) {
        return memberServiceClient.usernameAndPwdLogin(username, password);
    }

    public Member usernameAndPwdLoginFallBackCall(String username, String password) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "getPageFallBackCall")
    public PageImplWrapper<Member> getPage(Integer page, Integer size, List<String> sort) {
        return memberServiceClient.getPage(page, size, sort);
    }

    @Override
    @HystrixCommand(fallbackMethod = "getListFallBackCall")
    public List<Member> getList() {
        return memberServiceClient.getList();
    }

    public Member deleteFallBackCall(String id) {
        return null;
    }

    public Member getByIdFallBackCall(String id) {
        return null;
    }

    public Member saveFallBackCall(String name) {
        return null;
    }

    public PageImplWrapper<Member> getPageFallBackCall(Integer page, Integer size, List<String> sort) {
        return null;
    }

    public Member loginFallBackCall(String username, String password) {
        return null;
    }

    public List<Member> getListFallBackCall() {
        return Lists.newArrayList();
    }

    public Member resetPasswordFallBackCall(String mobilePhone, String pwd) {
        return null;
    }

    public Member memberInfoFallBackCall(String token) {
        return null;
    }


}

