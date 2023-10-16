package com.example.backend.yandex_delivery.geocoder;



    import com.example.backend.yandex_delivery.geocoder.models.GeocoderResponse;
    import com.fasterxml.jackson.core.JsonProcessingException;
    import com.fasterxml.jackson.databind.ObjectMapper;

    public class JsonToObjectConverter {



        public static GeocoderResponse convertJsonToGeoObject(String jsonString) {
            try {


                ObjectMapper objectMapper = new ObjectMapper();

                GeocoderResponse geoObjectResponse = objectMapper.readValue(jsonString, GeocoderResponse.class);

                return geoObjectResponse;
            } catch (Exception e) {
                e.printStackTrace();
                return null; // Обработка ошибок, например, если JSON неверно сформирован
            }
        }

        public static String convertToString(GeocoderResponse response) throws JsonProcessingException {
            ObjectMapper objectMapper = new ObjectMapper();
            String str = objectMapper.writeValueAsString(response);
            return str;
        }
    }


