package org.terry.magician.admin.ui;

import org.terry.magician.common.util.JsonService;
import org.terry.magician.constant.PageConstants;
import org.terry.magician.domain.Dict;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.rpc.hystrix.HystrixDictServiceClient;
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
@RequestMapping("dict")
public class DictController {

    @Autowired
    HystrixDictServiceClient hystrixDictServiceClient;

    @Autowired
    JsonService jsonService;

    @RequestMapping("/list")
    public String list(Model model,
                       @RequestParam(value = "page", required = false, defaultValue = PageConstants.DEFAULT_PAGE_NUMBER) Integer page,
                       @RequestParam(value = "size", required = false, defaultValue = PageConstants.DEFAULT_PAGE_SIZE) Integer size,
                       @RequestParam(value = "sort", required = false) List<String> sort) {
        final PageImplWrapper<Dict> pageList = hystrixDictServiceClient.getPage(page, size, sort);
        model.addAttribute("page", pageList);
        return "dict/dictList";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Dict save(@ModelAttribute Dict dict) {
        return hystrixDictServiceClient.save(jsonService.toJson(dict));
    }

    @RequestMapping(value = "/findByType", method = RequestMethod.GET)
    @ResponseBody
    public List<Dict> findByType(@RequestParam("type") String type) {
        return hystrixDictServiceClient.findByType(type);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Dict get(@RequestParam("id") String id) {
        return hystrixDictServiceClient.getById(id);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Dict delete(@RequestParam(value = "id") String id) {
        return hystrixDictServiceClient.deleteById(id);
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(Model model, @RequestParam(value = "id", required = false) String id) {

        Dict Dict = null;
        if (StringUtils.isEmpty(id)) {
            Dict = new Dict();
        } else {
            Dict = hystrixDictServiceClient.getById(id);
        }

        model.addAttribute("entity", Dict);

        return "dict/dictForm";
    }
}
