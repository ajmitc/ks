package ks.common.model.unit.util;

import ks.common.model.unit.Unit;
import ks.common.util.CommonUtil;

/**
 * 3.2. Artillery Fire
 * 3.2.1 Good & Bad Effect
 * The effect of artillery fire will depend on whether it is at good or bad effect. This will largely depend on the terrain, as follows:
 * Good effect covers the following:
 * - Canister Shot at Point blank range and low elevation. When the ground between the battery and the target is even, with no slope up or down more than 10°.
 * - High Elevation Range. When the battery has a clear view for 200 paces before or behind the target.
 * - Random or Ricochet Shot: Same as for canister shot
 *
 * Bad Effect will cover the following:
 * - Canister Shot at Point blank range and low elevation. When the ground between the battery and the target is swampy, marshy, full of hedges, broken or undulating, or has a
 *   slope up or down of more then 10°.
 * - High Elevation Range. When the ground between the battery and the target is swampy or marshy, when the terrain between the battery and the target rises or falls more than 20°,
 *   and when there is not a clear view of the target.
 * - Random or Ricochet Shot: Same as for canister shot.
 *
 * 3.2.2 Using the Artillery Fire Table
 * To calculate fire from an artillery battery roll a die and cross reference the result with the type of battery firing and the range. This will indicate the losses, expressed in points, inflicted on the
 * target unit. For larger or smaller units than those specified, adjust the casualties inflicted on a pro rata basis. For example, for a half battery firing halve the casualties that would have been
 * inflicted by a full battery Artillery Fire Table
 *
 * 3.2.3 Target Under Cover
 * The effect of all fire-arms will be less against troops under cover. Infantry occupying outskirts of woods, villages, town walls, embankments and ditches to defend them suffer half the losses from
 * canister fire or one third the loss from cannon ball and howitzer fire.  When troops are taking cover and not defending behind woods 200 paces wide, villages, towns and
 * high embankments, there will be no losses from cannon ball or howitzer. They will suffer casualties from howitzer fire only when the battery knows of their location, and then at one third
 * the normal rate.
 *
 * 3.2.4 Adjustments to the Basic Artillery Fire Results
There are, of course, a multitude of circumstances that will affect this basic result and need to be
considered by the umpire. Some general guidelines are as follows:
Artillery Fire Against Columns & Second Lines
a) Cannon fire against columns of two battalions or more, squadrons or batteries. Add 25%
effect.
b) Grenade Fire from Howitzers. Add 33% effect.
c) When the target is two or more lines in the same range category. Add 25% effect.
d) Skirmishers when they are not more than 100 paces from their supporting line. Add 25%
effect.
Artillery Fire Against Flanks
Artillery fire, both cannon ball and howitzer grenade, will add 25% effect when firing against flanks
of troops.

3.2.5 The Morale Effect of Artillery
An attack which has been prepared with canister shot to ‘Good Effect’, without the battery itself
coming under similar fire promises certain advantages.
It cannot be assumed that the troops will remain still for long under effective canister fire or low
elevation range fire without either going forwards or back. There can be very few exceptions to
this.
If, therefore, a half battery is firing against 1 battalion or two squadrons in canister range, under
conditions which will give good effect, and without itself coming under canister fire from an enemy
battery, Die 2 is rolled after each move to the advantage of the battery to decide whether they
troops can remain in position or retire.
If the dice decides against them the troops must retire without any other penalty apart from the
losses from artillery fire.
If the dice falls in favour of the target they can choose to stay where they are or to advance,
whereupon Die 2 will be used again in the next turn with the same implications.
We would, therefore, avoid any unintentional advances or halts under enemy canister fire. If an
attack is to be seriously undertaken against an enemy line that has been strengthened by artillery,
we would combine the attack with our own artillery fire, so that part of the artillery would occupy
Example
A Red battery of 6 pounder guns fires at a blue infantry battalion. The target has deployed its
normal complement of skirmishers so the main body is now two ranks deep. The range is 700 paces,
which from the artillery ruler we can see is the right range for Large Canister to be fired. The
target is clearly in view and with the ground being reasonably flat the fire is considered to be at
Good Effect.
The umpire rolls a die resulting in a 4. This results in 6 points of damage. On a two rank body of
formed troops this equates to twenty casualties as each three points is 10 men.

the enemy guns while the other part would, for at least one or two moves before the attack, direct
canister fire at the enemy line.
Those battalions or squadrons which receive canister fire from artillery in the course of their
advance will be at a disadvantage in the ensuing attack in that they will use a Die to their
disadvantage - Die 2 instead of 1, 3 instead of 2 &c. (i.e. they lose one Index Point, see section
4.1.2).
Example
In the last example we saw a Blue battalion under artillery fire. Although casualties were light
Reisswitz notes troops will not stand under artillery fire indefinitely. It is therefore necessary to also
roll a die against Die Two, with the odds 3:2 in favour of the battery, to see if Blue retires under fire.
If the die indicates a white circle then the infantry battalion is obliged to withdraw 250 paces in the
next turn. If the dice indicates a black circle then the infantry may hold their ground or advance as
desired in the next turn.
 */
public class ArtilleryFireTable {
    public static int getResult(Unit attacker, int rangePaces, boolean isGoodEffect){
        switch (attacker.getUnitSubType()){
            case BATTERY_12_POUNDER:
                return get12PounderResults(rangePaces, isGoodEffect);
            case BATTERY_6_POUNDER:
                return get6PounderResults(rangePaces, isGoodEffect);
            case BATTERY_7_POUNDER_HOWITZER:
                break;
            case DOUBLE_10_POUNDER_HOWITZERS:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + attacker.getUnitSubType());
        }
        return 0;
    }

    public static int get12PounderResults(int rangePaces, boolean isGoodEffect){
        int roll = CommonUtil.roll();
        if (rangePaces < 500){
            if (isGoodEffect){
                switch (roll){
                    case 1:
                    case 2:
                        return 50;
                    case 3:
                    case 5:
                        return 25;
                    case 4:
                        return 38;
                    case 6:
                        return 71;
                }
            }
            else {
                switch (roll){
                    case 1:
                    case 2:
                        return 31;
                    case 3:
                        return 37;
                    case 4:
                        return 25;
                    case 5:
                    case 6:
                        return 15;
                }
            }
        }
        else if (rangePaces < 1000){
            if (isGoodEffect){
                switch (roll){
                    case 1:
                    case 2:
                        return 31;
                    case 3:
                        return 13;
                    case 4:
                        return 25;
                    case 5:
                        return 19;
                    case 6:
                        return 50;
                }
            }
            else {
                switch (roll){
                    case 1:
                    case 2:
                        return 20;
                    case 3:
                        return 25;
                    case 4:
                        return 18;
                    case 5:
                    case 6:
                        return 10;
                }
            }
        }
        else if (rangePaces < 1500){
            if (isGoodEffect){
                switch (roll){
                    case 1:
                    case 2:
                        return 13;
                    case 3:
                        return 8;
                    case 4:
                        return 10;
                    case 5:
                        return 8;
                    case 6:
                        return 22;
                }
            }
            else {
                switch (roll){
                    case 1:
                    case 2:
                        return 7;
                    case 3:
                        return 10;
                    case 4:
                        return 6;
                    case 5:
                    case 6:
                        return 5;
                }
            }
        }
        else if (rangePaces < 2000){
            if (isGoodEffect){
                switch (roll){
                    case 1:
                    case 2:
                        return 9;
                    case 3:
                    case 5:
                        return 6;
                    case 4:
                        return 8;
                    case 6:
                        return 12;
                }
            }
            else {
                switch (roll){
                    case 1:
                    case 2:
                        return 3;
                    case 3:
                        return 5;
                    case 4:
                        return 2;
                    case 5:
                        return 1;
                    case 6:
                        return 1;
                }
            }
        }
        return 0;
    }

    public static int get6PounderResults(int rangePaces, boolean isGoodEffect){
        int roll = CommonUtil.roll();
        if (rangePaces < 400){
            if (isGoodEffect){
                switch (roll){
                    case 1:
                    case 2:
                        return 40;
                    case 3:
                    case 5:
                        return 20;
                    case 4:
                        return 30;
                    case 6:
                        return 60;
                }
            }
            else {
                switch (roll){
                    case 1:
                    case 2:
                        return 25;
                    case 3:
                        return 30;
                    case 4:
                        return 20;
                    case 5:
                    case 6:
                        return 12;
                }
            }
        }
        else if (rangePaces < 800){
            if (isGoodEffect){
                switch (roll){
                    case 1:
                    case 2:
                        return 25;
                    case 3:
                        return 10;
                    case 4:
                        return 20;
                    case 5:
                        return 15;
                    case 6:
                        return 40;
                }
            }
            else {
                switch (roll){
                    case 1:
                    case 2:
                        return 16;
                    case 3:
                        return 20;
                    case 4:
                        return 15;
                    case 5:
                    case 6:
                        return 8;
                }
            }
        }
        else if (rangePaces < 1200){
            if (isGoodEffect){
                switch (roll){
                    case 1:
                    case 2:
                        return 10;
                    case 3:
                    case 5:
                        return 6;
                    case 4:
                        return 8;
                    case 6:
                        return 18;
                }
            }
            else {
                switch (roll){
                    case 1:
                    case 2:
                        return 6;
                    case 3:
                        return 8;
                    case 4:
                        return 5;
                    case 5:
                    case 6:
                        return 4;
                }
            }
        }
        else if (rangePaces < 1800){
            if (isGoodEffect){
                switch (roll){
                    case 1:
                    case 2:
                        return 7;
                    case 3:
                    case 5:
                        return 5;
                    case 4:
                        return 6;
                    case 6:
                        return 10;
                }
            }
            else {
                switch (roll){
                    case 1:
                    case 2:
                        return 3;
                    case 3:
                        return 5;
                    case 4:
                        return 4;
                    case 5:
                    case 6:
                        return 2;
                }
            }
        }
        return 0;
    }

    private ArtilleryFireTable(){}
}
