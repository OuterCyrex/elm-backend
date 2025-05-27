package com.elm.service;

import com.elm.dao.BusinessDao;
import com.elm.model.entity.Business;
import com.elm.model.vo.BusinessResponse;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessService {
    private static final BusinessDao businessDao = new BusinessDao();

    private BusinessResponse EntityToResponse(Business b) {
        return new BusinessResponse(
                b.getRemarks(),
                b.getDeliveryPrice(),
                b.getStarPrice(),
                b.getBusinessImg(),
                b.getOrderTypeId(),
                b.getBusinessExplain(),
                b.getBusinessAddress(),
                b.getBusinessName(),
                b.getBusinessId()
        );
    }

    public List<BusinessResponse> GetBusinessByOrderTypeId(int orderTypeId) throws SQLException {
        Business b = new Business();
        b.setOrderTypeId(orderTypeId);
        List<Business> EntityList = businessDao.FindBusiness(b);

        List<BusinessResponse> ResponseList = new ArrayList<>();

        for (Business Entity : EntityList) {
            ResponseList.add(EntityToResponse(Entity));
        }

        return ResponseList;
    }

    public BusinessResponse GetBusinessById(int id) throws SQLException {
        Business b = new Business();
        b.setBusinessId(id);
        List<Business> entityList = businessDao.FindBusiness(b);

        return EntityToResponse(entityList.get(0));
    }
}
