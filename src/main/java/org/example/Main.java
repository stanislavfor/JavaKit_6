package org.example;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) {

        int simulationNumber = 1000;
        Map<Integer, Boolean> total = new HashMap<>();
        MontyHall.GameResult result = MontyHall.simulateMontyHall(simulationNumber, total);

        DescriptiveStatistics stats = new DescriptiveStatistics();
        stats.addValue(result.getStayWithWin());
        stats.addValue(result.getSwitchWithWin());

        System.out.println("Парадокс Монти Холла (Monty Hall's Paradox)");
        System.out.println("Количество игр (всего) : " + simulationNumber);
        System.out.println("Выигранные игры : " + result.getStayWithWin() + " (" + (result.getStayWithWin() * 100.0 / simulationNumber) + "%)");
        System.out.println("Выигранные после замены выбора : " + result.getSwitchWithWin() + " (" + (result.getSwitchWithWin() * 100.0 / simulationNumber) + "%)");

    }

}