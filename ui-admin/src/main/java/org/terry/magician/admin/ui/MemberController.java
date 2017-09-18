package org.terry.magician.admin.ui;

import org.terry.magician.common.util.JsonService;
import org.terry.magician.common.util.MD5Util;
import org.terry.magician.constant.PageConstants;
import org.terry.magician.domain.Member;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.rpc.hystrix.HystrixMemberServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Terry
 */
@Controller
@RequestMapping("member")
public class MemberController {

    @Autowired
    HystrixMemberServiceClient hystrixMemberServiceClient;

    @Autowired
    JsonService jsonService;

    @RequestMapping("/list")
    public String list(Model model,
                       @RequestParam(value = "page", required = false, defaultValue = PageConstants.DEFAULT_PAGE_NUMBER) Integer page,
                       @RequestParam(value = "size", required = false, defaultValue = PageConstants.DEFAULT_PAGE_SIZE) Integer size,
                       @RequestParam(value = "sort", required = false) List<String> sort) {
        final PageImplWrapper<Member> pageList = hystrixMemberServiceClient.getPage(page, size, sort);
        model.addAttribute("page", pageList);
        return "member/memberList";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Member save(@ModelAttribute Member member) {
        if (!StringUtils.isEmpty(member.getPassword())) {
            member.setPassword(MD5Util.md5(member.getPassword()));
        }
        return hystrixMemberServiceClient.save(jsonService.toJson(member));
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Member get(@RequestParam("id") String id) {
        return hystrixMemberServiceClient.getById(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Member delete(@RequestParam(value = "id") String id) {
        return hystrixMemberServiceClient.deleteById(id);
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(Model model, @RequestParam(value = "id", required = false) String id) {

        Member member = null;
        if (StringUtils.isEmpty(id)) {
            member = new Member();
        } else {
            member = hystrixMemberServiceClient.getById(id);
        }

        model.addAttribute("entity", member);

        return "member/memberForm";
    }
}
