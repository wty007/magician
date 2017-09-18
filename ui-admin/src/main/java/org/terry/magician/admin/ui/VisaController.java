package org.terry.magician.admin.ui;

import org.terry.magician.common.util.JsonService;
import org.terry.magician.constant.PageConstants;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.domain.Visa;
import org.terry.magician.rpc.hystrix.HystrixVisaServiceClient;
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
@RequestMapping("visa")
public class VisaController {

    @Autowired
    HystrixVisaServiceClient hystrixVisaServiceClient;

    @Autowired
    JsonService jsonService;

    @RequestMapping("/list")
    public String list(Model model,
                       @RequestParam(value = "page", required = false, defaultValue = PageConstants.DEFAULT_PAGE_NUMBER) Integer page,
                       @RequestParam(value = "size", required = false, defaultValue = PageConstants.DEFAULT_PAGE_SIZE) Integer size,
                       @RequestParam(value = "sort", required = false) List<String> sort) {
        final PageImplWrapper<Visa> pageList = hystrixVisaServiceClient.getPage(page, size, sort);
        model.addAttribute("page", pageList);
        return "visa/visaList";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Visa save(@ModelAttribute Visa visa) {
        return hystrixVisaServiceClient.save(jsonService.toJson(visa));
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Visa get(@RequestParam("id") String id) {
        return hystrixVisaServiceClient.getById(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Visa delete(@RequestParam(value = "id") String id) {
        return hystrixVisaServiceClient.deleteById(id);
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(Model model, @RequestParam(value = "id", required = false) String id) {

        Visa visa = null;
        if (StringUtils.isEmpty(id)) {
            visa = new Visa();
        } else {
            visa = hystrixVisaServiceClient.getById(id);
        }

        model.addAttribute("entity", visa);

        return "visa/visaForm";
    }


}
