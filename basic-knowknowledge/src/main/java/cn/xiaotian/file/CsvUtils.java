package cn.xiaotian.file;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author xiaotian
 * @description
 * @date 2022-09-20 10:34
 */
public class CsvUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(CsvUtils.class);

    private static final String CSV_SUFFIX = "csx";

    public static boolean importCsv(String importPath) {
        if (StringUtils.isBlank(importPath)) {
            LOGGER.error("the importpath is blank, please check parameter");
            return false;
        }
        String[] split = importPath.split("\\.");
        if (!StringUtils.equals(split[split.length - 1], CSV_SUFFIX)) {
            LOGGER.error("the importpath is not end by csv, please check parameter");
            return false;
        }
        File file = new File(importPath);
        if (!file.exists()) {
            LOGGER.error("the file is not exist, please check");
            return false;
        }
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(importPath);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }


    public static boolean exportCsv(String outputPath) {

        return true;
    }


}
