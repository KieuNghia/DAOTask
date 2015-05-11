package DAOTask;

import java.util.List;


public class Movie extends Entity {

    private String name;
    private int yearOfRelease;
    private String countryOfOrigin;
    private List <Crew> cast;

    public Movie(int id, String name, int yearOfRelease, String countryOfOrigin, List<Crew> cast) {
        super(id);
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.countryOfOrigin = countryOfOrigin;
        this.cast = cast;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public List<Crew> getCast() {
        return cast;
    }

    public void setCast(List<Crew> cast) {
        this.cast = cast;
    }

    @Override
    public String toString() {
        return ".Movie: " +
                " name ='" + name + '\'' +
                " yearOfRelease =" + yearOfRelease +
                " countryOfOrigin ='" + countryOfOrigin + '\'' +
                " cast =" + cast +
                "}\n";
    }
}
