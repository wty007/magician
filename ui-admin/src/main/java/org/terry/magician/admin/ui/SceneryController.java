package org.terry.magician.admin.ui;

import org.terry.magician.common.util.JsonService;
import org.terry.magician.constant.PageConstants;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.domain.Scenery;
import org.terry.magician.rpc.hystrix.HystrixSceneryServiceClient;
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
@RequestMapping("scenery")
public class SceneryController {

    @Autowired
    HystrixSceneryServiceClient hystrixSceneryServiceClient;

    @Autowired
    JsonService jsonService;

    @RequestMapping("/list")
    public String list(Model model,
                       @RequestParam(value = "page", required = false, defaultValue = PageConstants.DEFAULT_PAGE_NUMBER) Integer page,
                       @RequestParam(value = "size", required = false, defaultValue = PageConstants.DEFAULT_PAGE_SIZE) Integer size,
                       @RequestParam(value = "sort", required = false) List<String> sort) {
        final PageImplWrapper<Scenery> pageList = hystrixSceneryServiceClient.getPage(page, size, sort);
        model.addAttribute("page", pageList);
        return "scenery/sceneryList";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Scenery save(@ModelAttribute Scenery Scenery) {
        return hystrixSceneryServiceClient.save(jsonService.toJson(Scenery));
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Scenery get(@RequestParam("id") String id) {
        return hystrixSceneryServiceClient.getById(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Scenery delete(@RequestParam(value = "id") String id) {
        return hystrixSceneryServiceClient.deleteById(id);
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(Model model, @RequestParam(value = "id", required = false) String id) {

        Scenery Scenery = null;
        if (StringUtils.isEmpty(id)) {
            Scenery = new Scenery();
        } else {
            Scenery = hystrixSceneryServiceClient.getById(id);
        }

        model.addAttribute("entity", Scenery);

        return "scenery/sceneryForm";
    }
}
