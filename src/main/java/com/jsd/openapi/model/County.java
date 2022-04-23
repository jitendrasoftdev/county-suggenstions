package com.jsd.openapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "COUNTY")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class County {
    /**
     * Checking fips is not null or empty and should not be greater than 5 digits long.
     */
    @Id
    //@Pattern(regexp = "^\\d{5}$", message = "invalid fips should be 5 digits long.")
    private Integer fips;

    @NotBlank(message = "State shouldn't null or empty.")
    private String state;

    @NotBlank(message = "Name shouldn't null or empty.")
    private String name;
}
