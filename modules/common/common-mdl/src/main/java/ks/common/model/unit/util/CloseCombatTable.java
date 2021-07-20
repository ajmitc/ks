package ks.common.model.unit.util;

import ks.common.model.unit.Unit;

/**
 * This table is used to determine the results of close combat (bayonet attack or cavalry charge)
 *
 * Consider these issues:
 * 1) relative formations and arms of opposing forces
 * 2) numerical strengths involved
 * 3) troop quality, terrain, external influences
 *
 * Infantry Attacks
 * - Infantry Line attacked by Battalion Column: Die 1 for equal strength
 * - Infantry Line vs Infantry Line: Die 1 for equal strength
 *   - In both above cases, Repulsed die result is changed to Defeated
 * - Infantry in Line Attacked by Two or more Battalion Mass Columns for equal strength Die 2 with
 *   advantage to the battalion-mass will be used. If the attack does not succeed the column is
 *   ‘Defeated’ even if the Die gives ‘R’, and ‘Totally Defeated’ if the Die gives ‘D’ or ‘T’, and ‘Totally
 *   Defeated’ if, in any circumstances, they are pursued by cavalry whilst retreating.
 *
 * Cavalry Attacks
 * Cavalry Against an Infantry Battalion in Attack Column or Square
 *   Three or four squadrons without preparation, Die 2 (3:2)
 *   Two squadrons without preparation, Die 3, (2:1)
 *   One squadron without preparation, Die 5, (4:1)
 *   The above odds being to the advantage of the infantry. A larger number of squadrons only means that the attack can be renewed more often.
 *
 * Cavalry Against Two Battalions or More
 *   For six battalions attacked by twelve squadrons, as for one battalion attacked by two squadrons, the Die 3 is used – against the cavalry.
 *
 * Note that if the cavalry do not succeed against infantry they are not be counted as totally defeated, even if the Die gives ‘T’ in the circle, but only ‘Repulsed’. Close ordered cavalry must
 * have at least half their strength to hand, so they need two moves to pursue.  It is not necessary to push all twelve squadrons at the same time onto the Brigade-mass. They can
 * be used in waves to attack one after the other; indeed such a position will need many attack waves before the fight is over. Each wave uses the same Die 3.
 * Instead of twelve there are eight – Die 4
 * If only four squadrons – Die 5
 *
 * Cavalry Against an Infantry Line with Secure Flanks
 *   Three or four squadrons against one battalion, Die 3
 *   Two squadrons against one battalion, Die 4
 *   One squadron against one battalion, Die 5
 *
 * If the infantry are beaten by cavalry they are always to be counted as totally defeated. Defeated cavalry will be according to the dice.
 * If the infantry could be attacked in the flank they would be dealt with as in paragraph 3.2.6.
 *
 * Cavalry Against Cavalry – will use Die I for equal strength
 * Example:
 *   Two Blue cavalry squadrons attempt to charge home against a Red infantry battalion in attack column. No preparation has been made by artillery fire so Die 3 is chosen, with its odds of 2:1
 *   favouring the infantry. Were preparatory fire to have been undertaken then this would alter the odds in favour of the cavalry as will be covered in Step Two if loss of strength has been significant, and Step Three.
 *
 * 4.1.2 Step Two – Consideration of Numerical Strength
 * Once the basic Die has been identified then consult the table below to see how the numerical strength of the forces involved affect the odds. The Index Point Shift noted in the third column
 * refers to the shift in dice used if the odds to not considered equal in Stage One. Each Index Point shift changes the dice used in favour of one side or the other. For example where Die 2 is being
 * used an Index Point shift of +1 in favour of the attacker would mean Die 3 would be used, whereas a similar advantage to the defender would mean Die 1 was used.
 *
 * Strength Difference Die Odds Index Point Shift
 *   Equal forces to 1/6th difference Die 1 1:1 No shift
 *   Between 1/6th and 1⁄4 difference Die 2 3:2 +1
 *   Between 1⁄4 and 1⁄2 difference Die 3 2:1 +2
 *   Between 1⁄2 and 1 difference Die 4 3:1 +3
 *   Between 1 and 1 2/3rd difference Die 5 4:1 +4
 * If the difference in strength is greater than this the victory for the greater side – other things being equal – is considered a foregone conclusion and the weaker side loses.
 * Example:
 *   The two cavalry squadrons in our previous example fail miserably in their attempt to engage the enemy column, being driven off by firepower. Subsequently two more squadrons and a horse
 * battery are sent to deal with Red’s infantry. Their battery engages the attack column for several turns killing just over 200 men. This reduces the strength of the Red battalion by just less than a
 * quarter, and this is enough to see a +1 shift in Index Points in favour of the cavalry. Were they to charge now the dice used would be Dice 2 in favour of the infantry. But wait, we need to look at
 * Step Three before the final odds can be established.
 *
 * 4.1.3 Step Three – Circumstances, Quality & External Influences
 * With the odds now established for the relative formations, troop types and numerical strengths we
now need to consider the many factors that can influence an attack. Some of the major ones are
listed below in detail; however this list is by no means comprehensive. The umpire is responsible
to consider each attack individually, to view the terrain over which it is conducted, the freshness of
the units concerned, the relative qualities of the units involved and, once the complete picture is
considered, apply any shift in Index Points to adjust the final odds for the action.
4.1.3.1 Artillery Support in Attack and Defence
Artillery Support for Attack
If the defenders have been two moves under canister fire the attack will gain an Index Point.
Artillery Support in Defence
Those battalions or squadrons which receive canister fire from artillery in the course of their
advance will be at a disadvantage in the ensuing attack in that they will lose one Index Point.
4.1.3.2 Attacks on Flank & Rear
As a general rule each infantry battalion or cavalry squadron which is attacking in flank and rear
counts as double so far as determining odds is concerned. There are, however, circumstances that
we should consider to decide if this is appropriate.
A. Cavalry
Cavalry can be attacked in flank and rear if they remain standing or if in retreat they cannot get
away from a mêlée.
A flank and rear attack presumes a surprise or an envelopment, as otherwise the attacked side
would have already taken up another position or withdrawn.
If an envelopment is being attempted the troops should be so manoeuvred that they can cut
through the line of communication before the enemy can reach it.
B. Infantry
The infantry are only involved in these considerations if there is a flank attack against a deployed
line or column of route, and if the attacking cavalry are not more than 600 paces away when they
are making for the flank (attacking infantry not more than 300 paces away when making a flank
attack).
C. Artillery
Foot batteries attacking in the flank and rear by a half battalion or a half squadron are lost.
Horse artillery batteries that are attacked in the flank and rear by at least half a battalion or a
squadron are lost.
4.1.3.3 Influences of a Second Line
A. Influence on Cavalry
The suitable distance for the second line is between 400 and 800 paces behind the first. Cavalry
units conforming to these distances forming two lines gain the following advantages:
1. The first line cannot be attacked in the flank or rear, so the advantages noted in paragraph
3.2.6 are not given to the enemy. On the contrary, they only count those squadrons which
reach the front in the attack. If the enemy line extends far enough to a flank attack on the
second line then this modification will not count.
2. If the first, and after that the second line is beaten they will both only be counted as ‘R’,
Repulsed, even if the dice gives ‘D’ or ‘T’. Not until the first line is beaten for the second
time will they be treated strictly according to the losses and category as given on the dice.

40

3. If the first line, which has a reserve line, has beaten an enemy line which does not have a
reserve line within the qualifying distances, and the second line can take up the pursuit on
the next move the result will be decided by Dice 3 to the advantage of the reserve line. If
the enemy is beaten again, and if they can be followed on the next move, they will be
totally defeated or completely destroyed. If the enemy succeeds under these unfavourable
conditions they must stay one move to rally before making any further moves.
4. If cavalry in two lines are attacked by cavalry of superior strength but in only one line then
only the troops which will actually meet will be counted.
5. If the first of two cavalry lines is attacked by cavalry in one line which has roughly the same
number of squadrons as the cavalry in two lines, the cavalry in two lines can count half the
number of squadrons in the second line when assessing numerical strength.
6. If the second line is too close then not only will these advantages not be counted, but if the
first line is beaten it will take the second line with it in flight.
7. If the second line is too far back it will have no influence at all and the first line will be
treated as not having a second line.
B. Influence of a Second Line on Infantry
1. For infantry the second line should be 150 – 400 paces from the first.
2. If there is a second line within the above noted distance it gains the following advantage:
An attack against an enemy in one line will gain two Index Points, or Die 3 instead of Die 1,
&c.
3. If, in spite of this advantage, the side formed in two lines is beaten, the first line only will
be repulsed whatever result the dice gives.
If, both for cavalry and infantry, the two lines deployed as prescribed above the decision is made as
follows:
If the first line is defeated it will only be counted as ‘Repulsed’. If the second line is beaten on a
renewed attack it will be treated, as far as losses and time are concerned, according to the die.
For a third attack on a beaten line paragraph 3.3.11 should be consulted.
If one side deploys more than two lines there is no advantage apart from the possibility of making
renewed attacks.
A more or less equal strength is assumed in these notes. If numerical strength is not equal, or if
there is artillery presence &c., then the odds are modified accordingly by the umpire.
4.1.3.4 Attacks on Batteries
The storming and capture of a battery is possible. We must examine the circumstances of the
battery as below:
A. An isolated battery defended from front only
The battery is isolated, without support is unable to withdraw, and is limited in its defence to firing
forwards only.
1. If the terrain allows the spreading out of a whole battalion or two squadrons, in skirmish or
mounted skirmish order, which can attack from front and flank, the battery is lost.
2. If only a half battalion or one squadron are to hand – Die 3 against the artillery is used.
3. If less than a half battalion or one squadron are to hand – Die 2 against the artillery is used.
4. If the terrain is limited and does not allow for the spreading out of the troops to the flanks
there must be at least a half battalion or one squadron for each half battery.
As soon as they come within small canister shot range (point blank) Die 2 is used, against
the attackers. If the white circle falls the battery will be taken. If not the troops must
withdraw. See also paragraph 3.3.4 on advances under artillery fire.
B. An Isolated Battery Which Can Defend its Flank
The battery can defend its flanks with artillery fire.
1. If the terrain allows the spreading out of one battalion or two squadrons in skirmish order
Die 1 decides whether the battery will be taken.
2. If the terrain is limited then Die 3 will be used, with the advantage to the artillery

41

C. A Battery With Support
The battery is covered by troops who have been given the responsibility of defending it.
1. In this case the supports must be beaten at the same time, or before hand if the battery is
to be taken. In addition there will have to be a sufficient number of skirmishers to hand to
keep the battery occupied during the battle with the supports.
Before any attack on a battery the opponent must be asked whether the guns will stay or
whether they will withdraw.
If a battery has been in the possession of the enemy for four moves it will remain out of
action for the rest of the game. If it is reclaimed before the four moves are up it is only out
of action for 30 moves, or one hour.
Losses from artillery fire in these actions will be found from the dice as for normal ranged
fire.
4.1.3.5 Deployments Within Enemy Strike Distance
Lateral movements of cavalry within striking distance of enemy units will cause the loss of an Index
Point if they come under attack while carrying out the movement. Troop concentration or
deployment may come under attack while carrying out their movement.
If cavalry have come as close as 400 paces to enemy infantry when they are forced to move the
cavalry will gain an Index Point in an attack.
If infantry are 200 paces from enemy infantry who are changing to an attach formation from a
column with a narrower front, the first mentioned infantry will gain the advantage of an Index
Point in an ensuing attack.
Example One
A squadron of Red Cuirassiers is making an attack on a similar sized unit of Blue Uhlans. With equal
numbers our calculations start with Die 1, however the Cuirassiers are heavier cavalry than the
Uhlans so they gain an Index Point shift to Die 2. In their approach to the Blue lines the Cuirassiers
have been moving at the trot for some considerable time (20 minutes in fact) and as a result of this
exertion must be considered shaken. The consequent loss of an Index Point shifts the die back to
Die I. But in the final attack the Cuirassiers find themselves attacking downhill over a slope of 1 in
10, in excess of 5o. This results in a significant disadvantage, a loss of two Index Points, which
finally shifts the odds to Die 3 but with the advantage now to Blue.
Example Two
One battalion in open ground, without cover, with a half battery in support, is attacked by two
battalions without artillery. The numerical proportion of two against one would give Die 3 with
advantage to the two battalions, but the presence of artillery adds an index point to the one
battalion, so Die 2 will be used instead, although it can be assumed that the two battalions would
not be making for the battery but would be sending their main strength against the enemy battalion
while skirmishers were sent forwards to keep the battery occupied. If the half battery were with
the two battalions then they would gain a point and the odds would be 3:1, Die 4.

42

4.2. Using the Close Combat Table
Once the correct die has been selected the umpire will roll a D6 against the relevant line on the
Close Combat table. The roll of the dice will indicate a white or black circle, representing the Red
or Blue side depending on the combat odds. The letter in the disk will show the overall result, with
one side or the other being Repulsed, Defeated or Totally Defeated. Casualties against the loser,
represented in points values, are shown by either the figure above the circle, per half battalion of
infantry, or below per squadron of cavalry. The victor’s losses are, in the case of infantry,
considered to be those taken from fire as they advanced to contact, whilst victorious cavalry will
suffer half of the losses of the defeated force.
If a blank circle results then roll again until a result is achieved.

 * 4.2.1 Repulsed, Defeated and Totally Defeated Troops
Following the hand-to-hand attack the beaten side falls into one of three categories, as indicated
by the letters on the black or white circles. These are as follows:
Repulsed Troops
When the circle in the die gives the initial ‘R’ the beaten troops are ‘Repulsed’. They have turned
back from the attack, but they remain in good order as they retire, without significant losses. They
need two moved before they can defend themselves and three before they may assume the
offensive. One of the troop blocks is turned over to signify this status.
Defeated Troops
When the circle on the die gives ‘D’ the beaten troops turn back. Only some of them regain their
order and the rest begin to scatter. Losses are significant. These ‘Defeated’ troops need three
moves before they can defend and six before they may assume the offensive. Two troop blocks will
be turned over to signify this status.
Totally Defeated Troops
When the circle on the die gives ‘T’ it means the troops are ‘Totally Defeated’. They go back in
disorder in full flight. They need five moves before they can rally for defence, and ten before they

43

can assume the offensive. As soon as they are able to defend themselves one troop block is turned
face up and when they are able to assume to offensive all the troop blocks are turned face upwards
again.
Finally each player must give careful thought to what he hopes to achieve by an attack, and to the
most purposeful way of leading it.
4.2.2 Recording Losses
The losses for those troop blocks which have been engaged in the fighting is given on the dice under
the black and white circles. The first number is for infantry – per troops block (half battalion)
when the infantry are in ranks, and per two skirmish blocks when they are in skirmish order. The
second number is for cavalry per squadron.
Attackers will suffer losses from infantry fire if they are successful, as given by the dice.
Successful defenders who have beaten off an attack suffer 10 points for each half battalion block,
and five points for each skirmish block.
When the rules lay down that troops will only be considered as ‘Repulsed’, even if the Die gives
‘Totally Defeated’ the losses suffered will be in the same proportion.
If the victorious infantry do not remain for one move to regroup, but follow up the enemy on foot,
they will only cause half the losses in the pursuit.
The lost troop blocks must be taken from the troops which have been in the fighting.

4.3. Retreats & Pursuits
Cavalry which have made a successful attack must wait one move before pursuit, and then follow
at half speed.
Move Light Cavalry Heavy Cavalry
1st Move Wait Wait
2nd Move 500 paces 400 paces
3rd Move 900 paces 800 paces
4th Move 900 paces 800 paces
5th Move 600 paces 600 paces
&c. 600 paces 600 paces
If the line which conducted the attack had flank columns which were not in the fight, these can be
used in the first moves at 800 paces.
4.3.1 Retreating Cavalry
The retreat of the beaten cavalry will take place at the gallop for the first two moves, and after
that at the trot. If the faster movement is necessary the troops will become downgraded –
‘Repulsed’ troops becoming ‘Defeated’ and so on.
4.3.2 Victorious Infantry
Infantry successful in an attack must halt for one turn before following, if the enemy are to suffer
the full loss. If they follow without a halt of one move only half of them will go.
4.3.3 Retreating Infantry
The retreat of beaten infantry takes place at 250 paces per move. They can go faster at 500 paces,
but become downgraded in the process – ‘Repulsed’ troops becoming ‘Defeated’ and so on.
If during the retreat they come under canister fire to ‘good effect’, or if they are caught by the
enemy cavalry before they can reach their reserve line, they are also downgraded.

44

Skirmishers which are beaten can go for two moves at 400 paces without penalty or downgrading.
4.3.4 Line of Retreat
The line of retreat for the beaten side is not restricted in any way except by the consideration that
a diagonal line of retreat will keep them in the close vicinity of the enemy for longer, and will
consequently leave them longer exposed to the threat of a renewed attack.
4.3.5 Beaten Troops Moving Through Reserve Lines
If totally defeated troops retire through their own reserve line, and this in turn is attacked within
the next two moves, the reserve line will lose a point in the attack.
If the attack on the reserve takes place on the third move after the totally defeated troops have
moved through it the rule will not apply.
4.3.6 Renewed Attacks on Beaten Troops
The umpire should note the Regimental or battalion number of totally defeated troops, since if
they are attacked again (before they have time to recover as covered in paragraph 4.2.1) they will
be at a disadvantage.
4.3.7 Captured Troops
If defeated troops come against insurmountable terrain obstacles in their retreat the following will
apply:
Artillery will, in all cases, be lost
Cavalry and Infantry are only destroyed or captured if the enemy remains uncontested amongst
them for three moves. For only one move a third are lost to capture. For two moves two-thirds
are lost. On the other side only a tenth of any loss from infantry fire will be counted (if the beaten
troops are resisting).

4.4. Beaten Troops Finding Cover
For ‘Repulsed’ or ‘Defeated’ troops who within two moves following an attack can find refuge
behind some terrain obstacle there may be a halt to a pursuit.
Infantry Shelter
For infantry a suitable refuge point might be a thicket or coppice, woods, trench, small stream
which must be waded, hill tops which have been occupied by artillery.
Cavalry Shelter
For cavalry this may be small ditches and streams, a coppice or thicket which is occupied by
skirmishers or hilltops occupied by artillery
If the fleeing troops manage to reach a refuge the attack must be renewed, but it will take place
with one point more advantage to the attacker than the previous attack unless circumstances have
changed through reinforcements &c.
 */
public class CloseCombatTable {

    public static CloseCombatResult getResult(Unit attacker, Unit defender){
        // TODO Implement above logic
        return null;
    }

    public static CombatOdds getOdds(Unit attacker, Unit defender){
        // TODO Implement above logic
        return CombatOdds.ONE_TO_ONE;
    }

    private CloseCombatTable(){}
}
