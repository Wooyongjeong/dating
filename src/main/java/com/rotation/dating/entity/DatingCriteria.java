package com.rotation.dating.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Getter
public class DatingCriteria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "datingCriteria")
    @JoinColumn(name = "dating_id", nullable = false)
    private Dating dating;

    @Column(nullable = false)
    private Integer maleMinAge;

    @Column(nullable = false)
    private Integer maleMaxAge;

    @Column(nullable = false)
    private Integer maleEntryFee;

    @Column(nullable = false)
    private Integer maleMaxCount;

    @Column(nullable = false)
    private Integer maleCurrentCount;

    @Column(nullable = false)
    private Integer femaleMinAge;

    @Column(nullable = false)
    private Integer femaleMaxAge;

    @Column(nullable = false)
    private Integer femaleEntryFee;

    @Column(nullable = false)
    private Integer femaleMaxCount;

    @Column(nullable = false)
    private Integer femaleCurrentCount;

    @Builder
    private DatingCriteria(Dating dating, Integer maleMinAge, Integer maleMaxAge, Integer maleEntryFee, Integer maleMaxCount, Integer maleCurrentCount, Integer femaleMinAge, Integer femaleMaxAge, Integer femaleEntryFee, Integer femaleMaxCount, Integer femaleCurrentCount) {
        this.dating = dating;
        this.maleMinAge = maleMinAge;
        this.maleMaxAge = maleMaxAge;
        this.maleEntryFee = maleEntryFee;
        this.maleMaxCount = maleMaxCount;
        this.maleCurrentCount = maleCurrentCount;
        this.femaleMinAge = femaleMinAge;
        this.femaleMaxAge = femaleMaxAge;
        this.femaleEntryFee = femaleEntryFee;
        this.femaleMaxCount = femaleMaxCount;
        this.femaleCurrentCount = femaleCurrentCount;
    }

    public void updateMaleAge(Integer minAge, Integer maxAge) {
        this.maleMinAge = minAge;
        this.maleMaxAge = maxAge;
    }

    public void updateMaleEntryFee(Integer entryFee) {
        this.maleEntryFee = entryFee;
    }

    public void updateMaleMaxCount(Integer maxCount) {
        this.maleMaxCount = maxCount;
    }

    public void updateMaleCurrentCount(Integer currentCount) {
        this.maleCurrentCount = currentCount;
    }

    public void updateFemaleAge(Integer minAge, Integer maxAge) {
        this.femaleMinAge = minAge;
        this.femaleMaxAge = maxAge;
    }

    public void updateFemaleEntryFee(Integer entryFee) {
        this.femaleEntryFee = entryFee;
    }

    public void updateFemaleMaxCount(Integer maxCount) {
        this.femaleMaxCount = maxCount;
    }

    public void updateFemaleCurrentCount(Integer currentCount) {
        this.femaleCurrentCount = currentCount;
    }

    public void setDating(Dating dating) {
        this.dating = dating;
        dating.setDatingCriteria(this);
    }
}
