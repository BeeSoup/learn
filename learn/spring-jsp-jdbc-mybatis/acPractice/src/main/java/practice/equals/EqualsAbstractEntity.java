package practice.equals;

import java.lang.reflect.Field;
import java.util.List;

public abstract class EqualsAbstractEntity {

    public abstract List<String> getSkip();

    public abstract void setSkip(List<String> skip);

    public void deal() {
        //获取对应的Class字段
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field.getName());
        }
        System.out.println(this.getSkip().toString());
    }


}
