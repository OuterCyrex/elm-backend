package com.elm.dao;

import com.elm.model.entity.Business;
import com.elm.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusinessDao{

    public List<Business> FindBusiness(Business criteria) throws SQLException{
        Connection conn = DBUtil.getConnection();

        List<Business> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM business WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (criteria.getBusinessId() != null) {
            sql.append(" AND businessId = ?");
            params.add(criteria.getBusinessId());
        }
        if (criteria.getBusinessName() != null && !criteria.getBusinessName().isEmpty()) {
            sql.append(" AND businessName LIKE ?");
            params.add("%" + criteria.getBusinessName() + "%");
        }
        if (criteria.getBusinessAddress() != null && !criteria.getBusinessAddress().isEmpty()) {
            sql.append(" AND businessAddress LIKE ?");
            params.add("%" + criteria.getBusinessAddress() + "%");
        }
        if (criteria.getBusinessExplain() != null && !criteria.getBusinessExplain().isEmpty()) {
            sql.append(" AND businessExplain LIKE ?");
            params.add("%" + criteria.getBusinessExplain() + "%");
        }
        if (criteria.getBusinessImg() != null && !criteria.getBusinessImg().isEmpty()) {
            sql.append(" AND businessImg = ?");
            params.add(criteria.getBusinessImg());
        }
        if (criteria.getOrderTypeId() != null) {
            sql.append(" AND orderTypeId = ?");
            params.add(criteria.getOrderTypeId());
        }
        if (criteria.getStarPrice() != null) {
            sql.append(" AND starPrice = ?");
            params.add(criteria.getStarPrice());
        }
        if (criteria.getDeliveryPrice() != null) {
            sql.append(" AND deliveryPrice = ?");
            params.add(criteria.getDeliveryPrice());
        }
        if (criteria.getRemarks() != null && !criteria.getRemarks().isEmpty()) {
            sql.append(" AND remarks LIKE ?");
            params.add("%" + criteria.getRemarks() + "%");
        }

        PreparedStatement ps = conn.prepareStatement(sql.toString());
        for (int i = 0; i < params.size(); i++) {
            ps.setObject(i + 1, params.get(i));
        }

        ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Business business = new Business();
                    business.setBusinessId(rs.getInt("businessId"));
                    business.setBusinessName(rs.getString("businessName"));
                    business.setBusinessAddress(rs.getString("businessAddress"));
                    business.setBusinessExplain(rs.getString("businessExplain"));
                    business.setBusinessImg(rs.getString("businessImg"));
                    business.setOrderTypeId(rs.getInt("orderTypeId"));
                    business.setStarPrice(rs.getDouble("starPrice"));
                    business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                    business.setRemarks(rs.getString("remarks"));
                    result.add(business);
                }

        conn.close();

        return result;
    }
}

