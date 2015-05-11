package DAOTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class MovieDAO extends AbstractDAO<Integer, Movie> {

    public static final String SQL_SELECT_ALL_MOVIES = "select * from movie ";
    public static final String SQL_SELECT_MOVIE_BY_AGE = "select * from movie where year = ? or year = ? - 1 ";
    public static final String SQL_DELETE_MOVIE_DUE_YEAR = "delete from movie where year < 2015 - ? ";

    CrewDAO crewDAO = new CrewDAO();

    public List<Movie> deleteDueYear(int year) {
        List<Movie> movies = new ArrayList<Movie>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectorDB.getConnection();
            statement = connection.prepareStatement(SQL_DELETE_MOVIE_DUE_YEAR);
            statement.setInt(1, year);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int yearOfRelease = resultSet.getInt(3);
                String countryOfOrigin = resultSet.getString(4);

                List<Crew> crews = crewDAO.findCrewByMovie(name);
                movies.add(new Movie(id, name, yearOfRelease, countryOfOrigin, crews));

            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return movies;
    }

    @Override
    public List<Movie> findAll() {
        List<Movie> movies = new ArrayList<Movie>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectorDB.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_MOVIES);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int yearOfRelease = resultSet.getInt(3);
                String countryOfOrigin = resultSet.getString(4);

                List<Crew> crews = crewDAO.findCrewByMovie(name);
                movies.add(new Movie(id, name, yearOfRelease, countryOfOrigin, crews));

            }


        } catch (SQLException e) {
            System.out.println("SQL Exeption in findAll movies");
        }
        return movies;
    }


    public List<Movie> findByAge(int year) {
        List<Movie> movies = new ArrayList<Movie>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectorDB.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_MOVIE_BY_AGE);
            statement.setInt(1, year);
            statement.setInt(2, year);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int yearRS = resultSet.getInt(3);
                String country = resultSet.getString(4);
                List<Crew> crews = crewDAO.findCrewByMovie(name);


                movies.add(new Movie(id, name, yearRS, country, crews));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }


    @Override
    public Movie findEntityById(Integer Id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Integer Id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Movie entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(Movie entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Movie update(Movie entity) {
        throw new UnsupportedOperationException();
    }
}
