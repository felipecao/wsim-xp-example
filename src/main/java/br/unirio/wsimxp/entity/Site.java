package br.unirio.wsimxp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: felipe
 * Date: 6/21/13
 * Time: 16:24
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="SITE")
@SequenceGenerator(name = "SQ_SITE", sequenceName = "SQ_SITE")
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SITE")
    @Column(name="SITE_ID")
    private Long id;

    @Column(name = "SITE_NAME", length = 100, nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "SITE_ACTIVITY", joinColumns = { @JoinColumn(name = "SITE_ID") },
            inverseJoinColumns = { @JoinColumn(name = "ACTIVITY_ID") })
    private List<Activity> activities = new ArrayList<Activity>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "SITE_SCENARIO", joinColumns = { @JoinColumn(name = "SITE_ID") },
            inverseJoinColumns = { @JoinColumn(name = "SCENARIO_ID") })
    private List<Scenario> scenarios = new ArrayList<Scenario>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "SITE_USER", joinColumns = { @JoinColumn(name = "SITE_ID") },
            inverseJoinColumns = { @JoinColumn(name = "USER_ID") })
    private List<User> users = new ArrayList<User>();

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

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public List<Scenario> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<Scenario> scenarios) {
        this.scenarios = scenarios;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
