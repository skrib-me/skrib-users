package me.skrib.users.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "preferences")
@Builder(builderMethodName = "pref")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@user")
public class Preferences {

    @Id
    private Long idUser;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    private Long rayon;
}
