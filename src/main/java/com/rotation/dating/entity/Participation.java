package com.rotation.dating.entity;

import com.rotation.dating.global.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "datings")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Participation extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dating_id", nullable = false)
    private Dating dating;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ParticipationStatus status;

    @Builder
    private Participation(Member member, Dating dating) {
        this.member = member;
        this.dating = dating;
        this.status = ParticipationStatus.PENDING; // 기본 상태는 PENDING
    }

    public void updateStatus(ParticipationStatus status) {
        this.status = status;
    }

}
