package com.bmh.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SommeNatureDTO {
    private Long Alimentaires;
    private Long Publics;
    private Long Touristiques;
}
