package org.terry.magician.admin.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Terry
 */
@Controller
public class IndexController {

    @RequestMapping({"/", "index"})
    public String list(Model model) {
        return "redirect:/hotel/list";
    }

    @RequestMapping({"config"})
    public String config(Model model) {
        return "config";
    }

}
