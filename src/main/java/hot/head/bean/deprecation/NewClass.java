package hot.head.bean.deprecation;

public class NewClass extends OldClass implements DeprecatedClass{
    @Override
    public void test1() {
        System.out.println("test 3");
    }
}
