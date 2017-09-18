package org.terry.magician.common.service;

import org.terry.magician.constant.PageConstants;
import org.terry.magician.domain.Member;
import org.terry.magician.domain.PageImplWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Administrator on 2017/7/24.
 */
public interface MemberServiceDefinition {
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    PageImplWrapper<Member> getPage(
            @RequestParam(value = "page", required = false, defaultValue = PageConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(value = "size", required = false, defaultValue = PageConstants.DEFAULT_PAGE_SIZE) Integer size,
            @RequestParam(value = "sort", required = false, defaultValue = "") List<String> sort);

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    List<Member> getList();

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    Member save(@RequestParam("dtoJson") String dtoJson);

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    Member deleteById(@RequestParam("id") String id);

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    Member getById(@RequestParam("id") String id);

    @RequestMapping(value = "/usernameAndPwdLogin", method = RequestMethod.GET)
    Member usernameAndPwdLogin(@RequestParam("username") String username, @RequestParam("password") String password);

    @RequestMapping(value = "/phoneAndPwdLogin", method = RequestMethod.GET)
    Member phoneAndPwdLogin(@RequestParam("mobilePhone") String mobilePhone, @RequestParam("password") String password);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    String login(@RequestParam("mobilePhone") String mobilePhone);

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    Boolean logout(@RequestParam("token") String token);

    @RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
    Member resetPassword(@RequestParam("mobilePhone") String mobilePhone, @RequestParam("newPassword") String newPassword);

    @RequestMapping(value = "/getByToken", method = RequestMethod.GET)
    Member getByToken(@RequestParam("token") String token);

    @RequestMapping(value = "/createGuest", method = RequestMethod.GET)
    Member createGuest();

    @RequestMapping(value = "/getByMobilePhone", method = RequestMethod.GET)
    Member getByMobilePhone(@RequestParam("mobilePhone") String mobilePhone);

}
