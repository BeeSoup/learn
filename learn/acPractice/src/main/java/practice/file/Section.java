/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/9/21  zhangyu30939  新增
 * ========    =======  ============================================
 */
package practice.file;

import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * 功能说明:
 *
 * @author zhangyu30939
 * @since 2021-09-21
 */
@Data
public class Section implements Serializable {
    public static List<String> DEFAULT_LEVEL_UNIT = Arrays.asList("章", "条", "款", "项", "目");
    private int level;
    private int index;
    private int type;
    private Section parentSection;
    private List<Section> children;
    private int begin;
    private int end;
    private String textNumber;
    private String textTitle;

    private String strutedTitle;


//    public String getStrutedTitle() {
//        return this.getStrutedTitle((List)null);
//    }
//
//    public String getStrutedTitle(List<String> specLevelUnit) {
//        List<Section> l = this.reachPath(this.getLevel() > 0 ? 1 : 0);
//        int size = l.size();
//        List<String> levelUnit = specLevelUnit == null ? DEFAULT_LEVEL_UNIT : specLevelUnit;
//        size = size > levelUnit.size() ? levelUnit.size() : size;
//        StringBuffer r = new StringBuffer();
//
//        for(int i = 0; i < size; ++i) {
//            Section s = (Section)l.get(i);
//            if (s.getType() == 1) {
//                r.append("第").append(s.getTextNumber()).append((String)levelUnit.get(i));
//            } else if (s.getType() == 11) {
//                r.append(s.getTextNumber());
//            }
//
//            if (!"".equals(s.getTextTitle())) {
//                r.append("“").append(s.getTextTitle()).append("”");
//            }
//        }
//
//        return r.toString();
//    }
//
//    public List<Section> reachPath() {
//        return this.reachPath(1);
//    }
//
//    public List<Section> reachPath(int level) {
//        List<Section> l = new ArrayList();
//
//        for(Section s = this; s != null && s.getLevel() >= level; s = s.getParentSection()) {
//            l.add(s);
//        }
//
//        Collections.reverse(l);
//        return l;
//    }
}
