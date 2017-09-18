package org.terry.magician.api.controller;

import org.terry.magician.api.Constants;
import org.terry.magician.api.service.VoBuilderService;
import org.terry.magician.api.support.APIResult;
import org.terry.magician.api.vo.LineDetailVO;
import org.terry.magician.api.vo.LineItemVO;
import org.terry.magician.api.vo.LineSearchItemVO;
import org.terry.magician.domain.Line;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.rpc.hystrix.HystrixLineServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Terry
 */
@RestController
public class LineEndpoint {

    @Autowired
    HystrixLineServiceClient hystrixLineServiceClient;

    @Autowired
    VoBuilderService voBuilderService;

    @RequestMapping("line/detail")
    public Object lineDetail(@RequestParam String id) {
        Line line = hystrixLineServiceClient.getById(id);
        LineDetailVO vo = voBuilderService.buildDetailVO(line);
        return APIResult.createSuccess(vo);
    }

    @RequestMapping("line/recommend/list")
    public Object lineRecommendList() {
        final List<Line> recommendList = hystrixLineServiceClient.getRecommendList();

        List<LineItemVO> lineVOList = new ArrayList<LineItemVO>();
        for (Line line : recommendList) {
            lineVOList.add(voBuilderService.buildItemVO(line));
        }

        return APIResult.createSuccess(lineVOList);
    }

    @RequestMapping("line/search")
    public Object lineSearchList(@RequestParam String city,
                                 @RequestParam(required = false, defaultValue = "") String keyword,
                                 @RequestParam(required = false, defaultValue = Constants.DEFAULT_PAGE_NO) Integer pageNo,
                                 @RequestParam(required = false, defaultValue = Constants.DEFAULT_PAGE_SIZE) Integer pageSize) {
        PageImplWrapper<Line> pageImplWrapper = hystrixLineServiceClient.search(city,
                StringUtils.isEmpty(keyword) ? "" : keyword, pageNo, pageSize);
        List<LineSearchItemVO> voList = new ArrayList<LineSearchItemVO>();

        for (Line line : pageImplWrapper.getContent()) {
            voList.add(voBuilderService.buildSearchItemVO(line));
        }

        return APIResult.createSuccess(voBuilderService.buildPage(voList, !pageImplWrapper.isLast()));
    }

}
