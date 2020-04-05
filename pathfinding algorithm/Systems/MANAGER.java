package Systems;

import java.util.concurrent.TimeUnit;

import javax.swing.*;
import GUI.*;
import javafx.scene.*;

public class MANAGER {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        gridSystem GridSystem = new gridSystem(20, 30);
        mazeGenerator mGenerator = new mazeGenerator(GridSystem.nodes, GridSystem.nodeSize, GridSystem.nodesNumber);
        for(int i = 0 ; i <= 380; i++){
            int random =(int)(Math.random() * 900);
            if(GridSystem.nodes.get(i) != mGenerator.startPoint && GridSystem.nodes.get(i) != mGenerator.endPoint)
            GridSystem.nodes.get(random).isObstical  = true;
        }
        pathfinding pathfinding_ = new pathfinding(mGenerator.startPoint,mGenerator.endPoint,gridSystem.nodes);
        pathfinding_.findPath();
     gui_manager gui_manager_ = new gui_manager(GridSystem.nodes, GridSystem.nodeSize,mGenerator.edgesNodes,mGenerator.startPoint,mGenerator.endPoint,pathfinding_.closedNodes,pathfinding_.opendNodes);
     frame.add(gui_manager_);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setBounds(0,0,638,640);
     frame.setVisible(true);
 }
}