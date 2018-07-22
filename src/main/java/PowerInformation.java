import jxl.read.biff.BiffException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: gdprtest
 * @description: 实体
 * @author: Mr.Shu
 * @create: 2018-07-18 17:20
 **/

public class PowerInformation implements PowerInerface{
    public void power() {
//        int key= 1;
//        int getkey=1;
//        if (key == getkey){
//            System.out.print("权限匹配");
        String relativePath = System.getProperty("user.dir");
        String path=relativePath+"\\src\\main\\xsl\\readExcel.xls";
        HashMap<String,String> dataMap = ImportExcelUtil.method(path);
        ImporExcelForList daa= new ImporExcelForList();
        IsPhone phonenum= new IsPhone();
        IsId idcard = new IsId();

        try {
            int a =0;
            for (int i=0;i<daa.getData().size();i++){
                boolean wdd=phonenum.isMobileNO(daa.getData().get(i));

                if (wdd){
                    a = 1;
                }

            }
            int b=0;
            for (int j=0;j<daa.getData().size();j++){

                 b=idcard.validator(daa.getData().get(j));
                if(b == 1){
                    break;
                }
            }


            int key2 = Integer.parseInt(dataMap.get("ID"));
            int key1 = Integer.parseInt(dataMap.get("PHONENUM"));
            if(key2==b){
                System.out.println("ID权限匹配");
            }
            else {
                System.out.println("ID权限不匹配");
            }
            if(key1==a){
                System.out.println("PHONENUM权限匹配");
            }
            else {
                System.out.println("PHONENUM权限不匹配");
            }

        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        }


//    private static void printMap(HashMap<String,String> dataMap){
//        for (Map.Entry<String, String> en: dataMap.entrySet()) {
//           System.out.println(en.getKey()+"..."+en.getValue());
//
//        }
//    }
}
