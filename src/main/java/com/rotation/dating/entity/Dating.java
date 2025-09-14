package com.rotation.dating.entity;

import com.rotation.dating.global.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "datings")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Dating extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Setter
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "dating_criteria_id", nullable = false)
    private DatingCriteria datingCriteria;

    @Embedded
    private Address address;

    @Column(nullable = false)
    private LocalDateTime meetingDateTime;

    @Builder
    private Dating(String title, String content, Member member, DatingCriteria datingCriteria, Address address, LocalDateTime meetingDateTime) {
        this.title = title;
        this.content = content;
        this.member = member;
        this.datingCriteria = datingCriteria;
        this.address = address;
        this.meetingDateTime = meetingDateTime;
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateContent(String content) {
        this.content = content;
    }

    public void updateAddress(Address address) {
        this.address = address;
    }
}
