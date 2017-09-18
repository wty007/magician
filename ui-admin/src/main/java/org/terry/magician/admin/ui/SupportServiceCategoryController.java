package org.terry.magician.admin.ui;

import com.google.common.collect.Lists;
import org.terry.magician.common.util.JsonService;
import org.terry.magician.constant.PageConstants;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.domain.SupportServiceCategory;
import org.terry.magician.rpc.hystrix.HystrixSupportServiceCategoryServiceClient;
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
@RequestMapping("/hotel/service/category")
public class SupportServiceCategoryController {

    @Autowired
    HystrixSupportServiceCategoryServiceClient hystrixSupportServiceCategoryServiceClient;

    @Autowired
    JsonService jsonService;

    @RequestMapping("/list")
    public String list(Model model,
                       @RequestParam(value = "page", required = false, defaultValue = PageConstants.DEFAULT_PAGE_NUMBER) Integer page,
                       @RequestParam(value = "size", required = false, defaultValue = PageConstants.DEFAULT_PAGE_SIZE) Integer size,
                       @RequestParam(value = "sort", required = false) List<String> sort) {
        final PageImplWrapper<SupportServiceCategory> pageList = hystrixSupportServiceCategoryServiceClient.getPage(page, size, sort);
        model.addAttribute("page", pageList);
        return "hotel/service/category/supportServiceCategoryList";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public SupportServiceCategory save(@ModelAttribute SupportServiceCategory supportServiceCategory) {
        return hystrixSupportServiceCategoryServiceClient.save(jsonService.toJson(supportServiceCategory));
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public SupportServiceCategory get(@RequestParam("id") String id) {
        return hystrixSupportServiceCategoryServiceClient.getById(id);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<SupportServiceCategory> get() {
        return hystrixSupportServiceCategoryServiceClient.getPage(0, Integer.MAX_VALUE, Lists.newArrayList("sort,asc")).getContent();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public SupportServiceCategory delete(@RequestParam(value = "id") String id) {
        return hystrixSupportServiceCategoryServiceClient.deleteById(id);
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(Model model, @RequestParam(value = "id", required = false) String id) {

        SupportServiceCategory supportServiceCategory = null;
        if (StringUtils.isEmpty(id)) {
            supportServiceCategory = new SupportServiceCategory();
        } else {
            supportServiceCategory = hystrixSupportServiceCategoryServiceClient.getById(id);
        }

        model.addAttribute("entity", supportServiceCategory);

        return "hotel/service/category/supportServiceCategoryForm";
    }
}
