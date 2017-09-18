package org.terry.magician.admin.ui;

import org.terry.magician.common.util.JsonService;
import org.terry.magician.constant.PageConstants;
import org.terry.magician.domain.Insurance;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.rpc.hystrix.HystrixInsuranceServiceClient;
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
@RequestMapping("insurance")
public class InsuranceController {

    @Autowired
    HystrixInsuranceServiceClient hystrixInsuranceServiceClient;

    @Autowired
    JsonService jsonService;

    @RequestMapping("/list")
    public String list(Model model,
                       @RequestParam(value = "page", required = false, defaultValue = PageConstants.DEFAULT_PAGE_NUMBER) Integer page,
                       @RequestParam(value = "size", required = false, defaultValue = PageConstants.DEFAULT_PAGE_SIZE) Integer size,
                       @RequestParam(value = "sort", required = false) List<String> sort) {
        final PageImplWrapper<Insurance> pageList = hystrixInsuranceServiceClient.getPage(page, size, sort);
        model.addAttribute("page", pageList);
        return "insurance/insuranceList";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Insurance save(@ModelAttribute Insurance insurance) {
        return hystrixInsuranceServiceClient.save(jsonService.toJson(insurance));
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Insurance get(@RequestParam("id") String id) {
        return hystrixInsuranceServiceClient.getById(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Insurance delete(@RequestParam(value = "id") String id) {
        return hystrixInsuranceServiceClient.deleteById(id);
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(Model model, @RequestParam(value = "id", required = false) String id) {

        Insurance insurance = null;
        if (StringUtils.isEmpty(id)) {
            insurance = new Insurance();
        } else {
            insurance = hystrixInsuranceServiceClient.getById(id);
        }

        model.addAttribute("entity", insurance);

        return "insurance/insuranceForm";
    }


}
