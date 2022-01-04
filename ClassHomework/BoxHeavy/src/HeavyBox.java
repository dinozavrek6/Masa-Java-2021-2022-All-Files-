import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;


public class HeavyBox{
    private List<Box> boxList;

    public HeavyBox(){
        boxList = new ArrayList<>();
    }
    public HeavyBox(List<Box> boxList){
        this.boxList = boxList;
    }
    public List<Box> getBoxList(){
        return boxList;
    }
    public void setBoxList(List<Box> boxList){
        this.boxList = boxList;
    }

    public void insertBox(Box box){
        boxList.add(box);
    }

    public boolean removeBox(Box box){
        if (boxList.contains(box)) {
            boxList.remove(box);
            return true;
        }
        return false;
    }

    public void printAll(){
        for (Box box : boxList){
            System.out.println(box);
        }
    }
}
