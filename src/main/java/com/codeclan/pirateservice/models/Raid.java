package com.codeclan.pirateservice.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "raids")
public class Raid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private int booty;
    @ManyToMany
    @JoinTable(
            name = "pirates_raids",
            joinColumns = {
                    @JoinColumn(
                            name = "raid_id",
                            nullable = false,
                            updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "pirate_id",
                            nullable = false,
                            updatable = false)
            }
    )
    private List<Pirate> pirates;

    public Raid(String location, int booty) {
        this.location = location;
        this.booty = booty;
        this.pirates = new ArrayList<>();
    }

    public Raid() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getBooty() {
        return booty;
    }

    public void setBooty(int booty) {
        this.booty = booty;
    }

    public List<Pirate> getPirates() {
        return pirates;
    }

    public void setPirates(List<Pirate> pirates) {
        this.pirates = pirates;
    }
    public void addPirateToRaid(Pirate pirate){
        this.pirates.add(pirate);
    }
}
