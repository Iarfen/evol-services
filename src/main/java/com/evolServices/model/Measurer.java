package com.evolServices.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "measurers")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Measurer {

    /**
     * Id of the measurer
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;

    /**
     * Physical address of the measurer
     */
    @Column
    @NotNull
    public String physicalAddress;

    /**
     * Installation number of the measurer
     */
    @Column
    @NotNull
    public String installationNumber;

    /**
     * EVOL_ID of the measurer
     */
    @Column
    @NotNull
    public String evolId;
}
