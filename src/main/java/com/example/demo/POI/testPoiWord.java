package com.example.demo.POI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;

/**
 * poi中docx格式的文件要用XWPFDocument处理，doc格式的用HWPFDocument处理
 * @author lei.X
 * @date 2018/10/20
 */
public class testPoiWord {


    public static void main(String[] args) throws Exception {
        Map<String, Text> replaces = new HashMap<String, Text>();

        replaces.put("${username}", Text.str("rongzhi_li"));
        replaces.put("${password}", Text.str("1123456"));
        replaces.put("${author}", Text.str("lee"));

        poiWordTableReplace("2.doc", "t2.doc", replaces);
    }

    public static void poiWordTableReplace(String sourceFile, String newFile,
                                           Map<String, Text> replaces) throws Exception {
        FileInputStream in = new FileInputStream(sourceFile);
        HWPFDocument hwpf = new HWPFDocument(in);
        Range range = hwpf.getRange();// 得到文档的读取范围
        TableIterator it = new TableIterator(range);
        // 迭代文档中的表格
        while (it.hasNext()) {
            Table tb = (Table) it.next();
            // 迭代行，默认从0开始
            for (int i = 0; i < tb.numRows(); i++) {
                TableRow tr = tb.getRow(i);
                // 迭代列，默认从0开始
                for (int j = 0; j < tr.numCells(); j++) {
                    TableCell td = tr.getCell(j);// 取得单元格
                    // 取得单元格的内容
                    for (int k = 0; k < td.numParagraphs(); k++) {
                        Paragraph para = td.getParagraph(k);

                        String s = para.text();
                        final String old = s;
                        for (String key : replaces.keySet()) {
                            if (s.contains(key)) {
                                s = s.replace(key, replaces.get(key).getText());
                            }
                        }
                        if (!old.equals(s)) {// 有变化
                            para.replaceText(old, s);
                            s = para.text();
                            System.out.println("old:" + old + "->" + "s:" + s);
                        }

                    } // end for
                } // end for
            } // end for
        } // end while

        FileOutputStream out = new FileOutputStream(newFile);
        hwpf.write(out);

        out.flush();
        out.close();

    }


}


abstract class Text {

    public abstract String getText();

    public static Text str(final String string) {
        return new Text() {
            @Override
            public String getText() {
                return string;
            }
        };
    }

}
