/* This Program take multiple text file having the shape points (x,y) as data from user and return
 largest perimeter in all those file

 to run this program install duke learn to program edu.duke Jar file at https://www.dukelearntoprogram.com/downloads/bluej.php?course=2 */


 import edu.duke.*;
 import java.io.File;
 /**
  * Write a description of PerimeterMultipleFiles here.
  * 
  * @author (your name) 
  * @version (a version number or a date)
  */
 public class MultipleFilePerimeter {
 
     public static double getPerimeter (Shape s) {
         // Start with totalPerim = 0
         double totalPerim = 0.0;
         // Start wth prevPt = the last point 
         Point prevPt = s.getLastPoint();
         // For each point currPt in the shape,
         for (Point currPt : s.getPoints()) {
             // Find distance from prevPt point to currPt 
             double currDist = prevPt.distance(currPt);
             // Update totalPerim by currDist
             totalPerim = totalPerim + currDist;
             // Update prevPt to be currPt
             prevPt = currPt;
         }
         // totalPerim is the answer
         return totalPerim;
     }
 
     public static void getLargestPerimeterMultipleFiles() {
         File temp = null; 
         // start with largestPerim = 0
         double largestPerim = 0;
         // make a DirectoryResource object dr wich helps in selecting multiple files
         DirectoryResource dr = new DirectoryResource();
         // for each file selected in dr
         for (File f : dr.selectedFiles()) {
         // make FileResource object fr for currunt file in dr(f)
             FileResource fr = new FileResource(f);
         // make Shape class Object of fr
             Shape s = new Shape(fr);   
         // call getPerimeter() on object s
             double perim = getPerimeter(s);
         // check the large value
             if(largestPerim < perim){
             // if so assign it to largestPerim
             largestPerim = perim;            
             temp = f;
         } 
             
         }
         System.out.println("Largest perimeter of Shape is in file : " 
         + temp.getName()+"\nPerimeter : "+largestPerim);
         
     }
 
     public static void main (String[] args){              
         getLargestPerimeterMultipleFiles();        
     }
     
     
 }