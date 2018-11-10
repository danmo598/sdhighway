package com.highway.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author fj123
 * @since 2018-11-10
 */
@TableName("sd_car_detail")
public class CarDetail extends Model<CarDetail> {

    private static final long serialVersionUID = 1L;

   @TableId(value="id", type= IdType.AUTO)
   private Integer id;
   private String image;
   @TableField("car_model")
   private String carModel;
   private String volume;
   private String detail;
   @TableField("type_id")
   private Integer typeId;
   @TableField("create_time")
   private Date createTime;


   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getImage() {
      return image;
   }

   public void setImage(String image) {
      this.image = image;
   }

   public String getCarModel() {
      return carModel;
   }

   public void setCarModel(String carModel) {
      this.carModel = carModel;
   }

   public String getVolume() {
      return volume;
   }

   public void setVolume(String volume) {
      this.volume = volume;
   }

   public String getDetail() {
      return detail;
   }

   public void setDetail(String detail) {
      this.detail = detail;
   }

   public Integer getTypeId() {
      return typeId;
   }

   public void setTypeId(Integer typeId) {
      this.typeId = typeId;
   }

   public Date getCreateTime() {
      return createTime;
   }

   public void setCreateTime(Date createTime) {
      this.createTime = createTime;
   }

   @Override
   protected Serializable pkVal() {
      return this.id;
   }

   @Override
   public String toString() {
      return "CarDetail{" +
         "id=" + id +
         ", image=" + image +
         ", carModel=" + carModel +
         ", volume=" + volume +
         ", detail=" + detail +
         ", typeId=" + typeId +
         ", createTime=" + createTime +
         "}";
   }
}
