package GUI;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.util.List;
import Systems.*;
public class gui_manager extends JPanel{
// here is nodes list
 public List<node_> nodes = new ArrayList<node_>();
 //here is nodes rectangles (shapes) list
 public List<Rectangle> nodesRect = new ArrayList<Rectangle>();
 public int nodeSize;
 //the edges list 
 public List<Rectangle> edgesRect = new ArrayList<Rectangle>();
 public List<node_> edgesNodes_ = new ArrayList<node_>();
 public node_ startPoint;
 public node_ endPoint;
public List<node_> openedNodes;
 public List<node_> closedNodes;
 
 public gui_manager (List<node_> Nodes,int nodeSize_,List<node_> edgesNodes,node_ startPoint_,node_ endPoint_,List<node_> closNode_s,List<node_> openNodes){
     nodes  = Nodes;
     nodeSize = nodeSize_;
     edgesNodes_ = edgesNodes;
     startPoint = startPoint_;
     endPoint = endPoint_;
     closedNodes = closNode_s;
     openedNodes = openNodes;
     for(node_ node : nodes){
         Rectangle rect = new Rectangle(node.inWorldPosition[0],node.inWorldPosition[1],nodeSize,nodeSize);
         nodesRect.add(rect);
     }
     for (node_ node : edgesNodes_){
       Rectangle rect = new Rectangle(node.inWorldPosition[0],node.inWorldPosition[1],nodeSize,nodeSize);
       edgesRect.add(rect);
     }
 }
 @Override
 public void paintComponent(Graphics g){
     super.paintComponent(g);
     this.setBackground(Color.black);
     Graphics2D g2d = (Graphics2D)g;
     
     g2d.setBackground(Color.BLACK);
     g2d.setColor(Color.WHITE);
     for(Rectangle rect : nodesRect){
      g2d.draw(rect);
     }
     for(Rectangle rect : edgesRect) {
        //g2d.setColor(Color.GREEN);
        g2d.draw(rect);
    }
    //g2d.setColor(Color.BLUE);
    Rectangle startPointRect = new Rectangle(startPoint.inWorldPosition[0],startPoint.inWorldPosition[1],nodeSize,nodeSize);
    g2d.fill(startPointRect);
    //g2d.setColor(Color.YELLOW);
    Rectangle endPointRect = new Rectangle(endPoint.inWorldPosition[0],endPoint.inWorldPosition[1],nodeSize,nodeSize);
    g2d.fill(endPointRect);
    
   
    g2d.setColor(Color.ORANGE);
    for(node_ node : nodes){
        if(node.isObstical){
        Rectangle Rect = new Rectangle(node.inWorldPosition[0],node.inWorldPosition[1],nodeSize,nodeSize);
        g2d.fill(Rect);
        }
    }
    g2d.setColor(Color.GREEN);
    for(node_ node : closedNodes){
        Rectangle Rect = new Rectangle(node.inWorldPosition[0],node.inWorldPosition[1],nodeSize,nodeSize);
        g2d.draw(Rect);
    }
    g2d.setColor(Color.RED);
    for(node_ node : openedNodes){
        Rectangle Rect = new Rectangle(node.inWorldPosition[0],node.inWorldPosition[1],nodeSize,nodeSize);
        g2d.draw(Rect);
    }
 }
}