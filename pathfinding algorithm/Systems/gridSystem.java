package Systems;
import java.util.*;
public class gridSystem {
 //this is the node diameter
  public int nodeSize;
  //this is the max nodes number
  public int nodesNumber;
  //this is the nodes list
  public static List<node_> nodes = new ArrayList<node_>();
  public gridSystem(int NodeSize,int NodesNumber){
      //here we setting some default values
      nodeSize = NodeSize;
      nodesNumber = NodesNumber;
      //here we are creating nodes
      for(int x = 1; x <= nodesNumber + 1;x++){

          for(int y = 1; y <= nodesNumber + 1;y++){
            //this is the world position of the created node 
           int[] WorldPosition = {x * nodeSize,y * nodeSize};
           //this is the "in grid position" of the created node
           int[] InGridPosition = {x,y};
           //this is the created node
           node_ node = new node_(WorldPosition,InGridPosition);
           //adding the created node to the nodes list
           nodes.add(node);
          }
      }
  }
}