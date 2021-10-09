package practice.test.myfinal;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.concurrent.ConcurrentLinkedQueue;

@Slf4j
public class TestDemo {

    public static void main2(String[] args) {
        String externalId = "99u929";
        String[] split = externalId.split(",");
        System.out.println(split);

        String fileName = "神奇动物124124124124125556690.doc";
        String fileNameSuffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        String substring = fileName.substring(0, fileName.lastIndexOf("."));

        log.info("\r\nfileName : {}， substring:{}", fileNameSuffix, substring);
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\zhangyu30939\\Desktop\\GJ\\test\\20210820\\盈峰价值进取私募证券投资基金3期基金合同（清洁）-处理后.docx");
        String parent = file.getParent();

        log.info("parent:{}", parent);
    }
}
