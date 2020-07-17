package com.example.demo.itfTest;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.List;

public class CityDemo {

//    https://github.com/youzan/vant/blob/dev/src/area/demo/area.js
    public static List<City> cityList = Lists.newArrayList();
    public static List<City> city2List = Lists.newArrayList();
    public static List<City> city3List = Lists.newArrayList();

    public static void main(String[] args) throws IOException {
        File file = new File("D:/city.txt");
        InputStreamReader inputStreamReader
                = new InputStreamReader(new FileInputStream(file), "UTF-8");
        BufferedReader br = new BufferedReader(inputStreamReader);
        String line = "";
        int level = 0;
        while ((line = br.readLine()) != null) {
            // 如果 t x t文件里的路径 不包含---字符串       这里是对里面的内容进行一个筛选
            if (StringUtils.isEmpty(line)) {
                level ++;
                continue;
            }
            String[] str = line.split(": '");
            City city = new City();
            city.setLevel(level);
            city.setCode(str[0].trim());
            city.setName(str[1].substring(0, str[1].length()-2).trim());
            if (level == 0) {
                city.setParentCode("0");
                cityList.add(city);
            } else if (level == 1) {
                city2List.add(city);
            } else if (level == 2) {
                city3List.add(city);
            }
        }
        br.close();
        inputStreamReader.close();

        cityList.forEach(city -> {
            String one = city.getCode().substring(0,2);
            city2List.forEach(city1 -> {
                String two = city1.getCode().substring(0,2);
                if (one.equals(two)) {
                    city1.setParentCode(city.getCode());
                }
                if (Integer.parseInt(two) > 90) {
//                    city1.setParentCode(city.getCode());
                    city1.setParentCode("900000");
                }
                String three = city1.getCode().substring(0,4);
                city3List.forEach(city2 -> {
                    String four = city2.getCode().substring(0,4);
                    if (three.equals(four)) {
                        city2.setParentCode(city1.getCode());
                    }
                });
            });
        });
//        System.out.println(JSON.toJSONString(cityList));
//        System.out.println(JSON.toJSONString(city2List));
//        System.out.println(JSON.toJSONString(city3List));

        cityList.addAll(city2List);
        cityList.addAll(city3List);
        String city = JSON.toJSONString(cityList);
        System.out.println(city);
        String outputFile = "D:/city.json";
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(outputFile),"UTF-8");
        outputStreamWriter.write(city);
        outputStreamWriter.close();
    }



    static class City {

        private int level;

        private String parentCode;

        private String code;

        private String name;


        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getParentCode() {
            return parentCode;
        }

        public void setParentCode(String parentCode) {
            this.parentCode = parentCode;
        }
    }

}
