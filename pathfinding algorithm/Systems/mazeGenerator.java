package Systems;

import java.util.*;
import java.util.List;
import java.awt.*;
public class mazeGenerator{
    public List<node_> nodes = new ArrayList<node_>();
    public List<node_> edgesNodes = new ArrayList<node_>();
   // public List<Rectangle> edgesRect = new ArrayList<Rectangle>();
    public int nodeSize;
    public node_ startPoint;
    public node_ endPoint;
    public mazeGenerator(List<node_> nodes_,int NodeSize,int nodeNum){
        nodes = nodes_;
        for(node_ node : nodes){
            //add edges nodes to edges list
  if(node.inGridPosition[0] == 1 || node.inGridPosition[0] == nodeNum +1 || node.inGridPosition[1] ==  1 
     ||node.inGridPosition[1] == nodeNum+1){
            edgesNodes.add(node);
         //   Rectangle rect = new Rectangle(node.inWorldPosition[0],node.inWorldPosition[1],nodeSize,nodeSize);
           // edgesRect.add(rect);
            }
        }
        //choose a random start and end point
        int randomStartPoint = Math.round((float) Math.random() * (edgesNodes.size() - 1));
        startPoint = edgesNodes.get(randomStartPoint);
        //this the all the edges nodes with out the start point(node)
        List<node_> edgesNodesWithOutStartPoint = new ArrayList<node_>();
        for(node_ node : edgesNodes){
            if(node != startPoint)
              edgesNodesWithOutStartPoint.add(node);
        }
        //here we ar chosing random end point 
        int randomEndPoint = Math.round((float) Math.random() * (edgesNodesWithOutStartPoint.size() - 1));
        endPoint = edgesNodesWithOutStartPoint.get(randomEndPoint);        
    }
}