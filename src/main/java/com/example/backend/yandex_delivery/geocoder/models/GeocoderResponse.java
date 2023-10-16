package com.example.backend.yandex_delivery.geocoder.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocoderResponse {
    private Response response;
}

@Data
@NoArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
class Response {
    @JsonProperty("GeoObjectCollection")
    private GeoObjectCollection geoObjectCollection;
}

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class GeoObjectCollection {
    private MetaDataProperty metaDataProperty;
//    private GeoObject[] featureMember;
//private List<FeatureMember> featureMember;
}

@Data
@SuperBuilder
@NoArgsConstructor
class MetaDataProperty {
    @JsonProperty("GeocoderResponseMetaData")
    private GeocoderResponseMetaData geocoderResponseMetaData;
   private List<FeatureMember> featureMember;
}

@Data
@SuperBuilder
@NoArgsConstructor
class GeocoderResponseMetaData {
    private String request;
    private String found;
    private String results;
}


@Data
@SuperBuilder
@NoArgsConstructor
class FeatureMember {
    @JsonProperty("GeoObject")
    private GeoObject geoObject;
}

@Data
@SuperBuilder
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class GeoObject {
    private GeocoderMetaData metaDataProperty;
    private String description;
    private String name;
    private BoundedBy boundedBy;
    private Point Point;
}

@Data
@SuperBuilder
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class Point {
    private String pos;
}

@Data
@SuperBuilder
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class BoundedBy {
    private Envelope Envelope;
}

@Data
@SuperBuilder
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class Envelope {
    private String lowerCorner;
    private String upperCorner;
}


@Data
@SuperBuilder
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class GeocoderMetaData {
    private String kind;
    private String text;
    private String precision;
    private Address Address;
}

@Data
@SuperBuilder
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class Address {
    private String country_code;
    private String postal_code;
    private String formatted;
    private List<AddressComponent> Components;
}

@Data
@SuperBuilder
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class AddressComponent {
    private String kind;
    private String name;
}



/*
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class GeoObject {
    private String name;
    private String description;
    private BoundedBy boundedBy;
    private Point Point;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BoundedBy getBoundedBy() {
        return boundedBy;
    }

    public void setBoundedBy(BoundedBy boundedBy) {
        this.boundedBy = boundedBy;
    }

    public Point getPoint() {
        return Point;
    }

    public void setPoint(Point Point) {
        this.Point = Point;
    }
}

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class BoundedBy {
    private Envelope Envelope;

    public Envelope getEnvelope() {
        return Envelope;
    }

    public void setEnvelope(Envelope Envelope) {
        this.Envelope = Envelope;
    }
}

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class Envelope {
    private String lowerCorner;
    private String upperCorner;

    public String getLowerCorner() {
        return lowerCorner;
    }

    public void setLowerCorner(String lowerCorner) {
        this.lowerCorner = lowerCorner;
    }

    public String getUpperCorner() {
        return upperCorner;
    }

    public void setUpperCorner(String upperCorner) {
        this.upperCorner = upperCorner;
    }
}

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class Point {
    private String pos;

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

 */

