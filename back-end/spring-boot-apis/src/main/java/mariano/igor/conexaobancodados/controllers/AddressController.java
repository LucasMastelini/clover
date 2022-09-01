package mariano.igor.conexaobancodados.controllers;

import com.google.maps.errors.ApiException;

import mariano.igor.conexaobancodados.dtos.AddressDto;
import mariano.igor.conexaobancodados.models.AddressModel;
import mariano.igor.conexaobancodados.services.AddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressModel> sendingEmail(@RequestBody AddressDto addressDto) throws IOException, InterruptedException, ApiException {
        AddressModel addressModel = new AddressModel();
        BeanUtils.copyProperties(addressDto, addressModel);
        addressService.findAddress(addressModel);
        return new ResponseEntity<>(addressModel, HttpStatus.CREATED);
    }

}
