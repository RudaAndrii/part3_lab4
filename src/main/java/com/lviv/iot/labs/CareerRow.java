package com.lviv.iot.labs;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CareerRow {
    private List<CareerPoint> values;
    public CareerRow() {
        values = new ArrayList<>();
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
