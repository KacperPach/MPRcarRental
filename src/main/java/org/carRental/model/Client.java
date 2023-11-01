package org.carRental.model;

import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class Client {
    @Getter @Setter
    private Integer id;
    @NonNull @Getter @Setter
    private String name;
    @NonNull @Getter @Setter
    private Integer rentedCarId; // one car per client
}
