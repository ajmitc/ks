package ks.server.dao;

import ks.common.model.force.Force;
import ks.common.model.game.Game;
import ks.common.model.side.Side;
import ks.common.model.terrain.Battlefield;
import ks.common.model.unit.Unit;
import ks.common.model.unit.UnitSize;
import ks.common.model.unit.UnitType;
import ks.common.model.user.User;
import ks.common.model.user.UserRole;
import ks.common.server.BattlefieldInfo;
import ks.common.server.BattlefieldList;
import ks.common.server.GameList;
import ks.common.server.protocol.BattlefieldListResponse;
import ks.common.server.protocol.GameListResponse;

import java.awt.*;
import java.util.UUID;

public class InMemoryStore implements ServerDAO {
    private GameList gameList = new GameList();
    private BattlefieldList battlefieldList = new BattlefieldList();

    public InMemoryStore(){
        addTestGame();
        addTestBattlefield();
    }

    @Override
    public GameListResponse getGameList(){
        return new GameListResponse(gameList);
    }

    @Override
    public BattlefieldListResponse getBattlefieldList() {
        return new BattlefieldListResponse(battlefieldList);
    }

    @Override
    public boolean saveGame(Game game) {
        gameList.getGames().add(game);
        return true;
    }

    private void addTestGame(){
        Game game = new Game();
        game.setId("" + UUID.randomUUID());
        game.setName("Test Game");
        game.setCommonDescription("This is the common description shared with all players");
        game.setBattlefield(new Battlefield(100, 100));
        game.getBattlefield().setMapPackId("test-map-pack");

        String sideAId = "" + UUID.randomUUID();
        String sideBId = "" + UUID.randomUUID();
        game.getSides().add(new Side(sideAId, "Side A", Color.RED));
        game.getSides().add(new Side(sideBId, "Side B", Color.BLUE));

        String umpireId = "" + UUID.randomUUID();
        String generalAId = "" + UUID.randomUUID();
        String generalBId = "" + UUID.randomUUID();
        game.getUsers().add(new User());
        game.getUsers().get(0).setId(umpireId);
        game.getUsers().get(0).setDisplayName("Umpire 1");
        game.getUsers().get(0).setRole(UserRole.UMPIRE);
        game.getUsers().add(new User());
        game.getUsers().get(1).setId(generalAId);
        game.getUsers().get(1).setDisplayName("General A");
        game.getUsers().get(1).setRole(UserRole.GENERAL);
        game.getUsers().add(new User());
        game.getUsers().get(2).setId(generalBId);
        game.getUsers().get(2).setDisplayName("General B");
        game.getUsers().get(2).setRole(UserRole.GENERAL);
        game.getUsers().add(new User());
        game.getUsers().get(3).setId("" + UUID.randomUUID());
        game.getUsers().get(3).setDisplayName("Observer");
        game.getUsers().get(3).setRole(UserRole.OBSERVER);

        String forceAId = "" + UUID.randomUUID();
        String forceBId = "" + UUID.randomUUID();
        game.getForces().add(new Force(forceAId, sideAId, generalAId));
        game.getForces().add(new Force(forceBId, sideBId, generalBId));

        game.getForces().get(0).getUnits().add(new Unit("" + UUID.randomUUID(), sideAId, forceAId, "1st Infantry", UnitType.INFANTRY, UnitSize.HALF_BATTALION, 450));
        game.getForces().get(1).getUnits().add(new Unit("" + UUID.randomUUID(), sideBId, forceBId, "2st Infantry", UnitType.INFANTRY, UnitSize.HALF_BATTALION, 450));

        gameList.getGames().add(game);
    }

    private void addTestBattlefield(){
        BattlefieldInfo battlefieldInfo = new BattlefieldInfo();
        battlefieldInfo.setId("test");
        battlefieldInfo.setName("Test Map");
        //battlefieldInfo.setImageFilename("Test.png");
        //battlefieldInfo.setBackgroundImageUrlCallback("/battlefield?id=test");

        battlefieldList.getBattlefields().add(battlefieldInfo);
    }
}
