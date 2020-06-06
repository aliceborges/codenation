package challenge;

import org.omg.PortableInterceptor.INACTIVE;

public class Player {
    private String id;
    private Integer order;
    private String name;
    private String fullname;
    private Club club;
    private String birthDate;
    private String age;
    private Nationality nationality;
    private Double eurReleaseClause;
    private String eurWage;

    public Player (String id, Integer order, String name, String fullname, Club club, String birthDate, String age, Nationality nationality,
                   Double eurReleaseClause, String eurWage) {
        this.id = id;
        this.order = order;
        this.name = name;
        this.fullname = fullname;
        this.club = club;
        this.birthDate = birthDate;
        this.age = age;
        this.nationality = nationality;
        this.eurReleaseClause = eurReleaseClause;
        this.eurWage = eurWage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public Double getEurReleaseClause() {
        return eurReleaseClause;
    }

    public void setEurReleaseClause(Double eurReleaseClause) {
        this.eurReleaseClause = eurReleaseClause;
    }

    public String getEurWage() {
        return eurWage;
    }

    public void setEurWage(String eurWage) {
        this.eurWage = eurWage;
    }
}
