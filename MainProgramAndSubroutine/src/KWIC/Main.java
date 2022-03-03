package KWIC;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public void loop(String line) {

    }

    public static void main(String[] args) throws FileNotFoundException {
        // 从键盘接收数据
        Scanner scan = new Scanner(System.in);
        // next方式接收字符串
        String str = scan.nextLine();
        scan.close();
        String[] strList;

        File infile = new File("C:/Users/Dell Inspiron 7557/Desktop/TIC3001/Project/assignment 1/KWIC/input.txt");
        File outfile = new File("C:/Users/Dell Inspiron 7557/Desktop/TIC3001/Project/assignment 1/KWIC/output.txt");
        Scanner input = new Scanner(infile);
        PrintWriter output = new PrintWriter(outfile);
        ArrayList<String> lineList = new ArrayList<>();
        ArrayList<String> re;
        String line;

        while (input.hasNextLine()) {
            line = input.nextLine();
            if (!line.equals("")) {
                lineList.add(line);
            }
        }
        re = new Loop(lineList).transform();
        re = new Sort(re).transform();

        if (str != "") {
            strList = str.split(",");
            ArrayList<String> result = null;
            for (int j = 0; j < strList.length; j++) {
                for (int i =  re.size()-1; i >=0; i--) {
                    if (strList[j].toUpperCase().equals(re.get(i).split(" ")[0].toUpperCase())) {
                        re.remove(i);
                    }
                }
            }
            for (int i = 0; i < re.size(); i++) {
                output.println(re.get(i));
            }
        } else {
            for (int i = 0; i < re.size(); i++) {
                output.println(re.get(i));
            }
        }
        input.close();
        output.flush();
        output.close();
    }
}
