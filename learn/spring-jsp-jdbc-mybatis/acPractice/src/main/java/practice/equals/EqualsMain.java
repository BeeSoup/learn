package practice.equals;

import java.util.List;

public class EqualsMain {


    public static void main(String[] args) {
        EqualsAbstractEntity entity = new EqualsEntity();

        List<String> skip = entity.getSkip();
        entity.deal();
//        System.out.println(skip.toString());
    }
}
