package org.carRental.model;

import lombok.*;
import org.carRental.model.types.Availability;
import org.carRental.model.types.CarCategory;

@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class Car {
    @Getter @Setter
    private Integer id;
    @NonNull @Getter @Setter
    private String brand;
    @NonNull @Getter @Setter
    private String model;
    @NonNull @Getter @Setter
    private String vin;
    @NonNull @Getter @Setter
    private CarCategory carClass;
    @NonNull @Getter @Setter
    private Availability availability;

}
