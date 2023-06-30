package com.evolServices.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "clients")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Client {

    /**
     * Id of the client
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;

    /**
     * Name of the client
     */
    @Column
    @NotNull
    public String name;

    /**
     * RUT of the client
     */
    @Column
    @NotNull
    public String rut;

    /**
     * Business name of the client. In Chile, it's called razón social
     */
    @Column
    @NotNull
    public String businessName;

    /**
     * Date of initiation of activities
     */
    @Column
    @NotNull
    public Date startDate;
}
