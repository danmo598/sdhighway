package com.highway.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author fj123
 * @since 2018-11-10
 */
@Table(name="sd_car_type")
public class CarType extends Model<CarType> {

    private static final long serialVersionUID = 1L;

   @Id
   private Integer id;
   private String name;
   @TableField("car_id")
   private Integer carId;
   @TableField("create_time")
   private Date createTime;


   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Integer getCarId() {
      return carId;
   }

   public void setCarId(Integer carId) {
      this.carId = carId;
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
      return "CarType{" +
         "id=" + id +
         ", name=" + name +
         ", carId=" + carId +
         ", createTime=" + createTime +
         "}";
   }
}
