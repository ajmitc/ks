package ks.client.view;

import ks.common.model.game.Game;
import ks.common.server.GameList;

import javax.swing.table.AbstractTableModel;

public class GameListTableModel extends AbstractTableModel {
    private String[] columnNames = new String[]{
            "Game",
            "# Users"
    };
    private GameList gameList = new GameList();

    public Game getRowAt(int row){
        if (gameList != null && gameList.getGames().size() > row)
            return gameList.getGames().get(row);
        return null;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return gameList.getGames().size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        Game game = gameList.getGames().get(row);
        switch (col){
            case 0:
                return game.getName();
            case 1:
                return game.getUsers().size();
        }
        return "";
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void setGameList(GameList gameList) {
        this.gameList = gameList;
    }
}
