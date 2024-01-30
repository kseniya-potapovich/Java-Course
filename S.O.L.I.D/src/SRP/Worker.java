package SRP;

import java.util.Objects;

public class Worker {
    private String name;
    private Integer skill;

    public Worker() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSkill() {
        return skill;
    }

    public void setSkill(Integer skill) {
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(name, worker.name) && Objects.equals(skill, worker.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, skill);
    }
}
