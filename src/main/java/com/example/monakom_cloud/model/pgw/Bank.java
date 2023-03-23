package com.example.monakom_cloud.model.pgw;

import com.example.monakom_cloud.model.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bank extends BaseEntity {

//    var id: UUID = UUID.randomUUID(),
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
