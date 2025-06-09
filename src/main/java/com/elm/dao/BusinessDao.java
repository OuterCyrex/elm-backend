package com.elm.dao;

import com.elm.model.entity.Business;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

@Mapper
public interface BusinessDao {

    @SelectProvider(type = BusinessSqlProvider.class, method = "findBusiness")
    List<Business> findBusiness(Business criteria);

    class BusinessSqlProvider {
        public String findBusiness(Business b) {
            return new SQL() {{
                SELECT("*");
                FROM("business");
                if (b.getBusinessId() != null) {
                    WHERE("businessId = #{businessId}");
                }
                if (b.getBusinessName() != null && !b.getBusinessName().isEmpty()) {
                    WHERE("businessName LIKE CONCAT('%', #{businessName}, '%')");
                }
                if (b.getBusinessAddress() != null && !b.getBusinessAddress().isEmpty()) {
                    WHERE("businessAddress LIKE CONCAT('%', #{businessAddress}, '%')");
                }
                if (b.getBusinessExplain() != null && !b.getBusinessExplain().isEmpty()) {
                    WHERE("businessExplain LIKE CONCAT('%', #{businessExplain}, '%')");
                }
                if (b.getBusinessImg() != null && !b.getBusinessImg().isEmpty()) {
                    WHERE("businessImg = #{businessImg}");
                }
                if (b.getOrderTypeId() != null) {
                    WHERE("orderTypeId = #{orderTypeId}");
                }
                if (b.getStarPrice() != null) {
                    WHERE("starPrice = #{starPrice}");
                }
                if (b.getDeliveryPrice() != null) {
                    WHERE("deliveryPrice = #{deliveryPrice}");
                }
                if (b.getRemarks() != null && !b.getRemarks().isEmpty()) {
                    WHERE("remarks LIKE CONCAT('%', #{remarks}, '%')");
                }
            }}.toString();
        }
    }
}


