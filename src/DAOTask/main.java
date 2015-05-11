package DAOTask;

public class main {

public static void main(String[] args){
    CrewDAO crewDAO = new CrewDAO();
    MovieDAO movieDAO = new MovieDAO();

    System.out.println("findCrewByDirectorRole");
    System.out.println(crewDAO.findCrewByDirectorRole());
    System.out.println("findCrewByMovie");
    System.out.println(crewDAO.findCrewByMovie("Seven"));
    System.out.println("findCrewByMoviesCount");
    System.out.println(crewDAO.findCrewByMoviesCount());
    System.out.println("findAllMovies");
    System.out.println(movieDAO.findAll());
    System.out.println("findByAge");
    System.out.println(movieDAO.findByAge(1995));
   /* System.out.println("deleteDueYear");
    System.out.println(movieDAO.deleteDueYear(10));*/
}
}
