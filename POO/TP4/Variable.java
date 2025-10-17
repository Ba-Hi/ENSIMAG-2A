public class Variable extends ExpAbstraite {
    private String name;
    public Variable(String name) {
        super();
        this.name = name;
    }
    @Override
    public String toStringInfixe() {
        return name;
    }
}
