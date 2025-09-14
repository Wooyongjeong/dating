package com.rotation.dating.dto;

import com.rotation.dating.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDto {

    private String province; // 시/도
    private String cityDistrict; // 시/군/구
    private String roadName; // 도로명
    private String detail; // 상세주소
    private String postalCode; // 우편번호

    public Address toEntity() {
        return Address.builder()
                .province(province)
                .cityDistrict(cityDistrict)
                .roadName(roadName)
                .detail(detail)
                .postalCode(postalCode)
                .build();
    }
}
