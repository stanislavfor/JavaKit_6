package org.example;

import lombok.Data;
import java.util.Map;
import java.util.Random;

public class MontyHall {

    @Data
    static class GameResult {
        private int stayWithWin;
        private int switchWithWin;
    }

    static GameResult simulateMontyHall(int simulationNumber, Map<Integer, Boolean> total) {

        Random random = new Random();
        GameResult result = new GameResult();

        for (int i = 0; i < simulationNumber; i++) {
            int winningDoor = random.nextInt(3);
            int chosenDoor = random.nextInt(3);

            int openedDoor = random.nextInt(3);
            if (openedDoor == winningDoor || openedDoor == chosenDoor) {
                openedDoor = (openedDoor + 1) % 3;
                if (openedDoor == winningDoor || openedDoor == chosenDoor) {
                    openedDoor = (openedDoor + 1) % 3;
                }
            }

            int replacedDoor = random.nextInt(3);
            if (replacedDoor == chosenDoor || replacedDoor == openedDoor) {
                replacedDoor = (replacedDoor + 1) % 3;
                if (replacedDoor == chosenDoor || replacedDoor == openedDoor) {
                    replacedDoor = (replacedDoor + 1) % 3;
                }
            }

            if (chosenDoor == winningDoor) {
                result.setStayWithWin(result.getStayWithWin() + 1);
                total.put(i, false);
            } else if (replacedDoor == winningDoor) {
                result.setSwitchWithWin(result.getSwitchWithWin() + 1);
                total.put(i, true);
            }
        }

        return result;
    }

}
