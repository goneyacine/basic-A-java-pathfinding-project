package Systems;
import java.util.*;
public class pathfinding {
    //this is the start point 
    static public node_ startNode;
    //this is the end point
    static public node_ endNode;
    //this is the nodes list
    static public List<node_> nodes = new ArrayList<node_>(); 
    //this the green nodes (the closed node)
    static public List<node_> closedNodes = new ArrayList<node_>();
    //this is the red nodes (opened nodes)
    static public List<node_> opendNodes = new ArrayList<node_>();
    public pathfinding(node_ startNode_ , node_ endNode_,List<node_> nodes_){
    startNode = startNode_;
    endNode = endNode_;
    nodes = nodes_;
    }
    public static void findPath(){
    //here i'm setting default value for start point(node)
    //this is GCost(the distance between the start point and this point)
    startNode.GCost = 0;
    //this is HCost(the distance between this point and the end poitn) 
    startNode.HCost =(float)Math.sqrt(Math.pow(startNode.inGridPosition[0] - endNode.inGridPosition[0], 2) + Math.pow(startNode.inGridPosition[1] - endNode.inGridPosition[1], 2));
    //this is FCost (GCost + HCost)
    startNode.FCost  = startNode.HCost + startNode.GCost;
    //here we are going to find the path
    for(int x = -1; x <= 1; x++){
     for(int y = -1 ; y <= 1; y++){
     for(node_ node : nodes){
         if(x != 0 || y != 0){
     if(node.inGridPosition[0] == x+startNode.inGridPosition[0] && node.inGridPosition[1] == y + startNode.inGridPosition[1] && node.isObstical == false){
         closedNodes.add(node);
         node.isClosed = true;
         node.HCost = (float)Math.sqrt(Math.pow(node.inGridPosition[0] - endNode.inGridPosition[0], 2) + Math.pow(node.inGridPosition[1] - endNode.inGridPosition[1], 2));
         if(x != 0 && y != 0){
             node.GCost = 1.4f;
         }else if((x != 0 && y == 0) || (x==0 && y !=0)){
            node.GCost = 1f;
         }
     }
  }
     }
       }
}
   if(closedNodes.size() != 0){
    boolean pathFinded = false;
    while(!pathFinded){
        //first check if we find path or no
        if(opendNodes.size() == 0)
        pathFinded = false;
        else{
            for(node_ node : opendNodes){
                if(node.HCost < 1.6f){
                 pathFinded = true;
                 break;
                }

            }
        }
    
        sortTheClosedNodesArray();
        opendNodes.add(closedNodes.get(0));
        closedNodes.remove(closedNodes.get(0));
        for(int x = -1; x <= 1; x++){
            for(int y = -1 ; y <= 1; y++){
            for(node_ node : nodes){
                if(x != 0 || y != 0){
            if(node.inGridPosition[0] == x+opendNodes.get(opendNodes.size() - 1).inGridPosition[0] && node.inGridPosition[1] == y + opendNodes.get(opendNodes.size() - 1).inGridPosition[1] && node.isObstical == false){
                closedNodes.add(node);
                node.isClosed = true;
                node.HCost = (float)Math.sqrt(Math.pow(node.inGridPosition[0] - endNode.inGridPosition[0], 2) + Math.pow(node.inGridPosition[1] - endNode.inGridPosition[1], 2));
                if(x != 0 && y != 0){
                    node.GCost = opendNodes.get(opendNodes.size() - 1).GCost;
                }else if((x != 0 && y == 0) || (x==0 && y !=0)){
                   node.GCost = 1f + opendNodes.get(opendNodes.size() - 1).GCost;
                }
            }
         }
            }
              }
       }

    }
    }
}
    public static void sortTheClosedNodesArray(){
        if(closedNodes.size() != 0){
            //this list contains the colsed nodes fcost values
            List<Float> closedNodes_FCost = new ArrayList<Float>();
            //here i'm adding data to "closedNodes_FCost"
            for(node_ node : closedNodes)
            closedNodes_FCost.add(node.FCost);
            bubbleSort sort = new bubbleSort();
            sort.Sort(closedNodes_FCost);
            List<node_> SortedClodedNodes = new ArrayList<node_>();
            for(int i = 0; i < closedNodes_FCost.size();i++){
                for(node_ node : closedNodes){
                    if(!SortedClodedNodes.contains(node) && node.FCost == closedNodes_FCost.get(i)){
                        SortedClodedNodes.add(node);
                        break;
                    }
                }
            }
            //the final sort for the closed node array 
            boolean isSorted = false;
            //check if the array is sorted 
            for(int i = 0; i < SortedClodedNodes.size() - 1; i++){
                if(SortedClodedNodes.get(i).FCost == SortedClodedNodes.get(i + 1).FCost){
                    if(SortedClodedNodes.get(i).HCost > SortedClodedNodes.get(i + 1).HCost){
                    isSorted = false;
                    break;
                    }else{
                    isSorted = true;
                    }
                }
            }
            //try to the if it's not sorted
            while(!isSorted){
                //sorting is here
                for(int i = 0; i <SortedClodedNodes.size() - 1; i++){
                    if(SortedClodedNodes.get(i).FCost == SortedClodedNodes.get(i + 1).FCost){
                        if(SortedClodedNodes.get(i).HCost > SortedClodedNodes.get(i + 1).HCost){
                            node_ tempNode = SortedClodedNodes.get(i + 1);
                            SortedClodedNodes.set(i + 1,SortedClodedNodes.get(i));
                            SortedClodedNodes.set(i,tempNode);
                        }
                    }
                }
             //check again if the array is sorted or not
             for(int i = 0; i < SortedClodedNodes.size() - 1; i++){
                if(SortedClodedNodes.get(i).FCost == SortedClodedNodes.get(i + 1).FCost){
                    if(SortedClodedNodes.get(i).HCost > SortedClodedNodes.get(i + 1).HCost){
                    isSorted = false;
                    break;
                    }else{
                    isSorted = true;
                    }
                }
            }
            }
        closedNodes = SortedClodedNodes;
        }
    }
}