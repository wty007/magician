package org.terry.magician.api.service.impl;

import com.google.common.collect.Lists;
import org.terry.magician.api.service.OrderService;
import org.terry.magician.api.service.VoBuilderService;
import org.terry.magician.api.vo.*;
import org.terry.magician.common.util.DateUtils;
import org.terry.magician.domain.*;
import org.terry.magician.rpc.hystrix.*;
import org.terry.magician.util.MemberUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Terry
 */
@Component
public class VoBuilderServiceImpl implements VoBuilderService {

    private static final String IMG = "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1734543960,1074006431&amp;fm=173&amp;s=68C283439AA6D76C1CD9E50F0000E0C3&amp;w=640&amp;h=603&amp;img.JPEG";
    private static final String LINE_PIC_URL = IMG;
    private static final String HOTEL_PIC_URL = IMG; //todo
    private static final String SCENERY_PIC_URL = IMG; //// TODO: 2017-07-27

    @Autowired
    HystrixMemberServiceClient hystrixMemberServiceClient;
    @Autowired
    OrderService orderService;
    @Autowired
    HystrixLineOrderServiceClient hystrixLineOrderServiceClient;
    @Autowired
    HystrixTicketOrderServiceClient hystrixTicketOrderServiceClient;
    @Autowired
    private HystrixDictServiceClient hystrixDictServiceClient;
    @Autowired
    private HystrixLineServiceClient hystrixLineServiceClient;
    @Autowired
    private HystrixTicketServiceClient hystrixTicketServiceClient;
    @Autowired
    private HystrixSceneryServiceClient hystrixSceneryServiceClient;
    @Autowired
    private HystrixRoomServiceClient hystrixRoomServiceClient;
    @Autowired
    private HystrixRoomOrderServiceClient hystrixRoomOrderServiceClient;
    @Autowired
    private HystrixHotelServiceClient hystrixHotelServiceClient;

    public BaseOrderDetailVO buildBaseOrderDetail(BaseOrder baseOrder) {
        BaseOrderDetailVO vo = new BaseOrderDetailVO();

        vo.setId(baseOrder.getId());
        vo.setBookingPersonMobilePhone(baseOrder.getBookingPersonMobilePhone());
        vo.setBookingPersonRealName(baseOrder.getBookingPersonRealName());
        vo.setCancelReason(baseOrder.getCancelReason());
        vo.setSn(baseOrder.getSn());
        vo.setCreateTime(baseOrder.getCreateTime());
        vo.setMemberId(baseOrder.getMemberId());
        vo.setPrice(baseOrder.getPrice());
        vo.setStatus(baseOrder.getStatus());

        return vo;
    }

    @Override
    public LineOrderDetailVO buildOrderDetail(LineOrder lineOrder) {

        LineOrderDetailVO vo = new LineOrderDetailVO();
        BaseOrderDetailVO baseOrder = buildBaseOrderDetail(lineOrder);
        BeanUtils.copyProperties(baseOrder, vo);

        Line line = hystrixLineServiceClient.getById(lineOrder.getLineId());
        vo.setLineName(line.getName());

        vo.setStartDate(lineOrder.getStartDate());
        vo.setAdultCount(lineOrder.getAdultCount());
        vo.setChildCount(lineOrder.getChildCount());

        return vo;
    }

    @Override
    public RoomOrderDetailVO buildOrderDetail(RoomOrder roomOrder) {
        RoomOrderDetailVO vo = new RoomOrderDetailVO();
        BaseOrderDetailVO baseOrder = buildBaseOrderDetail(roomOrder);
        BeanUtils.copyProperties(baseOrder, vo);

        Hotel hotel = hystrixHotelServiceClient.getById(roomOrder.getHotelId());
        Room room = hystrixRoomServiceClient.getById(roomOrder.getRoomId());

        vo.setHotelId(roomOrder.getHotelId());
        vo.setHotelName(hotel.getName());
        vo.setRoomId(roomOrder.getRoomId());
        vo.setRoomName(room.getName());
        vo.setCount(roomOrder.getCount());
        vo.setCheckInTime(roomOrder.getCheckInTime());
        vo.setLeaveTime(roomOrder.getLeaveTime());

        return vo;
    }

    @Override
    public RoomOrderInfoVO buildVO(RoomOrder roomOrder) {
        RoomOrderInfoVO vo = new RoomOrderInfoVO();

        Hotel hotel = hystrixHotelServiceClient.getById(roomOrder.getHotelId());
        Room room = hystrixRoomServiceClient.getById(roomOrder.getRoomId());

        vo.setNeedCode(isGuestMember(roomOrder));
        vo.setHotelName(hotel.getName());
        vo.setRoomId(roomOrder.getRoomId());
        vo.setRoomName(room.getName());

        return vo;
    }

    private boolean isGuestMember(RoomOrder roomOrder) {
        Member member = hystrixMemberServiceClient.getById(roomOrder.getMemberId());
        return MemberUtils.isGuestMember(member);
    }

    @Override
    public TicketOrderDetailVO buildOrderDetail(TicketOrder ticketOrder) {
        TicketOrderDetailVO vo = new TicketOrderDetailVO();
        BaseOrderDetailVO baseOrder = buildBaseOrderDetail(ticketOrder);
        BeanUtils.copyProperties(baseOrder, vo);

        Scenery scenery = hystrixSceneryServiceClient.getById(ticketOrder.getSceneryId());
        Ticket ticket = hystrixTicketServiceClient.getById(ticketOrder.getTicketId());

        vo.setSceneryId(ticketOrder.getSceneryId());
        vo.setSceneryName(scenery.getName());
        vo.setTicketId(ticketOrder.getTicketId());
        vo.setTicketName(ticket.getName());

        vo.setPlayTime(ticketOrder.getPlayTime());
        vo.setAdultCount(ticketOrder.getAdultCount());
        vo.setChildCount(ticketOrder.getChildCount());

        return vo;
    }

    @Override
    public TicketOrderInfoVO buildVO(TicketOrder ticketOrder) {
        TicketOrderInfoVO vo = new TicketOrderInfoVO();

        Member member = hystrixMemberServiceClient.getById(ticketOrder.getMemberId());
        vo.setNeedCode(MemberUtils.isGuestMember(member));

        Scenery scenery = hystrixSceneryServiceClient.getById(ticketOrder.getSceneryId());

        vo.setSceneryName(scenery.getName());
        vo.setTicketId(ticketOrder.getTicketId());
        vo.setLatestAllowPlayTime(getYYYYMMDDString(ticketOrder.getPlayTime() == null ? DateUtils.addDays(new Date(), 1) : ticketOrder.getPlayTime()));

        Ticket ticket = hystrixTicketServiceClient.getById(ticketOrder.getTicketId());
        vo.setTicketName(ticket.getName());

        return vo;
    }

    private Dict getDictById(String dictId) {
        return hystrixDictServiceClient.getById(dictId);
    }

    @Override
    public MemberIndexVO buildEmptyMemberIndexVO() {
        return new MemberIndexVO();
    }

    @Override
    public MemberIndexVO buildMemberIndexVO(Member member) {
        MemberIndexVO vo = new MemberIndexVO();

        //todo
        vo.setAddress("空");
        vo.setAvatar(LINE_PIC_URL);
        vo.setCanceledOrderCount(getMemberOrderCount(member.getId(), OrderService.ORDER_STATUS_CANCEL));
        vo.setCompletedOrderCount(getMemberOrderCount(member.getId(), OrderService.ORDER_STATUS_COMPLETED));
        vo.setWaitPayOrderCount(getMemberOrderCount(member.getId(), OrderService.ORDER_STATUS_UN_PAID));
        vo.setMobilePhone(member.getMobilePhone());
        vo.setEmail(member.getEmail());
        vo.setOrderCount(getMemberOrderCount(member.getId(), OrderService.ORDER_STATUS_ALL));
        vo.setNickName(member.getNickName());
        vo.setSex("男");
        vo.setIdCard("无");
        vo.setZipCode("无");

        return vo;
    }

    private int getMemberOrderCount(String memberId, Integer status) {
        final Integer[] realOrderStatues = orderService.getRealOrderStatues(status);

        List<RoomOrder> roomOrderList = hystrixRoomOrderServiceClient.findByMemberIdAndStatues(memberId,
                realOrderStatues);
        List<LineOrder> lineOrderList = hystrixLineOrderServiceClient.findByMemberIdAndStatues(memberId,
                realOrderStatues);
        List<TicketOrder> ticketOrderList = hystrixTicketOrderServiceClient.findByMemberIdAndStatues(memberId,
                realOrderStatues);

        return roomOrderList.size() + lineOrderList.size() + ticketOrderList.size();
    }

    @Override
    public LineOrderInfoVO buildVO(LineOrder lineOrder, List<Insurance> insurances) {
        LineOrderInfoVO vo = new LineOrderInfoVO();

        Member member = hystrixMemberServiceClient.getById(lineOrder.getMemberId());

        vo.setNeedCode(MemberUtils.isGuestMember(member));

        vo.setLineId(lineOrder.getLineId());
        Line line = hystrixLineServiceClient.getById(lineOrder.getLineId());

        String latestStartingTime = getLatestStartingTimeString(line);

        vo.setLineId(lineOrder.getLineId());
        vo.setLatestStartingTime(latestStartingTime);
        vo.setLineName(line.getName());
        vo.setInsurances(buildVOList(insurances));

        return vo;
    }

    private List<InsuranceVO> buildVOList(List<Insurance> insurances) {
        List<InsuranceVO> insuranceVOList = new ArrayList<InsuranceVO>();

        for (Insurance insurance : insurances) {
            insuranceVOList.add(buildVO(insurance));
        }

        return insuranceVOList;
    }

    private InsuranceVO buildVO(Insurance insurance) {
        InsuranceVO insuranceVO = new InsuranceVO();

        insuranceVO.setId(insurance.getId());
        insuranceVO.setName(insurance.getName());
        insuranceVO.setPrice(insurance.getPrice());

        return insuranceVO;
    }

    private String getLatestStartingTimeString(Line line) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, line.getRecommendedDaysOfAdvance());
        Date date = calendar.getTime();

        return getYYYYMMDDString(date);
    }

    private String getYYYYMMDDString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    @Override
    public SceneryDetailVO buildDetailVO(Scenery scenery) {
        SceneryDetailVO vo = new SceneryDetailVO();
        SceneryItemVO itemVO = buildItemVO(scenery);

        BeanUtils.copyProperties(itemVO, vo);

        vo.setAddress(scenery.getAddress());
        vo.setOpeningTime(scenery.getOpeningTime());
        vo.setPics(getPicList());
        vo.setTrafficGuide(scenery.getTrafficGuide());
        vo.setBuyTicketNotes(scenery.getBuyTicketNotes());

        fillTickets(scenery, vo);

        return vo;
    }

    private void fillTickets(Scenery scenery, SceneryDetailVO vo) {
        List<TicketVO> ticketVOs = new ArrayList<TicketVO>();

        List<Ticket> tickets = hystrixTicketServiceClient.getListBySceneryId(scenery.getId());

        if (!CollectionUtils.isEmpty(tickets)) {
            for (Ticket ticket : tickets) {
                final TicketVO ticketVO = new TicketVO();

                ticketVO.setId(ticket.getId());
                ticketVO.setPrice(ticket.getPrice());
                ticketVO.setMarketPrice(ticket.getMarketPrice());
                ticketVO.setName(ticket.getName());

                ticketVOs.add(ticketVO);
            }
        }

        vo.setTickets(ticketVOs);
    }

    @Override
    public LineDetailVO buildDetailVO(Line line) {

        LineDetailVO vo = new LineDetailVO();

        LineItemVO lineItemVO = buildItemVO(line);

        BeanUtils.copyProperties(lineItemVO, vo);

        vo.setPics(getPicList());
        vo.setBookingInformation(line.getBookingInformation());
        vo.setCostIntroduction(line.getCostIntroduction());
        vo.setLabels(getLabelList(line));
        vo.setStartCity(line.getStartCity());
        vo.setTravelIntroduction(line.getTravelIntroduction());

        return vo;
    }

    private ArrayList<String> getLabelList(Line line) {
        final ArrayList<String> labels = new ArrayList<String>();

        if (line.getRecommend()) {
            labels.add("推荐");
        }
        if (line.getSpecialOffer()) {
            labels.add("特价");
        }
        if (line.getGroupPurchase()) {
            labels.add("团购");
        }
        if (line.getNewProduct()) {
            labels.add("新品");
        }
        if (line.getHotSale()) {
            labels.add("热卖");
        }
        return labels;
    }

    @Override
    public HotelDetailVO buildDetailVO(Hotel hotel) {
        HotelDetailVO vo = new HotelDetailVO();
        HotelItemVO hotelItemVO = buildItemVO(hotel);
        BeanUtils.copyProperties(hotelItemVO, vo);

        vo.setPics(getPicList());
        vo.setOpeningTime(hotel.getOpeningTime());
        vo.setDecorationTime(hotel.getDecorationTime());
        vo.setAppendService(hotel.getAppendService());
        vo.setSpecialTips(hotel.getSpecialTips());
        vo.setPositionDistance(hotel.getPositionDistance());
        vo.setSurroundingEnvironment(hotel.getSurroundingEnvironment());
        vo.setContactInformation(hotel.getContactInformation());
        vo.setRooms(buildRoomVOs(hotel.getId()));

        return vo;
    }

    private List<RoomVO> buildRoomVOs(String hotelId) {
        List<Room> rooms = hystrixRoomServiceClient.getByHotelId(hotelId);
        List<RoomVO> roomVOList = new ArrayList<RoomVO>();
        for (Room room : rooms) {
            roomVOList.add(buildVO(room));
        }
        return roomVOList;
    }

    private RoomVO buildVO(Room room) {
        RoomVO vo = new RoomVO();

        vo.setId(room.getId());
        vo.setMarketPrice(room.getMarketPrice());
        vo.setPrice(room.getPrice());
        vo.setName(room.getName());

        return vo;
    }

    private String dateToString(String pattern, Date date) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(pattern).format(date);
    }

    private List<String> getPicList() {
        return Lists.newArrayList(HOTEL_PIC_URL, LINE_PIC_URL, SCENERY_PIC_URL,
                HOTEL_PIC_URL, LINE_PIC_URL, SCENERY_PIC_URL);
    }

    @Override
    public LineSearchItemVO buildSearchItemVO(Line line) {
        LineSearchItemVO vo = new LineSearchItemVO();

        vo.setId(line.getId());
        vo.setName(line.getName());
        vo.setStartCity(line.getStartCity());
        vo.setHot(line.getHotSale());

        //todo
        vo.setPic(LINE_PIC_URL);
        vo.setStartingPrice(line.getStartingPrice());

        return vo;
    }

    @Override
    public <T> PageVO<T> buildPage(Collection<T> content, Boolean hasMore) {
        return new PageVO<T>(content, hasMore);
    }

    @Override
    public <T> PageVO<T> buildPage(PageImplWrapper<T> pageImplWrapper) {
        return new PageVO<T>(pageImplWrapper);
    }

    @Override
    public LineItemVO buildItemVO(Line line) {
        LineItemVO vo = new LineItemVO();

        vo.setId(line.getId());
        vo.setName(line.getName());
        vo.setDesc(line.getBriefDescription());
        vo.setMarketPrice(line.getMarketPrice());
        vo.setStartingPrice(line.getStartingPrice());
        vo.setRecommend(line.getRecommend());

        //todo
        vo.setPic(LINE_PIC_URL);

        return vo;
    }

    @Override
    public HotelItemVO buildItemVO(Hotel hotel) {
        HotelItemVO vo = new HotelItemVO();

        vo.setId(hotel.getId());
        vo.setName(hotel.getName());
        vo.setDesc(hotel.getBriefDescription());
        vo.setMarketPrice(hotel.getMarketPrice());
        vo.setStartingPrice(hotel.getStartingPrice());
        vo.setRecommend(hotel.getRecommend());

        vo.setAddress(hotel.getAddress());
        vo.setLevel(getDictById(hotel.getLevel()).getName());

        //todo
        vo.setPic(HOTEL_PIC_URL);

        return vo;
    }

    @Override
    public SceneryItemVO buildItemVO(Scenery scenery) {
        SceneryItemVO vo = new SceneryItemVO();

        vo.setId(scenery.getId());
        vo.setName(scenery.getName());
        vo.setDesc(scenery.getBriefDescription());
        vo.setRecommend(scenery.getRecommend());


        fillTicketPrice(vo);

        //todo
        vo.setPic(SCENERY_PIC_URL);

        return vo;
    }

    private void fillTicketPrice(SceneryItemVO vo) {
        List<Ticket> tickets = hystrixTicketServiceClient.getListBySceneryId(vo.getId());

        Double startingPrice = 9999D;
        Double marketPrice = 9999D;

        if (!CollectionUtils.isEmpty(tickets)) {
            for (Ticket ticket : tickets) {
                if (startingPrice.compareTo(ticket.getPrice()) == 1) {
                    startingPrice = ticket.getPrice();
                }
                if (marketPrice.compareTo(ticket.getMarketPrice()) == 1) {
                    marketPrice = ticket.getMarketPrice();
                }
            }
        }

        vo.setStartingPrice(startingPrice);
        vo.setMarketPrice(marketPrice);
    }
}
