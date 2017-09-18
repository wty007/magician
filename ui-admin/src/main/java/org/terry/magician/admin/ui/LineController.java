package org.terry.magician.admin.ui;

import org.terry.magician.common.util.JsonService;
import org.terry.magician.constant.PageConstants;
import org.terry.magician.domain.Line;
import org.terry.magician.domain.LineOrderProcessTypeEnum;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.rpc.hystrix.HystrixDictManyToManyServiceClient;
import org.terry.magician.rpc.hystrix.HystrixLineServiceClient;
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
@RequestMapping("line")
public class LineController {

    @Autowired
    HystrixLineServiceClient hystrixLineServiceClient;

    @Autowired
    HystrixDictManyToManyServiceClient hystrixDictManyToManyServiceClient;

    @Autowired
    JsonService jsonService;

    @RequestMapping("/list")
    public String list(
            @RequestParam(value = "page", required = false, defaultValue = PageConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(value = "size", required = false, defaultValue = PageConstants.DEFAULT_PAGE_SIZE) Integer size,
            @RequestParam(value = "sort", required = false) List<String> sort, Model model) {
        final PageImplWrapper<Line> pageList = hystrixLineServiceClient.getPage(page, size, sort);
        model.addAttribute("page", pageList);
        return "line/lineList";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Line save(@ModelAttribute Line Line) {
        return hystrixLineServiceClient.save(jsonService.toJson(Line));
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Line get(@RequestParam("id") String id) {
        return hystrixLineServiceClient.getById(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Boolean delete(@RequestParam(value = "id") String id) {
        return hystrixLineServiceClient.deleteById(id);
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(Model model, @RequestParam(value = "id", required = false) String id) {

        Line line = null;
        if (StringUtils.isEmpty(id)) {
            line = new Line();
        } else {
            line = hystrixLineServiceClient.getById(id);
        }

        model.addAttribute("entity", line);
        model.addAttribute("orderProcessTypes", LineOrderProcessTypeEnum.values());

        return "line/lineForm";
    }
}
