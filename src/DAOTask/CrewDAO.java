package DAOTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CrewDAO extends AbstractDAO<Integer, Crew> {

    public static final String SQL_SELECT_ALL_CREW = "select * from crew";
    public static final String SQL_SELECT_CREW_BY_MOVIE = "select * from moviesdb.crew where id in (select id_crew from moviecast where id_movie in (select id from movie where name = ?)) ";
    public static final String SQL_SELECT_CREW_BY_MOVIES_COUNT = "select id, firstName, lastName, dateOfBirth, count(moviecast.id_crew) from crew inner join moviecast on moviecast.id_crew = crew.id where moviecast.role = 'actor' group by id having count(moviecast.id_crew) > 1 ";
    public static final String SAL_SELECT_CREW_BY_DIRECTOR_ROLE = "select id, firstName, lastName, dateOfBirth from crew inner join moviecast on moviecast.id_crew = crew.id where moviecast.role = 'director'";

    @Override
    public List<Crew> findAll() {
        List<Crew> crews = new ArrayList<Crew>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectorDB.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_CREW);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                Date dateOfBirth = resultSet.getDate(4);

                crews.add(new Crew(id, firstName, lastName, dateOfBirth));

            }

        } catch (SQLException e) {
            System.out.println("SQL Exeption in findAll crew");
        }
        return crews;
    }

    public List<Crew> findCrewByMovie(String name) {

        List<Crew> crews = new ArrayList<Crew>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectorDB.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_CREW_BY_MOVIE);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                Date date = resultSet.getDate(4);

                crews.add(new Crew(id, firstName, lastName, date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return crews;
    }

    public List<Crew> findCrewByMoviesCount() {


        List<Crew> crews = new ArrayList<Crew>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectorDB.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_CREW_BY_MOVIES_COUNT);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                Date date = resultSet.getDate(4);

                crews.add(new Crew(id, firstName, lastName, date));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return crews;
    }

    public List<Crew> findCrewByDirectorRole() {
        List<Crew> crews = new ArrayList<Crew>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectorDB.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SAL_SELECT_CREW_BY_DIRECTOR_ROLE);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                Date date = resultSet.getDate(4);

                crews.add(new Crew(id, firstName, lastName, date));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return crews;
    }


    @Override
    public Crew findEntityById(Integer Id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Integer Id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Crew entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(Crew entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Crew update(Crew entity) {
        throw new UnsupportedOperationException();
    }
}
