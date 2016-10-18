package com.cognitioco.drunkster.com.cognitioco.drunkster.model;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

import java.util.Date;


public class User extends SugarRecord
{
    private String name;
    private Date birthDate;
    private double weight;
    @Ignore
    private Sex sex;
    private int sexDB;
    private String prefferedTaxiService;
    private String emergencyNumber;

    public User() {
    }

    public User(long id, String name, Date birthDate, double weight, Sex sex, String prefferedTaxiService, String emergencyNumber) {
        setId(id);
        this.name = name;
        this.birthDate = birthDate;
        this.weight = weight;
        if (sex == Sex.FEMALE) sexDB = 1;
        else if (sex == Sex.MALE) sexDB = 0;
        this.sex = sex;
        this.prefferedTaxiService = prefferedTaxiService;
        this.emergencyNumber = emergencyNumber;
    }

    public User(String name, Date birthDate, double weight, Sex sex) {
        this.name = name;
        this.birthDate = birthDate;
        this.weight = weight;
        if (sex == Sex.FEMALE) sexDB = 1;
        else if (sex == Sex.MALE) sexDB = 0;
        this.sex = sex;
    }

    public User(long id) {
        setId(id);
    }

    public User(String name) {
        this.name = name;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //Getters and Setters
    //
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Sex getSex() {

        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getPrefferedTaxiService() {
        return prefferedTaxiService;
    }

    public void setPrefferedTaxiService(String prefferedTaxiService) {
        this.prefferedTaxiService = prefferedTaxiService;
    }

    public String getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    public int getSexDB() {
        return sexDB;
    }

    public void setSexDB(int sexDB) {
        this.sexDB = sexDB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (Double.compare(user.weight, weight) != 0) return false;
        if (!name.equals(user.name)) return false;
        if (!birthDate.equals(user.birthDate)) return false;
        if (sex != user.sex) return false;
        if (prefferedTaxiService != null ? !prefferedTaxiService.equals(user.prefferedTaxiService) : user.prefferedTaxiService != null)
            return false;
        return emergencyNumber != null ? emergencyNumber.equals(user.emergencyNumber) : user.emergencyNumber == null;

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ///Utilities
    ///
    ////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + birthDate.hashCode();
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + sex.hashCode();
        result = 31 * result + (prefferedTaxiService != null ? prefferedTaxiService.hashCode() : 0);
        result = 31 * result + (emergencyNumber != null ? emergencyNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", weight=" + weight +
                ", sex=" + sex +
                ", prefferedTaxiService='" + prefferedTaxiService + '\'' +
                ", emergencyNumber='" + emergencyNumber + '\'' +
                '}';
    }

    public enum Sex {
        MALE,
        FEMALE
    }


}
