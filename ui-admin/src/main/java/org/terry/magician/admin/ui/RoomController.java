package org.terry.magician.admin.ui;

import org.terry.magician.admin.support.CRUDException;
import org.terry.magician.common.util.JsonService;
import org.terry.magician.constant.PageConstants;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.domain.Room;
import org.terry.magician.rpc.hystrix.HystrixHotelServiceClient;
import org.terry.magician.rpc.hystrix.HystrixRoomServiceClient;
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
@RequestMapping("hotel/room")
public class RoomController {

    @Autowired
    HystrixRoomServiceClient hystrixRoomServiceClient;

    @Autowired
    HystrixHotelServiceClient hystrixHotelServiceClient;

    @Autowired
    JsonService jsonService;

    @RequestMapping("/list")
    public String list(Model model,
                       @RequestParam(value = "page", required = false, defaultValue = PageConstants.DEFAULT_PAGE_NUMBER) Integer page,
                       @RequestParam(value = "size", required = false, defaultValue = PageConstants.DEFAULT_PAGE_SIZE) Integer size,
                       @RequestParam(value = "sort", required = false) List<String> sort) {
        final PageImplWrapper<Room> pageList = hystrixRoomServiceClient.getPage(page, size, sort);
        model.addAttribute("page", pageList);
        return "hotel/roomList";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Room save(@ModelAttribute Room room) {
        Room savedRoom = hystrixRoomServiceClient.save(jsonService.toJson(room));
        if (savedRoom == null) {
            throw new CRUDException("保存失败");
        }
        return savedRoom;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Room get(@RequestParam("id") String id) {
        return hystrixRoomServiceClient.getById(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Boolean delete(@RequestParam(value = "id") String id) {
        return hystrixRoomServiceClient.deleteById(id);
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(Model model, @RequestParam(value = "id", required = false) String id) {

        Room room = null;
        if (StringUtils.isEmpty(id)) {
            room = new Room();
        } else {
            room = hystrixRoomServiceClient.getById(id);
        }

        model.addAttribute("entity", room);
        model.addAttribute("hotelList", hystrixHotelServiceClient.getList());

        return "hotel/roomForm";
    }


}
