package mariano.igor.conexaobancodados.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

import mariano.igor.conexaobancodados.models.AddressModel;
import mariano.igor.conexaobancodados.repositories.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AddressService {

    @Autowired
    IAddressRepository addressRepository;
    public AddressModel findAddress(AddressModel addressModel) throws IOException, InterruptedException, ApiException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyAnKHpfixlCYo5rolUBlIKinIlAu0L9Mas")
                .build();

//        GeocodingResult[] results =  GeocodingApi.geocode(context,location).await();
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String address = gson.toJson(results[0].formattedAddress);
//        String latitude = gson.toJson(results[0].geometry.location.lat);
//
//        String longitude = gson.toJson(results[0].geometry.location.lng);
//
//        System.out.println("Latitude: " + latitude + "\nLongitude: " + longitude);
        LatLng latLng = new LatLng(addressModel.getLat(), addressModel.getLng());

        GeocodingResult[] r =  GeocodingApi.reverseGeocode(context, latLng).await();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String address = gson.toJson(r[0].formattedAddress);
        System.out.println(address);
        addressModel.setAddressFormated(address);

        context.shutdown();

        return addressRepository.save(addressModel);
    }
}
