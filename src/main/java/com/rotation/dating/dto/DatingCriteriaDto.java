package com.rotation.dating.dto;

import com.rotation.dating.entity.DatingCriteria;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DatingCriteriaDto {

    private Integer maleMinAge;
    private Integer maleMaxAge;
    private Integer maleEntryFee;
    private Integer maleMaxCount;
    private Integer maleCurrentCount;
    private Integer femaleMinAge;
    private Integer femaleMaxAge;
    private Integer femaleEntryFee;
    private Integer femaleMaxCount;
    private Integer femaleCurrentCount;

    public DatingCriteria toEntity() {
        return DatingCriteria.builder()
                .maleMinAge(maleMinAge)
                .maleMaxAge(maleMaxAge)
                .maleEntryFee(maleEntryFee)
                .maleMaxCount(maleMaxCount)
                .maleCurrentCount(maleCurrentCount)
                .femaleMinAge(femaleMinAge)
                .femaleMaxAge(femaleMaxAge)
                .femaleEntryFee(femaleEntryFee)
                .femaleMaxCount(femaleMaxCount)
                .femaleCurrentCount(femaleCurrentCount)
                .build();
    }

}
