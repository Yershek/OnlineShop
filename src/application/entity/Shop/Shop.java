package application.entity.Shop;

import application.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private Long id;
    private Entity userGeneral;
    private String name;
    private String adres;
    private List<Employees> employees;

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Shop() {
        employees = new ArrayList<>();
    }

    public List<Employees> getAllEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees.add(employees);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Entity getUserGeneral() {
        return userGeneral;
    }

    public void setUserGeneral(Entity userGeneral) {
        this.userGeneral = userGeneral;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userGeneral=" + userGeneral.getLogin() +
                '}';
    }
}
