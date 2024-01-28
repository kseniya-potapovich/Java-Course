public class User implements Cloneable {
    private int Id;
    private Computer computer;

    public User(int id, Computer computer) {
        Id = id;
        this.computer = computer;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", computer=" + computer +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    protected Object cloneGlobal() throws CloneNotSupportedException {
        User newUser = (User) super.clone();
        Computer computer = (Computer) this.getComputer().clone();
        newUser.setComputer(computer);
        return newUser;
    }
}
