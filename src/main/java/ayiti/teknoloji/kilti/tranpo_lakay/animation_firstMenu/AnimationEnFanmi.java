/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ayiti.teknoloji.kilti.tranpo_lakay.animation_firstMenu;

import static ayiti.teknoloji.kilti.tranpo_lakay.App.hb;
import static ayiti.teknoloji.kilti.tranpo_lakay.App.vb;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.text.FontPosture;

/**
 *
 * @author negre
 */
public class AnimationEnFanmi {
    
    // We're gonna get a method that returns our  animation
    public static Pane animationAcc(){
        
        
        
        
        
        
    
        Pane pane = new Pane();
        
       Line line = new Line(10, 10, 10, 10);
       
        line.setStrokeWidth(3);
       line.setStroke(Color.DARKORANGE);
//        
////        line.endXProperty().bind(App.pane1.widthProperty().subtract(20));
////        line.endYProperty().bind(App.pane1.heightProperty().subtract(20));
//        
//        
//        
     DoubleProperty startX = line.startXProperty();
     DoubleProperty startY = line.startYProperty();
       DoubleProperty endX = line.endXProperty();
      DoubleProperty endY = line.endYProperty();
//        
//        
//        
////        startX.set(100.0);
////        startY.set(200.0);
////        endX.set(500.0);
////        endY.set(200.0);
//       
//       
//        
           startX.bind(pane.widthProperty().divide(6));
           startY.bind(pane.heightProperty().subtract(100));
           endX.bind(pane.widthProperty().subtract(200));
           endY.bind(pane.heightProperty().subtract(100));
//        
//        
//           Rectangle rectangle = new Rectangle(0,0,25, 50);
//           //rectangle.xProperty().bind(pane.widthProperty().divide(2));
//           //rectangle.yProperty().bind(pane.heightProperty().divide(2));
//           rectangle.setFill(Color.RED);
//           
//           
//                     Circle circle = new Circle(70);
//                     circle.centerXProperty().bind(pane.widthProperty().divide(2));
//                     circle.centerYProperty().bind(pane.heightProperty().divide(2));
//                    circle.setFill(Color.WHITE);
//                    circle.setStroke(Color.BLACK);
           
                    
                    
                    //-------------------------------------------------
                    
          Rectangle rectangle = new Rectangle(0, 0, 45, 60);
rectangle.setFill(Color.OLDLACE);
//Circle circle = new Circle(125, 100, 50);
Circle circle = new Circle(500, 400, 110);    //horizontal=500, vertical=500,  pour positionnement
circle.setFill(Color.WHITE);
circle.setStroke(Color.OLDLACE);

// Create a path transition
PathTransition pt = new PathTransition();
pt.setDuration(Duration.millis(4000));
pt.setPath(circle);
pt.setNode(rectangle);
                    
pt.setOrientation(
PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
pt.setCycleCount(Timeline.INDEFINITE);
pt.setAutoReverse(true);
pt.play(); // Start animation
//circle.setOnMousePressed(e -> pt.pause());
//circle.setOnMouseReleased(e -> pt.play());                    

                    
           
           
//           PathTransition pt = new PathTransition();
//            pt.setDuration(Duration.millis(100000));
//            pt.setPath(circle);
//            pt.setNode(rectangle);
//            pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
//            pt.setCycleCount(Timeline.INDEFINITE);
//            pt.setAutoReverse(true);
//            pt.play(); // Start animation
           
       // pane.getChildren().addAll(circle,rectangle);
       VBox vb = new VBox();
        pane.getChildren().addAll(circle, rectangle);
        vb.getChildren().addAll(pane, line);
    
    
     return vb;
    }
    
    
    
    
    
    public static Pane completeMethod(){
    
    Text tx = new Text(" Transpò Lakay ");
          tx.setFill(Color.DARKORANGE);
          tx.setFont(Font.font("Helvetica", FontPosture.ITALIC, 50));
          hb = new HBox();
          vb = new VBox();
          hb.getChildren().addAll(new Label("                  "), new Label("                    ", tx));
          hb.setAlignment(Pos.TOP_RIGHT);
          hb.setPadding(new Insets(20, 20, 0, 20));
          
          vb.getChildren().addAll(hb, animationAcc());
        
    
    return vb;
    }
    
    
    
    
    
    
}
