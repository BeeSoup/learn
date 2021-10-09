/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/9/22  zhangyu30939  新增
 * ========    =======  ============================================
 */
package practice.file;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 功能说明:
 *
 * @author zhangyu30939
 * @since 2021-09-22
 */
@Slf4j
public class FileTest {
    private static final String CHARSET_NAME = "UTF-8";

    public static void main(String[] args) {

        File file = new File("F:\\local\\20210921\\proCode1\\锦成盛锐意进取私募证券投资基金_V5.2【清洁版定稿】(1)API_JSON.txt");
        String fileContentTxt = null;

        try {
            FileInputStream inputStream = new FileInputStream(file);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            IOUtils.copyLarge(inputStream, outputStream);
            // 获取源文档
            fileContentTxt = outputStream.toString(CHARSET_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Section section = new Section();
        JSONObject selectionJsonObj = JSONObject.parseObject(fileContentTxt);
        transJson(selectionJsonObj, section);
        log.info("success:{}", JSON.toJSON(section));

    }

    private static void transJson(JSONObject selectionJsonObj, Section section) {

        JSONArray children = selectionJsonObj.getObject("children", JSONArray.class);

        if (Objects.nonNull(children)) {
            List<Section> sectionList = new ArrayList<>();
            section.setChildren(sectionList);
            for (Object child : children) {
                JSONObject cast = JSONObject.class.cast(child);
                Section childSection = new Section();
                transJson(cast, childSection);
                sectionList.add(childSection);
            }
        }

        String textNumber = selectionJsonObj.getString("textNumber");
        section.setTextNumber(textNumber);

        String textTitle = selectionJsonObj.getString("textTitle");
        section.setTextTitle(textTitle);

        Integer level = selectionJsonObj.getInteger("level");
        section.setLevel(level);

        String strutedTitle = selectionJsonObj.getString("strutedTitle");
        section.setStrutedTitle(strutedTitle);


        Integer index = selectionJsonObj.getInteger("index");
        section.setIndex(index);

        Integer begin = selectionJsonObj.getInteger("begin");
        section.setBegin(begin);

        Integer end = selectionJsonObj.getInteger("end");
        section.setEnd(end);

        Integer type = selectionJsonObj.getInteger("type");
        section.setType(type);
    }
}
