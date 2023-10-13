package com.example.backend.yandex_delivery.geocoder;


    import com.example.backend.yandex_delivery.geocoder.models.GeoObjectResponse;
    import com.example.backend.yandex_delivery.geocoder.models.Response;
    import com.fasterxml.jackson.databind.ObjectMapper;

    public class JsonToObjectConverter {

        public static Response convertJsonToGeoObject(String jsonString) {
            try {

                ObjectMapper objectMapper = new ObjectMapper();


                Response geoObjectResponse = objectMapper.readValue(jsonString, Response.class);

                return geoObjectResponse;
            } catch (Exception e) {
                e.printStackTrace();
                return null; // Обработка ошибок, например, если JSON неверно сформирован
            }
        }

    }


