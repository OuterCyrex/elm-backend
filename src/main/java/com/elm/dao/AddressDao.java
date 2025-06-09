package com.elm.dao;

import com.elm.model.entity.Address;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

@Mapper
public interface AddressDao {

    @Insert("INSERT INTO deliveryaddress (contactName, contactSex, contactTel, address, userId) " +
            "VALUES (#{contactName}, #{contactSex}, #{contactTel}, #{address}, #{userId})")
    int addAddress(Address address);

    @SelectProvider(type = AddressSqlProvider.class, method = "findAddress")
    List<Address> findAddress(Address address);

    class AddressSqlProvider {
        public String findAddress(Address a) {
            return new SQL() {{
                SELECT("*");
                FROM("deliveryaddress");

                if (a.getDaId() != null) {
                    WHERE("daId = #{daId}");
                }
                if (a.getContactName() != null && !a.getContactName().isEmpty()) {
                    WHERE("contactName = #{contactName}");
                }
                if (a.getContactSex() != null) {
                    WHERE("contactSex = #{contactSex}");
                }
                if (a.getContactTel() != null && !a.getContactTel().isEmpty()) {
                    WHERE("contactTel = #{contactTel}");
                }
                if (a.getAddress() != null && !a.getAddress().isEmpty()) {
                    WHERE("address = #{address}");
                }
                if (a.getUserId() != null && !a.getUserId().isEmpty()) {
                    WHERE("userId = #{userId}");
                }
            }}.toString();
        }
    }
}


