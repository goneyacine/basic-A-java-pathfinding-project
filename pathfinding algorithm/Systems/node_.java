package Systems;
public class node_{
    public int[] inWorldPosition;
    public int[] inGridPosition;
    //this is the distance between this point and the start point
    public float GCost;
    //this is the distance between this point and the end point
    public float HCost;
    //this is the sum of GCost and HCost
    public float FCost;
    public boolean isClosed;
    public boolean isOpened;
    public boolean isObstical = false;
    public node_(int[] InWorldPosition,int[] InGridPosition){
      inWorldPosition = InWorldPosition;
      inGridPosition = InGridPosition;
    }
}