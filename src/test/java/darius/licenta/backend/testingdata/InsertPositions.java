package darius.licenta.backend.testingdata;

import darius.licenta.backend.service.position.PositionService;

public class InsertPositions {
    public static void InsertPositions(PositionService positionService) {
        positionService.insert(Positions.position1);
        positionService.insert(Positions.position2);
        positionService.insert(Positions.position3);
        positionService.insert(Positions.position4);
        positionService.insert(Positions.position5);

    }
}
