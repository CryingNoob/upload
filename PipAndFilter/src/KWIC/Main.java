package KWIC;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File infile = new File("C:/Users/Dell Inspiron 7557/Desktop/TIC3001/Project/assignment 1/KWIC/input.txt");
        File outfile = new File("C:/Users/Dell Inspiron 7557/Desktop/TIC3001/Project/assignment 1/KWIC/output.txt");
        Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();

        new Input(infile, pipe1).start();
        new Loop(pipe1, pipe2).start();
        new Sort(pipe2, pipe3).start();
        new Output(pipe3, outfile).start();
    }
}
