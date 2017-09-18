package org.terry.magician.admin.ui;

import org.terry.magician.common.util.JsonService;
import org.terry.magician.constant.PageConstants;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.domain.Ticket;
import org.terry.magician.rpc.hystrix.HystrixSceneryServiceClient;
import org.terry.magician.rpc.hystrix.HystrixTicketServiceClient;
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
@RequestMapping("scenery/ticket")
public class TicketController {

    @Autowired
    HystrixTicketServiceClient hystrixTicketServiceClient;

    @Autowired
    HystrixSceneryServiceClient hystrixSceneryServiceClient;

    @Autowired
    JsonService jsonService;

    @RequestMapping("/list")
    public String list(Model model,
                       @RequestParam(value = "page", required = false, defaultValue = PageConstants.DEFAULT_PAGE_NUMBER) Integer page,
                       @RequestParam(value = "size", required = false, defaultValue = PageConstants.DEFAULT_PAGE_SIZE) Integer size,
                       @RequestParam(value = "sort", required = false) List<String> sort) {
        final PageImplWrapper<Ticket> pageList = hystrixTicketServiceClient.getPage(page, size, sort);
        model.addAttribute("page", pageList);
        return "scenery/ticketList";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Ticket save(@ModelAttribute Ticket Ticket) {
        return hystrixTicketServiceClient.save(jsonService.toJson(Ticket));
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Ticket get(@RequestParam("id") String id) {
        return hystrixTicketServiceClient.getById(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Boolean delete(@RequestParam(value = "id") String id) {
        return hystrixTicketServiceClient.deleteById(id);
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(Model model, @RequestParam(value = "id", required = false) String id) {

        Ticket ticket = null;
        if (StringUtils.isEmpty(id)) {
            ticket = new Ticket();
        } else {
            ticket = hystrixTicketServiceClient.getById(id);
        }

        model.addAttribute("sceneryList", hystrixSceneryServiceClient.getList());
        model.addAttribute("entity", ticket);

        return "scenery/ticketForm";
    }
}
