package practice.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo {

    public static void main(String[] args) {

        //不允许声明的时候，使用这样的形式
        // List<E> e = new ArrayList<>();

        List<? extends Data> child = new ArrayList<>();

        List<? super Data> parent = new ArrayList<>();
        DataChild childElement = new DataChild();

//        child.add(childElement); 编译不通过
//        child.add(new Data()); 编译不通过

    }

    static class DataChild extends Data {

    }

    static class DataParent {

    }
}
