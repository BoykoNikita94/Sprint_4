public class Account {

    final String REGEX = "^(?=.{3,19}$)(^\\S+\\s{1}\\S+$)";
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        return name != null && name.matches(REGEX);
    }
}