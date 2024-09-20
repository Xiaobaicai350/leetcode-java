package demo;

import com.github.difflib.DiffUtils;
import com.github.difflib.patch.AbstractDelta;
import com.github.difflib.patch.Chunk;
import com.github.difflib.patch.Patch;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> original = Arrays.asList("This is a test senctence." +
                "\r\nThis is a test for diffutils");
        //对比文件
        List<String> revised = Arrays.asList("This is a test senctence." +
                "\r\nThis is a test for diffutils1");


        //两文件的不同点
        Patch<String> patch = DiffUtils.diff(original, revised);
        System.out.println(patch);
        List<AbstractDelta<String>> deltas = patch.getDeltas();
        deltas.forEach(delta -> {
            System.out.println(delta.getType());
            switch (delta.getType()) {
                case INSERT:
                    //新增
                    System.out.println("新增");
                    Chunk<String> insert = delta.getTarget();
                    int position = insert.getPosition();
                    System.out.println("+ " + (position + 1) + " " + insert.getLines());
                    break;
                case CHANGE:
                    //修改
                    System.out.println("修改");
                    Chunk<String> source = delta.getSource();
                    Chunk<String> target1 = delta.getTarget();
                    System.out.println("\n- " + (source.getPosition() + 1) + " " + source.getLines() + "\n+ " + "" + (target1.getPosition() + 1) + " " + target1.getLines());
                    break;
                case DELETE:
                    //删除
                    System.out.println("删除");
                    Chunk<String> delete = delta.getSource();
                    System.out.println("- " + (delete.getPosition() + 1) + " " + delete.getLines());
                    break;
                case EQUAL:
                    System.out.println("无变化");
                    break;
            }
        });
    }
}