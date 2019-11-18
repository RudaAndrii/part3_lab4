package com.lviv.iot.labs;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
@Setter
public class CareerTree {
    private Integer height;
    private List<CareerRow> careerVertical;

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
        for (int rowIndex = 0; rowIndex < height; rowIndex++) {
            int rowLength = careerVertical.get(rowIndex).getValues().size();

            for(int pointIndex = 0; pointIndex < rowLength; pointIndex++) {
                if (rowIndex == 0) {
                    CareerPoint careerPoint = careerVertical.get(rowIndex).getValues().get(pointIndex);
                    careerPoint.setMaxValue(careerPoint.getValue());
                    careerVertical.get(rowIndex).getValues().set(pointIndex, careerPoint);
                } else {
                    CareerPoint careerPoint = careerVertical.get(rowIndex).getValues().get(pointIndex);
                    if (pointIndex == 0) {
                        CareerPoint parentPoint = careerVertical.get(rowIndex - 1).getValues().get(pointIndex);

                        careerPoint.setMaxValue(parentPoint.getMaxValue() + careerPoint.getValue());
                    } else if (pointIndex == rowLength - 1) {
                        CareerPoint parentPoint = careerVertical.get(rowIndex - 1).getValues().get(pointIndex - 1);

                        careerPoint.setMaxValue(parentPoint.getMaxValue() + careerPoint.getValue());
                    } else {
                        CareerPoint leftParentPoint = careerVertical.get(rowIndex - 1).getValues().get(pointIndex - 1);
                        CareerPoint rightParentPoint = careerVertical.get(rowIndex - 1).getValues().get(pointIndex);

                        careerPoint.setMaxValue(Math.max(leftParentPoint.getMaxValue(), rightParentPoint.getMaxValue()) + careerPoint.getValue());
                    }
                }
            }
        }
        return careerVertical.get(careerVertical.size() - 1).getValues()
                .stream().max(Comparator.comparingInt(CareerPoint::getMaxValue)).get().getMaxValue();
    }
}
