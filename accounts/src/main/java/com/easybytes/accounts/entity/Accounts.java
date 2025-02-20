package com.easybytes.accounts.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Accounts extends BaseEntity{

    @Column
    private Long customerId;

    @Id
    @Column
    private Long accountNumber;

    @Column
    private String accountType;

    @Column
    private String branchAddress;

}
