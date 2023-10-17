package com.example.backend.yandex_delivery.geocoder.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GeocoderResponse {
    private Response response;
}

@Data
@NoArgsConstructor
class Response {
    @JsonProperty("GeoObjectCollection")
    private GeoObjectCollection geoObjectCollection;
}

@Data
@NoArgsConstructor
class GeoObjectCollection {
    private MetaDataProperty metaDataProperty;
    private List<FeatureMember> featureMember;
}

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class MetaDataProperty {
    @JsonProperty("GeocoderResponseMetaData")
    private GeocoderResponseMetaData geocoderResponseMetaData;
}

@Data
@NoArgsConstructor
class GeocoderResponseMetaData {
    private String request;
    private String found;
    private String results;
}

@Data
@NoArgsConstructor
class FeatureMember {
    @JsonProperty("GeoObject")
    private GeoObject geoObject;
}

@Data
@NoArgsConstructor
class GeoObject {
    private MetaDataProperty2 metaDataProperty;
    private String description;
    private String name;
    private BoundedBy boundedBy;
    private String uri;
    @JsonProperty("Point")
    private Point point;
}

@Data
@NoArgsConstructor
class MetaDataProperty2 {
    @JsonProperty("GeocoderMetaData")
    private GeocoderMetaData geocoderMetaData;
}

@Data
@NoArgsConstructor
class Point {
    private String pos;
}

@Data
@NoArgsConstructor
class BoundedBy {
    @JsonProperty("Envelope")
    private Envelope envelope;
}

@Data
@NoArgsConstructor
class Envelope {
    private String lowerCorner;
    private String upperCorner;
}


@Data
@NoArgsConstructor
class GeocoderMetaData {
    private String kind;
    private String text;
    private String precision;
    @JsonProperty("Address")
    private Address address;
    @JsonProperty("AddressDetails")
    private AddressDetails addressDetails;
}

@Data
@NoArgsConstructor
class AddressDetails {
    @JsonProperty("Country")
    private Country country;
}

@Data
@NoArgsConstructor
class Country {
    @JsonProperty("AddressLine")
    private String addressLine;
    @JsonProperty("CountryNameCode")
    private String countryNameCode;
    @JsonProperty("CountryName")
    private String countryName;
    @JsonProperty("AdministrativeArea")
    private AdministrativeArea administrativeArea;

}

@Data
@NoArgsConstructor
class AdministrativeArea {
    @JsonProperty("AdministrativeAreaName")
    private String administrativeAreaName;
    @JsonProperty("Locality")
    private Locality locality;
}

@Data
@NoArgsConstructor
class Locality {
    @JsonProperty("LocalityName")
    private String localityName;
    @JsonProperty("Thoroughfare")
    private Thoroughfare thoroughfare;


}

@Data
@NoArgsConstructor
class Thoroughfare {
    @JsonProperty("ThoroughfareName")
    private String thoroughfareName;
    @JsonProperty("Premise")
    private Premise premise;
}

@Data
@NoArgsConstructor
class Premise {
    @JsonProperty("PremiseNumber")
    private String premiseNumber;
    @JsonProperty("PostalCode")
    private PostalCode postalCode;
}

@Data
@NoArgsConstructor
class PostalCode {
    @JsonProperty("PostalCodeNumber")
    private String postalCodeNumber;
}

@Data
@NoArgsConstructor
class Address {
    private String country_code;
    private String postal_code;
    private String formatted;
    @JsonProperty("Components")
    private List<AddressComponent> components;
}

@Data
@NoArgsConstructor
class AddressComponent {
    private String kind;
    private String name;
}