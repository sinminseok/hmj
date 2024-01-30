package com.comumu.hmj.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Authority {

    @Id
    @Column(name = "authority_id")
    private Long id;

    private String name;

}
