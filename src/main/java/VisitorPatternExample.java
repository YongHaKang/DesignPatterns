public class VisitorPatternExample {
    public static void main(String[] args) {
        Animal lion = new Lion();
        Animal eagle = new Eagle();

        lion.move();
        eagle.move();
        lion.fly();
        eagle.fly();

        lion.visit(new Swim());
        eagle.visit(new Swim());
        lion.visit(new Attack());
        eagle.visit(new Attack());
    }
}

interface Animal {
    void fly();
    void move();
    void visit(Visitor visitor);
}

class Lion implements Animal {

    @Override
    public void fly() {
        System.out.println("cannot fly");
    }

    @Override
    public void move() {
        System.out.println("move like jagger");
    }

    @Override
    public void visit(Visitor visitor) {
        visitor.visit(this);
    }
}

class Eagle implements Animal {

    @Override
    public void fly() {
        System.out.println("fly high");
    }

    @Override
    public void move() {
        System.out.println("cannot move");
    }

    @Override
    public void visit(Visitor visitor) {
        visitor.visit(this);
    }
}

interface Visitor {
    void visit(Lion lion);
    void visit(Eagle eagle);
}

class Swim implements Visitor {

    @Override
    public void visit(Lion lion) {
        System.out.println(lion.getClass().getSimpleName() + " swim");
    }

    @Override
    public void visit(Eagle eagle) {
        System.out.println(eagle.getClass().getSimpleName() + " swim");
    }
}

class Attack implements Visitor {

    @Override
    public void visit(Lion lion) {
        System.out.println(lion.getClass().getSimpleName() + " attack");
    }

    @Override
    public void visit(Eagle eagle) {
        System.out.println(eagle.getClass().getSimpleName() + " attack");
    }
}