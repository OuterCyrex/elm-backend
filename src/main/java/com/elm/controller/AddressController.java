package com.elm.controller;

import com.elm.model.dto.address.NewAddressRequest;
import com.elm.model.entity.Address;
import com.elm.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/elm/AddressController")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/saveAddress")
    private int saveAddress(@RequestParam String userId,
                             @RequestParam String contactName,
                             @RequestParam Integer contactSex,
                             @RequestParam String contactTel,
                             @RequestParam String address
                             ) throws Exception {

        NewAddressRequest da = new NewAddressRequest(contactName, contactSex, contactTel, address, userId);
        return addressService.addAddress(da);
    }

    @GetMapping("/findAddressByUserId")
    private List<Address> FindAddressByUserId(@RequestParam String userId) throws Exception {
       return addressService.AddressList(userId);
    }
}

