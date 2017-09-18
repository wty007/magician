package org.terry.magician.admin.ui;

import com.google.common.collect.Lists;
import org.terry.magician.common.util.JsonService;
import org.terry.magician.constant.PageConstants;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.domain.SupportService;
import org.terry.magician.rpc.hystrix.HystrixSupportServiceCategoryServiceClient;
import org.terry.magician.rpc.hystrix.HystrixSupportServiceServiceClient;
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
@RequestMapping("/hotel/service")
public class SupportServiceController {

    @Autowired
    HystrixSupportServiceServiceClient hystrixSupportServiceServiceClient;

    @Autowired
    HystrixSupportServiceCategoryServiceClient hystrixSupportServiceCategoryServiceClient;

    @Autowired
    JsonService jsonService;

    @RequestMapping("/list")
    public String list(Model model,
                       @RequestParam(value = "page", required = false, defaultValue = PageConstants.DEFAULT_PAGE_NUMBER) Integer page,
                       @RequestParam(value = "size", required = false, defaultValue = PageConstants.DEFAULT_PAGE_SIZE) Integer size,
                       @RequestParam(value = "sort", required = false) List<String> sort) {
        final PageImplWrapper<SupportService> pageList = hystrixSupportServiceServiceClient.getPage(page, size, sort);
        model.addAttribute("page", pageList);
        return "hotel/service/supportServiceList";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public SupportService save(@ModelAttribute SupportService SupportService) {
        return hystrixSupportServiceServiceClient.save(jsonService.toJson(SupportService));
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public SupportService get(@RequestParam("id") String id) {
        return hystrixSupportServiceServiceClient.getById(id);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<SupportService> getAll() {
        return hystrixSupportServiceServiceClient.getPage(0, Integer.MAX_VALUE, Lists.newArrayList("sort,asc")).getContent();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public SupportService delete(@RequestParam(value = "id") String id) {
        return hystrixSupportServiceServiceClient.deleteById(id);
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(Model model, @RequestParam(value = "id", required = false) String id) {

        SupportService supportService = null;
        if (StringUtils.isEmpty(id)) {
            supportService = new SupportService();
        } else {
            supportService = hystrixSupportServiceServiceClient.getById(id);
        }

        model.addAttribute("categories",
                hystrixSupportServiceCategoryServiceClient.getPage(0, Integer.MAX_VALUE, null).getContent());
        model.addAttribute("entity", supportService);

        return "hotel/service/supportServiceForm";
    }
}
