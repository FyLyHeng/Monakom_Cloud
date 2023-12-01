package com.example.monakom_cloud.payment_gateway.model;

import com.example.monakom_cloud.core.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company extends BaseEntity {

    @Id
    public UUID id = UUID.randomUUID();
    public String name;
}
