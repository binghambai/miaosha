package com.binghambai.mallgoods.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "pms_product", schema = "mall")
@Data
public class PmsProductEntity {
    private long id;
    private Long brandId;
    private Long productCategoryId;
    private Long feightTemplateId;
    private Long productAttributeCategoryId;
    private String name;
    private String pic;
    private String productSn;
    private Integer deleteStatus;
    private Integer publishStatus;
    private Integer newStatus;
    private Integer recommandStatus;
    private Integer verifyStatus;
    private Integer sort;
    private Integer sale;
    private BigDecimal price;
    private BigDecimal promotionPrice;
    private Integer giftGrowth;
    private Integer giftPoint;
    private Integer usePointLimit;
    private String subTitle;
    private String description;
    private BigDecimal originalPrice;
    private Integer stock;
    private Integer lowStock;
    private String unit;
    private BigDecimal weight;
    private Integer previewStatus;
    private String serviceIds;
    private String keywords;
    private String note;
    private String albumPics;
    private String detailTitle;
    private String detailDesc;
    private String detailHtml;
    private String detailMobileHtml;
    private Timestamp promotionStartTime;
    private Timestamp promotionEndTime;
    private Integer promotionPerLimit;
    private Integer promotionType;
    private String brandName;
    private String productCategoryName;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "brand_id")
    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    @Basic
    @Column(name = "product_category_id")
    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    @Basic
    @Column(name = "feight_template_id")
    public Long getFeightTemplateId() {
        return feightTemplateId;
    }

    public void setFeightTemplateId(Long feightTemplateId) {
        this.feightTemplateId = feightTemplateId;
    }

    @Basic
    @Column(name = "product_attribute_category_id")
    public Long getProductAttributeCategoryId() {
        return productAttributeCategoryId;
    }

    public void setProductAttributeCategoryId(Long productAttributeCategoryId) {
        this.productAttributeCategoryId = productAttributeCategoryId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "pic")
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Basic
    @Column(name = "product_sn")
    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    @Basic
    @Column(name = "delete_status")
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    @Basic
    @Column(name = "publish_status")
    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    @Basic
    @Column(name = "new_status")
    public Integer getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(Integer newStatus) {
        this.newStatus = newStatus;
    }

    @Basic
    @Column(name = "recommand_status")
    public Integer getRecommandStatus() {
        return recommandStatus;
    }

    public void setRecommandStatus(Integer recommandStatus) {
        this.recommandStatus = recommandStatus;
    }

    @Basic
    @Column(name = "verify_status")
    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    @Basic
    @Column(name = "sort")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "sale")
    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "promotion_price")
    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    @Basic
    @Column(name = "gift_growth")
    public Integer getGiftGrowth() {
        return giftGrowth;
    }

    public void setGiftGrowth(Integer giftGrowth) {
        this.giftGrowth = giftGrowth;
    }

    @Basic
    @Column(name = "gift_point")
    public Integer getGiftPoint() {
        return giftPoint;
    }

    public void setGiftPoint(Integer giftPoint) {
        this.giftPoint = giftPoint;
    }

    @Basic
    @Column(name = "use_point_limit")
    public Integer getUsePointLimit() {
        return usePointLimit;
    }

    public void setUsePointLimit(Integer usePointLimit) {
        this.usePointLimit = usePointLimit;
    }

    @Basic
    @Column(name = "sub_title")
    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "original_price")
    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    @Basic
    @Column(name = "stock")
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Basic
    @Column(name = "low_stock")
    public Integer getLowStock() {
        return lowStock;
    }

    public void setLowStock(Integer lowStock) {
        this.lowStock = lowStock;
    }

    @Basic
    @Column(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "weight")
    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "preview_status")
    public Integer getPreviewStatus() {
        return previewStatus;
    }

    public void setPreviewStatus(Integer previewStatus) {
        this.previewStatus = previewStatus;
    }

    @Basic
    @Column(name = "service_ids")
    public String getServiceIds() {
        return serviceIds;
    }

    public void setServiceIds(String serviceIds) {
        this.serviceIds = serviceIds;
    }

    @Basic
    @Column(name = "keywords")
    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "album_pics")
    public String getAlbumPics() {
        return albumPics;
    }

    public void setAlbumPics(String albumPics) {
        this.albumPics = albumPics;
    }

    @Basic
    @Column(name = "detail_title")
    public String getDetailTitle() {
        return detailTitle;
    }

    public void setDetailTitle(String detailTitle) {
        this.detailTitle = detailTitle;
    }

    @Basic
    @Column(name = "detail_desc")
    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }

    @Basic
    @Column(name = "detail_html")
    public String getDetailHtml() {
        return detailHtml;
    }

    public void setDetailHtml(String detailHtml) {
        this.detailHtml = detailHtml;
    }

    @Basic
    @Column(name = "detail_mobile_html")
    public String getDetailMobileHtml() {
        return detailMobileHtml;
    }

    public void setDetailMobileHtml(String detailMobileHtml) {
        this.detailMobileHtml = detailMobileHtml;
    }

    @Basic
    @Column(name = "promotion_start_time")
    public Timestamp getPromotionStartTime() {
        return promotionStartTime;
    }

    public void setPromotionStartTime(Timestamp promotionStartTime) {
        this.promotionStartTime = promotionStartTime;
    }

    @Basic
    @Column(name = "promotion_end_time")
    public Timestamp getPromotionEndTime() {
        return promotionEndTime;
    }

    public void setPromotionEndTime(Timestamp promotionEndTime) {
        this.promotionEndTime = promotionEndTime;
    }

    @Basic
    @Column(name = "promotion_per_limit")
    public Integer getPromotionPerLimit() {
        return promotionPerLimit;
    }

    public void setPromotionPerLimit(Integer promotionPerLimit) {
        this.promotionPerLimit = promotionPerLimit;
    }

    @Basic
    @Column(name = "promotion_type")
    public Integer getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(Integer promotionType) {
        this.promotionType = promotionType;
    }

    @Basic
    @Column(name = "brand_name")
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Basic
    @Column(name = "product_category_name")
    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PmsProductEntity that = (PmsProductEntity) o;
        return id == that.id && Objects.equals(brandId, that.brandId) && Objects.equals(productCategoryId, that.productCategoryId) && Objects.equals(feightTemplateId, that.feightTemplateId) && Objects.equals(productAttributeCategoryId, that.productAttributeCategoryId) && Objects.equals(name, that.name) && Objects.equals(pic, that.pic) && Objects.equals(productSn, that.productSn) && Objects.equals(deleteStatus, that.deleteStatus) && Objects.equals(publishStatus, that.publishStatus) && Objects.equals(newStatus, that.newStatus) && Objects.equals(recommandStatus, that.recommandStatus) && Objects.equals(verifyStatus, that.verifyStatus) && Objects.equals(sort, that.sort) && Objects.equals(sale, that.sale) && Objects.equals(price, that.price) && Objects.equals(promotionPrice, that.promotionPrice) && Objects.equals(giftGrowth, that.giftGrowth) && Objects.equals(giftPoint, that.giftPoint) && Objects.equals(usePointLimit, that.usePointLimit) && Objects.equals(subTitle, that.subTitle) && Objects.equals(description, that.description) && Objects.equals(originalPrice, that.originalPrice) && Objects.equals(stock, that.stock) && Objects.equals(lowStock, that.lowStock) && Objects.equals(unit, that.unit) && Objects.equals(weight, that.weight) && Objects.equals(previewStatus, that.previewStatus) && Objects.equals(serviceIds, that.serviceIds) && Objects.equals(keywords, that.keywords) && Objects.equals(note, that.note) && Objects.equals(albumPics, that.albumPics) && Objects.equals(detailTitle, that.detailTitle) && Objects.equals(detailDesc, that.detailDesc) && Objects.equals(detailHtml, that.detailHtml) && Objects.equals(detailMobileHtml, that.detailMobileHtml) && Objects.equals(promotionStartTime, that.promotionStartTime) && Objects.equals(promotionEndTime, that.promotionEndTime) && Objects.equals(promotionPerLimit, that.promotionPerLimit) && Objects.equals(promotionType, that.promotionType) && Objects.equals(brandName, that.brandName) && Objects.equals(productCategoryName, that.productCategoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brandId, productCategoryId, feightTemplateId, productAttributeCategoryId, name, pic, productSn, deleteStatus, publishStatus, newStatus, recommandStatus, verifyStatus, sort, sale, price, promotionPrice, giftGrowth, giftPoint, usePointLimit, subTitle, description, originalPrice, stock, lowStock, unit, weight, previewStatus, serviceIds, keywords, note, albumPics, detailTitle, detailDesc, detailHtml, detailMobileHtml, promotionStartTime, promotionEndTime, promotionPerLimit, promotionType, brandName, productCategoryName);
    }
}
