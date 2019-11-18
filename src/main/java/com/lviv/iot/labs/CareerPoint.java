package com.lviv.iot.labs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CareerPoint {
    private Integer value;
    private Integer maxValue;

    public CareerPoint(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString() + " (max - " + this.getMaxValue() + ")";
    }
}
