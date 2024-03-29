package entity;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * (BdLivePlanProduct)实体类
 *
 * @author makejava
 * @since 2022-11-02 14:47:36
 */
public class BdLivePlanProduct implements Serializable {
    private static final long serialVersionUID = -40386205874135412L;
    
    private Long id;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改时间
     */
    private Date gmtModified;
    /**
     * 软删除标志
     */
    private Integer isDeleted;

    private String liveDate;

    private String anchorName;

    private String anchorId;
    /**
     * 商品id
     */
    private String itemId;

    private String styleCode;

    private String barCode;
    /**
     * 商品名称
     */
    private String itemName;

    private BigDecimal livePrice;

    private String itemImg;
    /**
     * 品牌
     */
    private String brand;

    private String gaeaCatLv1Name;

    private String purchasePrincipal;

    private String shopType;

    private String department;

    private String shopName;

    private String shopId;

    private String supplierName;

    private String shipTimeLimit;

    private String contractSubject;

    private Integer paymentAmount;

    private Integer nextRefundAmount;

    private Integer refundAmount;

    private Integer liveOrderVolume;

    private String catLv1Name;

    private String md5;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 修改人
     */
    private String modifier;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getLiveDate() {
        return liveDate;
    }

    public void setLiveDate(String liveDate) {
        this.liveDate = liveDate;
    }

    public String getAnchorName() {
        return anchorName;
    }

    public void setAnchorName(String anchorName) {
        this.anchorName = anchorName;
    }

    public String getAnchorId() {
        return anchorId;
    }

    public void setAnchorId(String anchorId) {
        this.anchorId = anchorId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getStyleCode() {
        return styleCode;
    }

    public void setStyleCode(String styleCode) {
        this.styleCode = styleCode;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getLivePrice() {
        return livePrice;
    }

    public void setLivePrice(BigDecimal livePrice) {
        this.livePrice = livePrice;
    }

    public String getItemImg() {
        return itemImg;
    }

    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getGaeaCatLv1Name() {
        return gaeaCatLv1Name;
    }

    public void setGaeaCatLv1Name(String gaeaCatLv1Name) {
        this.gaeaCatLv1Name = gaeaCatLv1Name;
    }

    public String getPurchasePrincipal() {
        return purchasePrincipal;
    }

    public void setPurchasePrincipal(String purchasePrincipal) {
        this.purchasePrincipal = purchasePrincipal;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getShipTimeLimit() {
        return shipTimeLimit;
    }

    public void setShipTimeLimit(String shipTimeLimit) {
        this.shipTimeLimit = shipTimeLimit;
    }

    public String getContractSubject() {
        return contractSubject;
    }

    public void setContractSubject(String contractSubject) {
        this.contractSubject = contractSubject;
    }

    public Integer getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Integer paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Integer getNextRefundAmount() {
        return nextRefundAmount;
    }

    public void setNextRefundAmount(Integer nextRefundAmount) {
        this.nextRefundAmount = nextRefundAmount;
    }

    public Integer getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Integer refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Integer getLiveOrderVolume() {
        return liveOrderVolume;
    }

    public void setLiveOrderVolume(Integer liveOrderVolume) {
        this.liveOrderVolume = liveOrderVolume;
    }

    public String getCatLv1Name() {
        return catLv1Name;
    }

    public void setCatLv1Name(String catLv1Name) {
        this.catLv1Name = catLv1Name;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

}

