package practice.equals;

import java.util.Arrays;
import java.util.List;

public class EqualsEntity extends EqualsAbstractEntity {


    private List<String> skip = Arrays.asList("skip50","skip100");

    private String name = "hhhh";

    @Override
    public List<String> getSkip() {
        return this.skip;
    }

    @Override
    public void setSkip(List<String> skip) {
        this.skip = skip;
    }


}
