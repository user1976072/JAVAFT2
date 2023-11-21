package Model.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;



public class Human implements Serializable {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthdate;
    private LocalDate deathdate;
    public Human father;
    public Human mother;
    public List<Human> children;
    private Human marriage;

    public Human(String name, Gender gender, LocalDate birthdate, LocalDate deathdate, Human father, Human mother) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.deathdate = deathdate;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public LocalDate getDeathdate() {
        return deathdate;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public Human(String name, Gender gender, LocalDate birthdate) {
        this (name, gender, birthdate, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate birthdate, Human father, Human mother){
        this(name, gender, birthdate, null, father, mother);
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }
    public boolean addParents(Human parents) {
        if (parents.getGender().equals(Gender.Male)){
            setFather(parents);
        } else if (parents.getGender().equals(Gender.Female)){
            setMother(parents);
        }
        return true;
    }

    public void setMother(Human mother) {this.mother = mother;}

    public void setFather(Human father) {this.father = father;}

    public Human getMother() {return mother;}

    public Human getFather() {return father;}

    public List<Human> getParents(){
        List<Human> list = new ArrayList<>(2);
        if (father != null){
            list.add(father);
        }
        if (mother != null){
            list.add(mother);
        }
        return list;
    }

    public int getAge(){
        if (deathdate == null){
            return getPeriod(birthdate, LocalDate.now());
        } else {
            return getPeriod(birthdate, deathdate);
        }
    }

    private int getPeriod(LocalDate birthdate, LocalDate deathdate) {
        Period diff = Period.between(birthdate, deathdate);
        return diff.getYears();
    }

    public void setMarriage(Human marriage){ this.marriage = marriage; }

    public Human getMarriage() {return marriage;}

    public void setBirthdate(LocalDate birthdate) {this.birthdate = birthdate;}

    public void setDeathdate(LocalDate deathdate) {this.deathdate = deathdate;}

    public Gender getGender() {return gender;}

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("id");
        sb.append(id);
        sb.append(", имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getMarriageInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getMarriageInfo(){ // для поверки есть или нет, иначе обычно переопределенный toString делется много раз и программа падает
        String res = "супруг(а): ";
        if (marriage == null){
            res += "нет";
        } else {
            res += marriage.getName();
        }
        return res;
    }

    public String getMotherInfo(){
        String res = "мать: ";
        if (mother != null){
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo(){
        String res = "отец: ";
        if (father != null){
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (!children.isEmpty()){
            res.append(children.get(0).getName());
            for (int i = 0; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}
