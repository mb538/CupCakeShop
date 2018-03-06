package datamapper;

import entity.CupCake;
import java.util.ArrayList;
import entity.User;

public interface DataMapperInterface
{
    //public ArrayList<User> getTeamMembers(int team_id);
    //public ArrayList<Team> getTeams();
   // public Team getTeam(int id);
    //public Team getTeam(String teamname);
    //public ArrayList<CupCake> getOrders();
    public ArrayList<User> getUsers();
    public ArrayList<User> getUsers(String username);
    public User getUser(int id);
    public User getUser(String username);
    public boolean deleteUser(int id);
    public boolean updateUser(User u);
    public boolean createUser(User u);
}