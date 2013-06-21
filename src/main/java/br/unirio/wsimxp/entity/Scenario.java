package br.unirio.wsimxp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="SCENARIO")
@SequenceGenerator(name = "SQ_SCENARIO", sequenceName = "SQ_SCENARIO")
public class Scenario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SCENARIO")
    @Column(name="SCENARIO_ID")
    private Long id;

    @Column(name = "SCENARIO_NAME", length = 100, nullable = false)
    private String name;

    @OneToMany(mappedBy = "scenario")
    private List<Value> values = new ArrayList<Value>();

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

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }
}
