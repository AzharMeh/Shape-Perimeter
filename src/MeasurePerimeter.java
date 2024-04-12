

/* This Program take the shape points (x,y) input from user as text file and do operations on them  and return
 perimeter of Shape, Total Points, Average length, Largest side, Largest X value

 to run this program install duke learn to program edu.duke Jar file at https://www.dukelearntoprogram.com/downloads/bluej.php?course=2 */


 import edu.duke.*;
 import java.io.File;
 
 public class MeasurePerimeter {
     public double getPerimeter (Shape s) {
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
 
     public int getNumPoints (Shape s) {
         // Start with totalNum = 0
         int totalNum = 0;
         // For each point currPt in the shape
         for (Point currPt : s.getPoints()){
         // Increase totalNum by 1
         totalNum = totalNum + 1;
         }        
         // totalNum is the answer
         return totalNum;
     }
 
     public double getAverageLength(Shape s) {
         /* call getPerimeter() method on Shape type object s 
         and store the result in totalPerim*/
         double totalPerim = getPerimeter(s);
         /* Call getNumPoints method to count total number of point 
         and store result in totalNum */
         int totalNum = getNumPoints(s);
         // calculate the average
         double avg = totalPerim / totalNum;
         // return average(avg)
         return avg;
     }
 
     public double getLargestSide(Shape s) {
         // Initialize largest = 0
         double largest = 0;
         // get last point of shape as previouvs point(prevPt)
         Point prevPt = s.getLastPoint();
         // For each point currPt in the shape
         for (Point currPt : s.getPoints()){
         // find the distance between prevPt and currPt(legnth of that side)
         double currLen = prevPt.distance(currPt);
         // Check if currrLen is greater then largest
         if ( largest < currLen){
             // if so assign currLen value to largest
             largest = currLen; 
         } 
         
         }
         // return largest
         return largest;
     }
 
     public double getLargestX(Shape s) {
         // assign largeX = 0
         double largeX = 0;
         
         for( Point currPt : s.getPoints()){
         //get X value of currPt and assign to currX
         double currX = currPt.getX();
         // check the largest
         if(largeX < currX){
         // assign largest one to largeX
         largeX = currX;
         }
         }
         return largeX;
     }
 
     public double getLargestPerimeterMultipleFiles() {
         
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
             } 
         }
         return largestPerim ;
     }
 
     public String getFileWithLargestPerimeter() {
         // make a File class Object temp
         File temp = null;         
         double largestPerim = 0;
         // make a DirectoryResource object dr wich helps in selecting multiple files
         DirectoryResource dr = new DirectoryResource();
         // for each file selected in dr
         for (File f : dr.selectedFiles()){
         // make FileResource object fr for currunt file in dr(f)
         FileResource fr = new FileResource(f);
         // make Shape class Object of fr
         Shape s = new Shape(fr);
         // check the large value
         double perim = getPerimeter(s);
         if(largestPerim < perim){
         temp = f;
         }
         }
            // replace this code
         return temp.getName();
     }
 
     public void testPerimeter () {
     //Create a FileResource fr
         FileResource fr = new FileResource();
         Shape s = new Shape(fr);
         double length = getPerimeter(s);
         int nums = getNumPoints(s);
         double avg = getAverageLength(s);
         double largest = getLargestSide(s);
         double largeX = getLargestX(s);
         //String fileName = getFileWithLargestPerimeter();
        // double largestPerim = getLargestPerimeterMultipleFiles();
       System.out.println("perimeter of Shape is : " + length);
         System.out.println("Total Points = " + nums);
         System.out.println("Average length = " + avg);
         System.out.println("Largest side = " + largest);
         System.out.println("Largest X vale = " + largeX);
         //System.out.println("LFile Name = " + fileName);*/
        // System.out.println("Largest perimeter = " + largestPerim);
     }
    
 
     // This method creates a triangle to test your other methods
     public void triangle(){
         Shape triangle = new Shape();
         triangle.addPoint(new Point(0,0));
         triangle.addPoint(new Point(6,0));
         triangle.addPoint(new Point(3,6));
         for (Point p : triangle.getPoints()){
             System.out.println(p);
         }
         double peri = getPerimeter(triangle);
         System.out.println("perimeter = "+peri);
     }  
 
     public static void main (String[] args) {
        MeasurePerimeter pr = new MeasurePerimeter();
         pr.testPerimeter();
     }
 }