package com.lviv.iot.labs;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CareerHorizontal {
    private List<CareerPoint> values;
    public CareerHorizontal() {
        values = new ArrayList<>();
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
