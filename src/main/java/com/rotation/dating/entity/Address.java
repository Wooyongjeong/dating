package com.rotation.dating.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Getter
public class Address {

    @Column(nullable = false, length = 20)
    private String province; // 시/도

    @Column(nullable = false, length = 20)
    private String cityDistrict; // 시/군/구

    @Column(nullable = false, length = 50)
    private String roadName; // 도로명

    @Column(nullable = false, length = 100)
    private String detail; // 상세주소

    @Column(nullable = false, length = 5)
    private String postalCode; // 우편번호

    @Builder
    public Address(String province, String cityDistrict, String roadName, String detail, String postalCode) {
        this.province = province;
        this.cityDistrict = cityDistrict;
        this.roadName = roadName;
        this.detail = detail;
        this.postalCode = postalCode;
    }

}
