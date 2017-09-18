package org.terry.magician.api.vo;

/**
 * @author Terry
 */
public class AdvVO extends BaseVO {

    /**
     * 图片URL
     */
    private String imgUrl;

    /**
     * 目标ID
     */
    private String refId;

    /**
     * 跳转类型
     * NONE("不跳转", 0),
     * HOTEL("酒店", 20),
     * SCENERY("景区", 30),
     * LINE("路线", 10);
     */
    private Integer refType;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public Integer getRefType() {
        return refType;
    }

    public void setRefType(Integer refType) {
        this.refType = refType;
    }
}
