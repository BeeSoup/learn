package practice.design.creational.prototype;

import java.util.Date;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/1 19:56
 */
public class ProtoTypeClone implements Cloneable {
    private String name ;
    private Date date ;
    @Override
    protected Object clone() throws CloneNotSupportedException {
//      直接clone date将会是潜克隆  同时， 克隆方法不走构造方法
//      如果使用this.clone() 将会死亡循环调用，当前的clone()
        ProtoTypeClone prototype = (ProtoTypeClone) super.clone();
        prototype.date = (Date) date.clone();
        return prototype;
    }

    public ProtoTypeClone(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ProtoTypeClone clone = new ProtoTypeClone("pp",new Date(0L));
        ProtoTypeClone clone1 = (ProtoTypeClone) clone.clone();
    }
}
