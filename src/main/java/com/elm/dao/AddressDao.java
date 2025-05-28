package com.elm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.elm.utils.DBUtil;
import com.elm.model.entity.Address;

public class AddressDao {

    public int addAddress(Address da) throws SQLException {
        String sql = "INSERT INTO deliveryaddress (contactName, contactSex, contactTel, address, userId) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (
            Connection conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, da.getContactName());
            pstmt.setInt(2, da.getContactSex());
            pstmt.setString(3, da.getContactTel());
            pstmt.setString(4, da.getAddress());
            pstmt.setString(5, da.getUserId());

            return pstmt.executeUpdate();
        }
    }

    /**
     * 条件查询收货地址
     */
    public List<Address> findAddress(Address da) throws SQLException {
        List<Address> list = new ArrayList<>();

        StringBuilder sql = new StringBuilder("SELECT * FROM deliveryaddress WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (da.getDaId() != null) {
            sql.append(" AND daId = ?");
            params.add(da.getDaId());
        }
        if (da.getContactName() != null && !da.getContactName().isEmpty()) {
            sql.append(" AND contactName = ?");
            params.add(da.getContactName());
        }
        if (da.getContactSex() != null) {
            sql.append(" AND contactSex = ?");
            params.add(da.getContactSex());
        }
        if (da.getContactTel() != null && !da.getContactTel().isEmpty()) {
            sql.append(" AND contactTel = ?");
            params.add(da.getContactTel());
        }
        if (da.getAddress() != null && !da.getAddress().isEmpty()) {
            sql.append(" AND address = ?");
            params.add(da.getAddress());
        }
        if (da.getUserId() != null && !da.getUserId().isEmpty()) {
            sql.append(" AND userId = ?");
            params.add(da.getUserId());
        }

        try (
            Connection conn = DBUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString())
        ) {
            for (int i = 0; i < params.size(); i++) {
                pstmt.setObject(i + 1, params.get(i));
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Address address = new Address();
                    address.setDaId(rs.getInt("daId"));
                    address.setContactName(rs.getString("contactName"));
                    address.setContactSex(rs.getInt("contactSex"));
                    address.setContactTel(rs.getString("contactTel"));
                    address.setAddress(rs.getString("address"));
                    address.setUserId(rs.getString("userId"));

                    list.add(address);
                }
            }
        }

        return list;
    }
}
