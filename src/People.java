import java.util.Objects;

public class People {

    int peopleId;
    String name;

    public People(int peopleId, String name) {
        this.peopleId = peopleId;
        this.name = name;
    }

    public int getPeopleId() {
        return peopleId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "People{" +
                "peopleId=" + peopleId +
                ", name='" + name + '\'' +
                '}';
    }

       @Override
    public boolean equals(Object o){
        if(this == o) return true;
        People p = (People) o;
        if(o == null || this.getClass() != o.getClass()) return false;
        return peopleId == p.getPeopleId() && Objects.equals(name,p.getName());
   }

   @Override
    public int hashCode(){
        return Objects.hash(peopleId,name);
   }
}
