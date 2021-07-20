package ks.common.model.unit.util;

import ks.common.model.unit.Formation;
import ks.common.model.unit.Unit;
import ks.common.model.unit.UnitSize;
import ks.common.model.unit.UnitType;
import ks.common.util.CommonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 3.1. Infantry Fire
 * In most cases the terrain has almost no influence on infantry fire. Here we give an advantage to marksmen in the skirmish line who are under cover, and who are consequently able to take aim
 * with more care and less agitation.
 *
 * 3.1.1 Using the Infantry Fire Table
 * To calculate fire from an infantry unit roll a six sided dice and cross reference the result with the type of unit firing and the range. This will indicate the losses, expressed in points, inflicted on the
 * target unit. For larger or smaller units than those specified adjust the casualties inflicted on a pro rata basis. For example, for a full battalion firing double the casualties that would have been
 * inflicted by a half battalion Infantry Fire Table
 *
 * 3.1.2 Target Under Cover
 * The effect of all fire-arms will be less against troops under cover. Infantry occupying outskirts of woods, villages, town walls, embankments and ditches to defend them suffer half the losses from
 * infantry fire.  When troops are taking cover and not defending behind woods 200 paces wide, villages, towns and high embankments, there will be no losses from infantry fire.
 * Example
 * A battalion of Red infantry has deployed its normal complement of four skirmish Zugs which are now
in an open field engaging Blue’s skirmishers at a range of 150 paces. They roll 4 on the die, resulting
in 17 points of hits on the target; however there are four Zugs so this is doubled to 34 points. As their
enemy are in skirmish formation 3 men equate to two points, resulting in a total of 51 casualties.
Had the target been a battalion in three lines then this would have risen to 170 men, with one point
being 5 men to reflect a denser target.
 */
public class InfantryFireTable {

    /**
     * Get the number of point casualties from an infantry unit firing
     * @return
     */
    public int getResult(List<Unit> attackers, int rangePaces, boolean hasCover) {
        UnitSize totalSize = null;
        int casualtyPoints = 0;
        List<Unit> skirmishZugs = new ArrayList<>();
        for (Unit attacker : attackers) {
            switch (attacker.getSize()) {
                case HALF_BATTALION:
                    casualtyPoints += getHalfBattalionResult(rangePaces);
                    break;
                case COMPANY: {
                    int pts = getHalfBattalionResult(rangePaces) / 2;
                    casualtyPoints += pts;
                    break;
                }
                case ZUG: {
                    if (attacker.getFormation() == Formation.SKIRMISH){
                        skirmishZugs.add(attacker);
                    }
                    else {
                        int pts = getHalfBattalionResult(rangePaces) / 4;
                        casualtyPoints += pts;
                    }
                    break;
                }
            }
        }
        if (!skirmishZugs.isEmpty()){
            int numTwoZugs = skirmishZugs.size() / 2;
            for (int i = 0; i < numTwoZugs; ++i){
                int pts = getTwoZugResult(skirmishZugs.get(i), rangePaces, hasCover);
                casualtyPoints += pts;
            }
        }
        return casualtyPoints;
    }

    public int getHalfBattalionResult(int rangePaces){
        int roll = CommonUtil.roll();
        if (rangePaces < 100){
            switch (roll){
                case 1:
                case 2:
                    return 30;
                case 3:
                    return 15;
                case 4:
                    return 40;
                case 5:
                    return 60;
                case 6:
                    return 10;
            }
        }
        else if (rangePaces < 200){
            switch (roll){
                case 1:
                case 2:
                    return 20;
                case 3:
                    return 10;
                case 4:
                    return 25;
                case 5:
                    return 50;
                case 6:
                    return 6;
            }
        }
        else if (rangePaces < 300){
            switch (roll){
                case 1:
                case 2:
                    return 10;
                case 3:
                    return 4;
                case 4:
                    return 12;
                case 5:
                    return 25;
                case 6:
                    return 3;
            }
        }
        else {
            switch (roll){
                case 1:
                case 2:
                    return 4;
                case 3:
                    return 2;
                case 4:
                    return 6;
                case 5:
                    return 12;
                case 6:
                    return 3;
            }
        }
        return 0;
    }


    public int getTwoZugResult(Unit unit, int rangePaces, boolean hasCover){
        int roll = CommonUtil.roll();
        if (hasCover && unit.getFormation() == Formation.SKIRMISH){
            if (unit.getUnitSubType() == UnitType.INFANTRY_JAGER){
                if (rangePaces < 100) {
                    switch (roll) {
                        case 1:
                        case 2:
                            return 20;
                        case 3:
                        case 4:
                            return 40;
                        case 5:
                            return 60;
                        case 6:
                            return 20;
                    }
                } else if (rangePaces < 200) {
                    switch (roll) {
                        case 1:
                        case 2:
                            return 10;
                        case 3:
                        case 4:
                            return 25;
                        case 5:
                            return 40;
                        case 6:
                            return 10;
                    }
                } else if (rangePaces < 300) {
                    switch (roll) {
                        case 1:
                        case 2:
                            return 5;
                        case 3:
                        case 4:
                            return 15;
                        case 5:
                            return 25;
                        case 6:
                            return 5;
                    }
                } else {
                    switch (roll) {
                        case 1:
                        case 2:
                            return 3;
                        case 3:
                        case 4:
                            return 8;
                        case 5:
                            return 12;
                        case 6:
                            return 3;
                    }
                }
            }
            else {
                if (rangePaces < 100) {
                    switch (roll) {
                        case 1:
                        case 2:
                            return 25;
                        case 3:
                        case 4:
                            return 30;
                        case 5:
                            return 50;
                        case 6:
                            return 25;
                    }
                } else if (rangePaces < 200) {
                    switch (roll) {
                        case 1:
                        case 2:
                            return 5;
                        case 3:
                        case 4:
                            return 20;
                        case 5:
                            return 30;
                        case 6:
                            return 5;
                    }
                } else if (rangePaces < 300) {
                    switch (roll) {
                        case 1:
                        case 2:
                            return 3;
                        case 3:
                        case 4:
                            return 10;
                        case 5:
                            return 20;
                        case 6:
                            return 3;
                    }
                } else {
                    switch (roll) {
                        case 1:
                        case 2:
                            return 1;
                        case 3:
                        case 4:
                            return 6;
                        case 5:
                            return 10;
                        case 6:
                            return 1;
                    }
                }
            }
        }
        else { // no cover
            if (rangePaces < 100) {
                switch (roll) {
                    case 1:
                    case 2:
                        return 25;
                    case 3:
                        return 10;
                    case 4:
                        return 30;
                    case 5:
                        return 50;
                    case 6:
                        return 7;
                }
            } else if (rangePaces < 200) {
                switch (roll) {
                    case 1:
                    case 2:
                        return 15;
                    case 3:
                        return 6;
                    case 4:
                        return 17;
                    case 5:
                        return 34;
                    case 6:
                        return 4;
                }
            } else if (rangePaces < 300) {
                switch (roll) {
                    case 1:
                    case 2:
                        return 8;
                    case 3:
                        return 2;
                    case 4:
                        return 8;
                    case 5:
                        return 16;
                    case 6:
                        return 2;
                }
            } else {
                switch (roll) {
                    case 1:
                        return 2;
                    case 2:
                        return 5;
                    case 3:
                        return 1;
                    case 4:
                        return 4;
                    case 5:
                        return 8;
                    case 6:
                        return 2;
                }
            }
        }
        return 0;
    }

    private InfantryFireTable(){}
}
