package com.lviv.iot.labs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
@Setter
public class CareerTree {
    private Integer height;
    private List<CareerHorizontal> careerVertical;

    public CareerTree(Integer height) {
        this.height = height;
        careerVertical = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        careerVertical.forEach(careerVertical -> str.append(careerVertical.toString()).append("\n"));
        return str.toString();
    }

    public Integer getMaxCareerValueForNodes() {
        for (int row = 0; row < height; row++) {
            int rowLength = careerVertical.get(row).getValues().size();

            for(int i = 0; i < rowLength; i++) {
                if (row == 0) {
                    CareerPoint careerPoint = careerVertical.get(row).getValues().get(i);
                    careerPoint.setMaxValue(careerPoint.getValue());
                    careerVertical.get(row).getValues().set(i, careerPoint);
                } else {
                    CareerPoint careerPoint = careerVertical.get(row).getValues().get(i);
                    if (i == 0) {
                        CareerPoint parentPoint = careerVertical.get(row - 1).getValues().get(i);
                        careerPoint.setMaxValue(parentPoint.getMaxValue() + careerPoint.getValue());
                    } else if (i == rowLength - 1) {
                        CareerPoint parentPoint = careerVertical.get(row - 1).getValues().get(i - 1);
                        careerPoint.setMaxValue(parentPoint.getMaxValue() + careerPoint.getValue());
                    } else {
                        CareerPoint leftParentPoint = careerVertical.get(row - 1).getValues().get(i - 1);
                        CareerPoint rightParentPoint = careerVertical.get(row - 1).getValues().get(i);
                        careerPoint.setMaxValue(Math.max(leftParentPoint.getMaxValue(), rightParentPoint.getMaxValue()) + careerPoint.getValue());
                    }
                }
            }
        }
        return careerVertical.get(careerVertical.size() - 1).getValues()
                .stream().max(Comparator.comparingInt(CareerPoint::getMaxValue)).get().getMaxValue();
    }
}
