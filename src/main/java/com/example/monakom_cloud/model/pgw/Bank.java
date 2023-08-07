package com.example.monakom_cloud.model.pgw;

import com.example.monakom_cloud.core.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bank extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
//    var bankName : String = "",
//    var bankCode : String? = "",
//    var host : String? = "",
//    var requestQRUrl : String? = "",
//    var callBackUrl : String? = "",
//    var verifyUrl : String? = "",
//    var cancel : String? = "",
//    var refund : String? = "",
//    var merchantRdn : String? = "",
//    var requestSession : String? = "",
//    var callBackDuration : Long?=0

    public String bankName;
}
