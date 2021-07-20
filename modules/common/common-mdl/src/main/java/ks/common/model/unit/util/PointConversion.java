package ks.common.model.unit.util;

import ks.common.model.unit.Formation;
import ks.common.model.unit.UnitType;

public class PointConversion {
    public int convertPointsToMen(UnitType unitType, Formation formation, int points){
        switch (unitType){
            case INFANTRY:{
                if (formation == Formation.LINE){
                    // 3 points == 10 men
                    int numTriplePoints = (int) Math.ceil(points / 3);
                    return numTriplePoints * 10;
                }
                else if (formation == Formation.SQUARE){
                    // 1 point == 5 men
                    return points * 5;
                }
                else if (formation == Formation.SKIRMISH){
                    // 2 points == 3 men
                    int numDoublePoints = (int) Math.ceil(points / 2);
                    return numDoublePoints * 3;
                }
                break;
            }
            case CAVALRY:{
                if (formation == Formation.LINE || formation == Formation.COLUMN){
                    // 2 points == 3 riders
                    int numDoublePoints = (int) Math.ceil(points / 2);
                    return numDoublePoints * 3;
                }
            }
            case ARTILLERY:{
                // 12.5 points == 1 gun
                int numGroupedPoints = (int) Math.ceil(points / 12.5);
                return numGroupedPoints;
            }
        }
        return 0;
    }

    private PointConversion(){}
}
