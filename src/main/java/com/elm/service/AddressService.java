package com.elm.service;

import java.sql.SQLException;

import com.elm.dao.AddressDao;
import com.elm.model.dto.address.NewAddressRequest;
import com.elm.model.entity.Address;

public class AddressService {
    private final AddressDao addressDao = new AddressDao();

    public int addAddress(NewAddressRequest in) throws SQLException{
        Address a = new Address();
        
        a.setUserId(in.getUserId());
        a.setContactName(in.getContactName());
        a.setContactTel(in.getContactTel());
        a.setContactSex(in.getContactSex());
        a.setAddress(in.getAddress());

        return addressDao.addAddress(a);
    }
}