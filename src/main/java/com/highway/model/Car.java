package com.highway.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

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
@Table(name="sd_car")
public class Car extends Model<Car> {

    private static final long serialVersionUID = 1L;

   @TableId(value="id", type= IdType.AUTO)
   private Integer id;
   private String name;
   private String icon;
   @TableField("company_id")
   private Integer companyId;
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

   public String getIcon() {
      return icon;
   }

   public void setIcon(String icon) {
      this.icon = icon;
   }

   public Integer getCompanyId() {
      return companyId;
   }

   public void setCompanyId(Integer companyId) {
      this.companyId = companyId;
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
      return "Car{" +
         "id=" + id +
         ", name=" + name +
         ", icon=" + icon +
         ", companyId=" + companyId +
         ", createTime=" + createTime +
         "}";
   }
}
