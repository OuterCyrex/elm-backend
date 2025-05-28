package com.elm.service;

import java.sql.SQLException;
import java.util.List;

import com.elm.dao.AddressDao;
import com.elm.model.dto.address.NewAddressRequest;
import com.elm.model.entity.Address;
import com.elm.model.entity.Cart;

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

    public List<Address> AddressList(String  UserId) throws SQLException{
        Address ad = new Address();
        ad.setUserId(UserId);
        return addressDao.findAddress(ad);
    }
}